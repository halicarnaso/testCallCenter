package net.almundo.callcenter.util;

import java.util.Random;

public class Callhelper {

    private static Callhelper instance;

    public static  Callhelper getInstance(){
        if (instance == null){
            instance = new Callhelper();
        }
        return instance;
    }

    public Integer getDuration (Integer minDuration, Integer maxDuration){
        if (minDuration >= maxDuration) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((maxDuration - minDuration) + 1) + minDuration;
    }
}
