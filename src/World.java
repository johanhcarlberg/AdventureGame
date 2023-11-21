import java.util.*;

public class World {
    private String theme;
    private List<EnemyTypes> enemies;
    private List<Dilemma> dilemmas;
    public static List<World> availableWorlds = new ArrayList<>();
    private List<CompletionRequirement> completionRequirements;

    public World(String theme) {
        this.theme = theme;
        this.enemies = new ArrayList<>();
        this.dilemmas = new ArrayList<>();
    }

     public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<EnemyTypes> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<EnemyTypes> enemies) {
        this.enemies = enemies;
    }

    public List<Dilemma> getDilemmas() {
        return dilemmas;
    }

    public void setDilemmas(List<Dilemma> dilemmas) {
        this.dilemmas = dilemmas;
    }

    public void addCompletionRequirement(CompletionRequirement completionRequirement) {
        this.completionRequirements.add(completionRequirement);
    }
}