//给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。 
//
// 要求返回这个链表的深拷贝。 
//
// 
//
// 示例： 
//
// 
//
// 输入：
//{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
//
//解释：
//节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
//节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
// 
//
// 
//
// 提示： 
//
// 
// 你必须返回给定头的拷贝作为对克隆列表的引用。 
// 
//

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node pHead) {
        cloneNodes(pHead);
        connectRandomNodes(pHead);
        return reConnectNodes(pHead);
    }
    private static void cloneNodes(Node pHead) {
        Node pNode = pHead;
        while (pNode != null) {
            Node pCloned = new Node(pNode.val);
            pCloned.next = pNode.next;
            pCloned.random = null;
            pNode.next = pCloned;
            pNode = pCloned.next;
        }
    }

    private static void connectRandomNodes(Node pHead) {
        Node pNode = pHead;
        while (pNode != null) {

            Node pCloned = pNode.next;
            if (pNode.random != null) {
                pCloned.random = pNode.random.next;
            }
            pNode = pCloned.next;

        }
    }

    private static Node reConnectNodes(Node pHead) {
        Node pNode = pHead;
        Node pCloned = null;
        Node cloneHead = null;

        if (pNode != null) {
            pCloned = cloneHead = pNode.next;
            pNode.next = pCloned.next;
            pNode = pCloned.next;
        }
        while (pNode != null) {
            pCloned.next = pNode.next;
            pCloned = pCloned.next;
            pNode.next = pCloned.next;
            pNode = pNode.next;
        }
        return cloneHead;
    }

}