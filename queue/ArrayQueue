package queue;

/**
 * ArrayQueue[数组队列实现]
 *
 * 队列特点 :
 *      队列是一种常用的数据结构之一，队列特点是“先进先出”。队列有队头（front）和队尾（rear），
 *      数据从队尾进入队列，从队头出队列，队头（front）指向队列的第一个数据，队尾（rear）指向队列中的最后一个数据。
 *
 * 队列方法 :
 *      isFull -> 判断队列是否满了
 *      isEmpty-> 判断队列是否为空
 *      addQueue -> 入队
 *      getQueue -> 出队
 *      list -> 查看队列所有元素
 *      headQueue -> 查看队列头元素
 */

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        arr = new int[this.maxSize];
    }

    /**
     * 判断队列是否满了
     *
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int element) {
        if (isFull()) {
            System.out.println("队列元素已满");
            return;
        }
        arr[++rear] = element;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[++front];
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("队列为空");
        }
        for (int i = front + 1; i <= rear; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }

}

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue a = new ArrayQueue(5);
    }
}
