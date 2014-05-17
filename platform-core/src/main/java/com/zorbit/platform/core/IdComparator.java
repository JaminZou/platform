package com.zorbit.platform.core;

import java.util.Comparator;
/**
 * id比较器，
 * @param <T>
 * @since 2013年8月17日 上午11:33:26
 * @author Jamin Zou
 */
public class IdComparator<T extends Idable<String> & Orderable> implements Comparator<T> {


	public int compare(T arg0, T arg1) {
		if(arg0.getNordernum()==arg1.getNordernum()){
			return arg0.getUid().compareTo(arg1.getUid());
		}
		return arg0.getNordernum()<arg1.getNordernum()?-1:1;
	}

}
