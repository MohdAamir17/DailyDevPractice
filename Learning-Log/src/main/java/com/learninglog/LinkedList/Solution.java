package com.learninglog.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Pointer to the head of the list
    private ListNode head;

    // Constructor for an empty list
    public Solution() {
        this.head = null;
    }

    // Main method to test the linked list functionality
    public static void main(String[] args) {
        Solution linkedList = new Solution();
        // Adding elements to the list
        linkedList.addNodeAtEnd(1);
        linkedList.addNodeAtEnd(2);
        linkedList.addNodeAtEnd(3);
        linkedList.addNodeAtEnd(4);
        linkedList.addNodeAtEnd(5);
        // Array of integers to modify the list
        int[] nums = {1,2,3};
        // Modify the linked list using nums array
        linkedList.head = linkedList.modifiedList(nums, linkedList.head);
        // Display the modified list
        System.out.println("Modified Linked List:");

        // Display the modified list
        System.out.println("Modified Linked List:");
        linkedList.displayList();

    }

    public static ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> arrayElementToDelete = new HashSet<>();
        for(var num : nums){
            arrayElementToDelete.add(num);
        }

        ListNode demo = new ListNode();
        demo.next = head;
        ListNode curr = demo;
        ListNode prev = demo;
        while(curr != null){
            ListNode nextNode = curr.next;
            if(arrayElementToDelete.contains(curr.val)){
                prev.next = nextNode;
            }else{
                prev = curr;
            }
            curr = nextNode;
        }
        return demo.next;
    }


    // Method to add a node at the end of the list and return the updated linked list
    public ListNode addNodeAtEnd(int value) {
        ListNode newNode = new ListNode(value);
        // If the list is empty, set the new node as head
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            // Traverse to the last node
            while (current.next != null) {
                current = current.next;
            }
            // Set the new node as the next of the last node
            current.next = newNode;
        }
        // Return the head of the linked list
        return head;
    }

    // Method to display the linked list
    public void displayList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null"); // End of the list
    }
}
