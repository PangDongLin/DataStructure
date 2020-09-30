package queue;

/**
 * CircleArrayQueue(环形队列)
 *      ArrayQueue存在一个问题，假设当尾部插入元素满了，头部又删掉了一些元素，这种情况下，就误认为空间满了，造成了假溢出，
 *      实际上头部删除了元素留出了空间。这时候环形队列就解决了这样的一个问题，环形队列的front指针始终指向当前队列的最后位置；
 *      rear指针始终指向第一个元素的前一个位置为-1，存储元素的时候头部和尾部都可以相互移动，而不必造成假溢出现象，节省了内存空间。如下
 */
class CircleArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int element) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        arr[rear] = element;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;

    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        
    }
}
