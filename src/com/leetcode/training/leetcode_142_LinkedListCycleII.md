Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

Note: Do not modify the linked list.

Example 1:

> Input: head = [3,2,0,-4], pos = 1
> Output: tail connects to node index 1
> Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:

> Input: head = [1,2], pos = 0
> Output: tail connects to node index 0
> Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:

> Input: head = [1], pos = -1
> Output: no cycle
> Explanation: There is no cycle in the linked list.


#思路

找到环形链表的入口
头节点到环的入口距离为a， slow到相遇的节点为b， slow走过的路径为a+b
fast指针走过的路径是slow的2倍，相遇时已经在环内走了K圈
a+b = n
a+b + K*L = 2n 推算出 a+b = K*L = n

所以继续让fast从头一步一步走，slow从相遇点继续一步一步走，slow与fast再次相遇时为环的入口节点