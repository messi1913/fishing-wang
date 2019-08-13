package com.ddastudio.fishing.exception;

/**
 * @author messi1913@gmail.com
 * @since 2019-08-05
 * @Github http://github.com/messi1913
 */
public class FishingException extends Exception {

    public FishingException() {
        super();
    }

    public FishingException(String message) {
        super(message);
    }

    public FishingException(Throwable cause) {
        super(cause);
    }

    public FishingException(String message, Throwable cause) {
        super(message, cause);
    }

}
