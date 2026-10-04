/**
 * @Description:
 * @Author: hezi
 * @Date: 2026/10/4
 */
public class MyArrayList<E> {
    private E[] data;
    private int size;
    private static final int INIT_CAP=1;

    public MyArrayList(){
        this(INIT_CAP);
    }
    public MyArrayList(int initCapacity){
        this.data=(E[])new Object[initCapacity];
//        this.data=new E[initCapacity];
        size=0;
    }

    public int size(){
        return size;
    }


    //增加
    public void addLast(E e){
        int cap=data.length;
        if (size==cap){
            addCap();
        }
        data[size]=e;
        size++;
    }
    public void add(int index,E e){
        //判断是否需要扩容
        int cap=data.length;
        if (size==cap){
            addCap();
        }
        //判断index合法性
        checkElementIndex(index);
        //
        for (int i=size;i>index;i--){
            data[i]=data[i-1];
        }
        data[index]=e;
        size++;
    }
    //删
    public void remove(int index){
        //判断index合法性
        checkElementIndex(index);
        //
        for(int i=index;i<size-1;i++){
            data[i]=data[i+1];
        }
        size--;

        //最后一个元素设置为null，否则会内存泄漏
        data[size-1]=null;
        //判断缩容
        if (size< data.length/4&&size>100){
            delCap();
        }

    }
    //改
    public void set(int index,E e){
        //判断index合法性
        checkElementIndex(index);
        //
        data[index]=e;
    }
    //查
    public E get(int index){
        //判断
        checkElementIndex(index);
        return data[index];
    }

    //扩容
    private void addCap(){
        int newCap= data.length*2;
        E[] newData=(E[])new Object[newCap];

        for(int i=0;i<size;i++){
            newData[i]=data[i];
        }
        this.data=newData;
    }
    //减容
    private void delCap(){
        int newCap= data.length/2;
        E[] newData=(E[]) new Object[newCap];

        for(int i=0;i<size;i++){
            newData[i]=data[i];
        }
        this.data=newData;
    }
    //检查索引位置是否可以存在元素
    private boolean isElementIndex(int index){
        return index>=0 &&index<=size;
    }
    private void checkElementIndex(int index){
        if (!isElementIndex(index)){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

}
