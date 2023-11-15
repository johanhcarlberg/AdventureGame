import java.util.*;

public class Enemy {
    private String name;
    private int level;
    private int maxHealth;
    private int currentHealth;
    private int Str;
    private int Dex;
    private int experience;
    private Random random = new Random();
    

    public Enemy(String name){
        this.name=name;
        this.level = 1;
        this.maxHealth = random.nextInt(5) + 6;
        this.currentHealth = this.maxHealth;
        this.Str = random.nextInt(5) + 1;
        this.Dex = random.nextInt(5) + 1;
        this.experience = (int) Math.floor(((this.level + 1) * 10) * 1.25);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return currentHealth;
    }

    public int getStr() {
        return Str;
    }

    public int getDex() {
        return Dex;
    }

     public int getLevel(){
        return level;
    }
    
    public int getExperience(){
        return experience;
    }

    public void printStats(){
        System.out.println("Name: " + getName());
        System.out.println("Level: " + getLevel());
        System.out.println("Health: " + getHealth());
        System.out.println("Strength: " + getStr());
        System.out.println("Dexterity: " + getDex());
        System.out.println("Gives xp: " + getExperience());
    }
}

