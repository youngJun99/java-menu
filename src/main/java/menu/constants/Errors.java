package menu.constants;

public enum Errors {

    //개발자용 시스템 에러
    MENU_CHECK("메뉴 조회 오류"),
    COACH_CHECK("코치 조회 오류"),

    //코치 입력 관련 에러
    COACH_NAME_RANGE("코치의 이름은 최소 %d글자 최대 %d글자 여야 합니다."),
    NONE_EATABLE_MENU_RANGE("코치가 못먹는 음식은 최소 %d개 최대 %개 사이여야 합니다."),
    NONE_EATABLE_MENU_DOES_NOT_EXIST("입력한 음식은 메뉴판에 존재하지 않습니다.");


    private static final String PREFIX = "[ERROR] ";

    private String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
