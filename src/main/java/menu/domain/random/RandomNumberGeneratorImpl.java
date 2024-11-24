package menu.domain.random;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator{

    @Override
    public int generateBetweenRange(int start, int end) {
        return Randoms.pickNumberInRange(start,end);
    }
}
