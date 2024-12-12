package menu.constants;

public enum Errors {

    //재시도 횟수 관련 에러
    OVER_MAX_RETRIES("최대 재시도 횟수 %d번을 초과했습니다."),

    //코치 관련 에러
    COACH_NAME_RANGE("코치의 이름은 %d 글자에서 %d 글자 사이로 입력해야 합니다."),
    COACHES_RANGE("코치들은 최소 %d명에서 %d명 사이로 입력해야 합니다.");


    private static final String PREFIX = "[ERROR] ";

    private String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX+message;
    }
