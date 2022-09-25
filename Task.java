import java.util.Scanner;

public class Task {

    static void print_array(int[] arr) {
        System.out.println("Визуализация двоичного дерева");
        System.out.printf("%17d", arr[0]);
        System.out.println();
        String str = "";
        for (int i = 1; i < 3; i++) {
            str = str + String.format("%10d     ", arr[i]);
        }
        System.out.println(str);
        str = "";
        for (int i = 3; i < 7; i++) {

            str = str + String.format("%6d  ", arr[i]);
        }
        System.out.println(str);
        str = "";
        for (int i = 7; i < 15; i++) {

            str = str + String.format("%4d", arr[i]);
        }
        System.out.println(str);
    }

    static int[] input() {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Введите 15 чисел через пробел:");
            String[] str = input.nextLine().split(" ");
            if (str.length > 15 || str.length < 15) {
                System.out.println("Вы ввели не верное количество чисел");
            } else {
                int[] array = new int[str.length];
                input.close();
                for (int i = 0; i < array.length; i++) {
                    array[i] = Integer.parseInt(str[i]);
                }
                return array;
            }
        }
    }

    static void direct_bypass(Node n) {
        if (n != null) {
            System.out.printf("%d ",  n.value);
            if (n.left != null) {
                direct_bypass(n.left);
            }
            if (n.right != null) {
                direct_bypass(n.right);
            }
        }
    }
    static void centered_bypass(Node n) {
        if (n != null) {
            if (n.left != null) {
                centered_bypass(n.left);
            }
            System.out.printf("%d ", n.value);
            
            if (n.right != null) {
                centered_bypass(n.right);
            }
        }
    }
    static void reverse_bypass(Node n) {
        if (n != null) {            
            if (n.left != null) {
                reverse_bypass(n.left);
            }
            if (n.right != null) {
                reverse_bypass(n.right);
            }
            System.out.printf("%d ", n.value);
        }
    }

    static void print_bracket(Node n, String space) {
        if (n != null) {
            System.out.print(space + n.value);
            if (n.left != null || n.right != null) {
                System.out.print("(");
                print_bracket(n.left, space);
                System.out.print(",");
                print_bracket(n.right, space);
                System.out.print(")");
            }
        } else {
            System.out.print("null");
        }
    }


    public static void main(String[] args) {
        var array = input();
        print_array(array);

        Node root = new Node(array[0]);

        Node l1 = new Node(array[1]);
        Node l1l2 = new Node(array[3]);
        Node l1r2 = new Node(array[4]);
        Node l1l2l3 = new Node(array[7]);
        Node l1l2r3 = new Node(array[8]);
        Node l1r2l3 = new Node(array[9]);
        Node l1r2r3 = new Node(array[10]);

        Node r1 = new Node(array[2]);
        Node r1l2 = new Node(array[5]);
        Node r1r2 = new Node(array[6]);
        Node r1l2l3 = new Node(array[11]);
        Node r1l2r3 = new Node(array[12]);
        Node r1r2l3 = new Node(array[13]);
        Node r1r2r3 = new Node(array[14]);

        root.left = l1;
        root.right = r1;
        l1.left = l1l2;
        l1.right = l1r2;
        l1l2.left = l1l2l3;
        l1l2.right = l1l2r3;
        l1r2.left = l1r2l3;
        l1r2.right = l1r2r3;

        r1.left = r1l2;
        r1.right = r1r2;
        r1l2.left = r1l2l3;
        r1l2.right = r1l2r3;
        r1r2.left = r1r2l3;
        r1r2.right = r1r2r3;
        System.out.println("Прямой обход");
        direct_bypass(root);
        System.out.println();
        System.out.println("Центрированный обход");
        centered_bypass(root);
        System.out.println();
        System.out.println("Обратный обход");
        reverse_bypass(root);
        System.out.println();
        System.out.println("Скобочная запись");
        print_bracket(root,"");

    }
}

class Node {
    public Node(Integer v) {
        value = v;
    }

    Integer value;
    Node left;
    Node right;
}
