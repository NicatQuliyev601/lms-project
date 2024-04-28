package az.nicat.lmsproject.entity.submission;

import az.nicat.lmsproject.entity.assignment.Assignment;
import az.nicat.lmsproject.entity.grade.Grade;
import az.nicat.lmsproject.entity.group.Group;
import az.nicat.lmsproject.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "submissions")
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String link;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private User user;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Assignment assignment;

    @OneToOne(mappedBy = "submission",cascade = CascadeType.REMOVE)
    @JsonIgnore
    @ToString.Exclude
    private Grade grade;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonIgnore
    @ToString.Exclude
    Group group;
}
