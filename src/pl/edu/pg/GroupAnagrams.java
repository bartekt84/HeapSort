package pl.edu.pg;


import java.util.ArrayList;


public class GroupAnagrams extends Anagram {

    public GroupAnagrams(String anagram) {
        super(anagram);
    }

    public StringBuilder signatureMethod(String string) {
        StringBuilder signature = new StringBuilder(string);
        signature.setLength(signature.length() / 2);
        return signature;
    }

    public StringBuilder anagramMethod(String string) {
        StringBuilder anagram = new StringBuilder(string);
        anagram.delete(0, anagram.length() / 2 + 1);
        return anagram;
    }

    public boolean equals(StringBuilder s1, StringBuilder s2) {
        boolean bool = false;
        String st1 = new String(s1);
        String st2 = new String(s2);
        if (st1.equals(st2)) {
            bool = true;
        }
        return bool;
    }


    //grupowanie anagramów i zapis w zbiorach tylko tych wyrazów, które posiadają anagramy.
    public void groupAnagrams() {
        ArrayList<String> anagramGroup = new ArrayList<>();
        int n = list.size();
        for (int i = 1; i < n; i++) {
            StringBuilder signature = new StringBuilder(list.get(i));
            signature.setLength(signature.length() / 2);
            int j = i - 1;
            String string = "";
            while (equals(signatureMethod(list.get(j)), signature)) {
                string = string + " " + anagramMethod(list.get(j));
                if (j == n - 1) {
                    break;
                }
                j++;
            }
            if(!string.equals("")){
            anagramGroup.add(string);}
            if (j > i) {
                i = j;
            }
        }
        Files files = new Files();
        files.fileWriter("pogrupowane.txt", anagramGroup);
    }

}
