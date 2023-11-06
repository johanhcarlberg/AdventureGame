public class Player {
    private String name;
    private int level;
    private int experience;
    private int health;

    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.experience = 0;
        this.health = 10;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return this.health;
    }

}
