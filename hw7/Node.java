
public class Node<T> {
    private T data;
    private Node<T> next;
    public Node(T data, Node<T> next){
        this.data =data;
        this.next =next;
    }
    public Node(T data){
        this(data,null);
    }

    public T getData(){
        return data;
    }
    public Node<T> getNext(){
        return next;
    }
    public void setData(T newData){
        this.data = newData;
    }

    public void setNext(Node<T> newNext){
        this.next = newNext;
    }
}