public class LinkedList{

    public static class Node{
        int data;
        Node next;

        public Node(int data){

            this.data = data;
            this.next= null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst (int data){
        
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head= tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast (int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next= newNode;
        tail = newNode;
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    
    public void add ( int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i =0;

        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next= newNode;
    }

    public int removeFirst(){
        if(size==0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;

            size=0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size ==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;

        }else if(size==1){
            int val = head.data;
            head = tail = null;

            size = 0;
            return val;
        }
        Node prev = head ;
        for (int i =0; i<size-2;i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key){
        Node temp = head;
        int i = 0;

        while(temp !=null){
            if(temp.data== key){
                return i;

            }
            temp = temp.next;
            i++;
        }

        return -1;

    }

    public boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }

           

        }
         return false;
    }

    public static void removeCycle(){
        // detect cyccle

        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        
        while (fast != null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                cycle = true;
                break;
            }
        }

        if(cycle == false){
            return;
        }

        slow = head;
        Node prev = null;
        while(slow!=fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
            
        }

        prev.next = null;
    }
    public static void main(String args[]){

        LinkedList ll = new LinkedList();
        // // ll.head= new Node(1);
        // // ll.head.next= new  Node (2); 
        
        // ll.addFirst(2);
    
        // ll.addFirst(1);
      
        // ll.addLast(3);
     
        // ll.addLast(4);
        // ll.add(2,7);
        // ll.print();
        // // System.out.println(ll.size);
        // ll.removeFirst();
        // ll.removeLast();
        // ll.print();

        // System.out.println(ll.itrSearch(3));
        // System.out.println(ll.itrSearch(50));

        head = new Node(1);
        Node temp = new Node(2);
        // head.next = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        System.out.println(ll.isCycle());
        removeCycle();
        System.out.println(ll.isCycle());


    }
}