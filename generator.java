package davaleba4;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class Generator implements  GeneratorIterface {
    String defaultParameters = "h-2-6-f-2-3-k-2-7";
    boolean wronginput = false;

    private Hashtable alphabet;
    private String language;
    private String parameters;
    private ArrayList param;
    Random random = new Random();

    public Generator(String language, String parameters) {
        this.language = language;
        this.parameters = parameters;
        param = new ArrayList();
        alphabet = new Hashtable();
    }


    public void parseStringToArray() {

        String[] par = parameters.split("-");
        for (String item : par) {
            try {
                param.add(Integer.parseInt(item));
            } catch (NumberFormatException e) {
            }
        }
    }



    public String generateAlpha(char startSymbol, char endSymbol) {
        String alphabet = "";
        for (int i = (int) startSymbol; i <= (int) endSymbol; i++) {
            alphabet += (char) i;
        }
        return alphabet;


    }


    public void generateAlphabet() {

        alphabet.put("ge", generateAlpha('ა', 'ჰ'));
        alphabet.put("en", generateAlpha('a', 'z'));
        alphabet.put("ru",generateAlpha('а','я'));


    }


    public char generateRandomChar() {
        String a = alphabet.get(language).toString();
        char symbol = a.charAt(random.nextInt(a.length()));
        return symbol;


    }


    public String generateRandomWord() {
        int a=(int)param.get(4);
        int b=(int)param.get(5);
        int word_min_number =Math.min(a,b);
        int word_max_number = Math.max(a,b);
        String word = "";
        int rand = random.nextInt(word_max_number - word_min_number + 1) + word_min_number;
        for (int j = 0; j < rand; j++) {
            word += generateRandomChar();
        }
        return word;
    }

    public void generateRandomSentence() {
        int a=(int) param.get(0);
        int b=(int) param.get(1);
        int c=(int)param.get(2);
        int d=(int)param.get(3);
        int e=(int)param.get(4);
        int f=(int)param.get(5);
        int sentenese_number_min= Math.min(a,b);
        int sentenese_number_max=Math.max(a,b);
        int word_min_number_sentense =Math.min(c,d);
        int word_max_number_sentense =Math.max(c,d);
        int word_min_number = Math.min(e,f);
        int word_max_number = Math.max(e,f);
        int rand=random.nextInt(sentenese_number_max-sentenese_number_min+1)+sentenese_number_min;

        for(int i=0;i<rand;i++) {
            String sentence = "";
            int rand_word = random.nextInt(word_max_number_sentense - word_min_number_sentense + 1) + word_min_number_sentense;
            for (int j = 0; j < rand_word; j++) {
                sentence += generateRandomWord() + " ";

            }

            System.out.println(sentence);

        }

    }

}