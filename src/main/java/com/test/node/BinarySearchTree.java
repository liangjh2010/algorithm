package com.test.node;


/**
 * 二叉树的插入,删除,查找, 前中后序遍历
 */
public class BinarySearchTree {

   static Node tree ;

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
           this.data = data;
        }

        public Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }



    // 插入
    public void insert(int data){
        if(tree == null){
             tree = new Node(data);
            return;
        }
       Node p = tree;
        while(p!=null){
            if(data>p.data){
                if(p.right == null){
                    p.right = new Node(data);
                    return ;
                }
                p = p.right ;
            }else { // data < p.data
                if(p.left == null){
                    p.left = new Node(data);
                    return ;
                }
                p = p.left;
            }
        }
    }

    //查找
    public  Node find(int data){
        Node p = tree;
          while(p != null){
              if(data > p.data){
                 p = p.right;
              }else if(data < p.data){
                  p = p.left;
              }else {
                  return p;
              }
          }
          return null;
    }

//===============================delete begin==================================
    //删除节点,自写
    public void delete(int data){

        Node p = tree; //开始指向根节点
        Node parent = null; //删除节点的父节点
        while(p!=null && p.data!=data){ //找到该节点
            parent = p;
            if(p.data < data){
                p = p.right;
            }else {
                p = p.left;
            }
        }
        if(p==null){ //没有此节点
            return ;
        }

        //3.该节点包含左右节点
        //需要找到这个节点的右子树中的最小节点，把它替换到要删除的节点上。
        //然后再删除掉这个最小节点，因为最小节点肯定没有左子节点（如果有左子结点，那就不是最小节点了）
        if(p.left!=null && p.right!=null){
            Node minP = p.right;
            Node minParent = p;
            while(minP.left!=null){
                minParent = minP;
                minP = minP.left;
            }
            p.data = minP.data; //将找到的最小的节点的值赋值给要删除的节点.
            p=minP;
            parent = minParent;
        }


        //1.该节点为叶子节点,直接删除
        if(p.left == null && p.right == null){
            if(p == tree){ //根节点
                tree = null;
                return ;
            }else {
                if(parent.left == p){
                    parent.left = null;
                    return;
                }else {
                    parent.right = null;
                    return ;
                }
            }
        }

        //2.该节点包含一个左节点或右节点
        //直接删除该结点，并将其左子树或者右子树设置为其父结点的左子树或者右子树即可，此操作不会破坏树结构
        if(p.right!=null && p.left == null){ //要删除的节点只有右节点
            if(parent==null){ //删除的是根节点
                tree = p.right; //将右节点赋值给tree
                return ;
            }
            //非根节点
             if(parent.left == p){//要删除的节点是父节点的左节点
                parent.left = p.right;
                 return ;
            }else if(parent.right == p){
                parent.right = p.right;
                 return ;
            }
        }

        if(p.left!=null && p.right == null){//要删除的节点只有左节点
            if(parent==null){
                tree = p.left;
                return ;
            }
            //非根节点
            if(parent.left == p){//要删除的节点是父节点的节点
                parent.left = p.left;
                return ;
            }else if(parent.right == p){
                parent.right = p.left;
                return ;
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = {2,4,5,7,9,12,45,34,1,10};
        int[] arr = {33,16,50,13,18, 34,58,15,17,25, 51,66,19,27,55};
        BinarySearchTree t = new BinarySearchTree();
        t.init(arr);



//        t.delete(55); //叶子节点
//        t.delete(13); //只有1个子节点
        t.delete(18); //有2个子节点

        t.midIterator(tree);

        //t.deleteW(18);
//        t.deleteW(13);
//        t.deleteW(55);

//        System.out.println("----------------");
//        t.midIterator(tree);
//        t.delete(13);
//        t.midIterator(tree);
//        System.out.println("----------------");
//        t.delete(55);

//        Node res2 = t.find(55);
//        if(res2==null){
//            System.out.println("null");
//        }else {
//            System.out.println(res2.data);
//        }
        //遍历二叉树
//        t.midIterator(tree);
//        System.out.println("----------------");
//        t.predIterator(tree);
//        System.out.println("----------------");
//        t.backIterator(tree);

    }

    //===============================delete end==================================

//王争 代码
public void deleteW(int data) {
    Node p = tree; // p指向要删除的节点，初始化指向根节点
    Node pp = null; // pp记录的是p的父节点
    while (p != null && p.data != data) {
        pp = p;
        if (data > p.data) p = p.right;
        else p = p.left;
    }
    if (p == null) return; // 没有找到

    // 要删除的节点有两个子节点
    if (p.left != null && p.right != null) { // 查找右子树中最小节点
        Node minP = p.right;
        Node minPP = p; // minPP表示minP的父节点
        while (minP.left != null) {
            minPP = minP;
            minP = minP.left;
        }
        p.data = minP.data; // 将minP的数据替换到p中
        p = minP; // 下面就变成了删除minP了
        pp = minPP;
    }

    // 删除节点是叶子节点或者仅有一个子节点
    Node child; // p的子节点
    if (p.left != null) child = p.left;
    else if (p.right != null) child = p.right;
    else child = null;

    if (pp == null) tree = child; // 删除的是根节点
    else if (pp.left == p) pp.left = child;
    else pp.right = child;
}



//    //初始化测试节点
//    public static Node<Integer> init(){
//        Node<Integer> node3 = new BinaryNode<Integer>(3);
//        Node<Integer> node1 = new BinaryNode<Integer>(1);
//        Node<Integer> node4 = new BinaryNode<Integer>(4,node3,null);
//        BinaryNode<Integer> node2 = new BinaryNode<Integer>(2,node1,node4);
//        BinaryNode<Integer> node8 = new BinaryNode<Integer>(8);
//        BinaryNode<Integer> root = new BinaryNode<Integer>(6,node2,node8);
//        return root;
//    }

    public void init(int[] arr){
        for(int i=0;i<arr.length;i++){
            this.insert(arr[i]);
        }
    }


    //删除


    //最大值


    //最小值


    //遍历二叉树

    //节点遍历
    //中序遍历
    public void midIterator(Node node){
        if(node!=null){
            midIterator(node.left);
            System.out.print(node.data+",");
            midIterator(node.right);
        }
    }

    //前序遍历
    public void predIterator(Node node){
        if(node!=null){
            System.out.println(node.data);
            predIterator(node.left);
            predIterator(node.right);
        }
    }

    //后序遍历
    public void backIterator(Node node){
        if(node!=null){
            backIterator(node.left);
            backIterator(node.right);
            System.out.println(node.data);
        }
    }

}
