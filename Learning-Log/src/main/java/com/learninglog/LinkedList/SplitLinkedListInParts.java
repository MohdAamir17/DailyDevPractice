package com.learninglog.LinkedList;

public class SplitLinkedListInParts {
    private ListNode head;

    // Constructor for an empty list
    public SplitLinkedListInParts() {
        this.head = null;
    }

    public static void main(String[] args) {
        SplitLinkedListInParts listInParts = new SplitLinkedListInParts();
        listInParts.addNodeInLinkedList(1);
        listInParts.addNodeInLinkedList(2);
        listInParts.addNodeInLinkedList(3);
        System.out.println("Hello");

        int k = 5;
        ListNode[] listNodes = splitListToParts(listInParts.head, k);

        System.out.println("Hello");
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] listNodes = new ListNode[k];
        int count = 0;
        ListNode dummy = head;

        // Step 1: Count total nodes in the list
        while (dummy != null) {
            count++;
            dummy = dummy.next;
        }

        // Step 2: Determine average size and number of extra nodes
        int avg = count / k;
        int extra = count % k;
        dummy = head;

        // Step 3: Split the list into parts
        for (int i = 0 ; i < k ; i++) {
            if (dummy == null) {
                listNodes[i] = null; // If the list has fewer elements than k, fill remaining parts with null
                continue;
            }

            ListNode curHead = dummy; // Start of current part
            ListNode prev = null;
            int len = 0;

            // Step 4: Traverse avg nodes for each part
            while (dummy != null && len < avg) {
                prev = dummy;
                dummy = dummy.next;
                len++;
            }

            // Step 5: Add one more node if extra nodes are still available
            if (extra > 0) {
                prev = dummy; // Ensure prev is not null before setting prev.next to null
                dummy = dummy.next;
                extra--;
            }

            // Step 6: End current part
            if (prev != null) {
                prev.next = null; // Cut the current list part from the remaining nodes
            }

            listNodes[i] = curHead; // Add the current part to result
        }

        return listNodes;
    }

    public ListNode addNodeInLinkedList(int data) {
        ListNode listNode = new ListNode(data);
        if (head == null) {
            head = listNode;
        } else {
            ListNode currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = listNode;
        }
        return head;
    }
}
