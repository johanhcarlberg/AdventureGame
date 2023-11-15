import java.util.*;

public class World {
    private String theme;
    private List<Enemy> enemies;
    private List<String> dilemmas;

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

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public List<String> getDilemmas() {
        return dilemmas;
    }

    public void setDilemmas(List<String> dilemmas) {
        this.dilemmas = dilemmas;
    }
}