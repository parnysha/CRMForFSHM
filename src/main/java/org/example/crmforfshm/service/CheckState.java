package org.example.crmforfshm.service;

import lombok.RequiredArgsConstructor;
import org.example.crmforfshm.dto.Person;
import org.springframework.stereotype.Service;


public interface CheckState {
    boolean checkProbel(Person person);

}
