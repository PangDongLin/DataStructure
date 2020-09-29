package day01;

import java.util.Stack;
/**
 * ��������
 * @author pangdonglin
 *
 */
class Link{
	Node head = new Node(0,"");
	
	
	public Node getHead() {
		return head;
	}


	//Ԫ�����
	public void addNode(Node node) {
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
	}
	
	//�鿴����Ԫ��
	public void showNode() {
		Node temp = head.next;
		if(head.next == null) {
			System.out.println("�б�Ϊ��");
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
	
	//˳�����
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
			System.out.println("Ԫ���Ѵ���");
		}else {
			node.next = temp.next;
			temp.next = node;
		}
		
	}
	
	//Ԫ���޸�
	public void update(Node node) {
		Node temp = head;
		boolean flag = false;
		if(head.next == null) {
			System.out.println("����Ϊ��");
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
			System.out.println("�޸�Ԫ�ز�����");
		}
	}
	
	
	//Ԫ��ɾ��
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
			System.out.println("ɾ����Ԫ�ز�����");
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

	//��ȡ��������Ч�ڵ����
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
	
	//���ҵ�����ĵ�k���ڵ�
	public static Node findLastIndexNode(Node head,int index) {
		Node temp = head.next;
		int length = getLength(head);
		if(head.next == null) {
			System.out.println("������");
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
		//�����ǰ����Ϊ��,����ֻ��һ���ڵ�,���跴ת,ֱ�ӷ���
		if(head.next == null || head.next.next == null) {
			return;
		}
		
		//����ָ��
		Node cur = head.next;
		Node next = null; //ָ��ڵ����һ���ڵ�
		Node reverseHead = new Node(0,"");
		
		while(cur.next != null) {
			next = cur.next;
			cur.next = reverseHead.next; //��
			reverseHead.next = cur; // �� temp1 
			cur = next;
		}
		head.next = reverseHead.next;
	}
	
	//�����ӡ ,�ݹ�ʵ��
	public static void reversePrint0(Node head) {
		Node temp = head;
		if(temp.next == null) {
			return;
		}
		reversePrint0((temp = temp.next));
		System.out.println(temp);
		
	}
	
	//�����ӡ , ʹ��ջ�ṹ
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
