import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static LinkedList<String> listProducts = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Выберите номер операции или наберите end для выхода из программы");
            System.out.println("1. Добавить");
            System.out.println("2. Показать");
            System.out.println("3. Удалить");

            String input = "";
            int operationStr = 0;
            try {
                input = scanner.nextLine();
                operationStr = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                if (input.equals("end")) {
                    break;
                }
            }

            switch (operationStr) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    showProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                default:
                    System.out.println("Такого номера операции не существует");
            }
        }
    }

    static void addProduct() {
        System.out.println("Какую покупку хотите добавить?");
        String product = scanner.nextLine();
        listProducts.add(product);
        System.out.println("Всего " + listProducts.size() + " пунктов");
    }

    static void showProduct() {
        System.out.println("Список покупок:");
        for (int i = 0; i < listProducts.size(); i++) {
            System.out.println(listProducts.get(i));
        }
    }

    static void removeProduct() {
        System.out.println("Какую покупку хотите удалить? Введите номер или название");
        String product = scanner.nextLine();
        try {
            int productNumber = Integer.parseInt(product);
            listProducts.remove(productNumber - 1);
            showProduct();
        } catch (NumberFormatException e) {
            listProducts.remove(product);
            showProduct();
        }
    }
}