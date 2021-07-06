package com.test;

/**
 * 链表
 */
public class LinkTest {
    public static void main(String[] args) {
        int[] a = {4, 2, 3, 5, 9, 6};
//        System.out.println(find1(a,6,7));
//        System.out.println(find1(a,6,6));

//        System.out.println(find2(a,6,7));
        System.out.println(find2(a,6,9));
    }


    public static int find2(int[] a,int n,int key){

        if(a==null || a.length==0){
            return -1;
        }

        if(a[n-1]==key){
            return n-1;
        }

        int tmp = a[n-1];

        a[n-1] = key;
        int i = 0;
        while (a[i]!=key){
            i++;
        }

        a[n-1] = tmp;
        if(i==n-1){
            return -1;
        }else {
            return i;
        }

    }

    /**
     * // {4, 2, 3, 5, 9, 6} n=6 key = 7
     */
    public static int find1(int[] a,int n,int key){

        if(a==null || a.length==0){
            return -1;
        }

        for(int i=0;i<n;i++){
            if(i==n-1 && a[i]!=key){
                return -1;
            }
            if(a[i]==key){
                return i;
            }
        }
        return -1;
    }



}
