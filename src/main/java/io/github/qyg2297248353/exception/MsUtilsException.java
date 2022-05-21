/*
 * Ms.萌森工作室 Copyright (c) 2022. Java基本工具开发由萌森工作室倾情打造，请勿恶意转载！
 */

package io.github.qyg2297248353.exception;

import java.io.Serializable;


/**
 * The type Ms utils exception.
 *
 * @author Ms
 */
public class MsUtilsException extends Exception implements Serializable {

    private static final long serialVersionUID = -8275836796415184541L;

    /**
     * Instantiates a new Ms utils exception.
     */
    public MsUtilsException() {
    }

    /**
     * Instantiates a new Ms utils exception.
     *
     * @param message the message
     */
    public MsUtilsException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Ms utils exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public MsUtilsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Ms utils exception.
     *
     * @param cause the cause
     */
    public MsUtilsException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Ms utils exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected MsUtilsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
