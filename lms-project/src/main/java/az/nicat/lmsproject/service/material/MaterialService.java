package az.nicat.lmsproject.service.material;

import az.nicat.lmsproject.dto.request.material.MaterialRequest;
import az.nicat.lmsproject.dto.response.material.MaterialResponse;
import az.nicat.lmsproject.entity.group.Group;
import az.nicat.lmsproject.entity.material.Material;
import az.nicat.lmsproject.repository.group.GroupRepository;
import az.nicat.lmsproject.repository.material.MaterialRepository;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MaterialService {

    @Value("${application.material.bucket.name}")
    private String bucketName;

    private final AmazonS3 s3Client;
    private final MaterialRepository materialRepository;
    private final ModelMapper modelMapper;
    private final GroupRepository groupRepository;

    public List<MaterialResponse> getAllMaterials() {
        List<Material> materials = materialRepository.findAll();
        return materials.stream()
                .map(material -> modelMapper.map(material, MaterialResponse.class))
                .collect(Collectors.toList());
    }

    public MaterialResponse uploadMaterial(MaterialRequest materialRequest, MultipartFile file, Long groupId) throws IOException {
        File fileObj = convertMultiPartFileToFile(file);
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
        fileObj.delete();

        Material material = new Material();
        material.setTitle(materialRequest.getTitle());
        material.setType(materialRequest.getType());
        material.setContent(fileName);

        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));

        material.setGroup(group);

        Material savedMaterial = materialRepository.save(material);

        return modelMapper.map(savedMaterial, MaterialResponse.class);
    }

    public byte[] downloadFile(String fileName) {
        S3Object s3Object = s3Client.getObject(bucketName, fileName);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        try {
            byte[] content = IOUtils.toByteArray(inputStream);
            return content;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String deleteFile(String fileName) {
        s3Client.deleteObject(bucketName, fileName);
        return fileName + " removed... ";
    }

    private File convertMultiPartFileToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        }
        return convertedFile;
    }
    public List<MaterialResponse> findMaterialsByGroup(Long groupId) {
        List<Material> materials = materialRepository.findByGroupId(groupId);

        return materials.stream()
                .map(material -> modelMapper.map(material, MaterialResponse.class))
                .collect(Collectors.toList());
    }
}
