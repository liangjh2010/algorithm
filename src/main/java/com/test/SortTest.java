package com.test;


/**
 * 冒泡，选择，插入 排序
 */
public class SortTest {

    /**
     * 冒泡排序(自写）
     * @param a
     * @param n
     */
    public static void bubbleSort(int[] a,int n){
        if(n==1){
            return ;
        }

        for(int i=n-1;i>0;i--){
            int j = 0;
            for(;j<i;j++){
                if(a[j]>a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1]=tmp;
                }
            }
        }
    }



    /**
     * 极客时间 冒泡排序
     * @param a
     * @param n
     */
    public static void bubbleSort2(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j+1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换,提前退出 ,代表剩下的元素已经是顺序排列
        }
    }

    /**
     * 插入排序(自写)
     * @param a
     * @param n
     */
    public static void insertionSort(int[] a,int n){
        if(n==1){
            return ;
        }

        /**
         * 1. 第一层循环，第二个元素开始出列，一直到第n个元素，
         * 2. 依次拿出来和原队列比较，从第一个到[自己的位置-1]
         * 3. 如果小于第k个元素，则插入到k-1的位置，【k，第一个到自己的位置-1】元素依次向后挪动一位
         * 4. 继续比较，直到最后一个元素
         * 5. 注意边界条件
         */

        for(int i=1;i<n;i++){
            int j=0;
            for(;j<i;j++){
                if(a[i]<a[j+1]){
                    int tmp = a[i];
                    for(int k=i;k>j;k--){
                        a[k]=a[k-1];
                    }
                    a[j]=tmp;
                    break;
                }
            }
        }
    }


    // 插入排序，a表示数组，n表示数组大小
    public static void insertionSort2(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }


    public static void selectSortMe(int[] a,int n){
        if (n <= 1) return;

        /**
         * 每次遍历，找到最小的元素，和对应位置的元素交换，直到遍历完所有
         */

        for(int posi=0;posi<n;posi++){
            int index = posi+1;
          //  int min = a[posi];
            int minIndex = posi;
            for(;index<n;index++){
                if(a[index]<a[minIndex]){
//                    min=a[index];
                    minIndex = index;
                }
            }
            //交换
            int tmp = a[minIndex];
            a[minIndex] = a[posi];
            a[posi] = tmp;
        }



    }

    public static void main(String[] args) {
        int a[] = {4,5,6,3,2,1};

//        bubbleSort2(a,a.length);
//        insertionSort(a,a.length);
//        insertionSort2(a,a.length);
        selectSortMe(a,a.length);

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}



