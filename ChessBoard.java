package pieces;

import java.util.Scanner;

public class ChessBoard {
        private static final AbstractPiece[][] chessboard = new AbstractPiece[8][8];
        private static int srcRow, srcCol, destRow, destCol;
        // Set to true if move is invalid. Asks for user input again in move()
        // method.
        private static Boolean invalidMove = false;

        /**
         * Constructs a Chessboard object and populates it with pieces Starts a
         * chess game running.
         */

        public ChessBoard() {
         initialiseBoard(chessboard);
        }

        /**
         * Populates the chessboard of AbstractPiece with the correct pieces and
         * randomly assigns whether white or black moves first
         *
         * @param chessboard
         */
        private static void initialiseBoard(AbstractPiece[][] chessboard) {

            for (int row = 0; row < chessboard.length; row++) {
                for (int col = 0; col < chessboard[row].length; col++) {
                    if (row == 0) {
                        switch (col) {
                            case 1 -> chessboard[row][col] = new Rook(Colors.Black);
                            case 2, 7 -> chessboard[row][col] = new Pawn(Colors.Black);
                            case 3, 4 -> chessboard[row][col] = new Pawn(Colors.White);
                        }
                    } else if (row == 1) {
                        switch (col) {
                            case 1 -> chessboard[row][col] = new Bishop(Colors.Black);
                            case 3 -> chessboard[row][col] = new Rook(Colors.White);
                        }
                    } else if (row == 2) {
                        switch (col) {
                            case 3 -> chessboard[row][col] = new Pawn(Colors.Black);
                            case 2 -> chessboard[row][col] = new Bishop(Colors.White);
                            case 5 -> chessboard[row][col] = new Pawn(Colors.White);
                        }
                    } else if (row == 3) {
                        switch (col) {
                            case 1, 6 -> chessboard[row][col] = new Pawn(Colors.Black);
                            case 2 -> chessboard[row][col] = new Knight(Colors.Black);
                        }
                    } else if (row == 4) {
                        switch (col) {
                            case 0, 5 -> chessboard[row][col] = new Pawn(Colors.Black);
                            case 2 -> chessboard[row][col] = new Rook(Colors.White);
                            case 7 -> chessboard[row][col] = new King(Colors.Black);
                        }
                    } else if (row == 5) {
                        switch (col) {
                            case 2 -> chessboard[row][col] = new Queen(Colors.Black);
                            case 3 -> chessboard[row][col] = new Pawn(Colors.White);
                            case 4 -> chessboard[row][col] = new Bishop(Colors.White);
                        }
                    } else if (row == 6) {
                        switch (col) {
                            case 0 -> chessboard[row][col] = new King(Colors.White);
                            case 1 -> chessboard[row][col] = new Rook(Colors.Black);
                            case 2, 4, 5 -> chessboard[row][col] = new Pawn(Colors.White);
                            case 7 -> chessboard[row][col] = new Queen(Colors.White);
                        }
                    } else if (row == 7) {
                        switch (col) {
                            case 0 -> chessboard[row][col] = new Pawn(Colors.White);
                            case 2 -> chessboard[row][col] = new Bishop(Colors.Black);
                            case 3, 7 -> chessboard[row][col] = new Knight(Colors.White);
                            case 4 -> chessboard[row][col] = new Knight(Colors.Black);
                            case 5 -> chessboard[row][col] = new Pawn(Colors.Black);
                        }
                    } else chessboard[row][col] = new Xsign('X');
                }
            }
        }

        /**
         * Prints out the unicode for each character to the console using the draw()
         * method from the relevant piece's class followed by tabs for tidiness.
         * Prints numbers 1-8 alongside rows and letters a-h alongside columns
         */
        public static void printBoard(){

            // must take an 8x8 array of Chessmen (chess pieces),
            // i.e. a chessboard, as argument

            System.out.println("X\ta\tb\tc\td\te\tf\tg\th");
            for (int row = 0; row < chessboard.length; row++) {
                System.out.print(row+ 1 + "\t");
                for (int col = 0; col < chessboard[row].length; col++) {
                    if (chessboard[row][col] != null) {
                        chessboard[row][col].draw();
                        System.out.print("\t");

                    } else {
                        System.out.print("\t");
                    }
                }
                System.out.println();
            }
        }

        /**
         * Checks if a move is valid with 2 steps. Step 1: some general rule checks
         * that any piece should obey.
         * Step 2: The specific isMoveValid() method from
         * a piece's class that checks rules specific for that piece, e.g that a
         * rook moves in straight lines.
         *
         * @return True if valid, false if invalid.
         */

        private boolean moveValid() throws IllogicalMoveException{

            // invalid if the move origin or destination is outside the board
            if (srcRow < 0 || srcRow > 7 || srcCol < 0 || srcCol > 7 || destRow < 0
                    || destRow > 7 || destCol < 0 || destCol > 7) {
                throw new IllogicalMoveException("Move is outside the board");
            }

            // Invalid if origin is null
            if (chessboard[srcRow][srcCol] == null) {
                throw new IllogicalMoveException("Origin is empty");
            }

            // Invalid if specific piece rules are not obeyed
            if (!chessboard[srcRow][srcCol].isMoveValid(srcRow, srcCol, destRow,
                    destCol)) {
                throw new IllogicalMoveException("This piece doesn't move like that");
            }
            return true;
        }

        /**
         * Take user input for the instructions for move in the form
         * "start coords to destination coords", e.g. "d2 to d3" and converts this
         * string to array coordinates for the Chessboard. Checks if the move is
         * valid using moveValid(). If valid moves piece to destination on
         * Chessboard and updates score with updateScore(). If invalid prints error
         * message and recursively calls itself.
         */
        public void move() throws IllogicalMoveException{
                if(invalidMove) {
                    try {
                        moveValid();
                    } catch (IllogicalMoveException e) {
                        e.printStackTrace();
                    } finally {
                        System.err.println("Move is invalid. Please try again:");
                    }
                    invalidMove = false;
                }
//            move = user_input.nextLine();

//            // convert to lower case
////            String lowerCase = move.toLowerCase();
//            // parse move string into components
//            String[] components = lowerCase.split(" ");

            // if you assume that move is "e1 to e5" then
//		 components[0].charAt(0) = 'e';
//		 components[0].charAt(1) = '1';

            // use chars in components to set the array coordinates of the
            // move origin and move destination

//            srcRow = 7 - (components[0].charAt(1) - '1');
//            srcCol = components[0].charAt(0) - 'a';
//            destRow = 7 - (components[2].charAt(1) - '1');
//            destCol = components[2].charAt(0) - 'a';

            if (moveValid()) {
                // put piece in destination
                chessboard[destRow][destCol] = chessboard[srcRow][srcCol];
                // empty the origin of the move
                chessboard[srcRow][srcCol] = null;
            } else {
                invalidMove = true;
                move();

            }

        }

    }
