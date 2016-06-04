package com.legend.common.utils;

import java.util.Collection;

import org.springframework.beans.BeanUtils;

public class DataUtil {

		public static void BeanCopy(Object source,Object target){
			BeanUtils.copyProperties(source, target);
		}
		
		public static boolean isEmpty(String s){
			return s==null||s.length()==0;
		}
		
		public static boolean isEmpty(Collection c){
			return c==null||c.isEmpty();
		}
		
}
