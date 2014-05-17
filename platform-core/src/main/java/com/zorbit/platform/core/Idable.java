package com.zorbit.platform.core;

import java.io.Serializable;
/**
 * po对象的id接口
 * @param <T>
 * @since 2013年8月17日 上午11:32:12
 * @author Jamin Zou
 */
public interface Idable<T extends Serializable> extends Serializable {

	T getUid();
}
