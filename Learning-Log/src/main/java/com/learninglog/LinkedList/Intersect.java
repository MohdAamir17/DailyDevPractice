package com.learninglog.LinkedList;

public class Intersect {
    private Node head;

   public Intersect (){
        this.head = null;
    }

    public static void main(String[] args) {
        Intersect listOne = new Intersect();
        listOne.addNode(4);
        listOne.addNode(4);
        listOne.addNode(4);
        listOne.addNode(4);
        listOne.addNode(4);

        Intersect listTwo = new Intersect();
        listTwo.addNode(4);
        listTwo.addNode(4);
        listTwo.addNode(4);

        int intersectPoint = intersectPoint(listOne.head, listTwo.head);
        System.out.println("Intersect Point : " + intersectPoint);

    }

     static int intersectPoint(Node head1, Node head2) {
         int lenOne = 0;
         int lenTwo = 0;

         Node tempOne = head1;
         Node tempTwo = head2;

         // Calculate the length of the first list
         while (tempOne != null) {
             lenOne++;
             tempOne = tempOne.next;
         }

         // Calculate the length of the second list
         while (tempTwo != null) {
             lenTwo++;
             tempTwo = tempTwo.next;
         }

         // Reset pointers to the heads of the lists
         tempOne = head1;
         tempTwo = head2;

         // Move the pointer of the longer list ahead by the length difference
         if (lenOne > lenTwo) {
             int diff = lenOne - lenTwo;
             while (diff-- > 0) {
                 tempOne = tempOne.next;
             }
         } else {
             int diff = lenTwo - lenOne;
             while (diff-- > 0) {
                 tempTwo = tempTwo.next;
             }
         }

         // Traverse both lists to find the intersection point
         while (tempOne != null && tempTwo != null) {
             if (tempOne == tempTwo) {
                 return tempOne.data; // Intersection point found
             }
             tempOne = tempOne.next;
             tempTwo = tempTwo.next;
         }

         return -1;
    }







































    public  Node addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }

        return head;
    }
}
