package com.test.queue;

/**
 * 队列
 */
public class QueueTest {

    private String[] items;
    private int n;
    private int head;
    private int tail;

    /**
     * 初始化
     * @param capacity
     */
    public QueueTest(int capacity){
        items = new String[capacity];
        n=capacity;
    }


    /**
     * 不扩容添加
     * @param item
     * @return
     */
    public boolean enqueue(String item){
        if(tail==n) return false;
        items[tail]=item;
        ++tail;
        return true;
    }

    /**
     * 自动扩容添加元素（未调试）
     * @param item
     * @return
     */
    public boolean enqueueExtend(String item){
        /**
         * 0. 判断是否已满
         * 1. 将原数组存储到临时数组
         * 2. 扩容原数组为2倍,
         * 3. 将原数组元素拷贝到新数组
         * 4. 将新元素追加到队列末尾
         */

        String[] tmpItems = new String[n];
        if(tail==n-1){
            tmpItems = items;
            n=2*n;
            items = new String[n];
        }

        //copy
        for(int i=head;i<tmpItems.length;i++){
            items[i-head] = tmpItems[i];
        }

        items[tail]=item;
        ++tail;
        return true;
    }


//文中例子是不新建数组扩容,重新利用原数组



    public String dequeue(){
        if(tail==head){
            return null;
        }
        String ret = items[head];
        ++head;
        return ret;
    }






    public static void main(String[] args) {

    }



}
