package com.example.testing.demo;

import com.example.testing.demo.entity.Employee;
import com.example.testing.demo.entity.Event;
import com.example.testing.demo.repository.EmployeeRepository;
import com.example.testing.demo.repository.EventRepository;
import org.salespointframework.core.DataInitializer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyDataInitializer implements DataInitializer {

    private EmployeeRepository employeeRepository;

    private EventRepository eventRepository;

    public MyDataInitializer(EmployeeRepository employeeRepository, EventRepository eventRepository) {
        this.employeeRepository = employeeRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public void initialize() {

        employeeRepository.save(new Employee("max Mustermann", "drogendealer"));
        employeeRepository.save(new Employee("zac zuhälter", "zuhälter"));

        eventRepository.save(new Event("Ein Name", "fakestreet1"));
        eventRepository.save(new Event("Ein anderer Name", "musterstraße 13"));

    }
}
