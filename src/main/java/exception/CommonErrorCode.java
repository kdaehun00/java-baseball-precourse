package exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CommonErrorCode implements ErrorCode {

    EMPTY_INPUT("EMPTY_INPUT", "입력값이 비어있습니다."),
    INVALID_LENGTH("INVALID_LENGTH", "3자리 숫자를 입력해야 합니다."),
    NOT_A_NUMBER("NOT_A_NUMBER", "숫자만 입력해야 합니다."),
    NUMBER_OUT_OF_RANGE("NUMBER_OUT_OF_RANGE", "각 자리는 1~9 사이여야 합니다."),
    DUPLICATED_NUMBER("DUPLICATED_NUMBER", "중복되지 않는 숫자 3개여야 합니다."),
    INVALID_COMMAND("INVALID_COMMAND", "1 또는 2를 입력해야 합니다.");

    private final String code;
    private final String message;
}
