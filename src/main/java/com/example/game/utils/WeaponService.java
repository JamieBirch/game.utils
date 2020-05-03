package com.example.game.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponService {

    private WeaponRepository weaponRepository;

    @Autowired
    public WeaponService(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    public Weapon generateWeapon() {
        Weapon weapon = new Weapon("Voice of the Application", 1000, "Mother of all weapons");
        weaponRepository.save(weapon);
        return weapon;
    }

    public List<Weapon> getAll() {
        return weaponRepository.findAll();
    }
}
