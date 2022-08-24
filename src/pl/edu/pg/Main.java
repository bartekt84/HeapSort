package pl.edu.pg;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Files files = new Files();
        files.readFile("Slownik_UTF8.txt");
        System.out.println("skończyłem czytać, zaczynamy zapis");
        ArrayList<Anagram> anagrams = new ArrayList<>();
        for (String anagram:Anagram.list){
            anagrams.add(new Anagram(anagram));
        }
        Anagram anagram = new Anagram("");
        files.fileWriter( "anagramy.txt",anagram.howToSave(anagrams) );
        System.out.println("Pierwszy plik zapisany.");
        Anagram.list.clear();
        System.out.println("Czytamy anagramy.");
        files.readFile("anagramy.txt");
        HeapSortStrings heapSort = new HeapSortStrings("");
        System.out.println("prystępujemy do sortowania");
        heapSort.heapBuild();
        System.out.println("Kopiec zbudowany");
        heapSort.heapRemover();
        System.out.println("kopiec pusty, anagramy posortowane");
        Anagram.list.clear();
        files.readFile("posortowane.txt");
        System.out.println("Grupuję anagramy.");
        GroupAnagrams group = new GroupAnagrams("");
        group.groupAnagrams();
        }
}
