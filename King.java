package pieces;

import java.util.Arrays;
import java.util.List;

public class King extends AbstractPiece{
    King(){}
    public King(Colors color) {
        super(color);
    }

    public void draw(){
        if(getColor()==Colors.White){
            System.out.print("\u2654");
        }else{
            System.out.print("\u265A");
        }
    }
    @Override
    public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol) {
        return false;
    }

    public List<String> diagonalPath(List<String> kingList) {
        if (super.getColor() == Colors.White) {
            String[] kingPossibleMoves1 = {"d2", "e2", "f2", "1d", "8d"};
           return kingList = Arrays.asList(kingPossibleMoves1);
        } else if (super.getColor() == Colors.Black) {
            String[] kingPossibleMoves = {"d7", "e7", "f7", "8d", "8f"};
           return kingList = Arrays.asList(kingPossibleMoves);
        }
        return kingList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getColor()).append("King").append("{ ");
        sb.append("ID = ").append(getID()).append("Position = ").append(getPosition());
        return sb.toString();
    }
}
