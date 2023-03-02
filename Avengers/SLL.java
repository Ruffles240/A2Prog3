package Avengers;

import java.util.Comparator;

/**
 * 
 * 
 *
 * @param <T>
 */
public class SLL<T extends Comparable<T>> {
	
	private Node<T> head, tail;
	
	private int size;
	
	/**
	 * 
	 */
	SLL(){
		head= null;
		tail=null;
		size=0;
	}
	
	/**
	 * 
	 * @param newItem
	 */
	public void add(T newItem){
		Node<T> newNode = new Node<T>(newItem);
		if(head!=null)
		{
			Node<T> pointer= head;
			while(pointer.getNext()!=null) {
				pointer= pointer.getNext();
		}
			pointer.setNext(newNode);
			size++;
			tail = newNode;
		}
		else {
			
			head = newNode;
			tail=newNode;
			size++;
		}
	}
	
	/**
	 * 
	 * @param newItem
	 * @param comparator
	 */
	public void addInOrder(T newItem, Comparator<T> comparator){	
		Node<T> newNode = new Node<T>(newItem);
		if (head==null) {	
			head = newNode;
			tail =head;
			size++;
		}
		else {
			Node<T> pointer = head;
			if(comparator.compare(pointer.getData(), newItem)>=0) {
				newNode.setNext(head);
				head=newNode;
				size++;
			}	
			else {
				
				while((pointer.getNext()!=null )&&(comparator.compare(pointer.getNext().getData(), newItem) <= 0 )){
					pointer = pointer.getNext();	
				}
				if(pointer.getNext()==null) {
					add(newItem);
					size++;	
				}
				else {
					newNode.setNext(pointer.getNext());
					pointer.setNext(newNode);
					size++;
				}
			}
		}
	}
	
	/**
	 * 
	 * @param newItem
	 */
	public void addInOrder(T newItem){
		
		Node<T> newNode = new Node<T>(newItem);
		if (head==null) {	
			head = newNode;
			tail =head;
			size++;
		}
		else {
			Node<T> pointer = head;
			if(newItem.compareTo(pointer.getData())<=0) {
				newNode.setNext(head);
				head=newNode;
				size++;
			}	
			else {
				
				while((pointer.getNext()!=null )&&(newItem.compareTo(pointer.getNext().getData()) >= 0 )){
					pointer = pointer.getNext();	
				}
				if(pointer.getNext()==null) {
					add(newItem);
					size++;	
				}
				else {
					newNode.setNext(pointer.getNext());
					pointer.setNext(newNode);
					size++;
				}
			}
		}
	}
	
	/**
	 * 
	 * @param sorter
	 * @return
	 */
	public SLL<T> sort(Comparator<T> sorter){
		SLL<T> sorted = new SLL<T>();
		Node<T> pointer = head;	
		while(pointer!=null) {

			sorted.addInOrder(pointer.getData(), sorter);
			pointer = pointer.getNext();		
		}		
		
		return sorted;
	}
	
	/**
	 * 
	 * @return
	 */
	public SLL<T> sort(){
		SLL<T> sorted = new SLL<T>();
		Node<T> pointer = head;	
		while(pointer!=null) {

			sorted.addInOrder(pointer.getData());
			pointer = pointer.getNext();		
		}		
		
		return sorted;
	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	public Node<T> search(String data) {
		
		Node<T> pointer = head;
		if(size==0) {
			return null;
		}
		while(pointer!=null) {
			if(pointer.getData().equals(data)) {
				return pointer;
			}
			else 
			{	
				pointer=pointer.getNext();
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public Node<T> getHead() {
		return head;
	}
	
	/**
	 * 
	 * @return
	 */
	public int size() {	
		return size;
	}
}
