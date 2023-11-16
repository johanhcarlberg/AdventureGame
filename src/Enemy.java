import java.util.*;

public class Enemy {
    private String name;
    private int level;
    private int maxHealth;
    private int currentHealth;
    private int strength;
    private int dexterity;
    private int experience;
    

    public Enemy(String name, int level, int maxHealth, int strength, int dexterity, int experience){
        this.name=name;
        this.level = level;
        this.maxHealth = maxHealth;
        this.currentHealth = this.maxHealth;
        this.strength = strength;
        this.dexterity = dexterity;
        this.experience = (int) Math.floor(((this.level) * experience) * 1.25);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return currentHealth;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
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
        System.out.println("Strength: " + getStrength());
        System.out.println("Dexterity: " + getDexterity());
        System.out.println("Gives xp: " + getExperience());
    }
    
    private List<String> waterEnemies = new ArrayList<>(); {
        waterEnemies.add("Seahorse");
        waterEnemies.add("Shrimp");
        waterEnemies.add("Shark");
        waterEnemies.add("An Anemone");
        waterEnemies.add("Jellyfish");
    }

    private List<String> fireEnemies = new ArrayList<>(); {
        fireEnemies.add("Fire Elemental");
        fireEnemies.add("Lava Snail");
        fireEnemies.add("Salamander");
        fireEnemies.add("Stone Giant");
        fireEnemies.add("Smoker");
    }
        
    
}

