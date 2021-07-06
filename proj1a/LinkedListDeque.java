public class LinkedListDeque {
    private int size;
    private IntNode sentinel;
    private class IntNode{
        public int item;
        public IntNode prev;
        public IntNode next;
        public IntNode(int i,IntNode p,IntNode n){
            this.item = i;
            this.prev = p;
            this.next =n;
        }
    }

    public LinkedListDeque(){
        sentinel = new IntNode(24,null,null);
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
        size=0;
    }

    /** 我在这里想岔了 我一直在思考 sentinel.prev不一定是这个next怎么办
     * 但其实这完全是杞人忧天，创建链表就只和创建的时候有关系。我就没有写创建多个数字的链表的构造器。
     * 我只会创建一个含一个数字的链表 它一定是这样。
     * @param x
     */
    public LinkedListDeque(int x){
        sentinel = new IntNode(24,null,null);
        sentinel.next=new IntNode(x,sentinel,sentinel);
        sentinel.prev= sentinel.next; //这里不能new 因为你要说明 它的上一个就是 sentinel.next。
        size=1;
    }

    public void addFirst(int item){
        sentinel.next.prev=new IntNode(item,sentinel,sentinel.next);
        sentinel.next = sentinel.next.prev;
        size+=1;
    }

    public void addLast(int item){
        sentinel.prev.next = new IntNode(item,sentinel.prev,sentinel);
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

    public void printDeque(){
        IntNode cur = sentinel;
        while(cur.next!=sentinel){
            System.out.print(cur.next.item+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    public int removeFirst(){
        if(size>0){
            int result =sentinel.next.item;
            sentinel.next.next.prev=sentinel;
            sentinel.next=sentinel.next.next;
            size-=1;
            return result;
        }else{
            return 0;
        }

    }

    public int removeLast(){
        if(size>0){
            int result =sentinel.prev.item;
            sentinel.prev.prev.next=sentinel;
            sentinel.prev=sentinel.prev.prev;
            return result;
        }else{
            return 0;
        }
    }

    public int get(int index){
        if(index>size-1){
            return 0;
        }
       IntNode p = sentinel.next;
       while (index!=0){
           p=p.next;
           index-=1;
       }
       return p.item;
    }
    public int getRecursive(int index){
        if(index>size-1){
            return 0;
        }
        return  getI(sentinel.next,index);


    }
    private int getI(IntNode p,int index){
        if(index==0){
            return p.item;
        }else{
            return getI(p.next,index-1);
        }
    }

    public static void main(String[] args) {
        LinkedListDeque t = new LinkedListDeque();
//        LinkedListDeque r =new LinkedListDeque(8);
        t.addFirst(1);
        t.addLast(4);
        t.addFirst(5);
        t.printDeque();
        System.out.println(t.getRecursive(3));


    }

}
