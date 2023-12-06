import java.util.*;

public class World {
    private String theme;
    private List<EnemyType> enemies;
    private List<Dilemma> dilemmas;
    public static List<World> availableWorlds = new ArrayList<>();
    private List<CompletionRequirement> completionRequirements;
    private String description; 

    public World(String theme, String description) {
        this.theme = theme;
        this.enemies = new ArrayList<>();
        this.dilemmas = new ArrayList<>();
        this.completionRequirements = new ArrayList<>();
        this.description = description;
    }

    public World(String theme) {
        this.theme = theme;
        this.enemies = new ArrayList<>();
        this.dilemmas = new ArrayList<>();
        this.completionRequirements = new ArrayList<>();
    }

     public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<EnemyType> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<EnemyType> enemies) {
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

    public boolean isCompleted() {
        if (completionRequirements.size() == 0) {
            return false;
        }
        for(CompletionRequirement completionRequirement : completionRequirements) {
            if (completionRequirement.verify() == false) {
                return false;
            }
        }
        return true;
    }

    public void printRequirements() {
        System.out.println("Completion requirements for " + getTheme().toLowerCase() + " world:");
        for (CompletionRequirement completionRequirement : completionRequirements) {
            System.out.println(completionRequirement + " - Completed: " + (completionRequirement.verify() == true ? "Yes" : "No"));
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
