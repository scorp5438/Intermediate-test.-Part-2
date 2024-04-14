import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\Punisher\\Desktop\\Class\\java_test\\input.txt";
        ArrayList<String> words = readToFole(path);

        int size = CountOfWords(words);
        System.out.printf("Количество слов с списке %d\n", size);

        checkMaxToWordLen(words);

        LinkedHashMap<String, Integer> map = WordFrequency(words);
        System.out.printf("Частота встречания слов:\n");
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }

    public static ArrayList<String> readToFole(String path) {
        StringBuilder str = new StringBuilder();
        ArrayList<String> list_fruit;
        try (FileReader reader = new FileReader(path);) {
            int check;
            while ((check = reader.read()) != -1) {
                str.append(((char) check));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String lists = str.toString();
        list_fruit = new ArrayList<>(Arrays.asList(lists.split("\\s+")));
        return list_fruit;
    }

    public static int CountOfWords(ArrayList<String> list) {
        int count = list.size();
        return count;
    }

    public static void checkMaxToWordLen(ArrayList<String> list) {
        int max_len = 0;
        String word = "";
        for (String string : list) {
            if (string.length() > max_len) {
                max_len = string.length();
                word = string;
            }
        }
        System.out.printf("Cамое длинное слово - %s, длина %d\n", word, max_len);
    }

    public static LinkedHashMap<String, Integer> WordFrequency(ArrayList<String> list) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String fruit : list) {
            if (map.get(fruit) == null) {
                map.put(fruit, 1);
            } else {
                map.put(fruit, map.get(fruit) + 1);
            }
        }
        return map;
    }

}
