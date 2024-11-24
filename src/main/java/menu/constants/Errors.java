package menu.constants;

public enum Errors {

    //시스템 에러
    SYSTEM_ERROR_UNKNOWN_MENU_INDEX("메뉴 인덱스가 존재하지 않습니다");


    private static final String PREFIX = "[ERROR] ";

    private String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX+message;
    }
}
