package com.herringbank.refund.helper;

import com.herringbank.refund.model.Student;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "Name", "Refund", "Email", "Phone" };

    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<Student> csvToStudents(MultipartFile file) {
        try {
            // Create a reader for the CSV file content
            Reader reader = new InputStreamReader(file.getInputStream());

            // Ensure the first record is treated as the header row
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

            List<Student> students = new ArrayList<Student>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Student student = new Student();
                student.setName(csvRecord.get("Name"));
                student.setRefund(Double.parseDouble(csvRecord.get("Refund")));
                student.setEmail(csvRecord.get("Email"));
                student.setPhone(Integer.parseInt(csvRecord.get("Phone")));
                students.add(student);
            }

            return students;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
