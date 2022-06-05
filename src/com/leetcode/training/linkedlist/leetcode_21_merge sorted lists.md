Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

> Input: 1->2->4, 1->3->4

> Output: 1->1->2->3->4->4

##思路：
构造一个虚拟头结点，依次比较链表的节点值的大小， 注意边界条件的处理