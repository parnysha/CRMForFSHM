package org.example.crmforfshm.service.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CheckCorrectStringFieldImpl implements CheckCorrectStringField{
    private static final Logger log = LoggerFactory.getLogger(CheckCorrectStringFieldImpl.class);
    @Override
    public boolean check(Boolean condition, String field) {
        if(condition){
            log.info("Корректное поле: "+field);
            return true;
        }
        log.info("Сотрудник имеет некорректное поле: "+field);
        return false;
    }
}
