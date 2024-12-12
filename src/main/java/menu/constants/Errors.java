package menu.constants;

public enum Errors {

    //재시도 횟수 관련 에러
    OVER_MAX_RETRIES("최대 재시도 횟수 %d번을 초과했습니다."),

    //메뉴 관련 에러
    NO_SUCH_MENU("존재하지 않는 메뉴입니다."),

    //코치 관련 에러
    COACH_NAME_RANGE("코치의 이름은 %d 글자에서 %d 글자 사이로 입력해야 합니다."),
    COACHES_RANGE("코치들은 최소 %d명에서 %d명 사이로 입력해야 합니다."),
    UNEATABLE_FOODS_RANGE("못먹는 음식은 최소 %d개이상 %d 이하여야 합니다."),
    INVALID_COACH_INPUT("코치들을 올바르게 입력하지 않았습니다."),
    INVALID_COACH_UNEATABLE_FOOD_INPUT("못 먹는 음식의 입력 형식이 올바르지 않습니다.");


    private static final String PREFIX = "[ERROR] ";

    private String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
