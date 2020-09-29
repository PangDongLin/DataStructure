package stack;

class ArrayStack {
	private int maxSize;// ջ�Ĵ�С
	private int[] stack;
	private int top = -1;// ջ��

	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}

	// �ж�ջ�Ƿ�����
	public boolean isFull() {
		return top == maxSize - 1;
	}

	// ջ��
	public boolean isEmpty() {
		return top == -1;
	}

	// ��ջ
	public void push(int value) {
		if (isFull()) {
			System.out.println("ջ��");
			return;
		}
		stack[++top] = value;
	}

	// ��ջ
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("ջ��");
		}
		return stack[top--];
	}

	// ����ջ
	public void list() {
		if (isEmpty()) {
			System.out.println("ջ��");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}
}

public class ArrayStackDemo {
	public static void main(String[] args) {
			
	}
}
