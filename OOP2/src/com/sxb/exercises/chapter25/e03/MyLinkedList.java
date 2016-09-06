package com.sxb.exercises.chapter25.e03;

import com.sxb.exercises.chapter25.e01.MyAbstractList;

public class MyLinkedList<E> extends MyAbstractList<E> {
    private Node<E> head, tail;

    /** Create a default list */
    public MyLinkedList() {
    }

    /** Create a list from an array of objects */
    public MyLinkedList(E[] objects) {
      super(objects);
    }

    /** Return the head element in the list */
    public E getFirst() {
      if (size == 0) {
        return null;
      }
      else {
        return head.element;
      }
    }

    /** Return the last element in the list */
    public Object getLast() {
      if (size == 0) {
        return null;
      }
      else {
        return tail.element;
      }
    }

    /** Add an element to the beginning of the list */
    public void addFirst(E o) {
      Node<E> newNode = new Node<E>(o);
      newNode.next = head;
      head.previous = newNode;
      head = newNode;
      size++;

      if (tail == null) {
        tail = head;
      }
    }

    /** Add an element to the end of the list */
    public void addLast(E o) {
      if (tail == null) {
        head = tail = new Node<E>(o);
      }
      else {
        tail.next = new Node<E>(o);
        (tail.next).previous = tail;
        tail = tail.next;
      }

      size++;
    }

    /** Add a new element o at the specified index in this list
     * The index of the head element is 0 */
    
    // 利用双向列表简化 add() 方法
    public void add(int index, E element) {
        if (index == 0) {
          addFirst(element);
        }
        else if (index >= size) {
          addLast(element);
        }
        else {
          Node<E> current = head;
          for (int i = 1; i < index; i++) {
            current = current.next;
          }
          Node<E> temp = current.next;
          current.next = new Node<E>(element);
          (current.next).previous = current;
          temp.previous= current.next;
          size++;
        }
      }

    /** Remove the head node and
     *  return the object that is contained in the removed node. */
    public E removeFirst() {
      if (size == 0) {
        return null;
      }
      else {
        Node<E> temp = head;
        head = head.next;
        head.previous = null;
        size--;
        // 如果head为空则为空链表
        if (head == null) {
          tail = null;
        }
        return temp.element;
      }
    }

    /** Remove the last node and
     * return the object that is contained in the removed node. */
    public E removeLast() {
      if (size == 0) {
        return null;
      }
      else if (size == 1) {
        Node<E> temp = head;
        head = tail = null;
        size = 0;
        return temp.element;
      }
      else {
        /*Node<E> current = head;

        for (int i = 0; i < size - 2; i++) {
          current = current.next;
        }*/
        Node<E> temp = tail;
        (temp.previous).next = null;
        tail = temp.previous;
        size--;
        return temp.element;
      }
    }

    /** Remove the element at the specified position in this list.
     *  Return the element that was removed from the list. */
    // 利用双向链表简化remove() 方法
    public E remove(int index) {
      if (index < 0 || index >= size) {
        return null;
      }
      else if (index == 0) {
        return removeFirst();
      }
      else if (index == size - 1) {
        return removeLast();
      }
      else {
        Node<E> previous = head;

        for (int i = 1; i < index; i++) {
          previous = previous.next;
        }

        Node<E> current = previous.next;
        previous.next = current.next;
        (current.next).previous = current;
        size--;
        return current.element;
      }
    }

    /** Override toString() to return elements in the list */
    public String toString() {
      StringBuffer result = new StringBuffer("[");

      Node<E> current = head;
      for (int i = 0; i < size; i++) {
        result.append(current.element);
        current = current.next;
        if (current != null) {
          result.append(", "); // Separate two elements with a comma
        }
        else {
          result.append("]"); // Insert the closing ] in the string
        }
      }

      return result.toString();
    }

    /** Clear the list */
    public void clear() {
      head = tail = null;
    }

    /** Return true if this list contains the element o */
    public boolean contains(E o) {
    	Node<E> current = head;
		for(int i=0; i<size; i++) {
			if(current.element.equals(o)){
				return true;
			}else{}
		}
		return false;
    }

    /** Return the element from this list at the specified index */
    public E get(int index) {
    	Node<E> current = head;
		if(size == 0) {
			return null;
		}
		for(int i=1; i<index; i++) {
			current = current.next;
		}
		
		return current.element;
    }

    /** Return the index of the head matching element in this list.
     *  Return -1 if no match. */
    public int indexOf(E o) {
    	Node<E> current = head;
		if(size == 0) {
			return -1;
		}else {
			for(int i=0; i<size; i++) {
				if(current.element.equals(o)){
					return i;
				}else{}
			}
		}
		return -1;
    }

    /** Return the index of the last matching element in this list
     *  Return -1 if no match. */
    public int lastIndexOf(E o) {
    	Node<E> current = head;
		int index = -1;
		if(size == 0) {
			return index;
		}else {
			for(int i=0; i<size; i++) {
				if(current.element.equals(o)){
					index = i;
				}else{}
			}
		}
		return index;
    }

    /** Replace the element at the specified position in this list
     *  with the specified element. */
    public E set(int index, E o) {
    	Node<E> current = head;
		E temp = null;
		if(index<0 || index>size) {
			return temp;
		}else {
			for(int i=0; i<index; i++) {
				current = current.next;
			}
			temp = current.element;
			current.element = o;
		}
		return temp; 
    }

    public static class Node<E> {
    	// 修改为双向
      E element;
      Node<E> previous;
      Node<E> next;

      public Node(E o) {
        this.element = o;
      }
    }
  }