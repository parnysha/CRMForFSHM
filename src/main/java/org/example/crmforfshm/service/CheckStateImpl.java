package org.example.crmforfshm.service;

import org.example.crmforfshm.dto.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

@Service
public class CheckStateImpl implements CheckState,CheckDate, CheckCorrectFields {
    private static final Logger log = LoggerFactory.getLogger(CheckStateImpl.class);

    @Override
    public boolean checkProbel(Person person){
        if("".equals(person.getGroupPerson().replaceAll(" ", ""))){
            log.info("Пустое поле группы сотрудников");
            return false;
        }
        if("".equals(person.getName().replaceAll(" ", ""))){
            log.info("Пустое поле имени");
            return false;
        }
        if("".equals(person.getPost().replaceAll(" ", ""))){
            log.info("Пустое поле должности");
            return false;
        }
        if("".equals(person.getDateBirth().replaceAll(" ", ""))){
            log.info("Пустое поле даты рождения");
            return false;
        }
        if("".equals(person.getSex().replaceAll(" ", ""))){
            log.info("Пустое поле пола");
            return false;
        }
        if("".equals(person.getDateFormatAdd().replaceAll(" ", ""))){
            log.info("Пустое поле даты приёма");
            return false;
        }
        if("".equals(person.getSnils().replaceAll(" ", ""))){
            log.info("Пустое поле снилса");
            return false;
        }
        if("".equals(person.getSubdivision().replaceAll(" ", ""))){
            log.info("Пустое поле подразделения");
            return false;
        }
        return true;
    }
    @Override
    public boolean checkDefDate(String date){
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
    @Override
    public boolean checkDelDate(String date){
        if(!"".equals(date.replaceAll(" ", ""))){
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                sdf.setLenient(false);
                Date parsedDate = sdf.parse(date);
                log.info("Дата увольнения: "+date+" корректна");
                return true;
            } catch (Exception e) {
                log.info("Дата увольнения: "+date+" не корректна");
                return false;
            }
        }
        log.info("Поле даты увольнения пустое");
        return true;
    }
    @Override
    public boolean checkCorrectGroupd(String group){
        if("Штатные сотрудники".equals(group)||"Уволенные сотрудники".equals(group)){
            log.info("Сотрудник принадлежит группе: "+group);
            return true;
        }
        log.info("Сотрудник имеет некорректную группу");
        return false;
    }

    @Override
    public boolean checkCorrectSex(String sex) {
        if("Мужской".equals(sex)||"Женский".equals(sex)){
            log.info("Сотрудник имеет "+sex+" пол");
            return true;
        }
        log.info("Сотрудник имеет некорректный пол");
        return false;
    }
    @Override
    public final boolean checkCorrectSnils(String snils){
        if(Pattern.matches("\\d{3}-\\d{3}-\\d{3}-\\d{2}$",snils)||Pattern.matches("\\d{3}-\\d{3}-\\d{3} \\d{2}$",snils)){
            log.info("Сотрудник имеет корректный снилс: "+snils);
            return true;
        }
        log.info("Сотрудник имеет некорректный снилс");
        return false;
    }
    public boolean checkCorrect(Person person){
        if(!checkProbel(person)){
            log.info("Имеется пустое недопустимое поле");
            return false;
        }
        if (!checkCorrectGroupd(person.getGroupPerson())||!checkCorrectSex(person.getSex())||!checkCorrectSnils(person.getSnils())){
            return false;
        }
        if(!checkDefDate(person.getDateBirth())){
            log.info("Дата рождения имеет некорректный формат");
            return false;
        }
        if(!checkDefDate(person.getDateFormatAdd())){
            log.info("Дата приема имеет некорректный формат");
            return false;
        }
        if(!checkDelDate(person.getDateFormatDis())){
            log.info("Дата увольнения имеет некорректный формат");
            return false;
        }
        return true;
    }
}
