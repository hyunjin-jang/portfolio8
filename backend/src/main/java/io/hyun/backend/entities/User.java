package io.hyun.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.hyun.backend.entities.references.Address;
import io.hyun.backend.entities.references.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;


import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false)
    private String userEmail;
    @Column(nullable = false)
    private String userPassword;
    @Column(nullable = false)
    private String userNickName;
    @Embedded
    private Address userAddress;
    private String userPhoneNumber;
    @ColumnDefault("'USER'")
    @Enumerated(EnumType.STRING)
    private Role role; // USER, ADMIN
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Posting> postingList = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();
}
