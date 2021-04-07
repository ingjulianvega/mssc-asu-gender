package ingjulianvega.ximic.msscasugender.exception;

import lombok.Getter;

@Getter
public class GenderException extends RuntimeException {

    private final String code;

    public GenderException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}

