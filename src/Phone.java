import java.util.*;

public class Phone {
    private static Map<String, List<String>> phoneBook;

    public Phone() {
        phoneBook = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        phoneBook.putIfAbsent(lastName, new ArrayList<>());
        phoneBook.get(lastName).add(phoneNumber);
    }

    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, Collections.emptyList());
    }

    public static void main(String[] args) {
        Phone phoneDirectory = new Phone();
        phoneDirectory.add("Иванов", "9179179117");
        phoneDirectory.add("Иванов", "9179111111");
        phoneDirectory.add("Сидоров", "9277771234");
        System.out.println(phoneDirectory.get("Иванов"));
    }
}
