package com.leetcode.training;

import java.math.BigDecimal;
import java.math.BigInteger;

public class test {
    BigDecimal a = new BigDecimal("1.0");
    BigDecimal b = new BigDecimal("2.0");

    public void test() {
        BigInteger bi1 = new BigInteger("123456789") ;  // 声明BigInteger对象
        BigInteger bi2 = new BigInteger("987654321") ;  // 声明BigInteger对象
        System.out.println("加法操作：" + bi2.add(bi1)) ;    // 加法操作
    }
}
