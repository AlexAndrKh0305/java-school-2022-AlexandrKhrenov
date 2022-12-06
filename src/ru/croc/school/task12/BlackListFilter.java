package ru.croc.school.task12;
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
     * @param blackList predicate that checks if it is a bad
     *                  word or not
     */
    void filterComments(List<String> comments, Set<String> blackList);
}

