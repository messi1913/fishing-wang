package com.ddastudio.fishing.exception;

/**
 * @author messi1913@gmail.com
 * @since 2019-08-05
 * @Github http://github.com/messi1913
 */
public class FishingValidationException extends FishingException {
    public FishingValidationException() {
        super();
    }

    public FishingValidationException(String message) {
        super(message);
    }

    public FishingValidationException(Throwable cause) {
        super(cause);
    }

    public FishingValidationException(String message, Throwable cause) {
        super(message, cause);
    }

}
