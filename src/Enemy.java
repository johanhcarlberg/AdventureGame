public class Enemy {
    private String name;
    private int maxHealth = 10;
    private int currentHealth = 10;
    private int egenskapSty = 2;
    private int egenskapSmi = 1;
    private int level = 1;
    private int experience = 5;

    public Enemy(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return currentHealth;
    }

    public int getEgenskapSty() {
        return egenskapSty;
    }

    public int getEgenskapSmi() {
        return egenskapSmi;
    }

     public int getLevel(){
        return level;
    }
    
    public int getExperience(){
        return experience;
    }
}

