import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class LinkedQueue extends GameObject{
	Node head;
	Node tail;


	public void enqueue(Note i){
		Node bago= new Node(i);
		if(head==null){
			head=bago;
			tail=bago;
		} else{
			tail.next=bago;
			tail=bago;
		}
	}
	public void dequeue(){
		if (head!=null){
			head=head.next;
			if(head==null){
				tail=null;
			}
		}
	}

	public Note peek(){
		if(head!=null){
			Note result = head.data;
			return result;
		} else{
			return null;
		}
	}

	public void visualizeQueue(Graphics2D g){
		Node rover=head;
		while(rover!=null){
			rover.visualizeNode(g);
			rover=rover.next;
		}
		
	}
	
	public boolean isEmpty(){
		return head==null;
	}

	public void fall(){
		Node rover=head;
		while(rover!=null){
			rover.data.yplace+=1;
			if(rover.data.yplace>600){
				if (head!=null){
					head=head.next;
					if(head==null){
						tail=null;
					}
				}
			}
			rover=rover.next;
		}
	}
}