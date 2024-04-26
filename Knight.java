package pieces;

import java.util.Arrays;
import java.util.List;

public class Knight extends AbstractPiece{
    Knight(){}
    public Knight(Colors color){
        super(color);
    }

    public void draw(){
        if(getColor() == Colors.White){
            System.out.print("\u2658");
        }else{
            System.out.print("\u265E");
        }
    }
    @Override
    public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol) {
        return false;
    }

    public List<String> lshapedPaths(List<String> knightList){
        if (super.getColor() == Colors.White) {
            String[] kingPossibleMoves1 = {"d2", "e2", "f3", "a3", "h3","c3"};
            knightList = Arrays.asList(kingPossibleMoves1);
        } else if (super.getColor() == Colors.Black) {
            String[] kingPossibleMoves = {"d7", "e7", "f6", "a6", "c6","h6"};
            knightList= Arrays.asList(kingPossibleMoves);
        }
        return knightList;
    }

    @Override
    public String toString() {
        return "Knight{} " + super.toString();
    }
}
