
import java.util.*;


public class Combat implements Encounter {
    private Player player;
    private Enemy enemy;
    private int pAction;
    private int eAction;
    private Random random = new Random();
    private Scanner actions = new Scanner(System.in);

    public Combat(Player player, Enemy enemy){
        this.player = player;
        this.enemy = enemy;
    }

    public void startEncounter() {
        startCombat();
    }
    
    void startCombat(){
        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("You encountered " + enemy.getName()+ "!");
        if (player.getLevel() < enemy.getLevel()){      //Loop som kollar vilken nivå motståndaren är i relation till spelaren och ger en print beroende på detta
            System.out.println("The "+enemy.getName()+" looks really strong! Better be careful!");
        }
        else if(player.getLevel() == enemy.getLevel()){
            System.out.println("The "+enemy.getName()+" looks mean. You got this!");
        }
        else if(player.getLevel() > enemy.getLevel()){
            System.out.println("The "+enemy.getName()+" looks pretty weak. Don't get too cocky though");
        }
  
        while(player.getCurrentHealth() > 0 && enemy.getCurrentHealth() > 0){
            attacks();
            if (pAction == 3) {
                System.out.println("You ran away!");
                System.out.println("\n-----------------------------------------------------\n");
                return;
            }
            compareAttacks(pAction, eAction);
        }
        if (player.getCurrentHealth() > 0){
            winner();
        }
        else{
            gameOver();
        }
    }

    void attacks(){ 
       
        List<String> actionsList = new ArrayList<>(); //Lista med alternativ för strid
        actionsList.add("Attack");
        actionsList.add("Counter");
        actionsList.add("Fake out");
        actionsList.add("Run away!");

        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("Your health: " + player.getCurrentHealth() + ".");
        System.out.println("Enemy health: " + enemy.getCurrentHealth() + ".\n");

        System.out.println("What would you like to do?");
        for (int i = 0; i < actionsList.size(); i++) { // Skriver ut lista med alternativ för strid
            System.out.println(i+1 + ". " + actionsList.get(i));
        }
        pAction = actions.nextInt() - 1;

        //Random funktion för att välja motståndarens handling
        eAction = random.nextInt(3);
        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("You chose to " + actionsList.get(pAction) + ".");
        System.out.println(enemy.getName() + " chose to " + actionsList.get(eAction) + ".");

    }

    void compareAttacks(int p, int e) {
        if(p == 0 && e == 0){
            System.out.println("You fight eachother. It's a tough opponent! Luckily you didn't take any damage.");
            System.out.println();
        }

        else if(p == 0 && e == 1){
            System.out.println(enemy.getName() + " counters you! You take damage.");
            System.out.println();
            playerDmg();
        }

        else if(p == 0 && e == 2){
            System.out.println(enemy.getName() + " tries to fake you out. The " + enemy.getName() + " fails and take damage");
            System.out.println();
             if(player.getPlayerClass().getName() == "Warrior"){
                System.out.println("Your great strength makes you do more damage!");
                enemyDmg();
                enemyDmg();
            }
            else{
                enemyDmg(); 
            }
        }

        else if(p == 1 && e == 0){
            System.out.println("You counter the enemy attack. The enemy takes damage.");
            System.out.println();
            enemyDmg();
        }

        else if(p == 1 && e == 1){
            System.out.println("You both stare at eachother intensely waiting for the other to move!");
            System.out.println();
        }

        else if(p == 1 && e == 2){
            System.out.println("You try to counter but the enemy fakes you out! You take damage!");
            System.out.println();
            playerDmg();
        }

        else if(p == 2 && e == 0){
            System.out.println("You try to fake out the enemy. It sees right through you. You take damage.");
            System.out.println();
            playerDmg();
        }

        else if(p == 2 && e == 1){
            System.out.println("The enemy tries to block but your attack slips through anyway! The enemy takes damage!");
            System.out.println();
            if(player.getPlayerClass().getName() == "Rogue"){
                System.out.println("Your speed makes you do more damage!");
                enemyDmg();
                enemyDmg();
            }
            else{
                enemyDmg(); 
            }
        }

        else if(p == 2 && e == 2){
            System.out.println("You both miss! What!? How!?");
            System.out.println();
        }
    }

    void playerDmg(){
        if( enemy.getStrength() > enemy.getDexterity()){
            player.takeDmg(random.nextInt(enemy.getStrength())+1);
        }
        else if(enemy.getStrength() < enemy.getDexterity()){
            player.takeDmg(random.nextInt(enemy.getDexterity())+1);
        }
    }

    void enemyDmg(){
        if(player.getPlayerClass().getName() == "Warrior"){
            enemy.takeDmg(random.nextInt(player.getStrength())+1);
        }
        else if(player.getPlayerClass().getName() == "Rogue"){
            enemy.takeDmg(random.nextInt(player.getDexterity())+1);
        }
    }

    void winner(){
        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("\nCongratulations! You defeated " + enemy.getName() + "!");
        System.out.println("\nYou gained " + enemy.getExperience() + " points of experience! Yay!");
        player.addExperience(enemy.getExperience());
        System.out.println("You now have " + player.getExperience() + " experience points! Much Wow! Such strong!");
        System.out.println("\n-----------------------------------------------------\n");
    }
    
    void gameOver(){
        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("The enemy was too strong! This is where your story ends. How sad.");
        System.out.println("\n\n GAME OVER \n\n");
        Game.exitGame();
    }
}