package com.example.timesheet.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Timesheet {
    @Id
    @SequenceGenerator(name="timesheet_sequence",sequenceName = "timesheet_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "timesheet_sequence")
    private Long timesheetId;
    private String projectName;
    private String task;
    private String status;
    private Date startDate;
    private Date endDate;

    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Long getUserId(){
        return user == null ? null : user.getUserId();
        //not sure how the country class is implemented
    }

}
