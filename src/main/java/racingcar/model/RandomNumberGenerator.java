package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Random;

public class RandomNumberGenerator {

    public RandomNumber generate() {
        return new RandomNumber(Randoms.pickNumberInRange(0, 9));
    }
}