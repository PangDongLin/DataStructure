package stack;

class ArrayStack2{
	private int maxSize;//栈的大小
	private int[] stack;
	private int top = -1;//栈顶
	
	public ArrayStack2(int maxSize)
	{
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	
	//判断栈是否满了
	public boolean isFull() {
		return top == maxSize-1;
	}
	
	//栈空
	public boolean isEmpty() {
		return top == -1;
	}
	
	//返回栈顶的值
	public int peek() {
		return stack[top];
	}
	
	//入栈
	public void push(int value) {
		if(isFull()) {
			System.out.println("栈满");
			return;
		}
		stack[++top] = value;
	}
	
	//出栈
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("栈空");
		}
		return stack[top--];
	}
	
	//遍历栈
	public void list() {
		if(isEmpty()) {
			System.out.println("栈空");
			return;
		}
		for(int i=top;i>=0;i--) {
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
		}
	}
	
	//返回运算符的优先级,优先级由程序编写人员制定,优先级用数字表示,优先级越高
	public int priority(int oper) {
		if(oper == '*' || oper == '/') {
			return 1;
		}else if(oper == '+' || oper == '-') {
			return 0;
		}else {
			return -1;
		}
	}
	
	//判断是不是一个运算符
	public boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/';
	}
	
	//计算方法
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
		//创建两个栈
		ArrayStack2 numStack = new ArrayStack2(10);
		ArrayStack2 operStack = new ArrayStack2(10);
		//定义需要的相关变量
		int index = 0; //用于扫描
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';	//将每次扫描到的char保存到ch
		while(true) {
			//一次得到expression的每一个字符
			ch = expression.substring(index,index+1).charAt(0);
			//判断ch是什么,然后做响应处理
			if(operStack.isOper(ch)) {//如果是运算符
				//判断当前符号栈是否为空
				if(!operStack.isEmpty()) {
					//如果符号栈有操作符,进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符
					if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1, num2, oper);
						//把运行的结果入数栈
						numStack.push(res);
						//让后将当前的操作入符号栈
						operStack.push(ch);
					}else {
						operStack.push(ch);
					}
				}else {
					//如果为空直接入符号栈..
					operStack.push(ch);//1 + 3
				}
			}else {//如果是数,则直接入数栈
				numStack.push(ch - 48);
			}
			//让index+1,并判断是否扫描到expression最后
			index++;
			if(index >= expression.length()) {
				break;
			}
		}
		while(true) {
			//如果符号栈为空,贼计算到最后的结果,数栈中只有一个数字[结果]
			if(operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num1, num2, oper);
			numStack.push(res);
			
		}
		System.out.printf("表达式%s = %d",expression,numStack.pop());
		
	}
	
	
}
