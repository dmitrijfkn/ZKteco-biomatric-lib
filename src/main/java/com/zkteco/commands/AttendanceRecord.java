package com.zkteco.commands;

import java.util.Date;

import com.zkteco.enums.AttendanceStateEnum;
import com.zkteco.enums.AttendanceTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AttendanceRecord {

    private int userSN;
    private String userID;
    private AttendanceTypeEnum verifyType;
    private Date recordTime;
    private AttendanceStateEnum verifyState;
}
