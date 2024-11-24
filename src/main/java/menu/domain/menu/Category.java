package menu.domain.menu;

import java.util.List;

public class Category {

    private final List<String> menus;

    public Category(List<String> menus) {
        this.menus = menus;
    }

    public int getNumberOfMenu() {
        return menus.size();
    }

    public String getMenu(int index) {
        return menus.get(index - 1);
    }
}
