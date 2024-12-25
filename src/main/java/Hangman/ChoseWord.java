package Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ChoseWord {
    private static final File file = new File("singular.txt");
    private char[] word;
    private char[] mask;
    private String examination;

    public void word() {
        Scanner scanner= null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        Random randomWord = new Random();
        String examination = list.get(randomWord.nextInt(list.size()));
        this.examination = examination;
        char[] word = examination.toCharArray();
        this.word = word;
        char[] mask = new char[word.length];
        Arrays.fill(mask, '*');
        this.mask = mask;
        scanner.close();
    }

    public char[] getWord() {
        return word;
    }

    public char[] getMask() {
        return mask;
    }

    public String getExamination() {
        return examination;
    }
}
