package com.qianxun.easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

输入: "()"
输出: true

输入: "()[]{}"
输出: true

输入: "([)]"
输出: false

输入: "{[]}"
输出: true
 * @author qianxun
 *
 */
public class Test_0020有效的括号 {

	public static void main(String[] args) {
		System.out.println(isValid("]]"));
	}
	
	
	/**
	 * 判断括号的有效性可以使用「栈」这一数据结构来解决。

我们对给定的字符串 ss 进行遍历，当我们遇到一个左括号时，我们会期望在后续的遍历中，有一个相同类型的右括号将其闭合。由于后遇到的左括号要先闭合，因此我们可以将这个左括号放入栈顶。

当我们遇到一个右括号时，我们需要将一个相同类型的左括号闭合。此时，我们可以取出栈顶的左括号并判断它们是否是相同类型的括号。如果不是相同的类型，或者栈中并没有左括号，那么字符串 ss 无效，返回 False。为了快速判断括号的类型，我们可以使用哈希映射（HashMap）存储每一种括号。哈希映射的键为右括号，值为相同类型的左括号。

在遍历结束后，如果栈中没有左括号，说明我们将字符串 ss 中的所有左括号闭合，返回 True，否则返回 False。

注意到有效字符串的长度一定为偶数，因此如果字符串的长度为奇数，我们可以直接返回 False，省去后续的遍历判断过程。

	 */
	
	public boolean isValidv2(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        @SuppressWarnings("serial")
		Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        
        //Java堆栈Stack类已经过时，Java官方推荐使用Deque替代Stack使用。Deque堆栈操作方法：push()、pop()、peek()
        //Deque是一个双端队列接口，继承自Queue接口，Deque的实现类是LinkedList、ArrayDeque、LinkedBlockingDeque，其中LinkedList是最常用的
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {//准备弹栈
            	//pop() 出栈操作，获取栈顶元素，获取后该元素就从栈中被删除了
            	//peek() 引用栈顶元素，而不做出栈操作
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {//压栈
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
	
	/**
	 * 模拟栈结构，
	 * 遇到 [ 压栈  ]
	 * 遇到 ( 压栈  )
	 * 遇到 { 压栈 }
	 * 其它情况就是出栈操作，栈中为空 或出栈 字符 和该字符不匹配(顺序不对)返回false
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[') stack.push(']');
            else if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
