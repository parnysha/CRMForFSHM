package org.example.crmforfshm.service.employeeInfo.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CheckCorrectDateImpl implements CheckCorrect<String> {
    private static final Logger log = LoggerFactory.getLogger(CheckCorrectDateImpl.class);
    @Override
    public boolean check(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            sdf.setLenient(false);
            Date parsedDate = sdf.parse(date);
            log.info("Дата: "+date+" корректна");
            return true;
        } catch (Exception e) {
            log.info("Дата: "+date+" не корректна");
            return false;
        }
    }
}
