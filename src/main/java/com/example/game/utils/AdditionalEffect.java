package com.example.game.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdditionalEffect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private WeaponEffect effect;
    private int damage;

    public AdditionalEffect(WeaponEffect effect, int damage) {
        this.effect = effect;
        this.damage = damage;
    }
}
