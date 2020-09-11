package com.grupo1.amst.theheroproject;

public class Hero {
    String id,intelligence, strength,speed, durability, power, combat;
    String name;

    public Hero(String id, String name, String intelligence, String strength, String speed, String durability, String power, String combat) {
        this.id = id;
        this.intelligence = intelligence;
        this.strength = strength;
        this.speed = speed;
        this.durability = durability;
        this.power = power;
        this.combat = combat;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", intelligence=" + intelligence +
                ", strength=" + strength +
                ", speed=" + speed +
                ", durability=" + durability +
                ", power=" + power +
                ", combat=" + combat +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setCombat(String combat) {
        this.combat = combat;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrength() {
        return strength;
    }

    public String getSpeed() {
        return speed;
    }

    public String getDurability() {
        return durability;
    }

    public String getPower() {
        return power;
    }

    public String getCombat() {
        return combat;
    }

    public String getName() {
        return name;
    }
}
