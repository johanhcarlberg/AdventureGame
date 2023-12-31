public class Player extends GameCharacter implements Damageable {
    private int experience;
    private int nextLevelExperience;
    private CharacterClass playerClass;

    public Player(String name, CharacterClass playerClass) {
        super(name, 1, 15, playerClass.getInitialStrength(), playerClass.getInitialDexterity());
        this.experience = 0;
        this.nextLevelExperience = calcNextLevelExperience();
        this.playerClass = playerClass;
    }

    public int getExperience() {
        return experience;
    }

    public void restoreHealth() {
        setCurrentHealth(getMaxHealth());
    }

    private void setExperience(int experience) {
        this.experience = experience;
    }

    public CharacterClass getPlayerClass() {
        return this.playerClass;
    }

    public int addExperience(int experienceToAdd) {
        setExperience(this.experience + experienceToAdd);
        if (canLevelUp()) {
            levelUp();
        }
        return this.experience;
    }


    public void takeDamage (int damage) {
        setCurrentHealth(getCurrentHealth() - damage);
        System.out.println("You took " + damage + " damage.");
    }

    public void increaseHealthScore (int healthPoints) {
        setCurrentHealth(getCurrentHealth() + healthPoints);
    }

  
    public int getNextLevelExperience() {
        return this.nextLevelExperience;
    }

    private void setNextLevelExperience(int nextLevelExperience) {
        this.nextLevelExperience = nextLevelExperience;
    }

    public int calcNextLevelExperience() {
        return (int) Math.floor(((getLevel() + 1) * 50) * 1.25);
    }

    public boolean canLevelUp() {
        return this.experience >= nextLevelExperience;
    }

    private void levelUp() {
        setLevel(getLevel() + 1);
        setExperience(Math.max(0, experience - nextLevelExperience));
        setNextLevelExperience(calcNextLevelExperience());

        setMaxHealth(getMaxHealth() + 10);
        restoreHealth();

        setStrength(getStrength() + playerClass.getStrengthPerLevel());
        setDexterity(getDexterity() + playerClass.getDexterityPerLevel());
        
        printLevelUpMessage();

        if (canLevelUp()) {
            levelUp();
        }
    }

    private void printLevelUpMessage() {
        System.out.println("You have gained a level! You are now level " + getLevel() + ".");
    }

}
