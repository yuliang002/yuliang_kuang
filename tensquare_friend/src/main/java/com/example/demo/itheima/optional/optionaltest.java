/**
 * ClassName:optionaltest
 * Author:机械革命
 * Date:2019/9/2517:07
 * Description:TODO
 */
package com.example.demo.itheima.optional;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Author: yuliang
 * @Date: 2019/9/25 17:07
 */
public class optionaltest {
	public static void main(String[] args) {
//		Stream<String> names = Stream.of("Lamurudu", "LlOkanbi", "Oduduwa");
//		Optional<String> longest  = names.filter(name -> name.startsWith("L")).findFirst();
//		longest.ifPresent(name -> {
//			String s = name.toUpperCase();
//			System.out.println("The longest name is "+ s);
//		});
//		User yuliang = new User.UserBuilder().build();
//		boolean b = new CheckObjectIsNullUtils().objCheckIsNull(yuliang);
//		System.out.println(b);
	}


	public static class CheckObjectIsNullUtils {

		/**
		 * 判断对象是否为空，且对象的所有属性都为空
		 * ps: boolean类型会有默认值false 判断结果不会为null 会影响判断结果
		 *     序列化的默认值也会影响判断结果
		 * @param object
		 * @return
		 */
		public  boolean objCheckIsNull(Object object){
			Class clazz = (Class)object.getClass(); // 得到类对象
			Field fields[] = clazz.getDeclaredFields(); // 得到所有属性
			boolean flag = true; //定义返回结果，默认为true
			for(Field field : fields){
				field.setAccessible(true);
				Object fieldValue = null;
				try {
					fieldValue = field.get(object); //得到属性值
					Type fieldType =field.getGenericType();//得到属性类型
					String fieldName = field.getName(); // 得到属性名
					System.out.println("属性类型："+fieldType+",属性名："+fieldName+",属性值："+fieldValue);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				if(fieldValue != null){  //只要有一个属性值不为null 就返回false 表示对象不为null
					flag = false;
				}
			}
			return flag;
		}

	}
}
