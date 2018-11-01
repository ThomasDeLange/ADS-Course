package Queue;

public class MainQueue {

    public static void main(String[] args) {

        ArrayQueue<String> queue = new ArrayQueue<String>();

        queue.enqueue("Thomas1");
        queue.enqueue("Thomas2");
        queue.enqueue("Thomas3");
        queue.enqueue("Thomas4");
        queue.enqueue("Thomas5");
        queue.enqueue("Thomas6");
        queue.enqueue("Thomas7");
        queue.enqueue("Thomas1");
        queue.enqueue("Thomas2");
        queue.enqueue("Thomas3");
        queue.enqueue("Thomas4");
        queue.enqueue("Thomas5");
        queue.enqueue("Thomas6");
        queue.enqueue("Thomas7");
        queue.enqueue("Thomas1");
        queue.enqueue("Thomas2");
        queue.enqueue("Thomas3");
        queue.enqueue("Thomas4");
        queue.enqueue("Thomas5");
        queue.enqueue("Thomas6");
        queue.enqueue("Thomas7");

        System.out.println(queue.isEmpty());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println(queue.isEmpty());

        queue.enqueue("Thomas8");
        queue.enqueue("Thomas9");
        queue.enqueue("Thomas10");
        queue.enqueue("Thomas11");
        queue.enqueue("Thomas12");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());



    }
}
