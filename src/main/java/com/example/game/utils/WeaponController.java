package com.example.game.utils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeaponController {

    @RequestMapping("/hi")
    public String hi() {
        return "hi";
    }
}
