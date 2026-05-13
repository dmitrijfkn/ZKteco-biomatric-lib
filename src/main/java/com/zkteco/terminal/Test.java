package com.zkteco.terminal;

import com.zkteco.commands.AttendanceRecord;
import com.zkteco.commands.ZKCommandReply;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


public class Test {

    private static final ZKTerminal zkTerminal = new ZKTerminal("10.43.221.234", 4370);

    public static void main(String[] args) throws Exception {
        try {
            ZKCommandReply reply = zkTerminal.connect();

            zkTerminal.connectAuth(0).getCode();

            List<AttendanceRecord> attendanceLogs = zkTerminal.getAttendanceRecords();

            ZoneId zone = ZoneId.systemDefault();
            ZonedDateTime nowZdt = ZonedDateTime.now(zone);
            Instant minAllowedDate = nowZdt.minusMonths(3).toInstant();
            Instant maxAllowedDate = nowZdt.plusHours(1).toInstant();

            List<AttendanceRecord> validDateLogs = new ArrayList<>();
            List<AttendanceRecord> invalidDateLogs = new ArrayList<>();

            for (AttendanceRecord row : attendanceLogs) {
                Instant recordTime = row.getRecordTime().toInstant();
                if (recordTime.isBefore(minAllowedDate) || recordTime.isAfter(maxAllowedDate)) {
                    invalidDateLogs.add(row);
                } else {
                    validDateLogs.add(row);
                }
            }

            System.out.println(attendanceLogs.size());
            System.out.println(validDateLogs.size());
            System.out.println(invalidDateLogs.size());
        } finally {
            zkTerminal.disconnect();
        }

    }

}
