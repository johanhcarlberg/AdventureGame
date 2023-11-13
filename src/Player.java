public class Player {
    private String name;
    private int level;
    private int experience;
    private int nextLevelExperience;
    private int maxHealth;
    private int currentHealth;

    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.experience = 0;
        this.maxHealth = 10;
        this.currentHealth = this.maxHealth;
        this.nextLevelExperience = calcNextLevelExperience();
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    private void setCurrentHealth(int newHealth) {
        this.currentHealth = newHealth;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    private void setMaxHealth(int newMaxHealth) {
        this.maxHealth = newMaxHealth;
    }

    private void setExperience(int experience) {
        this.experience = experience;
    }

    public int addExperience(int experienceToAdd) {
        this.experience += experienceToAdd;
        return this.experience;
    }

    public int getNextLevelExperience() {
        return this.nextLevelExperience;
    }

    public int calcNextLevelExperience() {
        return (int) Math.floor(((this.level + 1) * 50) * 1.25);
    }

}
