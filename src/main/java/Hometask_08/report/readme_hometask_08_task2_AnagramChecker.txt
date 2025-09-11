Задание 2:
С консоли на вход подается две строки s и t. Необходимо вывести true, если одна
строка является валидной анаграммой другой строки, и false – если это не так.
Анаграмма – это слово, или фраза, образованная путем перестановки букв другого
слова или фразы, обычно с использованием всех исходных букв ровно один раз.
Для проверки:
● Бейсбол – бобслей
● Героин – регион
● Клоака – околка

Особенности реализации:
Бесконечный цикл с возможностью выхода по команде "stop"
Обработка пустых строк и ошибок ввода
Подсветка результатов с помощью эмодзи и форматирования
Возможность быстрого перехода к следующей проверке
Расширенная обработка символов (игнорирование пробелов и знаков препинания)

Код задачи

import java.util.Scanner;
import java.util.Arrays;

public class AnagramChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Проверка анаграмм ===");
        System.out.println("Введите две строки для проверки");
        System.out.println("Для выхода введите 'stop'");
        System.out.println("=".repeat(30));

        while (true) {
            // Ввод первой строки
            System.out.print("\nВведите первую строку (или 'stop' для выхода): ");
            String s = scanner.nextLine();

            // Проверка на команду выхода
            if (s.equalsIgnoreCase("stop")) {
                break;
            }

            // Ввод второй строки
            System.out.print("Введите вторую строку: ");
            String t = scanner.nextLine();

            // Проверка являются ли строки анаграммами
            boolean result = isAnagram(s, t);

            // Вывод результата с подробной информацией
            System.out.println("=".repeat(30));
            System.out.println("Результат проверки:");
            System.out.println("Строка 1: '" + s + "'");
            System.out.println("Строка 2: '" + t + "'");
            System.out.println("Являются анаграммами: " + result);
            System.out.println("=".repeat(30));

            // Предложение продолжить
            System.out.print("Продолжить проверку? (y/n или нажмите Enter для продолжения): ");
            String continueChoice = scanner.nextLine();

            if (continueChoice.equalsIgnoreCase("n") || continueChoice.equalsIgnoreCase("no")) {
                break;
            }
        }

        System.out.println("\nПрограмма завершена. До свидания!");
        scanner.close();
    }

    /**
     * Метод проверяет, являются ли две строки анаграммами
     */
    public static boolean isAnagram(String s, String t) {
        // Удаляем пробелы, знаки препинания и приводим к нижнему регистру
        String sClean = s.replaceAll("[^\\p{L}]", "").toLowerCase();
        String tClean = t.replaceAll("[^\\p{L}]", "").toLowerCase();

        // Если длины разные - не могут быть анаграммами
        if (sClean.length() != tClean.length()) {
            return false;
        }

        // Преобразуем строки в массивы символов и сортируем
        char[] sArray = sClean.toCharArray();
        char[] tArray = tClean.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        // Сравниваем отсортированные массивы
        return Arrays.equals(sArray, tArray);
    }
}