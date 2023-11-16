  import java.util.*;

  public class EnemyTypes{
    String enemyName;
    private int maxHealth;
    private int strength;
    private int dexterity;
    private int experience;

    public EnemyTypes(String name, int maxHealth, int strength, int dexterity, int experience){
        this.enemyName = name;
        this.maxHealth = maxHealth;
        this.strength = strength;
        this.dexterity = dexterity;
        this.experience = experience;        
    }

    public Enemy create() {
        return new Enemy(enemyName);
    }



  
  private List<String> waterEnemies = new ArrayList<>();{
        waterEnemies.add("Seahorse");
        waterEnemies.add("Shrimp");
        waterEnemies.add("Shark");
        waterEnemies.add("An Anemone");
        waterEnemies.add("Jellyfish");
  }

    private List<String> fireEnemies = new ArrayList<>();{
        fireEnemies.add("Fire Elemental");
        fireEnemies.add("Lava Snail");
        fireEnemies.add("Salamander");
        fireEnemies.add("Stone Giant");
        fireEnemies.add("Smoker");
    }
}
  
  
  
  
  
