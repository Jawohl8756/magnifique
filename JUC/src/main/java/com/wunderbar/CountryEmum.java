package com.wunderbar;

import lombok.Getter;

/**
 * 枚举在实际生产中的使用方式
 * <p>
 * 数据库连接中断，但是枚举不会中断
 * <p>
 * 枚举就是类似数据库MySQL ,Redis
 */
public enum CountryEmum {
    ONE(1, "齐国"),
    TWO(2, "魏国"),
    THREE(3, "韩国"),
    FOUR(4, "赵国"),
    FIVE(5, "楚国"),
    SIX(6, "燕国");

    @Getter
    private Integer retCode;
    @Getter
    private String retMsg;

    //构造器
    CountryEmum(Integer retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public static CountryEmum ForEach_CountryEnum(int index) {
        CountryEmum[] myArray = CountryEmum.values();
        for (CountryEmum element : myArray) {
            if (index == element.getRetCode()) {
                return element;

            }

        }
        return null;

    }
}
