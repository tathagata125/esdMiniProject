package com.esd.assignment.dto;

import com.esd.assignment.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private String courseName;
    private String description;
    private Long courseId;
    private InstructorDto instructor;
    private List<StudentDto> studentList;
}
