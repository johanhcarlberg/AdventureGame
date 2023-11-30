

public class Inn {
    private Player player;
    private GameStateManager gameStateManager;
    private boolean firstVisit = true;
    

    public Inn (Player player, GameStateManager gameStateManager) {
        this.player = player;
        this.gameStateManager = gameStateManager;
    }

    public void showMenuAlternatives(){
            showInnAlternatives();
           int userInputChoiceInMenu = Input.getIntegerInRange(1, 3);
           System.out.println("You selected alternative number: " + userInputChoiceInMenu);

           if (userInputChoiceInMenu == 1){
               gameStateManager.setCurrentGameState(GameState.ADVENTURE);
               return;
           }

           else if (userInputChoiceInMenu ==2){
               viewCharacterSheet();  
           }

           else if (userInputChoiceInMenu == 3){
               restCharacter();   
           }  
            
           gameStateManager.setCurrentGameState(GameState.INN);
   }

   public void showInnAlternatives() {
    if (firstVisit) {
        printInnDescription();
        firstVisit = false;
    } else {
        System.out.println("---------------------------------------");
        System.out.println("\nYou return to the Wasted Wanderer.\n");
    }
    System.out.println("What would you like to do?");
    System.out.println("1: Go on an adventure.");
    System.out.println("2: Show your character sheet");
    System.out.println("3: Rest and regain your health");
    System.out.println();
    }

    public void viewCharacterSheet() {
        System.out.println();
        System.out.println(player.getName() + " the " + player.getPlayerClass().getName());
        System.out.println("---------------------------------------");
        System.out.println("Level: " + player.getLevel());
        System.out.println("Experience: "+player.getExperience()+"/"+player.getNextLevelExperience());
        System.out.println("Health: " + player.getCurrentHealth() + "/" + player.getMaxHealth());
        System.out.println("Strength: " + player.getStrength());
        System.out.println("Dexterity: " + player.getDexterity());
    }

    public void restCharacter() {
        player.restoreHealth();
        System.out.println("\nZzzzz.......");
        System.out.println("You are now healthier than ever!");
        System.out.println(" ");
        
    }

    private void printInnDescription() {
        System.out.println("You find the Wasted Wanderer, a lively inn situated close to the city gate. ");
        System.out.println("As you step through the creaking wooden door, you are immediately greeted by the soothing scent of ancient books and the faint melody of distant lands.");
        System.out.println("This inn is no ordinary resting place;  it is a hub of magical doorways, each leading to a different world waiting to be explored.\n");
        
        System.out.println("In the silence, a gentle hum signals the birth of a portal.");
        System.out.println("A shimmering distortion, radiant with otherworldly hues, materializes before you.\n");
    }
   
}
