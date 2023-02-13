package com.knk.refrigerator_manager.refrigerator;

import com.knk.refrigerator_manager.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "refrigerator")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Refrigerator {
    @Id
    @Column(name = "refri_seq", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refri_seq;

    @Column(name = "refri_name")
    private String refri_name;

    @Column(name = "refri_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date refri_date;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
