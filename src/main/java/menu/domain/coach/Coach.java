package menu.domain.coach;

import menu.constants.Errors;
import menu.domain.menu.MenuEnum;

import java.util.List;

public class Coach {

    private static final int NAME_RANGE_LOWER_INDEX = 2;
    private static final int NAME_RANGE_UPPER_INDEX = 4;

    private final String name;
    private final List<String> nonEatableMenu;

    public Coach(String name, List<String> noneEatableMenu) {
        validateName(name);
        this.name = name;
        this.nonEatableMenu = noneEatableMenu;
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


}