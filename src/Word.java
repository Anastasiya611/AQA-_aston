import java.util.HashMap;
import java.util.Map;

public class Word {
    public static void main(String[] args) {
        String[] words = {"тигр", "кот", "лев", "собака", "лев",
                "кот", "кот", "гепард", "пантера", "барс", "собака", "кот", "леопард"};

        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("слово: <" + entry.getKey() + "> встречается в списке: " + entry.getValue() + " раз.");
            } else {
                System.out.println("слово: <" + entry.getKey() + "> встречается в списке: " + entry.getValue() + " раза.");
            }
        }
    }
}
