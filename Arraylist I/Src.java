import java.util.ArrayList;
import java.util.Scanner;

public class Src {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        Scanner in = new Scanner(System.in);
        String word = "";

        while (true) {
            System.out.print("Zadej slovo: ");
            word = in.nextLine().trim().toLowerCase();

            if (word.equals("konec")) {
                break;
            }

            if (strings.contains(word) || word.equals("")) {
                continue;
            }

            strings.add(word);
        }

        System.out.println("Zadal jsi tato slova: " + strings);
    }
}
