package pl.edu.pg;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Files {

    //odczyt danych ze słownika
    public void readFile(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {

                String string = scanner.nextLine();
                Anagram.list.add(string);


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    //zapis do nowego pliku anagramów wraz z sygnaturami
    public void fileWriter(String filename, ArrayList<String> arrayList) {
        BufferedWriter bw = null;
        try {
            FileWriter fileWriter = new FileWriter(filename);
            bw = new BufferedWriter(fileWriter);
            for(String string : arrayList) {
                bw.write(string+"\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
