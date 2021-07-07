public class LinkedListDeque <T>{
    private int size;
    private Node sentinel;
    private class Node{
        public T item;
        public Node prev;
        public Node next;
        public Node(T i,Node p,Node n){
            this.item = i;
            this.prev = p;
            this.next =n;
        }
    }

    public LinkedListDeque(){
        sentinel = new Node(null,null,null);
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
        size=0;
    }

    /** 我在这里想岔了 我一直在思考 sentinel.prev不一定是这个next怎么办
     * 但其实这完全是杞人忧天，创建链表就只和创建的时候有关系。我就没有写创建多个数字的链表的构造器。
     * 我只会创建一个含一个数字的链表 它一定是这样。
     * @param x
     */
//    public LinkedListDeque(T x){
//        sentinel = new Node(null,null,null);
//        sentinel.next=new Node(x,sentinel,sentinel);
//        sentinel.prev= sentinel.next; //这里不能new 因为你要说明 它的上一个就是 sentinel.next。
//        size=1;
//    }

    public void addFirst(T item){
        sentinel.next.prev=new Node(item,sentinel,sentinel.next);
        sentinel.next = sentinel.next.prev;
        size+=1;
    }

    public void addLast(T item){
        sentinel.prev.next = new Node(item,sentinel.prev,sentinel);
        sentinel.prev=sentinel.prev.next;
        size+=1;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
    }
    public int size(){
        return size;
    }

    public void printDeque(){
        Node cur = sentinel;
        while(cur.next!=sentinel){
            System.out.print(cur.next.item+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    public T removeFirst(){
        if(size>0){
            T result =sentinel.next.item;
            sentinel.next.next.prev=sentinel;
            sentinel.next=sentinel.next.next;
            size-=1;
            return result;
        }else{
            return null;
        }

    }

    public T removeLast(){
        if(size>0){
            T result =sentinel.prev.item;
            sentinel.prev.prev.next=sentinel;
            sentinel.prev=sentinel.prev.prev;
            size-=1;
            return result;
        }else{
            return null;
        }
    }

    public T get(int index){
        if(index>size-1){
            return null;
        }
       Node p = sentinel.next;
       while (index!=0){
           p=p.next;
           index-=1;
       }
       return p.item;
    }
    public T getRecursive(int index){
        if(index>size-1){
            return null;
        }
        return  getI(sentinel.next,index);


    }
    private T getI(Node p,int index){
        if(index==0){
            return p.item;
        }else{
            return getI(p.next,index-1);
        }
    }

    public static void main(String[] args) {
        LinkedListDeque l =new LinkedListDeque();
        l.addFirst("Ass");
        l.addFirst("Bcd");
        l.printDeque();

    }



}
