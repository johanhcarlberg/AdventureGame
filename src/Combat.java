
import java.util.*;


public class Combat {
    Player player = new Player("Jonas");
    Enemy enemy = new Enemy("Wolf");
    private Random random = new Random();
    Scanner actions = new Scanner(System.in);

    int playerHP = player.getCurrentHealth();
    int enemyHP = enemy.getHealth();
    int pAction;
    int eAction;


    // public static void main(String[] args) {
    //     Combat test = new Combat();
    //     test.startCombat();
    
    // }

    void startCombat(){
        
        System.out.println("\nYou encountered ");  
        enemy.printStats();
        if (player.getLevel() < enemy.getLevel()){      //Loop som kollar vilken nivå motståndaren är i relation till spelaren och ger en print beroende på detta
            System.out.println("The "+enemy.getName()+" looks really strong! Better be careful!");
        }
        else if(player.getLevel() == enemy.getLevel()){
            System.out.println("The "+enemy.getName()+" looks mean. You got this!");
        }
        else if(player.getLevel() > enemy.getLevel()){
            System.out.println("The "+enemy.getName()+" looks pretty weak. Don't get too cocky though");
        }
  
        while(playerHP > 0 && enemyHP > 0){
            attacks();
            compareAttacks(pAction, eAction);
        }
        if (playerHP > 0){
            winner();
        }
        else{
            gameOver();
        }

    }

    void attacks(){ 
       
        List<String> actionsList = new ArrayList<>(); //Lista med alternativ för strid
        actionsList.add("Attack");
        actionsList.add("Block");
        actionsList.add("Fake out");
        actionsList.add("Try to run");

        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("Your health: " + playerHP + ".");
        System.out.println("Enemy health: " + enemyHP + ".\n");

        System.out.println("What would you like to do?");
        for (int i = 0; i < actionsList.size(); i++) { // Skriver ut lista med alternativ för strid
            System.out.println(i+1 + ". " + actionsList.get(i));
        }
        System.out.print(">");
        pAction = actions.nextInt() - 1;

        //Random funktion för att välja motståndarens handling
        eAction = random.nextInt(3);
        System.out.println("You chose to " + actionsList.get(pAction) + ".");
        System.out.println(enemy.getName() + " chose to " + actionsList.get(eAction) + ".");

    }

    void compareAttacks(int p, int e) {
        // if-else (?) som jämför pAction mot eAction
        if(p == 0 && e == 0){
            System.out.println("You fight eachother. You both take damage.");
            playerDmg();
            enemyDmg();
        }
        else if(p == 0 && e == 1){
            System.out.println(enemy.getName() + " blocks your attack and follows up with a counter. You take damage.");
            playerDmg();
        }

        else if(p == 0 && e == 2){
            System.out.println(enemy.getName() + " tries to fake you out. The " + enemy.getName() + " fails and take damage");
            enemyDmg();
        }

        else if(p == 1 && e == 0){
            System.out.println("You block the enemy attack and counter. The enemy takes damage.");
            enemyDmg();
        }

        else if(p == 1 && e == 1){
            System.out.println("You both stare at eachother intensely waiting for the other to move!");
        }

        else if(p == 1 && e == 2){
            System.out.println("You try to block but the enemy fakes you out! You take damage!");
            playerDmg();
        }

        else if(p == 2 && e == 0){
            System.out.println("You try to fake out the enemy. It sees right through you. You take damage.");
            playerDmg();
        }

        else if(p == 2 && e == 1){
            System.out.println("The enemy tries to block but your attack slips through anyway! You deal damage");
            enemyDmg();
        }

        else if(p == 2 && e == 2){
            System.out.println("You both miss eachother. No one takes any damage");
        }

        else if(p == 3 && e == 0){
            System.out.println("You turn to run away but the " + enemy.getName() + " catches you. You take damage");
            playerDmg();
        }

        else if(p == 3 && e == 1){
            System.out.println("You successfully run away");
            
        }

        else if(p == 3 && e == 2){
            System.out.println("You try to run away. Its no use. The enemy is too fast!");
        }

        // Skriv ut vad som händer vid varje utfall.

    }

    void playerDmg(){
        playerHP = playerHP - 1;
    }

    void enemyDmg(){
        enemyHP = enemyHP - 1;
    }

    void winner(){
        System.out.println("\nCongratulations! You defeated " + enemy.getName() + "!");
        System.out.println("\nYou gained " + enemy.getExperience() + " points of experience! Yay!");
        player.addExperience(enemy.getExperience());
        System.out.println("You now have " + player.getExperience() + " experience points! Much Wow! Such strong!\n");
    }
    
    void gameOver(){
        System.out.println("The enemy was too strong! This is where your story ends. How sad.");
        System.out.println("\n\n GAME OVER \n\n");
    }

        // Ser om någon har gått ner till 0 hp
        // Avslutar combat (skriver ut xp gains och skickar spelaren vidare)

}