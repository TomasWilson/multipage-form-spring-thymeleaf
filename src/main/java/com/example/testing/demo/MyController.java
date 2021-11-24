package com.example.testing.demo;

import com.example.testing.demo.entity.Employee;
import com.example.testing.demo.form.EventForm;
import com.example.testing.demo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@SessionAttributes("eventForm")
public class MyController {

    private final Logger LOG = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @ModelAttribute("eventForm")
    public EventForm eventForm() {
        return new EventForm();
    }

    @GetMapping("/event/create")
    public String createEventView(@ModelAttribute("eventForm") EventForm eventForm, Model model) {

        model.addAttribute("selectedEmployees", employeeRepository.findAllById(eventForm.getEmployeeIds()));

        return "event_form";
    }

    @PostMapping("/event/create")
    public String createEventForm(@ModelAttribute("eventForm") /*@Valid*/ EventForm eventForm,
                                  @RequestParam(value = "select_employee", required = false) String selectEmployee,
                                  @RequestParam(value = "remove_employee", required = false) Long removeEmployeeId,
                                  Model model) {

        // if the selectEmployee parameter is set, redirect to the select page
        // this will make sure the EventForm is persisted as a @SessionAttribute,
        // (even if its only filled out partially)
        if(selectEmployee != null) return "redirect:/employee/select";

        if(removeEmployeeId != null) {
            eventForm.getEmployeeIds().remove(removeEmployeeId);
            return "redirect:/event/create";
        }

        LOG.warn("EventForm post received");

        // TODO : validate the form, persist it and then reset it to be empty

        // this resets the current form, by overriding
        // the "eventForm" session attribute
        model.addAttribute("eventForm", new EventForm());

        return "redirect:/event/create";
    }

    @GetMapping("/employee/select")
    public String selectEmployeeView(@ModelAttribute("eventForm") EventForm eventForm, Model model) {

        List<Employee> allEmployees = employeeRepository.findAll();

        // all employees that can be added (i.e. are not in the form already)
        List<Employee> availableEmployees = allEmployees
                .stream()
                .filter(e -> !eventForm.getEmployeeIds().contains(e.getId()))
                .collect(Collectors.toList());

        model.addAttribute("availableEmployees", availableEmployees);

        return "select_employee_form";

    }

    @PostMapping("/employee/select")
    public String selectEmployeePost(@ModelAttribute("eventForm") EventForm eventForm,
                                     @RequestParam("employeeId") Long employeeId) {

        if(employeeId == null) throw new IllegalArgumentException("employee id shouldnt be null!");

        eventForm.addEmployeeId(employeeId);

        return "redirect:/event/create";

    }


}
