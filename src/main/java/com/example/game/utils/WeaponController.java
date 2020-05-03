package com.example.game.utils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weapon-generator")
public class WeaponController {
    private WeaponService weaponService;

    public WeaponController(WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    @GetMapping("/weapon")
    public Weapon weapon() {
        return weaponService.generateWeapon();
    }

    @GetMapping("/all")
    public List<Weapon> all() {
        return weaponService.getAll();
    }
}
