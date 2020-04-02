import java.util.Scanner;

public class HomeworkLesson3 {
    public static void main(String[] args) {
        String[] words = {
                "apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato"};

        int index = (int) (Math.random() * 26);
        String hiddenWord = words[index];
        //System.out.println("HiddenWord = " + hiddenWord);
        boolean isTrueAnswer = false;

        Scanner sc = new Scanner(System.in);

        do{
            System.out.print("Отгадайте слово: ");
            String word = sc.next();
            if(hiddenWord.equals(word)){
                System.out.println("Вы отгадали! Загаданное слово = " + word);
                isTrueAnswer = true;
            } else {
                String str = "";
                int wordLength = word.length() > hiddenWord.length() ? hiddenWord.length() : word.length();
                for (int i = 0; i < wordLength; i++) {
                    if(word.charAt(i) == hiddenWord.charAt(i)){
                        str+=word.charAt(i);
                    } else {
                        str+="#";
                    }
                }
                int hiddenSymbolCount = str.length();
                for (int i = 0; i < 15 - hiddenSymbolCount; i++) {
                    str+="#";
                }
                System.out.println("Слово = " + str + "\nПопробуйте еще раз");
            }
        } while (!isTrueAnswer);
    }
}
