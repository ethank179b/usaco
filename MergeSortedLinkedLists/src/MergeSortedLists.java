class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to serve as the start of the merged list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Traverse both lists while neither is empty
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Append any remaining nodes from either list
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Return the merged list, starting from the node after dummy
        return dummy.next;
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        if(current != null)
            System.out.print(current.val);
        while (current.next != null) {
            current = current.next;
            System.out.print( " -> " + current.val);

        }
    }
    public static void main(String[] args) {
        // Example test case
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        MergeSortedLists solution = new MergeSortedLists();
        ListNode mergedList = solution.mergeTwoLists(list1, list2);

        // Print the merged list
        printList(mergedList);
    }
}