package com.angelikabog.demo_compass.controller;

import com.angelikabog.demo_compass.logic.Side;
import com.angelikabog.demo_compass.logic.SideModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class Controller {
    private static final SideModel sideModel = SideModel.getInstance();
    private static final int id = 1;

    /* Пример post-запроса
{
    "north":"338-22",
    "northeast":"23-67",
    "northwest":"294-337",
    "south":"160-203",
    "southeast":"114-159",
    "southwest":"204-248",
    "east":"68-113",
    "west":"249-293"
}
    */

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/text")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Side side){
        String result = "";
        if(sideModel.getAll().size() == 0){
            sideModel.add(side, id);
            result = String.format("Координаты заданы: север %s, юг %s, восток %s, запад %s, северо-восток %s, юго-восток %s, юго-запад %s, северо-запад %s",
                    side.getNorth(), side.getSouth(), side.getEast(), side.getWest(), side.getNortheast(), side.getSoutheast(), side.getSouthwest(), side.getNorthwest());
        }else{
            sideModel.add(side, id);
            result = String.format("Координаты обновлены: север %s, юг %s, восток %s, запад %s, северо-восток %s, юго-восток %s, юго-запад %s, северо-запад %s",
                    side.getNorth(), side.getSouth(), side.getEast(), side.getWest(), side.getNortheast(), side.getSoutheast(), side.getSouthwest(), side.getNorthwest());
        }
        return result;
    }

    /* Пример get-запроса
{
    "degree":2
}
    */

    @GetMapping(value = "/getSide", consumes = "application/json", produces = "application/json")
    public Map<String,String> getSide(@RequestBody Map<String, Integer> degree){
            return sideModel.getSide(degree.get("degree"));
    }
}
