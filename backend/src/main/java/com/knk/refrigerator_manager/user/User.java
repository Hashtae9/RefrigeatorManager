package com.knk.refrigerator_manager.user;


import com.knk.refrigerator_manager.refrigerator.Refrigerator;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Entity //jpa entity 선언
@Getter @Setter
@Table(name="user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class User {
    @Id
    @Column(name = "USER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_PWD")
    private String password;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "USER_PHONE")
    private String phone;

    @Column(name = "USER_EMAIL")
    private String email;
    @Column(name = "USER_ROLE")
    private String role;
    @Column(name = "USER_BIRTH")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    @Column(name = "enroll_date")
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime enroll_date;

    @Column(name = "login_type")
    @Enumerated(EnumType.STRING) //enum의 String 값 자체가 db에 저장
    private LoginType login_type;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "refri_seq")
    private Refrigerator refrigerator;

    @Builder
    public User(Long id, String password, String username, String phone, String email, Date birth,
                LocalDateTime enroll_date, LoginType login_type, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.birth = birth;
        this.enroll_date = enroll_date;
        this.login_type = login_type;
        this.role = role;
    }

    public void updatePassword(String password){
        this.password = password;
    }
}
