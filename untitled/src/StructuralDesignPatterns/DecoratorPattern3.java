package StructuralDesignPatterns;


/*
You are developing an inventory and combat system for an RPG (Role-Playing Game).
Weapons in your game have a base physical damage. Players can find or buy magical runes,
enchantments, and attachments to upgrade their weapons.
Instead of writing a separate class for every possible weapon modification
combination (e.g., FireSword, IceFireSword, LifestealIceAxe),
you need to use the Decorator Pattern. This allows modifications to stack dynamically at
runtime based on what elements the player equips.
 */


interface Weapon{
    public double getDamage();
    public String getDescription();
}

class BaseSword implements Weapon{

    @Override
    public String getDescription() {
        return "This is base sword";
    }

    @Override
    public double getDamage() {
        return 20.0;
    }
}

abstract class WeaponDecorator implements Weapon{
    protected Weapon weapon;

    public WeaponDecorator(Weapon weapon){
        this.weapon = weapon;
    }

}

class FireDecorator extends WeaponDecorator{

    FireDecorator(Weapon weapon){
        super(weapon);
    }

    @Override
    public String getDescription() {
        return weapon.getDescription() + " with Fire Blast";
    }

    @Override
    public double getDamage() {
        return weapon.getDamage() + 7.5;
    }
}


class IceEnchantmentDecorator extends WeaponDecorator{

    IceEnchantmentDecorator(Weapon weapon){
        super(weapon);
    }

    @Override
    public String getDescription() {
        return weapon.getDescription() + " with Frost Bite";
    }

    @Override
    public double getDamage() {
        return weapon.getDamage() + 5;
    }

}



public class DecoratorPattern3 {
    public static void main(String[] args){

        Weapon weapon = new IceEnchantmentDecorator((new BaseSword()));
        System.out.println("The total damage by this weapon is  :" + weapon.getDamage());
        System.out.println("The description is: " + weapon.getDescription());

    }
}
