package com.zkteco.terminal;

import com.zkteco.commands.UserInfo;
import com.zkteco.commands.ZKCommandReply;

import java.util.Base64;
import java.util.List;

import static com.zkteco.enums.UserRoleEnum.USER_DEFAULT;


public class Test {

    private static final ZKTerminal zkTerminal = new ZKTerminal("172.23.16.61", 4370);

    public static String f1 = "SslTUzIxAAADiogECAUHCc7QAAAvi4ABAAAAg7cfnIoJASQPhQDbATCFhwDkABkOrgAIi1QJYgAYAY8PZ4rrAO4MiwCQAUKFdQBXAU4PfQBkiy4P8gBjAWsP+4qjAB4PhADGASaDtAAcAaMPtwAciz0PwwDvAO8PforUAAkPaQAaAGGEWwDWAPEOHwDKiiQPDAEUAWkOAotYAbIOgwA3AHmDeAD9AAkJCAAOi6sPjwA7Af0PoIrLABkPzAD/ASyFkQC2AIIPQgBri0YO3QCkAOQPHYooAUYP5QO7gMF7zPkNE4L8dKASmrwThQwNTZgZEn5IEBZBZI+E/rJtiP299gUL9A5SgBMa4/DT6OIAvnd2glOD4f96+Lx98R8ZrNHTDPt9Cgd21fRBCTzpiQq/Cy4HofAgqrEacXe1cA1aYJC+jI/pIgWy//IIWI0e/0N/OQWih5SB0GBlcEVUSedWGti1QQuKgN9/knH/BKruCZsPAt2Y+44Wh6cA5GtV80poAQnZ+sYQXo2n/csLM//q8zSFOSwfZSAuxAH3l2YKAINbBpP//XVbDQB7YwYFWP3I/FsFAHNlv2kRiiiK6UBHQPhLwp0BF6bgMEf7wP51RsD///89zQDjLCFYPAMA+WMiwpkBjraGkYtBa2n5HQAMw9b+hT38tzTA//79doFBBYqdyoySww7FpMia//7/wD7B/cIEitrNJlhKBMWk05D+/w8AgNbMMzXNwf5wCwBdHPTDdfz9//7+WsgAVlFhfG9cVBDFb92KL/8ywEL/qw0D7d5wncLAfqEeA4nk1kc4OP87OEN1/8DBNzf9zACLbBH9Pv5XCMVo73r6+/9MCwCl7mFLw4RywAsADfAlzk6LCwDC8eP/Wbx2DQCD8oYDwZH0w2ULAIn52f5Az08KAHP7aUhyfIARhwIe/jePwQqahQYmRP9SzBCigyjAwv3AReQQAobNwP/+wEaEQTDFRP/+U8D+BP4LmmgMXsKQcMIQfpM2wP9BBhCnGkrgwCEQAx/PlsD8tDo7/j7//+rBQHXBOAYQcCGFSv2MEXYhNz7A2hAjrs1GwED//jj/w3f+/v/+wP4EwP1L/v/A/sP+wBAZpkhWBxAhLINZ/U8EENA6LVLmEAaxyEL+wf/AO/9Fd/7+/v84ODtdUHRmBBDLPTGeBBMHPz1wBBCT+zdYmxFfZ8zCWwX++nj+OMA+";

    public static String f2 = "StNTUzIxAAADkJIECAUHCc7QAAAvkYABAAAAg70dy5DhABAP4QDmASSdaQAiAWgPLgAQkY4N7gA1AW0O0pBdATEP8gB5AI2fLQAwAVgPIACIkA8PqwBtADoP4ZAVARQNnwCNARefYAANAXAPTADBkAEPywC3AMgPeZBgAVcPCAGLATOfRgBiAdcP1gGkkI8LFwBdAZQPapAFAfoP0gAeAIifegBCAWUPJAA6kZ4OUADlADEP+ZBNATEPLQA0AGufGAHBABQO1AAtkVgPXIc2BpKGHoQwmZmKzfofcEWVbX5JaS7piAiCEgR7IpZCA+6I3ZJ7gvp+rQO+CVQSqoHLAYuCUvOwZ9IDaIax7Ftt9SHXv3/m7HuACsHv6g9795fza4V5Erv+7vQSR26B1pDzieaTL4hugVQSKH9eAouCLvg07AL55I/KlOsKZ++vgdb/XhDnUcVt1Pihev5wx42xbr+HVQD9iy+UDeUu+ydzJYs3igybLANjCPvzoVACnSEyAQISIHEFAz5NesIqAwATTYNSEADyVX1Wn8D84GXBAwAefKX9FZEOa4lmhcGQaVFuwl0IAK5txVdHlQHpjg9gFsQKhxxda8BwaVqdwhSRG5aQaWh4vVpyb2QXAQ+mkAXA/FRTwIT/XGoFbACQz7UJ/xAAA7aKFGNwwGLCFMXxuwPC/3hv/sIEYlpRCADOuxDAlv8/iQAru5Z2wAXC/FP+cntwwMC3FwKDv5BSgcDBosBxUcFawgUA93oTSZ8BjcMAwEA6VcOv/A0A09uJt8Fx58EJAMPgibV2wpoBy+AMQESPCgNb5xdd/sBTwAAof2yEGgAA9CzAPs3BQzj+N8HzQgWQLfVmacMb1QAHSinB/Xv+/zrAV27/wcD/REbKEG+U+0T/MDj9vQwTzwt0jP+Lb8sQZJz8VE/+//0FVgmAYRFtwI3AoxYTeROWdHd+VgFywswLEOQWGv87W0OeEW0g9/8+7UsymBFlIXGScMIQZLZqwsGDAxDULlVQBhArMFdkpR0TkDPW//9MK4FHMFDAK8DAwDHREOOoo8GIb3V1BmLCjxEAPtf+U4Q/VK4zL0rA/v0FBRPoRWaABRCgjRD9tAIQ/E4p/cgQzMilwcORwv8Gw26AEUhh0zMp9DFDlhF+atr8+z/9AICoapfHExAoarMUwv/CwZPBB8N2UwoQY2fa/+n/J24JELxopsMHxMAJ";

    public static void main(String[] args) throws Exception {
        try {
            ZKCommandReply reply = zkTerminal.connect();

            zkTerminal.connectAuth(0).getCode();

            List<UserInfo> users = zkTerminal.getAllUsers();

            System.out.println(users.size());
            //    zkTerminal.getUserTmpExStr(5000, 0);
        //    //    zkTerminal.resetDevice();
//
        //    UserInfo newUserInfo = new UserInfo(5000, "6000", "КостенкоТ", "", USER_DEFAULT, 0);
//
        //    ZKCommandReply createReply = zkTerminal.modifyUserInfo(newUserInfo);
//
        //    System.out.println(createReply);
//
        //    byte[] base64Bytes1 = Base64.getDecoder().decode(f1);
        //    zkTerminal.uploadFp(newUserInfo.getUid(), base64Bytes1, (byte) 0, (byte) 1);
        //    //zkTerminal.uploadAndVerifyFingerprint(newUserInfo, base64Bytes1, (byte) 0);
//
        //    byte[] base64Bytes2 = Base64.getDecoder().decode(f2);
        //    zkTerminal.uploadFp(newUserInfo.getUid(), base64Bytes2, (byte) 1, (byte) 1);
        //    //zkTerminal.uploadAndVerifyFingerprint(newUserInfo, base64Bytes1, (byte) 1);
//
        //    zkTerminal.saveData();
        } finally {
            zkTerminal.disconnect();
        }

    }

}
