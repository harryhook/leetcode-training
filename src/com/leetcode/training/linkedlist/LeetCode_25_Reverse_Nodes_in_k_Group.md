# Leetcode 25. Reverse Nodes in k-Group
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

## Example:
> Given this linked list: 1->2->3->4->5

> For k = 2, you should return: 2->1->4->3->5

> For k = 3, you should return: 3->2->1->4->5

## 思路： 
> a. 将k个结点进行翻转

> b. 将翻转后的k个结点与剩余的节点相连，pre.next != tail时继续执行a



关键点在于翻转的时候要维护翻转的节点与剩余节点的连接

demo: 
> k=3, 1->2->3->4->5
          
    pre.next: 1
    
    tail: 3

> 第一次反转时：
  
    temp: 1
  
    tail: 3

    pre->2->3->1->4->5

> 第二次反转时：

    temp: 2

    tail: 3

    pre->3->2->1->4->5

