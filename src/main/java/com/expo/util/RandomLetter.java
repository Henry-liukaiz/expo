package com.expo.util;

import java.util.Random;

public class RandomLetter {

    public static String run(int length) {
        Random random = new Random();

        String result = "";
        for (int i = 0; i < length; i++) {
            int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写还是小写
            result += (char) (choice + random.nextInt(26));
        }
        return result;
    }
}
