package com.zkteco.enums;

import lombok.Getter;

@Getter
public enum AttendanceTypeEnum {
    PASSWORD(0),
    FINGERPRINT(1),
    RF_CARD(2),
    UNKNOWN(3);

    private final int attendanceType;

    AttendanceTypeEnum(int attendanceType) {
        this.attendanceType = attendanceType;
    }

}
