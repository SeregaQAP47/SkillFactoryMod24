package util;

import model.Statistics;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XlsWriter {

    private static final Logger logger = Logger.getLogger(XlsWriter.class.getName());

    private XlsWriter() {
    }

    public static void writeStatistic(List<Statistics> statisticsList, String pathFile) {

        logger.log(Level.INFO, "Excel writing started");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet statisticsSheet = workbook.createSheet("Статистика");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setFontName("Arial");
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);

        int rowNumber = 0;
        Row headerRow = statisticsSheet.createRow(rowNumber++);
        Cell profileCellHeader = headerRow.createCell(0);
        profileCellHeader.setCellValue("Профиль обучения");
        profileCellHeader.setCellStyle(headerStyle);

        Cell avgScoreCellHeader = headerRow.createCell(1);
        avgScoreCellHeader.setCellValue("Средний балл за экзамены по профилю");
        avgScoreCellHeader.setCellStyle(headerStyle);

        Cell numberOfStudentsCellHeader = headerRow.createCell(2);
        numberOfStudentsCellHeader.setCellValue("Количество студентов по профилю");
        numberOfStudentsCellHeader.setCellStyle(headerStyle);

        Cell numberOfUniversitiesCellHeader = headerRow.createCell(3);
        numberOfUniversitiesCellHeader.setCellValue("Количество университетов по профилю");
        numberOfUniversitiesCellHeader.setCellStyle(headerStyle);

        Cell universitiesCellHeader = headerRow.createCell(4);
        universitiesCellHeader.setCellValue("Университеты");
        universitiesCellHeader.setCellStyle(headerStyle);

        for (Statistics statistics : statisticsList) {
            Row dataRow = statisticsSheet.createRow(rowNumber++);
            Cell profile = dataRow.createCell(0);
            profile.setCellValue(statistics.getProfile().getProfileName());

            Cell avgScore = dataRow.createCell(1);
            avgScore.setCellValue(statistics.getAvgExamScore());

            Cell numberOfStudents = dataRow.createCell(2);
            numberOfStudents.setCellValue(statistics.getNumbersOfStudents());

            Cell numberOfUniversities = dataRow.createCell(3);
            numberOfUniversities.setCellValue(statistics.getNumbersOfUniversities());

            Cell universities = dataRow.createCell(4);
            universities.setCellValue(statistics.getUniversityName());
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(pathFile);
            workbook.write(outputStream);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "New excel file writing failed", e);
            return;
        }

        logger.log(Level.INFO, "Excel writing finished successfully");
    }

}
