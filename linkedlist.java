public class linkedlist {
    
    class Node{
        int data;
        Node next;

        public Node(int data ){
            this.data = data;
            this.next = null;
        }
    }
    public int length = 0;
    public static Node head;
    public  Node tail;

    public void addStart(int data){
        length++;
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addEnd(int data){
        length++;
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addIndex(int i, int data){
        length++;
        Node newNode = new Node(data);
        Node temp = head;
        int index = 0;
        while(index < i-1){
            temp = temp.next;
            index++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void print(){
        Node temp = head;
        if(head ==  null){
            System.out.println("linked list is empty.");
            return;
        }
        while(temp!= null){
            System.out.print(temp.data + " ->");
            temp = temp.next;
        }
        System.out.println("null"  + "      lenght = "+length);
    }

    public void removeStart(){
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.println("removed :"+ head.data);
        head = head.next;
        length--;
    }

    public void removeEnd(){
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) {
            System.out.println("Removed: " + tail.data);
            head = tail = null;
            length--;
            return;
        }
        System.out.println("removed : " + tail.data);
        Node temp = head;
        while(temp.next!= tail){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        length--;
    }

    public void iterativeSearch(int target){
        int index = 0;
        Node temp = head;
        while(temp!= null){
            if(temp.data==target){
                System.out.println("element found at index: "+ index);
                return;
            }
            temp= temp.next;
            index++;
        }
        System.out.println("element not found in linked list.");
    }

    public void recursiveSearch(int target,Node start,int index){
        if(start.data == target){
            System.out.println("element found at index : "+ index);
            return;
        }if(start.next==null){
            System.out.println("element not found in linked list ");
            return;
        }
        recursiveSearch(target, start.next, index+1);
    }

    public void reverse(){
        if (head == null || head.next == null) {
            return;
        }
        Node prev = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // After the loop, prev will be the new head
        Node temp = head;
        head = tail;
        tail = temp;
    }

    public void removeNth(int index){
        Node prev=head;
        Node curr = head;
        int i= 0;
        while(i<index){
            if(curr==null){
                System.out.println("index entered is out of bound");
            }
            prev=curr;
            curr=curr.next;
            i++;
        }
        prev.next= curr.next;
        length--;
    }
    public static void main(String[] args) {
        linkedlist ll = new linkedlist();
        ll.addStart(1);
        ll.addStart(3);
        ll.addEnd(9);
        ll.addEnd(7);
        ll.addIndex(2, 5);
        ll.print();
        // ll.removeStart();
        // ll.removeEnd();
        // ll.print();
        ll.iterativeSearch(5);
        ll.recursiveSearch(7, head, 0);
        ll.reverse();
        ll.print();
        ll.removeNth(2);
        ll.print();
    }
}
