package io.hyun.backend.entities;

import io.hyun.backend.entities.references.Address;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userEmail;
    private String userPassword;
    private String userNickName;
    @Embedded
    private Address userAddress;
    private String userPhoneNumber;
    @OneToMany(mappedBy = "user")
    private List<Posting> postingList = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Comment> commentList = new ArrayList<>();
}
