package com.zkteco.commands;

import com.zkteco.enums.CommandReplyCodeEnum;
import lombok.Getter;

@Getter
public class ZKCommandReply {

    private final CommandReplyCodeEnum code;
    private final int sessionId;
    private final int replyId;
    private final int[] payloads;

    public ZKCommandReply(CommandReplyCodeEnum code, int sessionId, int replyId, int[] payloads) {
        this.code = code;
        this.sessionId = sessionId;
        this.replyId = replyId;
        this.payloads = payloads;
    }

}
