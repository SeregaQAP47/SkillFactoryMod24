package model;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class University {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String fullName;
    @SerializedName("shortName")
    private String shortName;
    @SerializedName("year")
    private int yearOfFoundation;
    @SerializedName("profile")
    private StudyProfile mainProfile;
}
