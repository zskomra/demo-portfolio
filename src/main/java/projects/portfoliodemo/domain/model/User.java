package projects.portfoliodemo.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "username")
@ToString(exclude = "password")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;


    private String password;
    private Boolean active = Boolean.FALSE;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_roles",
            joinColumns =
    @JoinColumn(name = "username", referencedColumnName = "username"),
            indexes = @Index(name = "users_roles_username_idx", columnList = "username"))
    @Column(name = "role")
    private Set<String> roles;
}
