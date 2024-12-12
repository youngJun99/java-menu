package menu.domain.random;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constants.MenuCategory;

import java.util.ArrayList;
import java.util.List;

public class RandomCategoryPicker {

    public static final int DAYS_TO_EAT = 5;
    private static final int CATEGORY_UPPER_LIMIT = 5;
    private static final int CATEGORY_LOWER_LIMIT = 1;

    public List<MenuCategory> getWeeklyCategory() {
        List<MenuCategory> menuCategories = new ArrayList<>();
        while (menuCategories.size() < DAYS_TO_EAT) {
            MenuCategory randomCategory = pickRandomCategory();
            if (menuCategories.stream()
                    .filter(menuCategory -> menuCategory.equals(randomCategory))
                    .count() <= 1) {
                menuCategories.add(randomCategory);
            }
        }
        return menuCategories;
    }

    private MenuCategory pickRandomCategory() {
        int randomIndex = Randoms.pickNumberInRange(CATEGORY_LOWER_LIMIT, CATEGORY_UPPER_LIMIT);
        return MenuCategory.ofIndex(randomIndex);
    }
}

