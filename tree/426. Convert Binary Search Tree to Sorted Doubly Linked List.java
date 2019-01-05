/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node prev = null;
    public Node treeToDoublyList(Node root) {
         if (root == null) return root;
        Node dummy = new Node(0, null, root);
        prev = dummy;
        helper(root);
        // make it circle
        dummy.right.left = prev;
        prev.right = dummy.right;
        return dummy.right;
    }
    
    private void helper(Node root) {
        if (root == null) return;
        helper(root.left);
        prev.right = root;
        root.left = prev;
        prev = root;
        helper(root.right);
    }
}
