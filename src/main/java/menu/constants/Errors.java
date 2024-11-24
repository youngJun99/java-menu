package menu.constants;

public enum Errors {

    //개발자용 시스템 에러
    MENU_CHECK("메뉴 조회 오류");


    private static final String PREFIX = "[ERROR] ";

    private String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX+message;
    }
}
