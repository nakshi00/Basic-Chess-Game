package pieces;

import pieces.AbstractPiece;

public class Pawn extends AbstractPiece {
    Pawn(){}
    Pawn(Colors colors){
        super(colors);
    }

    @Override
    public void draw() {
        if (getColor()== Colors.White) {
            System.out.print("\u2659");
        }
       else {
            System.out.print("\u265F");

        }

    }

    @Override
    public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol) {

        //if pawn moves forward
        //or moves forward two from starting position
        //or takes a piece of black colour
        //break, else return false (not valid move)
        if (getColor()==Colors.White) {
            return (((srcCol == destCol) && srcRow == (destRow + 1))
                    || ((srcRow == 6) && (srcCol == destCol) && (srcRow == (destRow + 2)))
                    || ((srcRow == (destRow + 1))
                    && (Math.abs(srcCol - destCol) == 1)));
        }
        else {
            return (((srcCol == destCol) && srcRow == (destRow - 1))
                    || ((srcRow == 1) && (srcCol == destCol) && (srcRow == (destRow - 2)))
                    || ((srcRow == (destRow - 1))
                    && (Math.abs(srcCol - destCol) == 1)));
        }

    }
}
