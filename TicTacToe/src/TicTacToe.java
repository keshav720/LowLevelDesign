import Model.*;

import java.util.*;

public class TicTacToe {
    Deque<Player> players;
    Board gameboard;

    public void IntializeGame(){
        players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        PlayingPieceO zeroPiece = new PlayingPieceO();

        Player player1 = new Player("Player1", crossPiece);
        Player player2 = new Player("Player2", zeroPiece);

        players.add(player1);
        players.add(player2);

        gameboard = new Board(3);
    }

    public String PlayGame(){
        boolean gameOver = false;
        while(!gameOver){
            Player currentPlayer = players.pollFirst();
            gameboard.printBoard();
            List<Pair<Integer, Integer>> freeCells = gameboard.getFreeCells();

            if(freeCells.isEmpty()){
                gameOver = true;
                continue;
            }

            System.out.println("Current player is " + currentPlayer.name + " Enter row and col : ");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] tokens = s.split(" ");

            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);

            boolean piecesAddedSuccessfully = gameboard.addPiece(currentPlayer.playingPiece, row, col);
            if(!piecesAddedSuccessfully){
                System.out.println("You have not added a piece to the board, please try again !!");
                players.addFirst(currentPlayer);
                continue;
            }

            players.addLast(currentPlayer);

            boolean winner = isThereWinner(row, col, currentPlayer.playingPiece.pieceType);
            if(winner){
                gameOver = true;
                return currentPlayer.name;
            }
        }
        return "Tie";
    }

    private boolean isThereWinner(int row, int col, PieceType pieceType) {
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagMatch = true;
        boolean antiDiagMatch = true;

        for(int i = 0; i<gameboard.size; i++){
            if(gameboard.board[row][i] == null || gameboard.board[row][i].pieceType != pieceType){
                rowMatch = false;
            }
        }

        for(int i = 0; i<gameboard.size; i++){
            if(gameboard.board[i][col] == null || gameboard.board[i][col].pieceType != pieceType)
                colMatch = false;
        }

        for(int i = 0, j = 0; i<gameboard.size && j< gameboard.size; i++, j++){
            if(gameboard.board[i][j] == null || gameboard.board[i][j].pieceType != pieceType)
                diagMatch = false;
        }

        for(int i = gameboard.size - 1, j = 0; i>=0 && j< gameboard.size; i--, j++){
            if(gameboard.board[i][j] == null || gameboard.board[i][j].pieceType != pieceType)
                antiDiagMatch = false;
        }


        return rowMatch || colMatch || diagMatch || antiDiagMatch;
    }
}
