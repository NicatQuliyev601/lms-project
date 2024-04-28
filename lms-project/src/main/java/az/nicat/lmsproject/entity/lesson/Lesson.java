package az.nicat.lmsproject.entity.lesson;

import az.nicat.lmsproject.entity.group.Group;
import az.nicat.lmsproject.entity.participation.Participation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate date;
    private int duration;

//    @ManyToOne
//    private User user;

    @OneToMany(mappedBy = "lesson",cascade = CascadeType.REMOVE)
    private List<Participation> participations = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Group group;
}
