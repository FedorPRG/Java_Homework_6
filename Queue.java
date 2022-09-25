public class Queue {
    public static void main(String[] args) {
        MyQueue ms = new MyQueue();
        System.out.println(ms.print());
        ms.push(1);
        ms.push(2);
        System.out.println(ms.print());
        ms.push(3);
        ms.push(4);
        System.out.println(ms.print());
        System.out.println(ms.pop());
        System.out.println(ms.print());
        System.out.println(ms.pop());
        System.out.println(ms.print());
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
