import java.util.Set;
import java.util.HashSet;

public class CharacterClass {
    private String name;
    private int initialStrength;
    private int strengthPerLevel;
    private int initialDexterity;
    private int dexterityPerLevel;
    public static Set<CharacterClass> availableClasses = new HashSet<>();

    public CharacterClass(String name, int initialStrength, int strengthPerLevel, int initialDexterity, int dexterityPerLevel) {
        this.name = name;
        this.initialStrength = initialStrength;
        this.strengthPerLevel = strengthPerLevel;
        this.initialDexterity = initialDexterity;
        this.dexterityPerLevel = dexterityPerLevel;
    }

    public String getName() {
        return name;
    }

    public int getInitialStrength() {
        return initialStrength;
    }

    public int getStrengthPerLevel() {
        return strengthPerLevel;
    }

    public int getInitialDexterity() {
        return initialDexterity;
    }

    public int getDexterityPerLevel() {
        return dexterityPerLevel;
    }
}
