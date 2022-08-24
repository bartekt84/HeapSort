package pl.edu.pg;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;

public class Anagram {

    //lista anagramów wrarz z sygnaturami
    static ArrayList<String> list = new ArrayList<>();

    //pola w klasie
    private String anagram;
    private StringBuilder signature;


    /////// KONSTRUKTORY /////
    public Anagram(String anagram) {
        this.anagram = anagram;
        this.signature = new StringBuilder(this.anagram);
        signatureBuilder(this.signature);
    }

    //metoda odpowiadająca za stworzenie sygnatury danego anagramu
    public void signatureBuilder(StringBuilder signature) {

        for (int i = 1; i < signature.length(); i++) {
            if (signature.charAt(i - 1) > signature.charAt(i)) {
                char tmp = signature.charAt(i - 1);
                signature.setCharAt(i - 1, signature.charAt(i));
                signature.setCharAt(i, tmp);
                signatureBuilder(signature);
            }
        }

    }

    // Sortowanie pliku odbywa się w klasie HeapSortStrings. Anagramy są sortowane przez kopcowanie.
    // Odczyt i zapis plików jest w klasie Files
    //Grupowanie anagramów jest rozpisane w klasie GroupAnagrams.





    public String howToSave() {   //zapisywanie danych do nowego pliku
        return this.signature + " " + this.anagram;
    }

    public ArrayList<String> howToSave(ArrayList<Anagram> list) {
        ArrayList<String> strings = new ArrayList<>();
        for (Anagram anagram : list) {
            strings.add(anagram.howToSave());
        }
        return strings;
    }
    ////////////////////////////////////////////////


    public StringBuilder getSignature() {
        return signature;
    }
}
