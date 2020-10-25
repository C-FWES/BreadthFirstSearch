package Queueue;

import java.util.ArrayList;
import java.util.List;

public class Queue<E> {
    private List<E> list = new ArrayList<>();

    public void lineup(E s) {
        list.add(s);
    }

    public E exit() {
        if (list.size() == 0) {
            return null;
        }
        E result = list.get(0);
        list.remove(0);
        return result;
    }

    public E peek() {
        if (list.size() == 0) {
            return null;
        }
        E result = list.get(0);
        return result;
    }


    public int getSize() {
        return list.size();
    }


    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.lineup("a");
        queue.lineup("b");
        queue.lineup("c");
        queue.lineup("d");


        System.out.println(queue.peek());
        System.out.println(queue.exit());
        System.out.println(queue.exit());
        queue.lineup("e");
        System.out.println(queue.exit());
        System.out.println(queue.exit());
        System.out.println(queue.exit());
        System.out.println(queue.exit());
        System.out.println(queue.exit());


        Queue<Integer> integer = new Queue<>();
        integer.lineup(1);
        integer.lineup(2);
        integer.lineup(3);

        System.out.println(integer.exit());
        System.out.println(integer.exit());
        System.out.println(integer.exit());
        System.out.println(integer.exit());

    }
}
