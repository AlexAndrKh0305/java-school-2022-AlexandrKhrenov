package ru.croc.school.task14;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

interface BlackListFilter<E, T2> {

    /**
     * From the given collection of comments removes ones
     * that contain words from the black list.
     *
     * @param comments collection of comments; every comment
     *                 is a sequence of words, separated
     *                 by spaces, punctuation or line breaks
     * @param isBadWord predicate that checks if it is a bad
     *                  word or not
     */
    //void filterComments(List<String> comments, Set<String> blackList);

    public default <E, T extends Iterable<E>>
    List<E> filterComments(T comments, Predicate<E> isBadWord) {
        List<E> commentsWithNoBadWords = new ArrayList<>();

        for (E comment : comments) {
            if (!isBadWord.test(comment))
                commentsWithNoBadWords.add(comment);
        }

        return commentsWithNoBadWords;
    }
}