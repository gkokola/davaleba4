package davaleba4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String language;
        String parameters;
        System.out.println("Please input language: ");
        language=input.next();
        System.out.println("Please input parameters: ");
        parameters=input.next();
        Generator generator = new Generator(language,parameters);
        generator.parseStringToArray();
        generator.generateAlphabet();
        generator.generateRandomWord();
        generator.generateRandomChar();
        generator.generateRandomSentence();



    }

}
