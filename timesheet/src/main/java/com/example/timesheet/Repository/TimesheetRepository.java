package com.example.timesheet.Repository;

import com.example.timesheet.entity.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet,Long> {

    public Timesheet findTimesheetByTimesheetId(Long timesheetId);
    public List<Timesheet> findTimesheetByTask(String task);

}
