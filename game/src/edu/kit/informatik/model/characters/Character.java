package edu.kit.informatik.model.characters;

public abstract class Character {

    private int hp;
    private int fp;
    private int dmgDealt = 0;
    private int dmgBlocked = 0;
    private int roll = 0;

    public Character() {

    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return this.hp;
    }

    public void setFp(int fp) {
        this.fp = fp;
    }

    public int getFp() {
        return this.fp;
    }

    public void loseHp(int dmg) {
        this.hp -= dmg;
    }

    public void setDmgDealt(int dmgDealt) {
        this.dmgDealt = dmgDealt;
    }

    public int getDmgDealt() {
        return this.dmgDealt;
    }

    public void setDmgBlocked(int dmgBlocked) {
        this.dmgBlocked = dmgBlocked;
    }

    public int getDmgBlocked() {
        return dmgBlocked;
    }

    public int getRoll() {
        return this.roll;
    }
    
}
