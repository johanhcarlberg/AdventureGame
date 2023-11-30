
public class Enemy extends GameCharacter implements Damageable {
    private int experience;
    

    public Enemy(String name, int level, int maxHealth, int strength, int dexterity, int experience){
        super(name, level, level * maxHealth, level * strength, level * dexterity);
        this.experience = level * experience;
    }

    public int getExperience(){
        return experience;
    }

    public void takeDamage (int damage) {
        setCurrentHealth(getCurrentHealth() - damage);
        System.out.println("The enemy took " + damage + " damage.");
    }

    public void printStats(){
        System.out.println("Name: " + getName());
        System.out.println("Level: " + getLevel());
        System.out.println("Health: " + getCurrentHealth());
        System.out.println("Strength: " + getStrength());
        System.out.println("Dexterity: " + getDexterity());
        System.out.println("Gives xp: " + getExperience());
    }
        
    
}

