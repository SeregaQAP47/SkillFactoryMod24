package comparator;

import comparator.interfaces.StudentComparator;
import comparator.interfaces.UniversityComparator;
import comparator.studentComparators.StudentAvgExamScoreComparator;
import comparator.studentComparators.StudentCurrentCourseNumberComparator;
import comparator.studentComparators.StudentFullNameComparator;
import comparator.studentComparators.StudentUniversityIdComparator;
import comparator.universityComparators.*;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;

public class ComparatorMain {

    public static StudentComparator getStudentComparator(StudentComparatorType studentComparatorType) {
        return switch (studentComparatorType) {
            case FULL_NAME -> new StudentFullNameComparator();
            case UNIVERSITY_ID -> new StudentUniversityIdComparator();
            case COURSE_NUMBER -> new StudentCurrentCourseNumberComparator();
            case AVG_EXAM_SCORE -> new StudentAvgExamScoreComparator();
        };
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorType universityComparatorType) {
        return switch (universityComparatorType) {
            case ID -> new UniversityIdComparator();
            case FULL_NAME -> new UniversityFullNameComparator();
            case SHORT_NAME -> new UniversityShortNameComparator();
            case MAIN_PROFILE -> new UniversityStudyProfileComparator();
            case YEAR -> new UniversityYearOfFoundationComparator();
        };
    }
}
