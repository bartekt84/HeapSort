package pl.edu.pg;


import java.util.ArrayList;

public class HeapSortStrings extends Anagram {


    public HeapSortStrings(String anagram) {
        super(anagram);
    }


    public void heapBuild() {

        int n = list.size();
        for (int i = 1; i < n; i++) {

            int j = i;
            while (min(list.get(j), list.get((j - 1) / 2)).equals(list.get((j - 1) / 2)) && j > 0) {
                swapPosition(list, j, (j - 1) / 2);
                j = (j - 1) / 2;
            }
        }
    }


    public void heapRemover() {
        int n = list.size();

        for (int i = n - 1; i > 0; i--) {
            swapPosition(list, i, 0);
            int j = 0;
            while (2 * j + 2 < i && min(list.get(j), max(list.get(2 * j + 1), list.get(2 * j + 2))).equals(list.get(j))) {
                if (max(list.get(2 * j + 1), list.get(2 * j + 2)).equals(list.get(2 * j + 1))) {
                    swapPosition(list, j, 2 * j + 1);
                    j = 2 * j + 1;
                } else {
                    swapPosition(list, j, 2 * j + 2);
                    j = 2 * j + 2;
                }
            }
        }

        if (max(list.get(0), list.get(1)).equals(list.get(0))) {
            swapPosition(list, 0, 1);
        }
        for (int i = 0; i < n; i++) {
            list.set(i, list.get(i));
        }
        Files files = new Files();
        files.fileWriter("posortowane.txt", list);

    }


    // Porwnanie dwoch zmiennych typu STRING
    public String min(String s1, String s2) {
        String string = null;
        if (s1.equals(s2)) {
            string = s2;
        } else {

            int n = Math.min(s1.length(), s2.length());
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) < s2.charAt(i)) {
                    string = s1;
                    break;
                } else if (s1.charAt(i) > s2.charAt(i)) {
                    string = s2;
                    break;
                }

            }
        }
        if (string == null) {
            if (s1.length() < s2.length()) {
                string = s1;
            } else string = s2;
        }

        return string;
    }

    public String max(String s1, String s2) {
        String string = null;
        if (s1.equals(s2)) {
            string = s1;
        } else {

            int n = Math.min(s1.length(), s2.length());
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) > s2.charAt(i)) {
                    string = s1;
                    break;
                } else if (s1.charAt(i) < s2.charAt(i)) {
                    string = s2;
                    break;
                }
            }
        }
        if (string == null) {
            if (s1.length() < s2.length()) {
                string = s2;
            } else string = s1;
        }

        return string;
    }

    //Zmiana pozycji na liście zmiennych typu string;
    public void swapPosition(ArrayList<String> strings, int i, int j) {
        if (i >= strings.size() || j >= strings.size()) {
            System.out.println("Zamiana tych pozycji nie jest możliwa");
        } else {
            String tmp = strings.get(i);
            strings.set(i, strings.get(j));
            strings.set(j, tmp);
        }
    }

}
