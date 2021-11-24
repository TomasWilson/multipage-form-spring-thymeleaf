package com.example.testing.demo.form;

import com.example.testing.demo.entity.Employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EventForm implements Serializable {

    private String name;

    private String address;

    private List<Long> employeeIds;

    public EventForm() {
        this.employeeIds = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmployeeIds(List<Long> employeeIds) {
        this.employeeIds = employeeIds;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Long> getEmployeeIds() {
        return employeeIds;
    }

    public void addEmployeeId(Long employeeId) {
        employeeIds.add(employeeId);
    }

}
