package com.example.game.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;
    private int baseDamage;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private AdditionalEffect additionalEffect;
    private String description;

    public Weapon(String name, int baseDamage, AdditionalEffect additionalEffect, String description) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.additionalEffect = additionalEffect;
        this.description = description;
    }
}
