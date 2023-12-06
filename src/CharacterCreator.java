public class CharacterCreator {
    private final int NAME_MAX_LENGTH = 15;

    public Player createCharacter() {
        System.out.println("As you walk up to the city gate, a guard approaches.");
        System.out.println("\"So you want to be an adventurer, eh? What's your name?\"");
        
        String playerName;
        do {
            System.out.print("Character name: ");
            playerName = Input.getString();
        } while(!validateCharacterName(playerName));

        CharacterClass playerClass = selectClass();

        Player player = new Player(playerName, playerClass);
        String characterIntroString = String.format("\'I'm %s, a %s! And I'm gonna be the greatest adventurer ever!\'", player.getName(), player.getPlayerClass().getName());
        System.out.println(characterIntroString);
        System.out.println("\"Well good luck then... I used to be an adventurer like you, until I took an arrow to the knee. Now I'm just a guard in this town.\""); 
        System.out.println("\"Head on in. There is an inn called The Wasted Wanderer where you can find some tips on adventuring!\"\n");

        return player;
    }

    public CharacterClass selectClass() {
        CharacterClass[] characterClasses = new CharacterClass[CharacterClass.availableClasses.size()];
        CharacterClass.availableClasses.toArray(characterClasses);

        System.out.println("Select your class:");
        for (int i = 0; i < characterClasses.length; i++) {
            System.out.println(i + 1 + ". " + characterClasses[i].getName());
        }

        int classSelection = Input.getIntegerInRange(1, characterClasses.length);
        CharacterClass selectedClass = characterClasses[classSelection - 1];

        return selectedClass;
    }

    private boolean validateCharacterName(String name) {
        if(name.length() > NAME_MAX_LENGTH) {
            System.out.println("Character name must be 15 characters or less.");
            return false;
        }

        if(name.isEmpty()) {
            System.out.println("Character name cannot be empty.");
            return false;
        }

        if(!isAlphanumeric(name)) {
            System.out.println("Character name must be alphanumeric.");
            return false;
        }

        return true;
    }

    private boolean isAlphanumeric(String name) {
        for (char c : name.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }

        return true;
    }


}
