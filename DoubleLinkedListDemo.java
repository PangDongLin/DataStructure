package day01;
/**
 * 双向链表
 * @author pangdonglin
 *
 */
class Node2{
	public int no;
	public String data;
	public Node2 next; 
	public Node2 pre;//指向前一个节点
	
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
	
	//返回头节点
	public Node2 getHead() {
		return head;
	}
	
	//节点添加
	public void addNode(Node2 node) {
		Node2 temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		//形成一个双向链表
		temp.next = node;
		node.pre = temp;
	}
	
	//元素修改 和单向链表一样
	public void update(Node2 node) {
		Node2 temp = head;
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
	
	
	//节点删除
	public void del(int no) {
		Node2 temp = head.next;
		boolean flag = false;
		if(head.next == null) {
			System.out.println("链表为空,不能删除!");
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
			//如果是最后一个节点,就不需要执行下面这句话了,否则出现空指针
			if(temp.next != null) {
				temp.next.pre = temp.pre;
			}
			
		}else {
			System.out.println("删除的元素不存在");
		}
	}
	
	//遍历双向链表
	public void list() {
		Node2 temp = head.next;
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
}
public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		Node2 node1 = new Node2(2,"张三");
		Node2 node2 = new Node2(3,"李四");
		Node2 node3 = new Node2(4,"张王五");
		
		Node2 node4 = new Node2(4,"张五");
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
