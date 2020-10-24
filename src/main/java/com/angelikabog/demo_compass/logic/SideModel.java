package com.angelikabog.demo_compass.logic;

import com.angelikabog.demo_compass.parse.Parse;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SideModel implements Serializable {
    private static final SideModel instance = new SideModel();
    private final Map<Integer, Side> model;

    public SideModel(){
        model = new HashMap<Integer, Side>();
    }

    public static SideModel getInstance(){
        return instance;
    }

    public void add(Side side, int id){
        if(instance.getAll().size() == 0){
            model.put(id,side);
        }else{
            model.get(id).setEast(side.getEast());
            model.get(id).setWest(side.getWest());
            model.get(id).setNorth(side.getNorth());
            model.get(id).setNortheast(side.getNortheast());
            model.get(id).setNorthwest(side.getNorthwest());
            model.get(id).setSouth(side.getSouth());
            model.get(id).setSoutheast(side.getSoutheast());
            model.get(id).setSouthwest(side.getSouthwest());
        }
    }

    public Map<String,String> getSide(int degree){
        Map<String,String> result = new HashMap<String, String>();
        if(instance.getAll().size() != 0){
            Parse parse = new Parse();
            int leftNorth = parse.parsing(model.get(1).getNorth())[0];
            int rightNorth = parse.parsing(model.get(1).getNorth())[1];
            int leftNortheast = parse.parsing(model.get(1).getNortheast())[0];
            int rightNortheast = parse.parsing(model.get(1).getNortheast())[1];
            int leftNorthwest = parse.parsing(model.get(1).getNorthwest())[0];
            int rightNorthwest = parse.parsing(model.get(1).getNorthwest())[1];
            int leftSouth = parse.parsing(model.get(1).getSouth())[0];
            int rightSouth = parse.parsing(model.get(1).getSouth())[1];
            int leftSoutheast = parse.parsing(model.get(1).getSoutheast())[0];
            int rightSoutheast = parse.parsing(model.get(1).getSoutheast())[1];
            int leftSouthwest = parse.parsing(model.get(1).getSouthwest())[0];
            int rightSouthwest = parse.parsing(model.get(1).getSouthwest())[1];
            int leftEast = parse.parsing(model.get(1).getEast())[0];
            int rightEast = parse.parsing(model.get(1).getEast())[1];
            int leftWest = parse.parsing(model.get(1).getWest())[0];
            int rightWest = parse.parsing(model.get(1).getWest())[1];
            if ((leftNorth < 0) || (rightNorth < 0) || (leftSouth < 0) || (leftNortheast < 0)
                    || (leftNorthwest < 0) || (leftSoutheast < 0) || (leftSouthwest < 0) ||
                    (leftEast < 0) || (leftWest < 0) || (rightEast < 0) || (rightNortheast < 0) ||
                    (rightNorthwest < 0) || (rightSouth < 0) || (rightSoutheast < 0) || (rightSouthwest < 0) ||
                    (rightWest < 0) || (leftNorth > 359) || (rightNorth > 359) || (leftSouth > 359) || (leftNortheast > 359)
                    || (leftNorthwest > 359) || (leftSoutheast > 359) || (leftSouthwest > 359) ||
                    (leftEast > 359) || (leftWest > 359) || (rightEast > 359) || (rightNortheast > 359) ||
                    (rightNorthwest > 359) || (rightSouth > 359) || (rightSoutheast > 359) || (rightSouthwest > 359) ||
                    (rightWest > 359)
            ) {
                result.put("result", "Хьюстон, у нас проблемы, некорректно заданы координаты сторон!");
            }else {
                if(degree > leftNorth && degree < rightNorth){
                    result.put("side", "North");
                }
                if(degree > leftNortheast && degree < rightNortheast){
                    result.put("side", "Northeast");
                }
                if(degree > leftNorthwest && degree < rightNorthwest){
                    result.put("side", "Northwest");
                }
                if(degree > leftSouth && degree < rightSouth){
                    result.put("side", "South");
                }
                if(degree > leftSoutheast && degree < rightSoutheast){
                    result.put("side", "Southeast");
                }
                if(degree > leftSouthwest && degree < rightSouthwest){
                    result.put("side", "Southwest");
                }
                if(degree > leftEast && degree < rightEast){
                    result.put("side", "East");
                }
                if(degree > leftWest && degree < rightWest){
                    result.put("side", "West");
                }
            }
        }else{
            result.put("result", "Хьюстон, у нас проблемы, координаты сторон света не заданы!");
        }
        return result;
    }

    public Map<Integer, Side> getAll(){
        return model;
    }
}