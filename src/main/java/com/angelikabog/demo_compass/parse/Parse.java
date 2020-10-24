package com.angelikabog.demo_compass.parse;

public class Parse {

    public int[] parsing(String side){
        int[] arraySide = new int[2];
        int leftVal = Integer.parseInt(side.split("-")[0]);
        int rightVal = Integer.parseInt(side.split("-")[1]);

        arraySide[0] = leftVal;
        arraySide[1] = rightVal;

        return arraySide;
    }
}
