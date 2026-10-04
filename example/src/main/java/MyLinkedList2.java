
/**
 * @Description:
 * @Author: hezi
 * @Date: 2026/10/4
 */
public class MyLinkedList2<E>{

    //虚拟头尾节点
    final private Node<E>head, tail;
    private int size;

    //双链表节点
    private static class Node<E>{
        E val;
        Node<E> next;
        Node<E>prev;
        Node(E val){
            this.val=val;
        }
    }
    public MyLinkedList2(){
        this.head=new Node<>(null);
        this.tail=new Node<>(null);
        head.next=tail;
        tail.prev=head;
        this.size=0;
    }
    //增
    public void addLast(E e){
        Node<E> x=new Node<>(e);
        Node<E>prev=tail.prev;
        prev.next=x;
        x.prev=prev;
        x.next=tail;
        tail.prev=x;
        size++;
    }
    public void add(int index,E e){
        //判断index合法性
        checkIsElementIndex(index);
        //
        if (index==size){
            addLast(e);
            return;
        }
        //相关节点
        Node<E>cur=getNode(index);
        Node<E>prev=cur.prev;
        Node<E>x=new Node<>(e);
        //修改边
        prev.next=x;
        x.prev=prev;
        x.next=cur;
        cur.prev=x;
        size++;
    }

    //删
    public void remove(int index){
        Node<E>x=getNode(index);
        Node<E>prev=x.prev;
        Node<E>next=x.next;

        prev.next=next;
        next.prev=prev;
        //
        x.prev=null;
        x.next=null;
        size--;
    }

    //查
    private Node<E> getNode(int index){
        //
        checkIsElementIndex(index);
        //
        Node<E> p=head.next;
        for (int i=0;i<index;i++){
            p=p.next;
        }
        return p;
    }
    public E get(int index){
        checkIsElementIndex(index);
        Node<E>x=getNode(index);
//        return getNode(index).val;
        return x.val;
    }

    //改
    public void set(int index,E e){
        //
        Node<E>x=getNode(index);
        Node<E>prev=x.prev;
        Node<E>next=x.next;

        Node<E>newE=new Node<>(e);
        //pre<=>newE
        prev.next=newE;
        newE.prev=prev;
        //pre <=> newE <=> next
        newE.next=next;
        next.prev=newE;
        //
        x.prev=null;
        x.next=null;
    }

    private boolean isElementIndex(int index){
        return index>=0&&index<=size;
    }
    private void checkIsElementIndex(int index){
        if (!isElementIndex(index)){
            throw new IndexOutOfBoundsException("index:"+index+"size:"+size);
        }
    }
    public void display(){
        System.out.println("size= "+size);
        for(Node<E> cur=head.next;cur!=tail;cur=cur.next){
            System.out.print(cur.val+" <=> ");
        }
        System.out.println("null");
        System.out.println();
    }
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        MyLinkedList2<Integer> myLinkedList2=new MyLinkedList2<>();
        int index=5;
        for (int i=0;i<index;i++){
            myLinkedList2.addLast(i);
            System.out.println(myLinkedList2.get(i));
        }
        myLinkedList2.add(0,6);
        for (int i=0;i< myLinkedList2.size();i++){
            System.out.print(myLinkedList2.get(i));
        }
        System.out.println();
        myLinkedList2.remove(2);
        for (int i=0;i< myLinkedList2.size();i++){
            System.out.print(myLinkedList2.get(i));
        }
        System.out.println();
        myLinkedList2.set(0,667);
        for (int i=0;i< myLinkedList2.size();i++){
            System.out.print(myLinkedList2.get(i));
        }
        myLinkedList2.display();
    }

}
