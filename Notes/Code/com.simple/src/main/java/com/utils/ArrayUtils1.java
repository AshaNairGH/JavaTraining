package com.utils;

//******SINGLETON = can create one and only one object******

/*
1. Make constructor private
2. Create a static method for object creation
3. In above method create object only if not already created
4. use static member to find object already created
*/

public class ArrayUtils1 {
//private int array[] = {11,34,25,245,165,56,34,110};
	private int array[];
	private static boolean object_created = false;
	private static ArrayUtils1 m_obj[] = new ArrayUtils1[3];
	private static int curr_index=0;
	
//constructor
private ArrayUtils1(int array[]) {
	this.array = array;
}

public static ArrayUtils1 getInstance(int array[]) {
	//ArrayUtils1 obj = m_obj;
	//if(object_created ==false) {
		//obj = new ArrayUtils1(array);
	//	object_created = true;
	//	m_obj = obj;
	if(m_obj ==null) {
		m_obj = new ArrayUtils1(array);
	}
	
//	return obj;
	return m_obj;
}

public int min() {
	int min_val = array[0];
	for(int i = 0;i<array.length;i++) {
		if(array[i]<min_val) {
			min_val = array[i];
		}
	}
	return min_val;
}
}
