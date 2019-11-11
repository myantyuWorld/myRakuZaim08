package com.goldchain.www.common.util;

public class EnumUtil {
	/**
	 * ordinal から指定した Enum の要素に変換する汎用関数
	 */
	public static <E extends Enum<E>> E fromOrdinal(Class<E> enumClass, int ordinal) {
	    E[] enumArray = enumClass.getEnumConstants();
	    return enumArray[ordinal];
	}
}
