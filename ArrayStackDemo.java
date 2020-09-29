package stack;

class ArrayStack {
	private int maxSize;// Õ»µÄ´óÐ¡
	private int[] stack;
	private int top = -1;// Õ»¶¥

	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}

	// ÅÐ¶ÏÕ»ÊÇ·ñÂúÁË
	public boolean isFull() {
		return top == maxSize - 1;
	}

	// Õ»¿Õ
	public boolean isEmpty() {
		return top == -1;
	}

	// ÈëÕ»
	public void push(int value) {
		if (isFull()) {
			System.out.println("Õ»Âú");
			return;
		}
		stack[++top] = value;
	}

	// ³öÕ»
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Õ»¿Õ");
		}
		return stack[top--];
	}

	// ±éÀúÕ»
	public void list() {
		if (isEmpty()) {
			System.out.println("Õ»¿Õ");
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
