public class LinkedStackOfInteger {
	
	private Node top;
	private int count;	
	
	private class Node{
		public Integer element;
		public Node next;
		
		public Node(Integer element){
			this.element = element;
			this.next = null;
		}
	}
	
	public LinkedStackOfInteger(){
		top = null;
		count = 0;
	}
	
	public LinkedStackOfInteger(Integer element){
		this.top = new Node(element);
		this.count = 1;
	}
	
	public void push(Integer element){
		Node n = new Node(element);
		if(count==0){
			top = n;
			count++;
		}
		else{		
			Node aux = top;
			top = n;
			top.next = aux;
			count++;
		}
	}
	
	public Integer pop(){
		if(count==0)
			throw new IndexOutOfBoundsException("Cannot pop, stack is empty.");
		Integer aux = top.element;
		top = top.next;
		count--;
		return aux;
	}
	
	public Integer top(){
		if(count==0)
			throw new IndexOutOfBoundsException("There's no top, stack is empty.");
		return top.element;
	}
	
	public int size(){
		return count;
	}
	
	public boolean isEmpty(){
		return count == 0;
	}
	
	public void clear(){
		top = null;
		count = 0;
	}
		
	//toString
	@Override
	public String toString() {
		String aux = "";
		Node n = top;
		for(int i=0; i<count; i++) {
			aux += (n.element + "\n");
			n = n.next;
		}
		return aux;
	}		
}