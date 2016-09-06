package com.sxb.exercises.chapter25.e01;

public abstract class MyAbstractList<E> implements MyList<E> {
	protected int size = 0;

	protected MyAbstractList() {
	}

	protected MyAbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			add(objects[i]);
		}
	}

	// methods
	public void add(E e) {
		add(size, e);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		} else
			return false;
	}

	public int size() {
		return size;
	}
	
	/** Adds the elements in otherList to this list.
	 * Returns true if this list changed as a result of the call
	 */
	public boolean addAll(MyList<E> otherList) {
		try {
			if (otherList.size() > 0) {
				for (int i = 0; i < otherList.size(); i++) {
					add(otherList.get(i));
				}
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/** Removes all the elements in otherList from this list
	 *  Return true if this list changed as a result of the call
	 */
	public boolean removeAll(MyList<E> otherList) {
		boolean flag = false;
		try {
			for (int i = 0; i < otherList.size(); i++) {
				if (remove(otherList.get(i)))
					flag = true;
			}
			return flag;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	/** Retains the elements in this list that are also in otherList
	 *  Return true if this list changed as a result of the call 
	 */
	public boolean retainAll(MyList<E> otherList) {
		boolean flag = false;
		try {
			for (int i = 0; i < otherList.size(); i++) {
				if (!otherList.contains(this.get(i))) {
					this.remove(get(i));
					flag = true;
				} else 
					i++;
			}
			return flag;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
}
