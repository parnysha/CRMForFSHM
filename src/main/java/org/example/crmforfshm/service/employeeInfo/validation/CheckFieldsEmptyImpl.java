package org.example.crmforfshm.service.employeeInfo.validation;

import lombok.SneakyThrows;
import org.example.crmforfshm.dto.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.lang.reflect.Field;
@Service
public class CheckFieldsEmptyImpl implements CheckCorrect<Employee>{
    private static final Logger log = LoggerFactory.getLogger(CheckFieldsEmptyImpl.class);
    @SneakyThrows
    @Override
    public boolean check(Employee employee) {

        for(Field field : employee.getClass().getDeclaredFields()) {
            if (field.getName()!="dateFormatDis"){
                field.setAccessible(true);
                String employeeFieldValue = (String) field.get(employee);
                if(employeeFieldValue.replaceAll(" ", "").isEmpty()){
                    log.info("Пустое поле "+field.getName());
                    return false;
                }
            }
        }
        return true;
    }
}
