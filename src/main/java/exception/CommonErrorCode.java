package exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CommonErrorCode implements ErrorCode {

    private final String code;
    private final String message;
}
