package model;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class University {
    @XmlElement(name = "universityId")
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    @XmlElement(name = "universityName")
    private String fullName;

    @SerializedName("shortName")
    @XmlTransient
    private String shortName;

    @SerializedName("year")
    @XmlTransient
    private int yearOfFoundation;

    @SerializedName("profile")
    @XmlElement(name = "universityProfile")
    private StudyProfile mainProfile;
}
