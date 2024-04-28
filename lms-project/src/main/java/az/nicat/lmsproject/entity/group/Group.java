package az.nicat.lmsproject.entity.group;

import az.nicat.lmsproject.entity.assignment.Assignment;
import az.nicat.lmsproject.entity.course.Course;
import az.nicat.lmsproject.entity.lesson.Lesson;
import az.nicat.lmsproject.entity.material.Material;
import az.nicat.lmsproject.entity.participation.Participation;
import az.nicat.lmsproject.entity.submission.Submission;
import az.nicat.lmsproject.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "group",cascade = CascadeType.REMOVE)
    private List<User> user = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    Course course;

    @OneToMany(mappedBy = "group",cascade = CascadeType.REMOVE)
    private List<Material> materials = new ArrayList<>();

    @OneToMany(mappedBy = "group",cascade = CascadeType.REMOVE)
    private List<Assignment> assignments;

    @OneToMany(mappedBy = "group",cascade = CascadeType.REMOVE)
    private List<Lesson> lessons;

    @OneToMany(mappedBy = "group",cascade = CascadeType.REMOVE)
    private List<Participation> participations;

    @OneToMany(mappedBy = "group",cascade = CascadeType.REMOVE)
    private List<Submission> submissions;
}
