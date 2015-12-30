package com.powertrader.exception;

/**
 * Created by dudus on 2015-11-28.
 */
public class PowerTraderException extends RuntimeException {

    public PowerTraderException(String message) {
        super(message);
    }

    public PowerTraderException(String message, Throwable cause) {
        super(message, cause);
    }

    public PowerTraderException(Throwable cause) {
        super(cause);
    }

    public PowerTraderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
