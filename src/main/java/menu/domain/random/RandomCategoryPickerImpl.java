package menu.domain.random;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomCategoryPickerImpl implements RandomCategoryPicker {

    @Override
    public int generateBetweenRange(int start, int end) {
        return Randoms.pickNumberInRange(start,end);
    }
}
