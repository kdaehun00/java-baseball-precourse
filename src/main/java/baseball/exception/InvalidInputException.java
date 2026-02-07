package baseball.exception;

import lombok.Getter;

@Getter
public class InvalidInputException extends IllegalArgumentException {
    private final CommonErrorCode commonErrorCode;

    public InvalidInputException(CommonErrorCode commonErrorCode) {
        super(commonErrorCode.getMessage());
        this.commonErrorCode = commonErrorCode;
    }
}
