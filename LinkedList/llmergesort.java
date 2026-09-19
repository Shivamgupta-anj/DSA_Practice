public class llmergesort {

    public LinkedList.Node getMid(LinkedList.Node head) {
        LinkedList.Node slow = head;
        LinkedList.Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private LinkedList.Node merge(LinkedList.Node head1, LinkedList.Node head2) {

        LinkedList.Node mergedLL = new LinkedList.Node(-1);
        LinkedList.Node temp = mergedLL;

        while (head1 != null && head2 != null) {

            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;

            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public LinkedList.Node mergeSort(LinkedList.Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        LinkedList.Node mid = getMid(head);

        LinkedList.Node rightHead = mid.next;
        mid.next = null;

        LinkedList.Node newLeft = mergeSort(head);
        LinkedList.Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);
    }

    public static void main(String args[]) {

        LinkedList ll = new LinkedList();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        System.out.println("Before sorting");
        ll.print();

        llmergesort obj = new llmergesort();

        ll.head = obj.mergeSort(ll.head);

        System.out.println("After sorting");
        ll.print();
    }
}