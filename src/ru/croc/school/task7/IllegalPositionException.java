package ru.croc.school.task7;

class IllegalPositionException extends Exception{

    @Override
    public String getMessage() {
        return "Coordinates must be integer values from 0 to 7";
    }
}
