package com.example.game.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;
    private int baseDamage;
//    private int additionalDamage;
    private String description;

    public Weapon(String name, int baseDamage, String description) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.description = description;
    }
}
