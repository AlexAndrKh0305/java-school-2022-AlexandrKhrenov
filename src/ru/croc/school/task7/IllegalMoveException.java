package ru.croc.school.task7;

class IllegalMoveException extends Exception{

    private final ChessPosition firstPosition;
    private final ChessPosition secondPosition;

    IllegalMoveException(ChessPosition firstPosition, ChessPosition secondPosition) {
        super();
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
    }

    @Override
    public String getMessage() {
        return "Move from position " + firstPosition + " to position "
                + secondPosition + " is prohibited";
    }

    @Override
    public String toString() {
        return "Move from position " + firstPosition + " to position "
                + secondPosition + " is prohibited";
    }
}
