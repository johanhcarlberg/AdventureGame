  public class EnemyType{
    private String enemyName;
    private int maxHealth;
    private int strength;
    private int dexterity;
    private int experience;
  

    public EnemyType(String name, int maxHealth, int strength, int dexterity, int experience){
        this.enemyName = name;
        this.maxHealth = maxHealth;
        this.strength = strength;
        this.dexterity = dexterity;
        this.experience = experience;        
    }

    public Enemy create(int level) {
        return new Enemy(enemyName, level, maxHealth, strength, dexterity, experience);
    }

    public String getEnemyName() {
      return this.enemyName;
    }

}
  
  
  
  
  
