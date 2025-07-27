package word_utils;

import deque.LinkedListDeque;
import array_list.AList;

public class WordUtils {

    public static String longest(LinkedListDeque<String> list) {
        int maxIndex = 0;
        for (int i = 0; i < list.size(); ++i) {
            String maxString = list.get(maxIndex);
            String thisString = list.get(i);
            if (thisString.length() > maxString.length()) {
                maxIndex = i;
            }
        }
        return list.get(maxIndex);
    }



}