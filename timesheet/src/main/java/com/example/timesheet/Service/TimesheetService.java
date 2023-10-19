package com.example.timesheet.Service;

import com.example.timesheet.Repository.TimesheetRepository;
import com.example.timesheet.entity.Timesheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TimesheetService {

    public Timesheet saveTimesheet(Timesheet timesheet);

    public List<Timesheet> fetchTimesheetList();
    public void deleteTimesheetById(Long timesheetId);
    public Timesheet updateTimesheet(Long timesheetId,Timesheet timesheet);
    Timesheet fetchTimesheetById(Long timesheetId);

}
