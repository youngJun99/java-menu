package menu.domain.random;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constants.MenuCategory;

import java.util.List;

public class RandomMenuPicker {


    public String pickRandomMenu(MenuCategory menuCategory) {
        List<String> menus = menuCategory.getMenus();
        List<String> shuffled = Randoms.shuffle(menus);
        return shuffled.get(0);
    }
}


