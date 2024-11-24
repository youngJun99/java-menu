package menu.domain.coach;

import menu.constants.Errors;
import menu.domain.menu.MenuEnum;

import java.util.List;

public class Coach {

    private static final int NAME_RANGE_LOWER_INDEX = 2;
    private static final int NAME_RANGE_UPPER_INDEX = 4;
    private static final int NON_EATABLE_MENU_RANGE_UPPER_INDEX = 2;
    private static final int NON_EATABLE_MENU_RANGE_LOWER_INDEX = 0;


    private final String name;
    private List<String> nonEatableMenu;

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    public void setNonEatableMenu(List<String> nonEatableMenu) {
        validateNoneEatableMenu(nonEatableMenu);
        this.nonEatableMenu = nonEatableMenu;
    }

    public String getName() {
        return name;
    }

    public boolean canEat(String menu) {
        return nonEatableMenu.contains(menu);
    }

    private void validateName(String name) {
        if (name.length() < NAME_RANGE_LOWER_INDEX || name.length() > NAME_RANGE_UPPER_INDEX) {
            throw new IllegalArgumentException(String.format(Errors.COACH_NAME_RANGE.getMessage(), NAME_RANGE_LOWER_INDEX, NAME_RANGE_UPPER_INDEX));
        }
    }

    private void validateNoneEatableMenu(List<String> nonEatableMenu) {
        if (nonEatableMenu.size() > NON_EATABLE_MENU_RANGE_UPPER_INDEX) {
            throw new IllegalArgumentException(String.format(
                    Errors.NONE_EATABLE_MENU_RANGE.getMessage(),
                    NON_EATABLE_MENU_RANGE_LOWER_INDEX,
                    NON_EATABLE_MENU_RANGE_UPPER_INDEX));
        }
    }


}
