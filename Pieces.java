package pieces;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

enum Type{
    Pawn, King, Queen, Knight, Bishop, Rook
}

public class Pieces extends AbstractPiece{
        private Colors color;
        private Type type;
        Pieces(){}
        public Pieces(Colors color, Type type, int ID, ChessPosition position) {
            super(ID,position);
            this.color = color;
            this.type = type;
        }

        public Colors getColor() {
            return color;
        }
        public Type getType() {
            return type;
        }

        @Override
        public void draw() {
                switch(type) {
                    case Pawn:  if(getColor() == Colors.White){
                        System.out.print("\u2659");
                    }else{
                        System.out.print("\u265F");
                    }
                    break;
                    case King:
                        if(getColor() == Colors.White){
                            System.out.print("\u2654");
                        }else{
                            System.out.print("\u265A");
                        }
                        break;
                    case Queen:  if(getColor() == Colors.White){
                        System.out.print("\u2655");
                    }else{
                        System.out.print("\u265B");
                    }
                    break;
                    case Rook:  if(getColor() == Colors.White){
                        System.out.print("\u2656");
                    }else{
                        System.out.print("\u265C");
                    }
                    break;
                    case Knight: if(getColor() == Colors.White){
                        System.out.print("\u2658");
                    }else{
                        System.out.print("\u265E");
                    }
                    break;
                    case Bishop: if(getColor() == Colors.White){
                        System.out.print("\u2657");
                    }else{
                        System.out.print("\u265D ");
                    }
                    break;
                }
            }

        @Override
        public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol) {
            return false;
        }


        @Override
        public boolean equals(Object o) {
            Pieces p = (Pieces) o;
            return p.color == color && p.type == type;
        }

        public List<String> possibleMoves(List<String> movesList) {
                switch (type) {
                    case Pawn:
                        if (getColor() == Colors.White) {
                            String[] pawnPossibleMoves1 = {"a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3",
                                    "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4"};
                            movesList = Arrays.asList(pawnPossibleMoves1);
                        } else if (getColor() == Colors.Black) {
                            String[] pawnPossibleMoves = {"a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6",
                                    "a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5"};
                           movesList = Arrays.asList(pawnPossibleMoves);
                        }
                        break;
                    case King:
                        if (getColor() == Colors.White) {
                            String[] kingPossibleMoves1 = {"d2", "e2", "f2", "1d", "8d"};
                            movesList= Arrays.asList(kingPossibleMoves1);
                        } else if (getColor() == Colors.Black) {
                            String[] kingPossibleMoves = {"d7", "e7", "f7", "8d", "8f"};
                            movesList  = Arrays.asList(kingPossibleMoves);
                        }
                        break;
                    case Queen:
                        if (getColor() == Colors.White) {
                            String[] kingPossibleMoves1 = {"d1", "a8", "h8", "a5", "h4"};
                            movesList = Arrays.asList(kingPossibleMoves1);
                        } else if (getColor() == Colors.Black) {
                            String[] kingPossibleMoves = {"d8", "a4", "h5", "a1", "h1"};
                            movesList= Arrays.asList(kingPossibleMoves);
                        }
                        break;
                    case Knight:
                        if (getColor() == Colors.White) {
                            String[] kingPossibleMoves1 = {"d2", "e2", "f3", "a3", "h3","c3"};
                            movesList = Arrays.asList(kingPossibleMoves1);
                        } else if (getColor() == Colors.Black) {
                            String[] kingPossibleMoves = {"d7", "e7", "f6", "a6", "c6","h6"};
                            movesList= Arrays.asList(kingPossibleMoves);
                        }
                        break;
                    case Bishop:
                        if (getColor() == Colors.White) {
                            String[] bishopPossibleMoves1 = {"a3", "h6", "a6", "h3"};
                            movesList = Arrays.asList(bishopPossibleMoves1);
                        } else if (getColor() == Colors.Black) {
                            String[] bishopPossibleMoves = {"h3", "a6", "h6", "a3"};
                           movesList = Arrays.asList(bishopPossibleMoves);
                        }
                        break;
                    case Rook:
                        String[] RookPossibleMoves = {"a8","h8", "h1", "a1"}; //The both black and white rooks moves horizontally or vertically
                        movesList = Arrays.asList(RookPossibleMoves);
                        break;
                }
            return movesList;
        }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder();
        sb.append(color).append(type);
        sb.append('{').append(" ").append(super.toString()).append('}');
        return sb.toString();
    }
}
