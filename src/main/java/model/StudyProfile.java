package model;

public enum StudyProfile {
    ENGINEERING("инженерный"),
    MEDICAL("медицинский");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
