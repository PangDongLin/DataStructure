package stack;

class ArrayStack2{
	private int maxSize;//ջ�Ĵ�С
	private int[] stack;
	private int top = -1;//ջ��
	
	public ArrayStack2(int maxSize)
	{
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	
	//�ж�ջ�Ƿ�����
	public boolean isFull() {
		return top == maxSize-1;
	}
	
	//ջ��
	public boolean isEmpty() {
		return top == -1;
	}
	
	//����ջ����ֵ
	public int peek() {
		return stack[top];
	}
	
	//��ջ
	public void push(int value) {
		if(isFull()) {
			System.out.println("ջ��");
			return;
		}
		stack[++top] = value;
	}
	
	//��ջ
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("ջ��");
		}
		return stack[top--];
	}
	
	//����ջ
	public void list() {
		if(isEmpty()) {
			System.out.println("ջ��");
			return;
		}
		for(int i=top;i>=0;i--) {
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
		}
	}
	
	//��������������ȼ�,���ȼ��ɳ����д��Ա�ƶ�,���ȼ������ֱ�ʾ,���ȼ�Խ��
	public int priority(int oper) {
		if(oper == '*' || oper == '/') {
			return 1;
		}else if(oper == '+' || oper == '-') {
			return 0;
		}else {
			return -1;
		}
	}
	
	//�ж��ǲ���һ�������
	public boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/';
	}
	
	//���㷽��
	public int cal(int num1,int num2,int oper) {
		int res = 0;
		switch(oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		default:
			break;
		}
		return res;
	}
	
}

public class Calculator {
	public static void main(String[] args) {
		String expression = "3+2*6-1";
		//��������ջ
		ArrayStack2 numStack = new ArrayStack2(10);
		ArrayStack2 operStack = new ArrayStack2(10);
		//������Ҫ����ر���
		int index = 0; //����ɨ��
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';	//��ÿ��ɨ�赽��char���浽ch
		while(true) {
			//һ�εõ�expression��ÿһ���ַ�
			ch = expression.substring(index,index+1).charAt(0);
			//�ж�ch��ʲô,Ȼ������Ӧ����
			if(operStack.isOper(ch)) {//����������
				//�жϵ�ǰ����ջ�Ƿ�Ϊ��
				if(!operStack.isEmpty()) {
					//�������ջ�в�����,���бȽ�,�����ǰ�Ĳ����������ȼ�С�ڻ��ߵ���ջ�еĲ�����
					if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1, num2, oper);
						//�����еĽ������ջ
						numStack.push(res);
						//�ú󽫵�ǰ�Ĳ��������ջ
						operStack.push(ch);
					}else {
						operStack.push(ch);
					}
				}else {
					//���Ϊ��ֱ�������ջ..
					operStack.push(ch);//1 + 3
				}
			}else {//�������,��ֱ������ջ
				numStack.push(ch - 48);
			}
			//��index+1,���ж��Ƿ�ɨ�赽expression���
			index++;
			if(index >= expression.length()) {
				break;
			}
		}
		while(true) {
			//�������ջΪ��,�����㵽���Ľ��,��ջ��ֻ��һ������[���]
			if(operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num1, num2, oper);
			numStack.push(res);
			
		}
		System.out.printf("���ʽ%s = %d",expression,numStack.pop());
		
	}
	
	
}
