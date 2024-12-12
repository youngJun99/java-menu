package menu.dto;

public class CoachMenuDto {

    private final String name;
    private final String mondayMenu;
    private final String tuesdayMenu;
    private final String wednesdayMenu;
    private final String thursdayMenu;
    private final String fridayMenu;

    public CoachMenuDto(String name, String mondayMenu, String tuesdayMenu, String wednesdayMenu, String thursdayMenu, String fridayMenu) {
        this.name = name;
        this.mondayMenu = mondayMenu;
        this.tuesdayMenu = tuesdayMenu;
        this.wednesdayMenu = wednesdayMenu;
        this.thursdayMenu = thursdayMenu;
        this.fridayMenu = fridayMenu;
    }

    public String getName() {
        return name;
    }

    public String getMondayMenu() {
        return mondayMenu;
    }

    public String getTuesdayMenu() {
        return tuesdayMenu;
    }

    public String getWednesdayMenu() {
        return wednesdayMenu;
    }

    public String getThursdayMenu() {
        return thursdayMenu;
    }

    public String getFridayMenu() {
        return fridayMenu;
    }
}
