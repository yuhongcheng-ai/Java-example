package DSA.tree;

import DSA.list.MQueue;
import DSA.list.MStack;

public class BST<E extends Comparable<E>> {
    Node<E> root;
    Node<E> pNode;
    public BST(){
    }
    public BST(E e){
        root = new Node<E>(e);
    }
    public Node<E> getRoot() {
        return root;
    }

    public int compareTo(E e1, E e2){
        return e1.compareTo(e2);
    }

    public Node<E> add(E e){
        pNode = root;
        if(pNode == null){
            root = new Node(e);
            return root;
        }
        return add1(pNode,e);
    }
    Node<E> add1(Node<E> o,E e){
        if(compareTo(o.item,e)>0){
            //进入左子树
            if(o.lChild == null){
                return o.addlChild(e);
            }
            return add1(o.lChild,e);
        }else{
            //进入右子树
            if(o.rChild == null){
                return o.addrChild(e);
            }
            return add1(o.rChild,e);
        }
    }

    public void updateHeight(Node<E> node){
        do {
            node.high = getHeight(node);
        }while((node=node.parent) != null);
    }
    public int getHeight(Node<E> node){
        if(node == null){
            return -1;
        }
        return Math.max(node.getHigh(node.lChild),node.getHigh(node.rChild)) + 1;
    }
    public int getHigh(Node<E> node){
        return node==null?0:node.high;
    }

    /**
     * 先序遍历递归
     */
    public static void preOrderRe(Node biTree){
        if(biTree == null)
            return;
        else{
            System.out.print(biTree.item);
            preOrderRe(biTree.lChild);
            preOrderRe(biTree.rChild);
        }
    }

    /**
     * 先序遍历非递归
     */
    public static void preOrder(Node biTree){
        MStack<Node> ms = new MStack<>();
        while (biTree != null || !ms.isEmpty()){
            while(biTree != null){
                System.out.print(biTree.item);
                if(biTree.rChild != null){
                    ms.push(biTree);
                }
                biTree = biTree.lChild;
            }
            if(!ms.isEmpty()){
                biTree = ms.pop();
                biTree = biTree.rChild;
            }
        }
    }

    /**
     * 中序遍历递归
     */
    public static void midOrderRe(Node biTree){
        if(biTree == null)
            return;
        else{
            midOrderRe(biTree.lChild);
            System.out.print(biTree.item);
            midOrderRe(biTree.rChild);
        }
    }
    /**
     * 中序遍历非递归
     */
    public static void midOrder(Node biTree){
        MStack<Node> stack = new MStack<Node>();
        while(biTree != null || !stack.isEmpty()){
            while(biTree != null){
                stack.push(biTree);
                biTree = biTree.lChild;
            }
            if(!stack.isEmpty()){
                biTree = stack.pop();
                System.out.print(biTree.item);
                biTree = biTree.rChild;
            }
        }
    }
    /**
     * 后序遍历递归
     */
    public static void postOrderRe(Node biTree){
        if(biTree == null)
            return;
        else{
            postOrderRe(biTree.lChild);
            postOrderRe(biTree.rChild);
            System.out.print(biTree.item);
        }
    }

    /**
     * 后序遍历非递归
     */
    public static void postOrder(Node biTree){
        int left = 1;//在辅助栈里表示左节点
        int right = 2;//在辅助栈里表示右节点
        MStack<Node> stack = new MStack<Node>();
        MStack<Integer> stack2 = new MStack<Integer>();//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点。

        while(biTree != null || !stack.isEmpty())
        {
            while(biTree != null)
            {//将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(biTree);
                stack2.push(left);
                biTree = biTree.lChild;
            }

            while(!stack.isEmpty() && stack2.peek() == right)
            {//如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack2.pop();
                System.out.print(stack.pop().item);
            }

            if(!stack.isEmpty() && stack2.peek() == left)
            {//如果是从左子节点返回父节点，则将标记改为右子节点
                stack2.pop();
                stack2.push(right);
                biTree = stack.peek().rChild;
            }
        }
    }

    /**
     * 层次遍历
     */
    public static void levelOrder(Node biTree){
        if(biTree == null)
            return;
        MQueue<Node> mq = new MQueue();
        mq.add(biTree);
        Node n;
        int h = biTree.high;
        while (!mq.isEmpty()){
            n = mq.poll();
            if(n.lChild != null){
                mq.add(n.lChild);
            }
            if(n.rChild != null){
                mq.add(n.rChild);
            }
            System.out.print(n.item);
        }
    }

    public static void main(String[] args) {
        BST t = new BST();

        t.add(4);
        t.add(6);
        t.add(2);
        t.add(1);
        t.add(3);
        t.add(5);
        t.add(7);
        /*t.add(2);
        t.add(1);
        t.add(4);
        t.add(6);
        t.add(5);
        t.add(3);
        t.add(7);*/
        preOrderRe(t.root);
        System.out.println();
        preOrder(t.root);
        System.out.println();

        midOrderRe(t.root);
        System.out.println();
        midOrder(t.root);
        System.out.println();

        postOrderRe(t.root);
        System.out.println();
        postOrder(t.root);

        System.out.println();
        levelOrder(t.root);
    }
}
