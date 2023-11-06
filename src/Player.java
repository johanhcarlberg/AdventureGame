public class Player {
    private String name;
    private int level;
    private int experience;

    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.experience = 0;
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
}
