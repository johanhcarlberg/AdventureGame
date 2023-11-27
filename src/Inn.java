

public class Inn {
    private Player player;
    public GameState currentGameState;
    

    public Inn (Player player, GameState currentGameState) {
        this.player = player;
        this.currentGameState = currentGameState;
    }

    public GameState showMenuAlternatives(){
            showInnAlternatives();
           int userInputChoiceInMenu = Input.getIntegerInRange(1, 3);
           System.out.println("You selected alternative number: " + userInputChoiceInMenu);

           if (userInputChoiceInMenu == 1){
               return GameState.ADVENTURE;  
           }

           else if (userInputChoiceInMenu ==2){
               viewCharacterSheet();  
           }

           else if (userInputChoiceInMenu == 3){
               restCharacter();   
           }  
            
           return GameState.INN;    
   }

   public void showInnAlternatives() {
    System.out.println("You are now in the inn. Enter the number of your choice:");
    System.out.println("1: Go on an adventure.");
    System.out.println("2: Show your character sheet");
    System.out.println("3: Rest and regain your health");
    }

    public void viewCharacterSheet() {
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
        System.out.println("Zzzzz.......");
        System.out.println("You are now healthier than ever!");
        System.out.println(" ");
        
    }
   
}
