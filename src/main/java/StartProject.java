import comparator.ComparatorMain;
import comparator.interfaces.StudentComparator;
import comparator.interfaces.UniversityComparator;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;
import model.Statistics;
import model.Student;
import model.University;
import util.JsonUtil;
import util.ReaderExcel;
import util.XlsWriter;

import java.io.IOException;
import java.util.List;

import static util.StatisticsUtil.createStatistics;

public class StartProject {

    public static void main(String[] args) throws IOException {

        List<University> universities = ReaderExcel.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = ComparatorMain.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.stream().sorted(universityComparator);

        String universitiesJson = JsonUtil.universityListToJson(universities);
        System.out.println(universitiesJson);

        List<University> universitiesFromJson = JsonUtil.jsonToUniversityList(universitiesJson);
        System.out.println(universities.size() == universitiesFromJson.size());
        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            System.out.println(universityFromJson);
        });

        List<Student> students = ReaderExcel.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = ComparatorMain.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.stream().sorted(studentComparator);

        String studentsJson = JsonUtil.studentListToJson(students);
        System.out.println(studentsJson);

        List<Student> studentsFromJson = JsonUtil.jsonToStudentsList(studentsJson);
        System.out.println(students.size() == studentsFromJson.size());
        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
            System.out.println(studentFromJson);
        });

        List<Statistics> statisticsList = createStatistics(students, universities);
        XlsWriter.writeStatistic(statisticsList, "statistics.xlsx");
    }

}
