import java.util.Scanner;

public class Combat {
    Player player;
    Enemy enemy;
    

    Scanner actions = new Scanner(System.in);

    void startCombat(){
        System.out.println("You encountered "+ enemy);
        System.out.println("The "+enemy+" looks pretty strong/mean/weak");
        System.out.println("Your health: " + player.getCurrentHealth());
        System.out.println("Enemy health: " + enemy.getHealth());
       
    }

    void attacks(){ 
        int pAction;
        int eAction;

        System.out.println("What would you like to do?");
        System.out.println("1. Attack");
        System.out.println("2. Block"); //skall man göra en Counter-attack efter blocken?
        System.out.println("3. Fake out"); 
        System.out.println("4. Try to run");
        pAction = actions.nextInt();

        //Random funktion för att välja motståndarens handling
        eAction = Random(3);
        System.out.println("You chose to " + pAction + ".");
        System.out.println(enemy + " chose to " + eAction + ".");    
    }

    void compareAttacks(int player, int enemy) {
        // if-else (?) som jämför pAction mot eAction
        if(player = 1 && enemy = 1){
            System.out.println("You fight eachother. Both take damage.");
        }
        else if(player = 1 && enemy = 2){
            System.out.println(enemy + " blocks your attack and follows up with a counter. You take damage.");
        }

        else if(player = 1 && enemy = 3){
            System.out.println(enemy + " tries to fake you out. The " + enemy + " fails and take " + player.damage() + "points of damage.");
        }

        else if(player = 2 && enemy = 1){
            System.out.println("You block the enemy attack and counter. The enemy takes damage.");
        }

        else if(player = 2 && enemy = 2){
            System.out.println("You both stare at eachother intensely waiting for the other to move!");
        }

        else if(player = 2 && enemy = 3){
            System.out.println("You try to block but the enemy fakes you out! You take " + enemy.damage() + " points of damage!");
        }

        else if(player = 3 && enemy = 1){
            System.out.println("You try to fake out the enemy. It sees right through you. You take damage.");
        }

        else if(player = 3 && enemy = 2){
            System.out.println("The enemy tries to block but your attack slips through anyway! You deal damage");
        }

        else if(player = 3 && enemy = 3){
            System.out.println("You both miss eachother. No one takes any damage");
        }

        else if(player = 4 && enemy = 1){
            System.out.println("You turn to run away but the " + enemy + " catches you. You take damage");
        }

        else if(player = 4 && enemy = 2){
            System.out.println("You successfully run away");
            //End combat
        }

        else if(player = 4 && enemy = 3){
            System.out.println("You try to run away. Its no use. The enemy is too fast!");
        }

        // Skriv ut vad som händer vid varje utfall.

    }

    void winner(String winner){
        

        }
        // Ser om någon har gått ner till 0 hp
        // Avslutar combat (skriver ut xp gains och skickar spelaren vidare)
    }

}
