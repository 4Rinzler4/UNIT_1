import java.util.Random;
import java.util.Scanner;

public class Pz1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueProgram;

        do {
            try {
                System.out.println("Оберіть спосіб заповнення масиву:");
                System.out.println("1. Заповнити масив вручну");
                System.out.println("2. Згенерувати масив випадковими значеннями");
                int choice = scanner.nextInt();

                int[] array;
                if (choice == 1) {
                    array = manualArrayInput(scanner);
                } else if (choice == 2) {
                    System.out.print("Введіть розмір масиву: ");
                    int size = scanner.nextInt();
                    array = generateArray(size);
                } else {
                    throw new Exception("Невірний вибір. Спробуйте ще раз.");
                }

                System.out.println("Масив:");
                for (int num : array) {
                    System.out.print(num + " ");
                }
                System.out.println();

                int count = countElementsLessThanSeven(array);
                System.out.println("Кількість елементів, менших за 7: " + count);

                try {
                    int product = productBetweenZeros(array);
                    System.out.println("Добуток між першим і другим нулями: " + product);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } catch (Exception e) {
                System.out.println("Сталася помилка: " + e.getMessage());
            }

            System.out.println("Бажаєте продовжити? Введіть 'так' для продовження або будь-яке інше значення для виходу.");
            continueProgram = scanner.next();

        } while (continueProgram.equalsIgnoreCase("так"));

        scanner.close();
    }

    // Метод для генерації масиву випадкових чисел у діапазоні [-100; 100]
    public static int[] generateArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(201) - 100;
        }
        return array;
    }

    public static int[] manualArrayInput(Scanner scanner) {
        System.out.print("Введіть розмір масиву: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Введіть елементи масиву:");
        for (int i = 0; i < size; i++) {
            System.out.print("Елемент " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int countElementsLessThanSeven(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num < 7) {
                count++;
            }
        }
        return count;
    }

    public static int productBetweenZeros(int[] array) throws Exception {
        int firstZeroIndex = -1;
        int secondZeroIndex = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                if (firstZeroIndex == -1) {
                    firstZeroIndex = i;
                } else {
                    secondZeroIndex = i;
                    break;
                }
            }
        }

        if (firstZeroIndex == -1 || secondZeroIndex == -1) {
            throw new Exception("Має бути два нулі в масиві.");
        }

        int product = 1;
        for (int i = firstZeroIndex + 1; i < secondZeroIndex; i++) {
            product *= array[i];
        }

        return product;
    }
}
