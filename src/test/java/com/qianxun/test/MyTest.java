package com.qianxun.test;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author 千寻
 * @version 1.0
 * @create 2021-01-07 20:43
 */
public class MyTest {

    @Test
    public void test(){
        String ss = str("你好", (str) -> {
            return str+"11";
        });
        System.out.println(ss);

    }

    public String str(String str, Function<String,String> fun){
        return "哈哈" + fun.apply(str);
    }
}
