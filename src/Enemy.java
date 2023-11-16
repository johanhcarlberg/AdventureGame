import java.util.*;

public class Enemy {
    private String name;
    private int level;
    private int maxHealth;
    private int currentHealth;
    private int strength;
    private int dexterity;
    private int experience;
    private Random random = new Random();
    

    public Enemy(String name){
        this.name=name;
        this.level = 1;
        this.maxHealth = random.nextInt(5) + 6;
        this.currentHealth = this.maxHealth;
        this.strength = strength;
        this.dexterity = dexterity;
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

