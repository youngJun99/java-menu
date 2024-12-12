package menu.domain.random;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constants.MenuCategory;

public class RandomCategoryPicker {

    private static final int CATEGORY_UPPER_LIMIT = 5;
    private static final int CATEGORY_LOWER_LIMIT = 1;


    public MenuCategory pickRandomCategory() {
        int randomIndex = Randoms.pickNumberInRange(CATEGORY_LOWER_LIMIT,CATEGORY_UPPER_LIMIT);
        return MenuCategory.ofIndex(randomIndex);
    }
}

