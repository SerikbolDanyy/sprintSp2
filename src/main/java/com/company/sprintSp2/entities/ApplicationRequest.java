package com.company.sprintSp2.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CRMDB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "userName", length = 200)
    private String userName;

    @Column(name = "courseName", length = 200)
    private String courseName;

    @Column(name = "commentary", length = 200)
    private String commentary;

    @Column(name = "phone", length = 200)
    private String phone;

    @Column(name = "handled")
    private boolean handled;
}
