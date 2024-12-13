package com.herringbank.refund.service;

import com.herringbank.refund.helper.CSVHelper;
import com.herringbank.refund.model.Student;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StudentNotificationServiceImpl implements StudentNotificationService {

    private static final Logger LOG = LoggerFactory.getLogger(StudentNotificationServiceImpl.class);
    @Override
    public void sendStudentNotification(MultipartFile file) {
        try {
            List<Student> students = CSVHelper.csvToStudents(file);
            students.forEach(student -> LOG.info(student.getName()));

            //repository.saveAll(tutorials);
        } catch (Exception e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }


}
