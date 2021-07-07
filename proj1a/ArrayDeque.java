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
        items[head] = i;
        head = head - 1;
        size += 1;


    }
    public void addLast(T i){
        if (size == items.length) {
            resize();
        }
        items[tail]=i;
        tail=tail+1;
        size+=1;


    }
    public void resize(){
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
        T result=items[head+1];
        items[head+1]=null;
        return result;
    }
    public T removeLast(){
        T result=items[tail-1];
        items[tail-1]=null;
        return result;
    }

    public T get(int index){
        if(head+index+1< items.length){
            return items[head+index+1];
        }else{
            return items[index-(items.length-head-1)];
        }
    }


}