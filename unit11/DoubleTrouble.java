package unit11;
  public class DoubleTrouble {
    private int player1;
    private int player2;

    public DoubleTrouble() {
        player1 = 10;
        player2 = 10;
    }

    public static int rollDice() {
        int roll = (int) (Math.random() * 6) + 1;
        return roll;
    }

    public void playRound() {
        int dice1 = rollDice();
        int dice2 = rollDice();

        if (dice1 == dice2) {
            player1 -= 5;
        }
        if ((dice1 + dice2) == 7) {
            player1 += 3;
        }
        if ((dice1 + dice2) % 2 == 0) {
            player1 += 0;
        }
        if ((dice1 + dice2) % 2 != 0) {
            player1 += 1;
        }
    }

    public static void main(String[] args) {
        DoubleTrouble game = new DoubleTrouble();
        game.playRound();

        if (game.player1 == 0) {
            System.out.println("Player 1 loses");
        }
        if (game.player2 == 0) {
            System.out.println("Player 2 loses");
        }
    }
}
