package com.esd.assignment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id")
    private Long instructorId;

    @Column(name = "instructor_name")
    private String instructorName;

    @Column(name = "instructor_email")
    private String instructorEmail;

    @Column(name = "instructor_phone")
    private String instructorPhone;

    @OneToMany(mappedBy = "courseInstructor")
    @JsonBackReference
    private List<Course> courses;

}
