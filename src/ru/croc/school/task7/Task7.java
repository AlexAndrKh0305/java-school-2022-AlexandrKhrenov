package ru.croc.school.task7;
import ru.croc.school.task7.ChessPosition;
import ru.croc.school.task7.Knight;

public class Task7 {

    public static void main(String[] args) throws IllegalPositionException {

        ChessPosition firstPosition  = new ChessPosition(1, 2);
        System.out.println(firstPosition);

        //ChessPosition secondPosition  = new ChessPosition(-2, 3);
        //System.out.println(secondPosition);

        //firstPosition.setCoordY(-7);

        //ChessPosition thirdPosition = ChessPosition.parse("g5");
        //System.out.println(thirdPosition.getCoordY());

        ChessPosition[] prohibitedPositions = {
                ChessPosition.parse("g8"),
                ChessPosition.parse("e7"),
                ChessPosition.parse("e6")
        };

        Knight.isAllowedMoves(prohibitedPositions);

        ChessPosition[] allowedPositions = {
                ChessPosition.parse("g8"),
                ChessPosition.parse("e7"),
                ChessPosition.parse("c8")
        };

        Knight.isAllowedMoves(allowedPositions);

    }
}
