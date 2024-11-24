package menu.domain.random;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomMenuPickerImpl implements RandomMenuPicker {

    @Override
    public String pickRandomMenu(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
