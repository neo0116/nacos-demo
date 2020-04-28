package com.example.nacos.nacosdemo;

import org.apache.commons.lang3.RandomUtils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @ClassName RateWeight
 * @Description TODO
 * @Version 1.0
 **/
public class RateWeight {

    public static void main(String[] args) {
        int rate1 = 2;
        int rate2 = 3;
        int rate3 = 5;
        int[] rates = {rate1, rate2, rate3};

        int random = ThreadLocalRandom.current().nextInt(10);

        for (int i = 0; i < rates.length; i++) {
            random = random - rates[i];
            if (random < 0) {
                System.out.println("命中权重" + rates[i]);
                break;
            }
            System.out.println("未命中：" + rates[i]);
        }

    }
}
