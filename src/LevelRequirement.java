public class LevelRequirement implements CompletionRequirement {
    private int level;
    private Player player;
    public LevelRequirement(int level, Player player) {
        this.level = level;
        this.player = player;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Player level requirement: " + this.level;
    }

    @Override
    public boolean verify() {
        // TODO Auto-generated method stub
        return this.player.getLevel() >= this.level;
    }
}
