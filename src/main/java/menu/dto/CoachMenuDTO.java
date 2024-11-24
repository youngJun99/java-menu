package menu.dto;

import java.util.List;

public class CoachMenuDTO {

    private final String name;
    private final List<String> menus;

    public CoachMenuDTO(String name, List<String> menus) {
        this.name = name;
        this.menus = menus;
    }

    public String getName() {
        return name;
    }

    public List<String> getMenus() {
        return menus;
    }
}
