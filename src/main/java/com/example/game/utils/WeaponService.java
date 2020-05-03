package com.example.game.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class WeaponService {

    private WeaponRepository weaponRepository;

    @Autowired
    public WeaponService(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    public Weapon generateWeapon() {
        Weapon weapon = createRandomWeapon();
        weaponRepository.save(weapon);
        return weapon;
    }

    private Weapon createRandomWeapon() {
        WeaponType weaponType = pickWeaponType();
        int baseDamage = randomDamage();
        AdditionalEffect additionalEffect = createAdditionalEffect();
        String name = weaponType.name() + " of " + additionalEffect.getEffect().name();
        String description = String.format("%s damages enemy for %d points of physical damage as well as %d poins of %s damage", name, baseDamage, additionalEffect.getDamage(), additionalEffect.getEffect());
        return new Weapon(name, baseDamage, additionalEffect, description);
    }

    private int randomDamage() {
        return new Random().nextInt(100);
    }

    private AdditionalEffect createAdditionalEffect() {
        WeaponEffect weaponEffect = pickWeaponEffect();
        return new AdditionalEffect(weaponEffect, randomDamage());
    }

    private WeaponType pickWeaponType() {
        int pick = new Random().nextInt(WeaponType.values().length);
        return WeaponType.values()[pick];
    }

    private WeaponEffect pickWeaponEffect() {
        int pick = new Random().nextInt(WeaponEffect.values().length);
        return WeaponEffect.values()[pick];
    }

    public List<Weapon> getAll() {
        return weaponRepository.findAll();
    }
}
