import comparator.ComparatorMain;
import comparator.interfaces.StudentComparator;
import comparator.interfaces.UniversityComparator;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;
import model.Student;
import enums.StudyProfile;
import model.University;
import util.ReaderExcel;

import java.io.IOException;
import java.util.List;

public class StartProject {

    public static void main(String[] args) throws IOException {

        List<University> universities = ReaderExcel.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = ComparatorMain.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);

        List<Student> students = ReaderExcel.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = ComparatorMain.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);
    }
}
