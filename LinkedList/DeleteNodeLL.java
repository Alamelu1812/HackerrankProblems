/*
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 */

public void deleteNode(ListNode node) {
    //If node is null or a tail node, cannot delete the node without having an access to head of linked list    
    if(node == null || node.next == null)
        return;
        
    //Copy the contents of next node
    //The current node will be garbage collected
    ListNode nextNode = node.next;
    node.val = nextNode.val;
    node.next = nextNode.next;
    }
