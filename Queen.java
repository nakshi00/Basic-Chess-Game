package pieces;

import java.util.Arrays;
import java.util.List;

public class Queen extends AbstractPiece{
    Queen(){}

    public Queen(Colors colors) {
        super(colors);
    }

    public void draw(){
        if(getColor()==Colors.White){
            System.out.print("\u2655");
        }else{
            System.out.print("\u265B");
        }
    }
    @Override
    public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol) {
        return false;
    }
    public List<String> queenMoves(List<String> queenList){
        if (super.getColor() == Colors.White) {
            String[] kingPossibleMoves1 = {"d1", "a8", "h8", "a5", "h4"};
            queenList = Arrays.asList(kingPossibleMoves1);
        } else if (super.getColor() == Colors.Black) {
            String[] kingPossibleMoves = {"d8", "a4", "h5", "a1", "h1"};
            queenList= Arrays.asList(kingPossibleMoves);
        }
        return queenList;
    }

    @Override
    public String toString() {
        return "Queen{} " + super.toString();
    }
}
