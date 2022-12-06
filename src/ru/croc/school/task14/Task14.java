package ru.croc.school.task14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class Task14 {

    public static void main(String[] args) {

        NewBlackListFilter filter = new NewBlackListFilter();
        String text = "Some people can say bad_word_1, other can say bad_word_2 but the worst people say the_worst_word";
        String badWords = "bad_word_1 bad_word_2 the_worst_word";

        List<String> comments = new ArrayList<>();
        Set<String> blackList = new HashSet<>();

        for (String word : text.split("[ ,]+")) {
            comments.add(word);
        }

        for (String word : badWords.split(" ")) {
            blackList.add(word);
        }

        Predicate<String> isBadWord = word -> blackList.contains(word);

        List<String> commentsWithNoBadWords = filter.filterComments(comments, isBadWord);
        for (String word : commentsWithNoBadWords) {
            System.out.print(word + " ");
        }
    }
}
