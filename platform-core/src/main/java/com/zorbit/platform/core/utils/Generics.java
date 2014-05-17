package com.zorbit.platform.core.utils;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * 泛型s.
 * 
 * @since 2013年8月17日 上午11:30:53
 * @author Jamin Zou
 */
public final class Generics {
	/**
	 * 获取第一个类型参数Class.
	 * 
	 * @param subclass
	 *            子类Class对象.
	 * @return 类型参数Class
	 */
	public static Class<?> getTypeParameterClass(Class<?> subclass) {
		return getTypeParameterClass(subclass, 0);
	}

	/**
	 * 获取类型参数Class.
	 * 
	 * @param subclass
	 *            子类Class对象.
	 * @param parameterIndex
	 *            参数位置, 0 为第一个.
	 * @return 指定位置类型参数Class
	 */
	public static Class<?> getTypeParameterClass(Class<?> subclass,
			int parameterIndex) {
		return getRawType(getSuperclassTypeParameter(subclass, parameterIndex));
	}

	private static Type getSuperclassTypeParameter(Class<?> subclass,
			int parameterIndex) {
		Type superclass = subclass.getGenericSuperclass();
		// try superclass
		if (superclass instanceof Class) {
			if (subclass.getGenericInterfaces().length > 0) {
				// try superinterface
				superclass = subclass.getGenericInterfaces()[0];
			}
		}
		if (superclass instanceof Class) {
			throw new RuntimeException("无法获取类型参数.");
		}

		ParameterizedType parameterized = (ParameterizedType) superclass;
		return parameterized.getActualTypeArguments()[parameterIndex];
	}

	private static Class<?> getRawType(Type type) {
		if (type instanceof Class<?>) {
			// type is a normal class.
			return (Class<?>) type;
		} else if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;

			Type rawType = parameterizedType.getRawType();
			return (Class<?>) rawType;

		} else if (type instanceof GenericArrayType) {
			return Object[].class;

		} else if (type instanceof TypeVariable) {
			return Object.class;
		} else {
			throw new IllegalArgumentException(
					"Expected a Class, ParameterizedType, or "
							+ "GenericArrayType, but <" + type
							+ "> is of type " + type.getClass().getName());
		}
	}

	private Generics() {
	}
}
