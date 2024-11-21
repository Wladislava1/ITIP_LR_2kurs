import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "C:\\Git\\ITIP\\ITIP_LR_2kurs\\LR6\\text.txt";
        File file = new File(filePath);
        Map<String, Integer> wordCount = new HashMap<>();

        try {
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                word = word.replaceAll("[^a-zA-Zа-яА-Я0-9]", ""); 
                
                if (!word.isEmpty()) {
                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                    } else {
                        wordCount.put(word, 1);
                    }
                }
            }
            scanner.close(); 
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
            return;
        }

        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordCount.entrySet());

        for (int i = 0; i < wordList.size() - 1; i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (wordList.get(i).getValue() < wordList.get(j).getValue()) {
                    Map.Entry<String, Integer> temp = wordList.get(i);
                    wordList.set(i, wordList.get(j));
                    wordList.set(j, temp);
                }
            }
        }

        System.out.println("Топ-10 самых частых слов:");
        for (int i = 0; i < Math.min(10, wordList.size()); i++) {
            Map.Entry<String, Integer> entry = wordList.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue() + " раз(а)");
        }
    }
}
