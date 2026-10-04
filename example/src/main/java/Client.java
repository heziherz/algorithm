/**
 * @Description:
 * @Author: hezi
 * @Date: 2026/10/4
 */
public class Client {
    public static void main(String[] args) {

        int size=10;
        MyArrayList<Integer> myArrayList = new MyArrayList<>(size);
        System.out.println(myArrayList.size());

        //增加
        for (int i=0;i<size;i++){
            myArrayList.addLast(i);
        }
        //指定位置增加
        myArrayList.add(1,666);
        for (int i=0;i<myArrayList.size();i++){
            System.out.println(myArrayList.get(i));
        }
        //指定位置删除
        myArrayList.remove(1);
        for (int i=0;i<myArrayList.size();i++){
            System.out.println(myArrayList.get(i));
        }
        //查
        for (int i=0;i<myArrayList.size();i++){
            System.out.println(myArrayList.get(i));
        }
    }
}
