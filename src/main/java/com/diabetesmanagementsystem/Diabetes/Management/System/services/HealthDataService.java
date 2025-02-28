package com.diabetesmanagementsystem.Diabetes.Management.System.services;

import com.diabetesmanagementsystem.Diabetes.Management.System.model.Person;
import com.diabetesmanagementsystem.Diabetes.Management.System.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthDataService {

    @Autowired
    private PersonRepository personRepository;

    public Person findPersonByName(String name) {
        return personRepository.findByName(name);
    }
}