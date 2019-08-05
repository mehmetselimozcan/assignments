package org.second;
import java.lang.Class;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainClass {
	List<Bean> beans = new ArrayList<Bean>();

	public void method() {
		Bean bean = new Bean();
		Kebab kebab = new Kebab();
		Class<?> aClass0 = kebab.getClass();
		
		Pizza pizza = new Pizza();
		Class<?> aClass2 = pizza.getClass();
		
		Sushi sushi = new Sushi();
		Class<?> aClass3 = sushi.getClass();
		
		Class<?> classArray[] = {aClass0,aClass2,aClass3};
		
	
		for(Class<?> aClass : classArray) {
			Annotation annotation = aClass.getAnnotation(Food.class);
			
			if(annotation instanceof Food){	    
				bean.setPrice(((Food) annotation).price());
				bean.setName(aClass.getName());	    
			}
			
			Method methods[] = aClass.getMethods();
			int time = 0;
			for(Method method : methods) {
				Annotation methodAnnotation = method.getAnnotation(Time.class);
				if(methodAnnotation instanceof Time){
					time+= ((Time) methodAnnotation).takes();		    	    
				}
				
			}
			bean.setTime(time);
			beans.add(bean);
			
			System.out.println(beans.get(0).getName() + " " + beans.get(0).getPrice() + " " +beans.get(0).getTime());
		}

	}
	public static void main(String args[]) {
		MainClass mainClass = new MainClass();
		mainClass.method();
	}
	
	
}
