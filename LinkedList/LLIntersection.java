public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //Base Case: If either list is null, then there is no intersection
        if(headA == null || headB == null)
            return null;
        
        //Find the length of both the lists
        //Save details of last node of both the lists
        ListNode lastNodeA = headA;
        ListNode lastNodeB = headB;
        
        int lengthA = 1;
        int lengthB = 1;
        
        ListNode pointerNodeA = headA;
        ListNode pointerNodeB = headB;
        
        while(lastNodeA.next!=null){
            lengthA++;
            lastNodeA = lastNodeA.next;
        }
        
        while(lastNodeB.next!=null){
            lengthB++;
            lastNodeB = lastNodeB.next;
        }
        
        //Different last nodes implies no intersectiom
        if(lastNodeA != lastNodeB)
            return null;
        
        //Move the pointer of the longer list based on the difference in length between the two lists
        if(lengthA < lengthB){
            int differenceCount = lengthB - lengthA;
            while(differenceCount > 0){
                pointerNodeB = pointerNodeB.next;
                differenceCount--;
            }
        }
        else{
            int differenceCount = lengthA - lengthB;
            while(differenceCount > 0){
                pointerNodeA = pointerNodeA.next;
                differenceCount--;
            }
        }
        
        //The first node where both pointers meet is the point of intersection
        while(pointerNodeA != null && pointerNodeB!=null){
            if(pointerNodeA==pointerNodeB)
                return pointerNodeA;
            pointerNodeA = pointerNodeA.next;
            pointerNodeB = pointerNodeB.next;
        }
        return null;
    }
