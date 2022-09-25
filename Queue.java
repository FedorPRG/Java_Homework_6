public class Queue {
    public static void main(String[] args) {
        MyQueue ms = new MyQueue();
        System.out.println(ms.print());//вывод на экран
        ms.push(1);//добавление в очередь
        ms.push(2);//добавление в очередь
        System.out.println(ms.print());//вывод на экран
        ms.push(3);//добавление в очередь
        ms.push(4);//добавление в очередь
        System.out.println(ms.print());//вывод на экран
        System.out.println(ms.pop());//извлечение из очереди
        System.out.println(ms.print());//вывод на экран
        System.out.println(ms.pop());//извлечение из очереди
        System.out.println(ms.print());//вывод на экран
    }
}

class MyQueue {
    private int[] storage = new int[100];
    private int count = 0;
    private int start = 0;

    void push(int item) {
        storage[count++] = item;
    }

    int pop() {
        int item = start;
        start++;
        return storage[item];
    }

    String print() {
        String res = "";
        for (int i = start; i < count; i++) {
            res += storage[i] + " ";
        }
        return res;
    }
}
