package ru.croc.school.task7;
import ru.croc.school.task7.IllegalMoveException;

class Knight { // В английском языке knight это шахматная фигура коня

    public static void isAllowedMove(ChessPosition firstPosition,
                                     ChessPosition secondPosition)
            throws IllegalMoveException{
        int deltaX = secondPosition.getCoordX() - firstPosition.getCoordX();
        int deltaY = secondPosition.getCoordY() - firstPosition.getCoordY();
        if (!(Math.abs(deltaX) == 1 && Math.abs(deltaY) == 2 || Math.abs(deltaX) == 2 && Math.abs(deltaY) == 1)) {
            throw new IllegalMoveException(firstPosition, secondPosition);
        }
    }

    public static void isAllowedMoves(ChessPosition[] positions) {
        try {
            for (int i = 0; i < positions.length - 1; i++) {
                isAllowedMove(positions[i], positions[i + 1]);
            }
            System.out.println("OK");
        } catch (IllegalMoveException e) {
            System.out.println(e);
        }
    }
}
