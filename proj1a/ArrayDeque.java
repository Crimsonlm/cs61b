public class ArrayDeque<T> {
    private T[]items;
    private int size;
    private int head;
    private int tail;
    public ArrayDeque(){
        items=(T[])new Object[8];
        size=0;
        head=items.length-1;
        tail=0;
    }
    public void addFirst(T i) {
        if (size == items.length) {
            resize();
        }
        if(head<0){
            head=head+ items.length;
        }
        items[head] = i;
        head = head - 1;
        size += 1;


    }
    public void addLast(T i){
        if (size == items.length) {
            resize();
        }
        if(tail==items.length){
            tail=0;
        }
        items[tail]=i;
        tail=tail+1;
        size+=1;


    }
    private void resize(){
        T[]a =(T[])new Object[size*2];
        System.arraycopy(items,head+1,a,0,items.length-head-1);
        System.arraycopy(items,0,a,items.length-head-1,tail);
        items=a;
        tail=size;
        head=items.length-1;
    }
    public  boolean isEmpty(){
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
        for(int i =head+1;i<items.length;i++){
            System.out.print(items[i]+" ");
        }
        for(int i=0;i<tail;i++){
            System.out.print(items[i]+" ");
        }
    }
    public T removeFirst(){
        head=(head+1)% items.length;
        T result=items[head];
        items[head]=null;
        if(size>0){
            size=size-1;
        }
        return result;
    }
    public T removeLast(){
        if(tail==0){
            tail=tail+ items.length;
        }
        T result=items[tail-1];
        items[tail-1]=null;
        tail=tail-1;
        if(size>0){
            size=size-1;
        }
        return result;
    }

    public T get(int index){
        if(head+index+1< items.length){
            return items[head+index+1];
        }else{
            return items[index-(items.length-head-1)];
        }
    }

    public static void main(String[] args) {
        ArrayDeque t =new ArrayDeque();
        t.addLast(1);
        t.addFirst(3);
        t.addLast(5);
        t.addFirst(2);
        t.addLast(7);
        t.addFirst(4);
        t.addLast(8);
        t.addFirst(9);
        t.addLast(0);
        t.addFirst(6);
        t.addLast(5);
        t.addFirst(7);
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.addLast(1);
        t.addLast(2);
        t.addLast(3);
        t.addLast(4);
        t.addLast(5);
        t.addLast(6);
        t.addLast(7);
        t.addLast(8);
        t.addLast(9);
        t.addLast(10);
        t.addLast(11);















    }


}