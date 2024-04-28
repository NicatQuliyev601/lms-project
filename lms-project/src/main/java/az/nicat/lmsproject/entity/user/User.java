package az.nicat.lmsproject.entity.user;

import az.nicat.lmsproject.entity.authority.Authority;
import az.nicat.lmsproject.entity.enums.MessageStatus;
import az.nicat.lmsproject.entity.group.Group;
import az.nicat.lmsproject.entity.participation.Participation;
import az.nicat.lmsproject.entity.submission.Submission;
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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1, initialValue = 2)
    private Long id;


    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private MessageStatus status;
    private Boolean passwordChanged;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "user_authorities",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    private List<Authority> authorities;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Group group;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Participation> participations = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Submission> submissions = new ArrayList<>();

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_assignments",
//            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "assignment_id", referencedColumnName = "id")})
//    private List<Assignment> assignments;
}
