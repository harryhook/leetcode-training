#Given a string, find the length of the longest substring without repeating characters.

> Input: "abcabcbb"
  Output: 3 
  Explanation: The answer is "abc", with the length of 3. 
  
> Input: "pwwkew"
  Output: 3
  Explanation: The answer is "wke", with the length of 3. 
               Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
               
               
## 思路1， 循环遍历， 每次找出最长的不包含重复字符的子串
```java
public int lengthOfLongestSubstring(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isUniqueStr(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    private boolean isUniqueStr(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }
``` 
然而这种做法在leetcode上是超时的
jieyu
##思路2， 利用set存储字符， 判断当前set是否含有当前需要存储的字符
若没有， set.add(),
若有， 则删除重复元素，待下次再插入当前判断的元素
```java
public int lengthOfLongestSubstring(String s) {
        int res = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length()) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i++));
                res = Math.max(res, set.size());
            } else {
                set.remove(j++);
            }
        }
        return res;
    }
```