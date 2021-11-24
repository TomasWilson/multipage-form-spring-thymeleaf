package com.example.testing.demo.form;

import java.io.Serializable;

public class EmployeeForm {

    private String name;

    private String jobTitle;


    public EmployeeForm() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

}
