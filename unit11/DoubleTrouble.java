// ## Double Trouble

// - Number of Players: 2
// - Number of dice: 2 rolling dice

// Players start with 10 points. If they roll an even number, they receive 0 points. If they roll an odd, they get 1 point, if they roll a 7 they get 3 points and if they roll doubles they get -5 points. The first person to lose all their points loses the game.

public class DoubleTrouble {
    int player1;
    int player2;

    public DoubleTrouble(){
        player1 = 10;
        player2 = 10;
    }    
    
    
    public static int rollDice() {
        int roll = (int)(Math.random()*6)+1;
        return roll;
    }

    public void playRound(){
        int dice1;
        dice1 = rollDice();
        int dice2;
        dice2 = rollDice();
        if(dice1 == dice2){
            player1 -= 5;       
        }
        if((dice1 + dice2) == 7){
            player1 += 3; 
        }
        if((dice1 + dice2)%2 == 0){
            player1 += 0;
        }
        if((dice1 +dice2)%2 != 0){
            player1 += 1;
        }

    }


    
    
    
    
    
    
public static void main(String[] args) {
    DoubleTrouble game = new DoubleTrouble();
    game.playRound();
    if(player1 == 0){
        System.out.println("Player 1 loses");
    if(player2 == 0){
        System.out.println("Player 2 loses");
    }
    }
}

}