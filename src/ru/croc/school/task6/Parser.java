package ru.croc.school.task6;

public class Parser {

    static String removeJavaComments(String source) {
        String textWithNoComments = "";
        int startChar = 0;   //Символ, с которого начинаем искать
        int endChar = 0;

        int indexOfOneLineComment = source.indexOf("//", startChar);
        int indexOfManyLinesComment = source.indexOf("/*", startChar);

        while (indexOfOneLineComment != -1 || indexOfManyLinesComment != -1) {
            if (indexOfOneLineComment != -1 &&
                    (indexOfOneLineComment <= indexOfManyLinesComment || indexOfManyLinesComment == -1)) {
                endChar = Math.max(source.indexOf("\n", indexOfOneLineComment), startChar);
                textWithNoComments += source.substring(startChar, indexOfOneLineComment);
                startChar = endChar;
            }

            else {
                endChar = Math.max(source.indexOf("*/", indexOfManyLinesComment), startChar);
                textWithNoComments += source.substring(startChar, indexOfManyLinesComment);
                startChar = endChar + 2;
            }
            indexOfOneLineComment = source.indexOf("//", startChar);
            indexOfManyLinesComment = source.indexOf("/*", startChar);

        }
        textWithNoComments += source.substring(Math.min(startChar, source.length()), source.length());

        return textWithNoComments;
    }
}
