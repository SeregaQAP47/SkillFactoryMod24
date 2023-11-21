import model.Student;
import model.StudyProfile;
import model.University;

public class StartProject {
    public static void main(String[] args) {
        University university = new University("1122", "Московский Государственный Индустриальный Университет", "МГИУ", 1973, StudyProfile.ENGINEERING);
        Student student = new Student("Jack", "1399", 1, 4.7F);
        System.out.println(university.toString());
        System.out.println(student.toString());
    }
}
