package com.ms.common.exception;

import java.io.Serializable;

/**
 * 工具类异常
 *
 * @author 萌森 Ms
 * @Created 2022/5/19 15:02
 */
public class MsUtilsException extends Throwable implements Serializable {

    private static final long serialVersionUID = -8275836796415184541L;

    public MsUtilsException() {
    }

    public MsUtilsException(String message) {
        super(message);
    }

    public MsUtilsException(String message, Throwable cause) {
        super(message, cause);
    }

    public MsUtilsException(Throwable cause) {
        super(cause);
    }

    protected MsUtilsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
