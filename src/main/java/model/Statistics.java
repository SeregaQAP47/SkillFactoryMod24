package model;

import enums.StudyProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statistics {
    private StudyProfile profile;
    private float avgExamScore;
    private int numbersOfStudents;
    private int numbersOfUniversities;
    private String universityName;
}
