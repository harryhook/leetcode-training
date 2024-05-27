单调栈核心算法

```java
for(;;){
    while(stack.isEmpty()&&stack.peek()<=nums[i]){
            stack.pop();
    }
```

遇到数组可循环问题， 可以通过建立双倍数组长度来解决
也可以通过求模来解决

![img.png](next-greater-ii.png)