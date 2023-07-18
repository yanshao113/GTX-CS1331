import java.util.NoSuchElementException;
public class LinkedList<T> implements List<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;
    public LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    public Node<T> getHead(){
        return head;
    }
    public void setHead(Node<T> newHead){
        head = newHead;
    }

    public Node<T> getTail(){
        return tail;
    }
    public void setTail(Node<T> newTail){
        tail = newTail;
    }

    @Override
    public void addAtIndex(T data, int index){
        if(index>size || index<0){throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        if(data == null){
            throw new IllegalArgumentException("You cannot add null data to the list");
        }
        Node<T> node = new Node<T>(data,null);
        Node<T> current = head;
        if(isEmpty()){
            head = node;
            tail = node;
        }else{
            if(index ==0){
                head = new Node<T>(data,head);
            }else if (index == size-1){
                tail = node;
            } else{
                for (int i = 0; i < index; i++) {
                    if (i != (index-1)) {
                        current = current.getNext();
                    } else {
                        node.setNext(current.getNext());
                        current.setNext(node);
                    }
                }
            }

        }
        size++;
    }

    @Override
    public T getAtIndex(int index){
        if(index<0 || index > (size-1)){throw new IllegalArgumentException("Your index is out of the list bounds");}
        Node<T> current = head;
        if(index == 0){
            return head.getData();
        }else{
            for(int i =0; i<index;i++){
                current = current.getNext();
            }
            return current.getData();
        }
    }

    @Override
    public T removeAtIndex(int index){
        if(index<0 || index > (size-1)){throw new IllegalArgumentException("Your index is out of the list bounds");}
        T data;
        Node<T> current = head;
        Node<T> currentBefore = null;
        if(size==1){
            data = head.getData();
            head = null;
            tail = null;
        }else {
            if (index == 0) {
                data = head.getData();
                head = head.getNext();
            } else if (index==(size-1)){
                data = tail.getData();
                tail = null;
            }else {
                for (int i = 0; i < index; i++) {
                    currentBefore = current;
                    current = current.getNext();
                }
                data = current.getData();
                currentBefore.setNext(current.getNext());
            }
        }
        size--;
        return data;

    }

    @Override
    public T remove(T data){
        if(data == null){throw new IllegalArgumentException("You cannot remove null data from the list");}
        if(isEmpty()){throw new NoSuchElementException("The data is not present in the list.");}
        try{
            Node<T> current = head;
            Node<T> currentBefore = null;
            for(int i = 0; i < size; i++){
                if(current.getData() != data){
                    currentBefore = current;
                    current = current.getNext();

                }else{
                    if(i == 0){
                        head = head.getNext();
                    }else {
                        currentBefore.setNext(current.getNext());
                    }
                    break;
                }
            }
            size--;

        }catch (Exception e){
            throw new NoSuchElementException("The data is not present in the list.");
        }

        return data;
    }

    @Override
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty(){
        return head == null;
    }

    @Override
    public int size(){
        return size;
    }
}
