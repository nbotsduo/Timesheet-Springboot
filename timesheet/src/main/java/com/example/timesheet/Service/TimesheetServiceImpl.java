package com.example.timesheet.Service;

import com.example.timesheet.Repository.TimesheetRepository;
import com.example.timesheet.entity.Timesheet;
import com.example.timesheet.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TimesheetServiceImpl implements TimesheetService{
    @Autowired
    public TimesheetRepository timesheetRepository;

    @Override
    public Timesheet saveTimesheet( Timesheet timesheet) {
        timesheet.setUser(timesheet.getUser());
        return timesheetRepository.save(timesheet);
    }

    @Override
    public List<Timesheet> fetchTimesheetList() {
        return timesheetRepository.findAll();
    }

    @Override
    public void deleteTimesheetById(Long timesheetId) {
        timesheetRepository.deleteById(timesheetId);
    }

    @Override
    public Timesheet updateTimesheet(Long timesheetId, Timesheet timesheet) {
       Timesheet tsDB = timesheetRepository.findById(timesheetId).get();

        if(Objects.nonNull(timesheet.getProjectName()) && !"".equalsIgnoreCase(timesheet.getProjectName())){
            tsDB.setProjectName(timesheet.getProjectName());
        }
        if(Objects.nonNull(timesheet.getTask()) && !"".equalsIgnoreCase(timesheet.getTask())){
            tsDB.setTask(timesheet.getTask());
        }
        if(Objects.nonNull(timesheet.getStatus()) && !"".equalsIgnoreCase(timesheet.getStatus())){
            tsDB.setStatus(timesheet.getStatus());
        }
        if(Objects.nonNull(timesheet.getStartDate())){
            tsDB.setStartDate(timesheet.getStartDate());
        }
        if(Objects.nonNull(timesheet.getEndDate())){
            tsDB.setEndDate(timesheet.getEndDate());
        }
        if(Objects.nonNull(timesheet.getUser())){
            tsDB.setUser(timesheet.getUser());
        }

        return timesheetRepository.save(tsDB);
    }

    @Override
    public Timesheet fetchTimesheetById(Long timesheetId) {
        return timesheetRepository.findTimesheetByTimesheetId(timesheetId);
    }
}
