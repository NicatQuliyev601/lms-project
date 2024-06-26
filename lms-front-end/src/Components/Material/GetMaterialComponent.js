import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { FaFolder } from 'react-icons/fa'; // Import the folder icon from react-icons
import './GetMaterial.css';

const GetMaterialComponent = () => {
    const [materials, setMaterials] = useState([]);

    useEffect(() => {
        const groupId = localStorage.getItem('groupId');
        if (groupId) {
            fetchMaterials(groupId); // Fetch materials for the specific group
        }
    }, []);

    const fetchMaterials = async (groupId) => {
        try {
            const token = localStorage.getItem('jwtToken');
            const response = await axios.get(`http://localhost:8080/api/v1/materials/groups/${groupId}`, {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });
            setMaterials(response.data);
        } catch (error) {
            console.error('Error fetching materials:', error);
        }
    };

    const handleDownload = async (fileName) => {
        try {
            const token = localStorage.getItem('jwtToken');
            const response = await axios.get(`http://localhost:8080/api/v1/materials/download/${fileName}`, {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
                responseType: 'blob', // Specify response type as blob
            });
            const blobUrl = URL.createObjectURL(new Blob([response.data]));
            const link = document.createElement('a');
            link.href = blobUrl;
            link.setAttribute('download', fileName);
            document.body.appendChild(link);
            link.click();
            document.body.removeChild(link);
        } catch (error) {
            console.error('Error downloading file:', error);
        }
    };

    // Function to generate video URLs from references
    const getVideoUrl = (videoReference) => {
        // You should replace this URL generation logic with your actual video URL generation method
        return `https://materiallmsbucket.s3.eu-north-1.amazonaws.com/${videoReference}`;
    };

    const handleVideoClick = (videoId) => {
        const videoElement = document.getElementById(videoId);
        if (videoElement) {
            videoElement.style.display = videoElement.style.display === 'block' ? 'none' : 'block'; // Toggle display
        }
    };

    return (
        <div className="get-material-container">
            <h2>Uploaded Materials</h2>
            <table>
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Type</th>
                    <th>Download</th>
                </tr>
                </thead>
                <tbody>
                {materials.map((material) => (
                    <tr key={material.id}>
                        <td>
                            <FaFolder /> {material.title} {/* Folder icon added */}
                        </td>
                        <td>{material.type}</td>
                        <td onClick={() => handleDownload(material.content)} className="download-link">Download</td>
                    </tr>
                ))}
                </tbody>
            </table>
            <div className="video-container">
                <h3>Video Materials</h3>
                <div className="videos-list">
                    {materials.filter((material) => material.type === 'video').map((videoMaterial) => (
                        <div key={videoMaterial.id} className="video-item" onClick={() => handleVideoClick(videoMaterial.id)}>
                            <p className="video-title">{videoMaterial.title}</p>
                            <video
                                id={videoMaterial.id}
                                className="cld-video-player cld-fluid"
                                controls
                                style={{ display: 'none' }} // Initially hidden
                                src={getVideoUrl(videoMaterial.content)}
                                width={640}
                                height={360}
                            >
                                Your browser does not support the video tag.
                            </video>
                            <p className="video-description">{videoMaterial.description}</p>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
};

export default GetMaterialComponent;
