package com.petstore.utils;

import org.apache.commons.lang3.RandomUtils;

public class RandomsUtils {

    public static Integer getRandomIdNumber(){
        return RandomUtils.nextInt(88888888, 999999999);
    }

    private RandomsUtils() {
    }
}
