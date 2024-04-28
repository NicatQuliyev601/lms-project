package az.nicat.lmsproject.entity.participation;

import az.nicat.lmsproject.entity.enums.Attendance;
import az.nicat.lmsproject.entity.group.Group;
import az.nicat.lmsproject.entity.lesson.Lesson;
import az.nicat.lmsproject.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "participations")
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    private LocalDate lessonDate;
    @Enumerated(EnumType.STRING)
    private Attendance attendance;

    @Column(name = "participation_data", columnDefinition = "TEXT")
    private String participationData;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    @ToString.Exclude
    private User user;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    @JsonIgnore
    @ToString.Exclude
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonIgnore
    @ToString.Exclude
    private Group group;


}
