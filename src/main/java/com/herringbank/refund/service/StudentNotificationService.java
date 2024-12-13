package com.herringbank.refund.service;

import org.springframework.web.multipart.MultipartFile;

public interface StudentNotificationService {
    void sendStudentNotification(MultipartFile file);
}
