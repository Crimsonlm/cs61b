public class LinkedListDeque {
    private static class IntNode {
        public int item;
        public IntNode prev;
        public IntNode next;

        public IntNode(int item, IntNode prev, IntNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
        private IntNode sentinel;
        private int size;

        public LinkedListDeque(){
            sentinel = new IntNode(64,null,null);
            size = 0;
        }
        public LinkedListDeque(int x){
            sentinel = new IntNode(64,null,null);
            sentinel.next = new IntNode(x,sentinel,sentinel);
            size=1;
        }
        public void addFirst(int x){
            sentinel.next = new IntNode(x,sentinel,sentinel.next);
            size+=1;
        }
}
