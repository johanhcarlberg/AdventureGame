public class Player {
    private String name;
    private int level;
    private int experience;
    private int nextLevelExperience;
    private int maxHealth;
    private int currentHealth;
    private CharacterClass playerClass;
    private int strength;
    private int dexterity;

    public Player(String name, CharacterClass playerClass) {
        this.name = name;
        this.level = 1;
        this.experience = 0;
        this.maxHealth = 10;
        this.currentHealth = this.maxHealth;
        this.nextLevelExperience = calcNextLevelExperience();
        this.playerClass = playerClass;
        this.strength = playerClass.getInitialStrength();
        this.dexterity = playerClass.getInitialDexterity();
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

    public void restoreHealth() {
        setCurrentHealth(this.maxHealth);
    }

    private void setExperience(int experience) {
        this.experience = experience;
    }

    public CharacterClass getPlayerClass() {
        return this.playerClass;
    }

    public int getStrength() {
        return this.strength;
    }

    private void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    private void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int addExperience(int experienceToAdd) {
        setExperience(this.experience + experienceToAdd);
        if (canLevelUp()) {
            levelUp();
        }
        return this.experience;
    }


    public void takeDmg (int damage) {
        System.out.println("Din hälsa innan dmg" + currentHealth);
        currentHealth -= damage;
        System.out.println("Din hälsa efter dmg:" + currentHealth);
    }
  
    public int getNextLevelExperience() {
        return this.nextLevelExperience;
    }

    private void setNextLevelExperience(int nextLevelExperience) {
        this.nextLevelExperience = nextLevelExperience;
    }

    public int calcNextLevelExperience() {
        return (int) Math.floor(((this.level + 1) * 50) * 1.25);
    }

    public boolean canLevelUp() {
        return this.experience >= nextLevelExperience;
    }

    private void levelUp() {
        setLevel(this.level += 1);
        setExperience(Math.max(0, experience - nextLevelExperience));
        setNextLevelExperience(calcNextLevelExperience());

        setMaxHealth(maxHealth + 10);
        restoreHealth();
        
        printLevelUpMessage();

        if (canLevelUp()) {
            levelUp();
        }
    }

    private void printLevelUpMessage() {
        System.out.println("You have gained a level! You are now level " + this.level + ".");
    }

}
