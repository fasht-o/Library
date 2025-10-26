package ca.umanitoba.cs.fashina1.domain;

public class Pokemon {
    // must be greater than 0
    private int health;
    public Pokemon(int initialHealth){
        this.health = initialHealth;
    }

    /**
     * Attack another Pokemon. The health of the instance that we are attcaking will be reduced by 1
     * @param p
     */
    public void attack(Pokemon p){
        p.health -= 1;

    }

}
