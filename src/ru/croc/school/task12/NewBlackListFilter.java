package ru.croc.school.task12;
import java.util.List;
import java.util.Set;

final class NewBlackListFilter implements BlackListFilter{

    public void filterComments(List<String> comments, Set<String> blackList) {
        for (String badWord : blackList) {
            int indexOfBadWord = comments.indexOf(badWord);
            while (indexOfBadWord != -1) {
                comments.remove(indexOfBadWord);
                indexOfBadWord = comments.indexOf(badWord);
            }
        }
    }
}
