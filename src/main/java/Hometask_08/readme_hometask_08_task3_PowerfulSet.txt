Задание 3:
Реализовать класс PowerfulSet, в котором должны быть следующие методы:
● public <T> Set<T> intersection(Set<T> set1, Set<T> set2) – возвращает
пересечение двух наборов.
Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {1, 2}
● public <T> Set<T> union(Set<T> set1, Set<T> set2) – возвращает
объединение двух наборов
Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {0, 1, 2, 3, 4}
● public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) –
возвращает элементы первого набора без тех, которые находятся также и
во втором наборе.
Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {3}

Особенности реализации:

Использование дженериков для работы с любыми типами данных
Метод retainAll() для пересечения множеств
Метод addAll() для объединения множеств
Метод removeAll() для относительного дополнения
Интерактивный режим с пользовательским вводом

Код задачи

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.util.Arrays;

public class PowerfulSet {

    public <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.removeAll(set2);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PowerfulSet powerfulSet = new PowerfulSet();

        System.out.println("=== ИНТЕРАКТИВНАЯ ДЕМОНСТРАЦИЯ PowerfulSet ===");

        while (true) {
            System.out.println("\n" + "═".repeat(50));
            System.out.println("1 - Работа с числами");
            System.out.println("2 - Работа со строками");
            System.out.println("3 - Готовые примеры");
            System.out.println("stop - Выход");
            System.out.print("Выберите вариант: ");

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("stop")) {
                break;
            }

            switch (choice) {
                case "1":
                    processNumbers(scanner, powerfulSet);
                    break;
                case "2":
                    processStrings(scanner, powerfulSet);
                    break;
                case "3":
                    showExamples(powerfulSet);
                    break;
                default:
                    System.out.println("❌ Неверный выбор!");
            }
        }

        System.out.println("Программа завершена.");
        scanner.close();
    }

    private static void processNumbers(Scanner scanner, PowerfulSet powerfulSet) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        System.out.println("\n--- Ввод первого набора чисел ---");
        System.out.println("Введите числа через пробел (например: 1 2 3 4): ");
        String input1 = scanner.nextLine();
        for (String num : input1.split("\\s+")) {
            if (!num.trim().isEmpty()) {
                set1.add(Integer.parseInt(num.trim()));
            }
        }

        System.out.println("--- Ввод второго набора чисел ---");
        System.out.println("Введите числа через пробел: ");
        String input2 = scanner.nextLine();
        for (String num : input2.split("\\s+")) {
            if (!num.trim().isEmpty()) {
                set2.add(Integer.parseInt(num.trim()));
            }
        }

        displayResults(set1, set2, powerfulSet);
    }

    private static void processStrings(Scanner scanner, PowerfulSet powerfulSet) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        System.out.println("\n--- Ввод первого набора строк ---");
        System.out.println("Введите строки через запятую (например: apple, banana, orange): ");
        String input1 = scanner.nextLine();
        for (String str : input1.split(",")) {
            if (!str.trim().isEmpty()) {
                set1.add(str.trim());
            }
        }

        System.out.println("--- Ввод второго набора строк ---");
        System.out.println("Введите строки через запятую: ");
        String input2 = scanner.nextLine();
        for (String str : input2.split(",")) {
            if (!str.trim().isEmpty()) {
                set2.add(str.trim());
            }
        }

        displayResults(set1, set2, powerfulSet);
    }

    private static <T> void displayResults(Set<T> set1, Set<T> set2, PowerfulSet powerfulSet) {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("─".repeat(60));
        System.out.println("Пересечение (элементы в обоих наборах): " + powerfulSet.intersection(set1, set2));
        System.out.println("Объединение (все уникальные элементы): " + powerfulSet.union(set1, set2));
        System.out.println("Set1 \\ Set2 (только в первом наборе): " + powerfulSet.relativeComplement(set1, set2));
        System.out.println("Set2 \\ Set1 (только во втором наборе): " + powerfulSet.relativeComplement(set2, set1));
        System.out.println("═".repeat(60));
    }

    private static void showExamples(PowerfulSet powerfulSet) {
        System.out.println("\n📚 ГОТОВЫЕ ПРИМЕРЫ:");

        // Пример 1
        Set<Integer> numSet1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> numSet2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        System.out.println("\nПример 1 - Числа:");
        displayResults(numSet1, numSet2, powerfulSet);

        // Пример 2
        Set<String> strSet1 = new HashSet<>(Arrays.asList("Java", "Python", "C++"));
        Set<String> strSet2 = new HashSet<>(Arrays.asList("Python", "JavaScript", "Go"));
        System.out.println("\nПример 2 - Языки программирования:");
        displayResults(strSet1, strSet2, powerfulSet);

        // Пример 3 (из задания)
        Set<Integer> taskSet1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> taskSet2 = new HashSet<>(Arrays.asList(0, 1, 2, 4));
        System.out.println("\nПример 3 - Из задания:");
        displayResults(taskSet1, taskSet2, powerfulSet);
    }
}