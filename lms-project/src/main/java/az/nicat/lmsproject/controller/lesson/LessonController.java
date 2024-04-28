package az.nicat.lmsproject.controller.lesson;

import az.nicat.lmsproject.dto.request.lesson.LessonRequest;
import az.nicat.lmsproject.dto.response.lesson.LessonResponse;
import az.nicat.lmsproject.service.lesson.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
@CrossOrigin
public class LessonController {

    private final LessonService lessonService;

    @GetMapping
    public ResponseEntity<List<LessonResponse>> getAllLessons() {
        List<LessonResponse> lessons = lessonService.findAll();
        return ResponseEntity.ok(lessons);
    }

    @PostMapping("/{groupName}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<LessonResponse> createLesson(
            @RequestBody LessonRequest lessonRequest,
            @PathVariable("groupName") String groupName
    ) {
        LessonResponse lessonResponse = lessonService.save(lessonRequest, groupName);
        return ResponseEntity.status(HttpStatus.CREATED).body(lessonResponse);
    }

    @GetMapping("/findByDate")
    public ResponseEntity<List<LessonResponse>> getLessonsByDate(@RequestParam String date) {
        try {
            List<LessonResponse> lessons = lessonService.findByDate(date);
            return ResponseEntity.ok(lessons);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonResponse> updateLesson(
            @PathVariable("id") Long lessonId,
            @RequestBody LessonRequest lessonRequest
    ) {
        LessonResponse lessonResponse = lessonService.updateLesson(lessonId, lessonRequest);
        return ResponseEntity.ok(lessonResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable("id") Long lessonId) {
        lessonService.delete(lessonId);
        return ResponseEntity.noContent().build();
    }
}
