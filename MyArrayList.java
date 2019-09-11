package cn.test.mycollection;

import java.util.Arrays;

/**
 * 自定义实现ArrayList。
 * @author dell
 *
 */

public class MyArrayList<E> {
	private Object[] elementData;
	private int size;
	private static final int DEDALT_CAPACITY=1;
	
	
	public MyArrayList() {
	   elementData=new Object[DEDALT_CAPACITY];
	}
	public MyArrayList(int capacity) {
		if(capacity<0) {
			throw new RuntimeException("容器的容量不能为负数");
		}else {
		elementData=new Object[capacity];
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		for(int i=0;i<size;i++) {
			sb.append(elementData[i]+",");
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	public void chackRange(int index) {
		if(index>=size||index<0) {
			throw new RuntimeException("索引不合法:index "+index);
		}
	}
	public void add(E element) {
		if(size==elementData.length) {
			if(this.newCapacity()) {
				elementData[size++]=element;
			}
		}else {
			elementData[size++]=element;
		}
		
	}
	public boolean newCapacity() {	
		int newlength=size*2;
		Object[] newArray=new Object[newlength];
		System.arraycopy(elementData, 0, newArray, 0, elementData.length);
		elementData=newArray;
		if(elementData.length==newlength) {
			return true;
		}
		return false;
	}
	public E get(int index) {
		this.chackRange(index);
		return (E)elementData[index];
	}
	public void set(int index,E element) {
		this.chackRange(index);
		elementData[index]=element;
	}
	public E remove(int index) {
		this.chackRange(index);
		E e=(E)elementData[index];
		this.delete(index);
		return e;
	}
	public void delete(int index) {
		this.chackRange(index);
		if(index==size-1) {
			size--;
			System.out.println("***");
			return;
		}
		System.arraycopy(elementData, index+1, elementData, index, elementData.length-index-1);
	    size--;
	}
	public void delete(E e) {
		for(int i=0;i<size;i++) {
			if(e.equals(elementData[i])) {
				this.delete(i);
				return;
			}
		}
		System.out.println("不存在");
	}
	public static void main(String[] args) {
		MyArrayList<String> ma=new MyArrayList<>();
		ma.add("a");
		ma.add("b");
		ma.add("c");
		ma.add("d");
		System.out.println(ma);
		System.out.println(ma.get(2));
		ma.set(2, "mm");
		System.out.println(ma);
		ma.delete(3);
		System.out.println(ma);
		

	}
	

}
