package com.amitpamecha.sorting;

import com.amitpamecha.positionallist.IPosition;
import com.amitpamecha.positionallist.IPositionalList;

public class CollectionUtils{
	
	/**
	 * This method will sort the positional list of Integers in ascending order.
	 * @param list
	 */
	public static void insertionSort(IPositionalList<Integer> list){
		IPosition<Integer> marker = list.first();
		while(marker!=list.last()){
			IPosition<Integer> pivot = list.after(marker);
			if(pivot.getElement()>marker.getElement()){ //pivot is already sorted
				marker=pivot;
			}else{
				IPosition<Integer> walk = marker;
				//move walk away from marker towards left until it reaches end or it reaches value less than pivot
				while(walk!=list.first() && list.before(walk).getElement()>pivot.getElement()){
					walk=list.before(walk);
				}
				list.remove(pivot);//remove pivot entry
				list.addBefore(walk, pivot.getElement());// reinsert pivot before walk
			}
			
		}
	}

}
