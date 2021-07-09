package com.test.bsearch;


/**
 * 二分查找
 * 2021.7.7
 */
public class BSearchTest {


    public static int bsearch(int[] a,int n,int value){
      int low = 0 ;
      int high = n-1;
      while (low<=high){ // 注意是"<=" 而不是 "<"
          // 如果 low 和 high 比较大的话，两者之和就有可能会溢出。改进的方法是将 mid 的计算方式写成 low+(high-low)/2。
          //如果要将性能优化到极致的话，我们可以将这里的除以 2 操作转化成位运算 low+((high-low)>>1)。因为相比除法运算来说，计算机处理位运算要快得多。
         int mid = (low+high)/2;

          if(a[mid]==value){
              return mid;
          }else if(a[mid]>value){ //要找的值小于当前中间值,在左半边,
              high = mid-1;
          }else { //要找的值大于当前中间值,在右半边
              low = mid + 1;
          }
      }
      return -1;
    }


    public static void main(String[] args) {
//        int c[] = {1,2,3,5};  //n=4
//        int c[] = {1,2,3,5,7};  //n=4
//        System.out.println(bsearch(c,c.length,6)); //0

        int a[] = {3,5,6,13,21,  23,24,26,28,100,  101,102,103,106};  //n=14
        int b[] = {3,5,6,13,21,  23,24,26,28,100,  101,102,103,106,120 }; //n=15

       //数组a
        System.out.println(bsearch(a,a.length,3)); //0
        System.out.println(bsearch(a,a.length,5)); //1
        System.out.println(bsearch(a,a.length,6)); //2
        System.out.println(bsearch(a,a.length,26)); //7
        System.out.println(bsearch(a,a.length,28)); //8
        System.out.println(bsearch(a,a.length,106)); //13
        //数组b
        System.out.println(bsearch(b,b.length,3)); //0
        System.out.println(bsearch(b,b.length,5)); //1
        System.out.println(bsearch(b,b.length,6)); //2
        System.out.println(bsearch(b,b.length,26)); //7
        System.out.println(bsearch(b,b.length,28)); //8
        System.out.println(bsearch(b,b.length,100)); //9
        System.out.println(bsearch(b,b.length,120)); //14

    }
}



