public class Player {
    private String name;
    private int level;
    private int experience;
    private int maxHealth;
    private int currentHealth;

    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.experience = 0;
        this.maxHealth = 10;
        this.currentHealth = this.maxHealth;
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

    public void takeDmg (int damage) {
        System.out.println("Din hälsa innan dmg" + currentHealth);
        currentHealth -= damage;
        System.out.println("Din hälsa efter dmg:" + currentHealth);
    }

}
