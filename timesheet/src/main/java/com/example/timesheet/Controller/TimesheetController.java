package com.example.timesheet.Controller;

import com.example.timesheet.Repository.TimesheetRepository;
import com.example.timesheet.Repository.UserRepository;
import com.example.timesheet.Service.TimesheetService;
import com.example.timesheet.Service.UserService;
import com.example.timesheet.entity.Timesheet;
import com.example.timesheet.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimesheetController {

    @Autowired
    private TimesheetService timesheetService;
    @Autowired
    private TimesheetRepository timesheetRepository;
    @Autowired
    private UserRepository userRepository;

    //@CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/timesheets")
    public ResponseEntity<Timesheet> createTimesheet( @RequestBody Timesheet timesheet) {
        Timesheet savedTimesheet = timesheetService.saveTimesheet(timesheet);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTimesheet);
    }
    @GetMapping("/timesheets")
    public List<Timesheet> fetchTimesheetList(){
        return timesheetService.fetchTimesheetList();
    }

    @GetMapping("/timesheet/task={task}")
    public List<Timesheet> findTimesheetByName(@PathVariable("task") String task){
        return timesheetRepository.findTimesheetByTask(task);
    }

    @GetMapping("/timesheet/id={id}")
    public Timesheet fetchTimesheetById(@PathVariable("id") Long timesheetId) {
        return timesheetService.fetchTimesheetById(timesheetId);
    }

    @DeleteMapping("/timesheet/{id}")
    public String deletedTimesheetById(@PathVariable("id") Long timesheetId){
        timesheetService.deleteTimesheetById(timesheetId);
        return "Timesheet deleted!";
    }

    @PutMapping("/timesheet/{id}")
    public Timesheet updateTimesheet(@PathVariable("id") Long timesheetId,@RequestBody Timesheet timesheet){
        return timesheetService.updateTimesheet(timesheetId,timesheet);
    }
}
