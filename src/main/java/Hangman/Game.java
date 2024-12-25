package Hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static boolean lock = true;
    private static int counter;
    private static int rightLetters;
    private static Scanner scanner = new Scanner(System.in);

    public static void game() {
        while (true) {
            System.out.println("[S]tart new game or [E]xit");
            counter=0;
            lock=true;
            char choice=scanner.nextLine().charAt(0);
            if (choice == 'S') {
                ChoseWord choseWord=new ChoseWord();
                choseWord.word();
                Draw draw=new Draw(counter,lock, choseWord.getWord());
                System.out.print("Слово " );
                System.out.println(choseWord.getMask());
                List<Character>notContain=new ArrayList<>();
                while (lock) {
                    System.out.println("Введите букву");
                    char inputLetter = scanner.nextLine().charAt(0);
                    if(Arrays.toString(choseWord.getMask()).contains(String.valueOf(inputLetter))){
                        System.out.println("Вы уже вводили эту букву");
                    }
                    for (int i = 0; i < choseWord.getWord().length; i++) {
                        if (choseWord.getWord()[i] == inputLetter) {
                            choseWord.getMask()[i] =choseWord.getWord()[i] ;
                            rightLetters++;
                        }
                    }
                    System.out.println(choseWord.getMask());
                    if (!choseWord.getExamination().contains(String.valueOf(inputLetter))) {
                        System.out.println("Данной буквы нет");
                        counter++;
                        draw.draw(counter);
                        notContain.add(inputLetter);
                        System.out.println("Количество ошибок "+counter);
                        System.out.println("Использовавшиеся буквы "+notContain);
                        if(counter!=7) {
                            System.out.println(choseWord.getMask());
                        }
                        if(counter==7) {
                            lock = false;
                        }
                    }
                    if (rightLetters == choseWord.getWord().length) {
                        System.out.println("Поздравляю вы победили!");
                        lock = false;
                    }
                }
            }
            else if (choice == 'E'){
                break;
        }
    }
}
