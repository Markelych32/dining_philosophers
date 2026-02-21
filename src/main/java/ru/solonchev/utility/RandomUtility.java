package ru.solonchev.utility;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class RandomUtility {

    private static final Random RANDOM = new Random();

    public static int getRandomIntInclusive(int lowerBound, int upperBound) {
        return lowerBound + RANDOM.nextInt(upperBound - lowerBound) + 1;
    }

}
