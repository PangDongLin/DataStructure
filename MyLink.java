package day01;

import java.util.Stack;
/**
 * 单向链表
 * @author pangdonglin
 *
 */
class Link{
	Node head = new Node(0,"");
	
	
	public Node getHead() {
		return head;
	}


	//元素添加
	public void addNode(Node node) {
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
	}
	
	//查看所有元素
	public void showNode() {
		Node temp = head.next;
		if(head.next == null) {
			System.out.println("列表为空");
			return;
		}
		
		while(true) {
			if(temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
	
	//顺序添加
	public void addByOrder(Node node) {
		Node temp = head;
		boolean flag = false;
		while(true) {
			if(temp.next == null) {
				break;
			}
			
			if(temp.next.no > node.no) {
				break;
			}else if(temp.next.no == node.no) {
				flag = true;
			}
			
			temp = temp.next;
		}
		
		if(flag) {
			System.out.println("元素已存在");
		}else {
			node.next = temp.next;
			temp.next = node;
		}
		
	}
	
	//元素修改
	public void update(Node node) {
		Node temp = head;
		boolean flag = false;
		if(head.next == null) {
			System.out.println("链表为空");
		}
		while(true) {
			if(temp.next == null) {
				break;
			}
			
			if(temp.next.no == node.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		
		if(flag) {
			temp.next.data = node.data;
		}else {
			System.out.println("修改元素不存在");
		}
	}
	
	
	//元素删除
	public void del(int no) {
		Node temp = head;
		boolean flag = false;
		while(true) {
			if(temp.next == null) {
				break;
			}
			
			if(temp.next.no == no) {
				flag = true;
				break;
			}
			
			temp = temp.next;
		}
		if(flag) {
			temp.next = temp.next.next;
		}else {
			System.out.println("删除的元素不存在");
		}
	}
}

class Node{
	public int no;
	public String data;
	public Node next;
	
	public Node(int no,String data) {
		this.no = no;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", data=" + data + "]";
	}
	
	
}


public class MyLink {

	//获取单链表有效节点个数
	public static int getLength(Node head) {
		if(head.next == null) {
			return 0;
		}
		
		int length = 0;
		Node temp = head.next;
		while(temp != null) {
			length++;
			temp = temp.next;
		}
		
		return length;
	}
	
	//查找单链表的第k个节点
	public static Node findLastIndexNode(Node head,int index) {
		Node temp = head.next;
		int length = getLength(head);
		if(head.next == null) {
			System.out.println("空链表");
			return null;
		}
		
		if(index < 0 || index >length) {
			return null;
		}
		
		for(int i=1;i<=length-index;i++) {
			temp = temp.next;
		}
		return temp;
	}
	
	public static void reversetList(Node head) {
		//如果当前链表为空,或者只有一个节点,无需反转,直接返回
		if(head.next == null || head.next.next == null) {
			return;
		}
		
		//辅助指针
		Node cur = head.next;
		Node next = null; //指向节点的下一个节点
		Node reverseHead = new Node(0,"");
		
		while(cur.next != null) {
			next = cur.next;
			cur.next = reverseHead.next; //空
			reverseHead.next = cur; // 有 temp1 
			cur = next;
		}
		head.next = reverseHead.next;
	}
	
	//倒叙打印 ,递归实现
	public static void reversePrint0(Node head) {
		Node temp = head;
		if(temp.next == null) {
			return;
		}
		reversePrint0((temp = temp.next));
		System.out.println(temp);
		
	}
	
	//倒叙打印 , 使用栈结构
	public static void reversePrint(Node head) {
		if(head.next == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		Node cur = head.next;
		while(cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		
		while(stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
	public static void main(String[] args) {
	

	}
}
