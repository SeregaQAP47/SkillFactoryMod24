package comparator.universityComparators;

import comparator.interfaces.UniversityComparator;
import model.University;
import org.apache.commons.lang3.StringUtils;

public class UniversityStudyProfileComparator implements UniversityComparator {

    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getMainProfile().name(), o2.getMainProfile().name());
    }
}
