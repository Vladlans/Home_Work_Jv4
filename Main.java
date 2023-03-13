//1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
//2. Реализуйте очередь с помощью LinkedList со следующими методами:enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.
// 3. В калькулятор добавьте возможность отменить последнюю операцию.


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner enterNumber = new Scanner(System.in);
        System.out.print("Введите размер списка: ");
        int sizeList = enterNumber.nextInt();
        System.out.print("Введите минимально возможное число: ");
        int minList = enterNumber.nextInt();
        System.out.print("Введите максимально возможное число: ");
        int maxList = enterNumber.nextInt();
        LinkedList<Integer> list = getLinkedListRandom(sizeList, minList, maxList);
        getLinkedListReverse(list);

        Deque<Integer> queue = list;
        System.out.print("Какое число добавить в очередь? ");
        int num = enterNumber.nextInt();
        printLinkedList(list, num);

        calculator();

    }
    /**
     * 1. Пусть дан LinkedList с несколькими элементами.
     * Реализуйте метод, который вернет “перевернутый” список.
     */
    private static void getLinkedListReverse(LinkedList<Integer> list) {
        System.out.println("Первоначальный список: " + list);
        Collections.reverse(list);
        System.out.println("Перевернутый список: " + list);
    }
    /** Метод возвращает список из случайных целх чисел
     *
     */
    private static LinkedList<Integer> getLinkedListRandom(int size, int min, int max){
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++){
            Random rand = new Random();
            list.add(rand.nextInt((max - min) + 1) + min);
        }
        return list;
    }
    /**
     * 2. Реализуйте очередь с помощью LinkedList со следующими методами:
     * enqueue() - помещает элемент в конец очереди,
     * dequeue() - возвращает первый элемент из очереди и удаляет его,
     * first() - возвращает первый элемент из очереди, не удаляя.
     */
    private static void printLinkedList(Deque<Integer> queue, int elem) {
        System.out.println("Формируем первоначальную очередь: " + queue);
        enqueue(elem, queue);
        System.out.println("После добавления элемента в очередь: " + queue);
        System.out.println("Первый элемент очереди равен " + dequeue(queue));
        System.out.println("Очередь стала " +  queue);
        System.out.println("Теперь первый элемент очереди равен " + first(queue));
        System.out.println("Окончательная очередь " + queue);
    }
    private static void enqueue(int element, Deque<Integer> queue) {
        queue.addLast(element);
    }
    private static int dequeue(Deque<Integer> queue) {
        return queue.pollFirst();
    }
    private static int first(Deque<Integer> queue) {
        return queue.peekFirst();
    }

    /**
     * 3. В калькулятор добавьте возможность отменить последнюю операцию.
     */
    private static void cancelInCalculator() {
        boolean flag = true;
        while (flag) {
            System.out.println("Для отмены действия введите 'отмена'");
            System.out.println("Для выхода из калькулятора введите 'выход'");
            Scanner scanner = new Scanner(System.in);
            String back = scanner.next();

            if (back.equals("отмена")) {
                calculator();
            }
            if (back.equals("выход")) {
                flag = false;
            }
        }
    }
    /**
     * Самый простой калькулятор)
     */
    public static void calculator() {
        try{
            double firstNumber = scanNumber("Введите первое число: ");
            double secondNumber = scanNumber("Введите второе число: ");
            System.out.println(firstNumber + " + " + secondNumber + " = " + (firstNumber + secondNumber));
            System.out.println(firstNumber + " - " + secondNumber + " = " + (firstNumber - secondNumber));
            System.out.println(firstNumber + " * " + secondNumber + " = " + (firstNumber * secondNumber));
            System.out.println(firstNumber + " / " + secondNumber + " = " + (firstNumber / secondNumber));
            cancelInCalculator();
        }
        catch(Exception e) {
            System.out.println("Введено не число.");
        }
    }
    // функция запроса числа от пользователя
    public static double scanNumber(String text){
        System.out.print(text);
        Scanner sc = new Scanner(System.in);
        double number = sc.nextDouble();
        return number;
    }
}