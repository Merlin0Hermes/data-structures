package word_utils;

import List.List;
import deque.LinkedListDeque;
import array_list.AList;

public class WordUtils {

    public static String longest(List<String> list) {
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

    public static void main(String[] args) {
        AList<String> list = new AList<>();
        list.addFirst("What");
        list.addLast("watching");
        list.addFirst("however");
        list.addLast("whenever");
        list.addFirst("hieroglyphics");

        list.print();
        System.out.println(WordUtils.longest(list));
    }

}