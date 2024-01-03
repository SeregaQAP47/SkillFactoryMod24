import comparator.ComparatorMain;
import comparator.interfaces.StudentComparator;
import comparator.interfaces.UniversityComparator;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;
import model.FullInfo;
import model.Statistics;
import model.Student;
import model.University;
import util.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;


public class StartProject {

        private static final Logger logger = Logger.getLogger(StartProject.class.getName());

        public static void main(String[] args) throws IOException {

            try {
                LogManager.getLogManager().readConfiguration(
                        StartProject.class.getResourceAsStream("/logging.properties"));
            } catch (IOException e) {
                System.err.println("Could not setup logger configuration: " + e.toString());
            }

            logger.log(INFO, "Application started, Logger configured");

            List<University> universities =
                    ReaderExcel.readXlsUniversities("src/main/resources/universityInfo.xlsx");
            UniversityComparator universityComparator =
                    ComparatorMain.getUniversityComparator(UniversityComparatorType.YEAR);
            universities.sort(universityComparator);

            List<Student> students =
                    ReaderExcel.readXlsStudents("src/main/resources/universityInfo.xlsx");
            StudentComparator studentComparator =
                    ComparatorMain.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
            students.sort(studentComparator);

            List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
            XlsWriter.writeStatistic(statisticsList, "statistics.xlsx");

            FullInfo fullInfo = new FullInfo()
                    .setStudentList(students)
                    .setUniversityList(universities)
                    .setStatisticsList(statisticsList)
                    .setProcessDate(new Date());


            XmlWriter.generateXmlReq(fullInfo);
            JsonWriter.writeJsonReq(fullInfo);

            logger.log(INFO, "Application finished");
        }

}
