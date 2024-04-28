package az.nicat.lmsproject.service.grade;

import az.nicat.lmsproject.dto.request.request.GradeRequest;
import az.nicat.lmsproject.dto.response.grade.GradeResponse;
import az.nicat.lmsproject.entity.grade.Grade;
import az.nicat.lmsproject.entity.submission.Submission;
import az.nicat.lmsproject.entity.user.User;
import az.nicat.lmsproject.exception.handler.ErrorCodes;
import az.nicat.lmsproject.exception.submission.SubmissionNotFoundException;
import az.nicat.lmsproject.repository.grade.GradeRepository;
import az.nicat.lmsproject.repository.submission.SubmissionRepository;
import az.nicat.lmsproject.repository.user.UserRepository;
import az.nicat.lmsproject.service.email.EmailService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final GradeRepository gradeRepository;
    private final SubmissionRepository submissionRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final EmailService emailService;

    public GradeResponse gradeSubmission(Long submissionId, GradeRequest gradeRequest) {
        Submission submission = submissionRepository.findById(submissionId)
                .orElseThrow(() -> new SubmissionNotFoundException(ErrorCodes.SUBMISSION_NOT_FOUND));

        Grade grade = new Grade();
        grade.setScore(gradeRequest.getScore());
        grade.setFeedback(gradeRequest.getFeedback());
        grade.setSubmission(submission);

        Grade savedGrade = gradeRepository.save(grade);

        sendGradeEmailToUser(submission.getUser(), grade);

        return modelMapper.map(savedGrade, GradeResponse.class);
    }

    private void sendGradeEmailToUser(User user, Grade grade) {
        String subject = "📝 Grade Notification: " + grade.getSubmission().getAssignment().getTitle();
        String content = "\n\n🌟 Dear " + user.getFirstName() + ",\n\nWe are pleased to inform you that your recent assignment has been graded.\n\n📚 Assignment Title: "
                + grade.getSubmission().getAssignment().getTitle() + "\n\n🔢 Grade: " + grade.getScore() + "\n\n💬 Feedback:\n" + grade.getFeedback()
                + "\n\nThank you for your effort and dedication in completing the assignment. If you have any questions or need further clarification, please feel free to reach out.\n\nBest regards" +
                "\n\n<a href=\"http://localhost:3000/student/assignments\">Click here</a> to view the assignment in the student portal.";


        emailService.sendEmail(subject, content, Collections.singletonList(user.getEmail()));
    }

    public List<GradeResponse> findAllGrades() {
        return gradeRepository
                .findAll()
                .stream()
                .map(grade -> modelMapper.map(grade, GradeResponse.class))
                .collect(Collectors.toList());
    }

    public GradeResponse findGradeBySubmission(Long submissionId) {
        Submission submission = submissionRepository.findById(submissionId)
                .orElseThrow(() -> new SubmissionNotFoundException(ErrorCodes.SUBMISSION_NOT_FOUND));

        Grade grade = gradeRepository.findBySubmission(submission);

        return modelMapper.map(grade, GradeResponse.class);
    }
}
