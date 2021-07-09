package com.test.sort;

/**
 * 归并排序
 */
public class MergeSort {

    /**
     * 归并排序（自写）
     * 1. 将一个数组从中间分解成2个数组
     * 2. 一直分解，直到数组元素只有1个了，
     * 3. 从下到上归并数组，通过调用合并函数合并2个已有序的数组
     * 4. 完成排序
     * @param a
     */
    public static void mergeSort(int[] a){
        sort(a,0,a.length-1);
    }


    /**
     * 对数组进行归并
     */
    public static void sort(int[] data,int left,int right){

        if(left>=right){
            return ;
        }
        int center = (left+right)/2;
        sort(data,left,center);
        sort(data,center+1,right);
        merge(data,left,center,right);

    }

    /**
     * 合并两个有序的数组
     * 1. 设立aa数组的游标i，ab数组的游标j
     * 2. 新开辟一个数组tmp，临时存放数据
     * 3. 依次比较aa[i]和ab[j],谁小谁进入tmp
     * 4. 退出条件 当有一方的i或者j到达最末尾，将另外剩余的数据加入tmp
     * 5. 复制tmp数据到原数组
     */
    public static void merge(int[] data,int left, int center,int right){

        int i = left; //左边数组游标
        int j = center+1; //右边数组游标
        int k = left; //tmp数组当前已放入
        //缓存左边数组第一个元素的索引
        int tmpIndex = left;
        int[] tmp = new int[data.length];

        while(i<=center && j<=right){
            if(data[i]<=data[j]){
                tmp[k++]=data[i++];
            }else {
                tmp[k++]=data[j++];
            }
        }

        while(i<=center){
            tmp[k++]=data[i++];
        }

        while(j<=right){
            tmp[k++]=data[j++];
        }

        //copy 回原数组
        while(tmpIndex<=right){
            data[tmpIndex]=tmp[tmpIndex++];
        }
    }



    public static void main(String[] args) {
//        int a[] = {4,9,1,8,6,2};
        int a[] = {9,4,1};

         mergeSort(a);

//        for(int i=0;i<tmp.length;i++){
//            System.out.println(tmp[i]);
//        }

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
