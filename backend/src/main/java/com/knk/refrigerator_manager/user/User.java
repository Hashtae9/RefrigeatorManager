package com.knk.refrigerator_manager.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_pwd")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "user_phone")
    private String phone;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_birth")
    private String birth;

    @Column(name = "user_profile")
    private String profile;

    @Column(name = "enroll_date")
    private Date enroll_date;

    @Column(name = "login_type")
    @Enumerated(EnumType.STRING)
    private LoginType login_type;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Builder
    public User(String password, String username, String phone, String email, String birth,
                String profile, Date enroll_date,Boolean isDeleted) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.birth = birth;
        this.profile = profile;
        this.enroll_date = enroll_date;
        this.isDeleted = isDeleted;
    }

    public void updatePassword(String password){
        this.password = password;
    }
}
