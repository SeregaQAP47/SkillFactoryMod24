package model;

import enums.StudyProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {
    @XmlElement(name = "universityProfile")
    private StudyProfile profile;

    @XmlElement(name = "avgScore")
    private float avgExamScore;

    @XmlTransient
    private int numbersOfStudents;

    @XmlTransient
    private int numbersOfUniversities;

    @XmlTransient
    private String universityName;
}
