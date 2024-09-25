package org.example.crmforfshm.service.validation;

import org.example.crmforfshm.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class CheckCorrectEmployeeImpl implements CheckCorrect<Employee>{

    private final CheckCorrect<String> checkCorrectDate;
    private final CheckCorrectStringField checkCorrectStringField;
    private final CheckCorrect<Employee> checkFieldsEmpty;


    @Autowired
    public CheckCorrectEmployeeImpl(@Qualifier("checkCorrectDateImpl") CheckCorrect<String> checkCorrectDate, CheckCorrectStringField checkCorrectStringField,@Qualifier("checkFieldsEmptyImpl") CheckCorrect<Employee> checkFieldsEmpty){
        this.checkCorrectDate=checkCorrectDate;
        this.checkCorrectStringField=checkCorrectStringField;
        this.checkFieldsEmpty=checkFieldsEmpty;
    }

    @Override
    public boolean check(Employee employee) {
        boolean correctDateDis = true;
        if (!employee.getDateFormatDis().replaceAll(" ", "").isEmpty()){
            correctDateDis = checkCorrectDate.check(employee.getDateFormatDis());
        }
        return correctDateDis &&
                checkFieldsEmpty.check(employee) &&
                checkCorrectStringField.check("Штатные сотрудники".equals(employee.getGroupPerson())||"Уволенные сотрудники".equals(employee.getGroupPerson()),employee.getGroupPerson()) &&
                checkCorrectStringField.check("Мужской".equals(employee.getSex())||"Женский".equals(employee.getSex()),employee.getSex()) &&
                checkCorrectStringField.check(Pattern.matches("\\d{3}-\\d{3}-\\d{3}-\\d{2}$",employee.getSnils()),employee.getSnils()) &&
                checkCorrectDate.check(employee.getDateBirth()) &&
                checkCorrectDate.check(employee.getDateFormatAdd());
    }
}
