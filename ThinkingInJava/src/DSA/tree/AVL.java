package DSA.tree;

public class AVL<E extends Comparable<E>> extends BST<E>{
    public AVL(){}
    /**
     * 中序遍历递归
     */
    public static void midOrderRe1(Node biTree){
        if(biTree == null)
            return;
        else{
            midOrderRe1(biTree.lChild);
            System.out.print(biTree.high);
            midOrderRe1(biTree.rChild);
        }
    }

    @Override
    public Node<E> add(E e) {
        Node<E> newNode = super.add(e);
        while((newNode = newNode.parent) != null){
            if(!isBalanced(newNode)){
                newNode = Refactor34(tallerChild(tallerChild(newNode)));
            }
            super.root = newNode;
        }
        return newNode;
    }

    Node<E> tallerChild(Node<E> n){
        int lHigh = n.lChild==null?-1:n.lChild.high;
        int rHigh = n.rChild==null?-1:n.rChild.high;
        return lHigh > rHigh?n.lChild:n.rChild;
    }
    Node<E> Refactor34(Node<E> v){
        Node<E> p = v.parent;
        Node<E> g = p.parent;
        Node<E> f = g.parent;
        boolean cType = false;
        if(f != null){
            cType = f.lChild == g;
        }

        if(g.lChild == p){ //zig
            if(p.lChild == v){ //zig zig
                p.parent = g.parent;
                g = connect34(v,p,g,v.lChild,v.rChild,p.rChild,g.rChild);
            }else{ //zig zag
                v.parent = g.parent;
                g = connect34(p,v,g,p.lChild,v.lChild,v.rChild,g.rChild);
            }
        }else{ //zag
            if(p.rChild == v){ //zag zag
                p.parent = g.parent;
                g = connect34(g,p,v,g.lChild,p.lChild,v.lChild,v.rChild);
            }else{//zag zig
                v.parent = g.parent;
                g = connect34(g,v,p,g.lChild,v.lChild,v.rChild,p.rChild);
            }
        }
        if(f != null){
            if (cType) f.lChild = g;
            else f.rChild = g;
        }
        return g;
    }

    Node<E>  connect34(Node a,Node b,Node c,Node T0,Node T1,Node T2,Node T3){
        a.lChild = T0; if(T0 != null) T0.parent = a;
        a.rChild = T1; if(T1 != null) T1.parent = a;
        c.lChild = T2; if(T2 != null) T2.parent = c;
        c.rChild = T3; if(T3 != null) T3.parent = c;
        b.lChild = a; a.parent = b;
        b.rChild = c; c.parent = b;
        updateHeight(a);
        updateHeight(c);
        return b;
    }
    /**
     * 返回节点的平衡因子
     */
    int getBalance(Node n){
        int lHigh = n.lChild==null?-1:n.lChild.high;
        int rHigh = n.rChild==null?-1:n.rChild.high;
        return Math.abs(lHigh - rHigh);
    }
    /**
     * 判断节点v是否平衡
     */
    protected static boolean isBalanced(Node v) {
        if (null == v) return true;
        int lH = (v.hasLChild()) ? (v.lChild.high) : -1;
        int rH = (v.hasRChild()) ? (v.rChild.high) : -1;
        int deltaH = lH - rH;
        return (-1 <= deltaH) && (deltaH <= 1);
    }
    public static void main(String[] args) {
        AVL av = new AVL();
       /* av.add(4);
        av.add(2);
        av.add(1);
        av.add(3);
        av.add(6);
        av.add(5);
        av.add(7);*/
        /*av.add(1);
        av.add(2);
        av.add(3);
        av.add(4);
        av.add(5);
        av.add(6);
        av.add(7);
        av.add(8);*/

        av.add(2);
        av.add(5);
        av.add(1);
        av.add(8);
        av.add(4);
        av.add(6);
        av.add(9);
        av.add(3);
        av.add(7);

        midOrderRe(av.root);
        System.out.println();
        midOrderRe1(av.root);
        System.out.println();
        levelOrder(av.root);

    }
}
