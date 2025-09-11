
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueElements {

    public static <T> Set<T> getUniqueElements(ArrayList<T> list) {
        return new HashSet<>(list);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Программа для поиска уникальных элементов ===");
        System.out.println("Выберите тип данных:");
        System.out.println("1 - Целые числа");
        System.out.println("2 - Строки");
        System.out.print("Ваш выбор: ");

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Неверный выбор! Используем числа по умолчанию.");
            choice = 1;
        }

        if (choice == 1) {
            processNumbers(scanner);
        } else if (choice == 2) {
            processStrings(scanner);
        } else {
            System.out.println("Неверный выбор! Используем числа по умолчанию.");
            processNumbers(scanner);
        }

        scanner.close();
    }

    private static void processNumbers(Scanner scanner) {
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("\nВведите целые числа (для завершения введите 'stop'):");

        while (true) {
            System.out.print("Введите число: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("stop")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число или 'stop' для завершения.");
            }
        }

        displayResults(numbers);
    }

    private static void processStrings(Scanner scanner) {
        ArrayList<String> strings = new ArrayList<>();

        System.out.println("\nВведите строки (для завершения введите 'stop'):");

        while (true) {
            System.out.print("Введите строку: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("stop")) {
                break;
            }

            if (!input.trim().isEmpty()) {
                strings.add(input);
            } else {
                System.out.println("Ошибка! Строка не может быть пустой.");
            }
        }

        displayResults(strings);
    }

    private static <T> void displayResults(ArrayList<T> list) {
        if (list.isEmpty()) {
            System.out.println("Вы не ввели ни одного элемента!");
        } else {
            Set<T> uniqueElements = getUniqueElements(list);

            System.out.println("\nРезультаты:");
            System.out.println("Исходный список: " + list);
            System.out.println("Уникальные элементы: " + uniqueElements);
            System.out.println("Количество уникальных элементов: " + uniqueElements.size());
            System.out.println("Количество дубликатов: " + (list.size() - uniqueElements.size()));
        }
    }
}