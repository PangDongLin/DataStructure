package day01;
/**
 * ˫������
 * @author pangdonglin
 *
 */
class Node2{
	public int no;
	public String data;
	public Node2 next; 
	public Node2 pre;//ָ��ǰһ���ڵ�
	
	public Node2(int no,String data) {
		this.no = no;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", data=" + data + "]";
	}
	
	
}

class DoubleLinkedList{
	private Node2 head = new Node2(0,"");
	
	//����ͷ�ڵ�
	public Node2 getHead() {
		return head;
	}
	
	//�ڵ����
	public void addNode(Node2 node) {
		Node2 temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		//�γ�һ��˫������
		temp.next = node;
		node.pre = temp;
	}
	
	//Ԫ���޸� �͵�������һ��
	public void update(Node2 node) {
		Node2 temp = head;
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
	
	
	//�ڵ�ɾ��
	public void del(int no) {
		Node2 temp = head.next;
		boolean flag = false;
		if(head.next == null) {
			System.out.println("����Ϊ��,����ɾ��!");
			return;
		}
		while(true) {
			if(temp == null) {
				break;
			}
			
			if(temp.no == no) {
				flag = true;
				break;
			}
			
			temp = temp.next;
		}
		if(flag) {
			temp.pre.next = temp.next;
			//��������һ���ڵ�,�Ͳ���Ҫִ��������仰��,������ֿ�ָ��
			if(temp.next != null) {
				temp.next.pre = temp.pre;
			}
			
		}else {
			System.out.println("ɾ����Ԫ�ز�����");
		}
	}
	
	//����˫������
	public void list() {
		Node2 temp = head.next;
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
}
public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		Node2 node1 = new Node2(2,"����");
		Node2 node2 = new Node2(3,"����");
		Node2 node3 = new Node2(4,"������");
		
		Node2 node4 = new Node2(4,"����");
		DoubleLinkedList d = new DoubleLinkedList();
		d.addNode(node1);
		d.addNode(node2);
		d.addNode(node3);
		
		d.list();
		System.out.println("------------------");
		d.del(3);
		d.list();
		
		
		
	}

}
