  import java.util.*;

  public class EnemyTypes{
    String enemyName;

    public EnemyTypes(String name){
        this.enemyName = name;
        
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
  
  
  
  
  
