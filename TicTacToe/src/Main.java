//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.IntializeGame();
        System.out.println("Tic-Tac-Toe! and winner is " + game.PlayGame());
        }
    }

