package DSA.tree;

public class Node<E> {
    E item;
    Node<E> parent;
    Node<E> lChild;
    Node<E> rChild;
    int high;

    Node(){}
    Node(E item){
        this.item = item;
        this.high = 0;
    }

    public Node<E> addlChild(E e){
        lChild = new Node(e);
        lChild.parent = this;
        updateHeight(lChild);
        return lChild;
    }

    public Node<E> addrChild(E e){
        rChild = new Node(e);
        rChild.parent = this;
        updateHeight(rChild);
        return rChild;
    }
    public void updateHeight(Node<E> node){
        while((node=node.parent) != null){
            node.high = getHeight(node);
        }
    }
    public int getHeight(Node<E> node){
        if(node == null){
            return 0;
        }
       return Math.max(node.getHigh(node.lChild),node.getHigh(node.rChild)) + 1;
    }
    public int getHigh(Node<E> node){
        return node==null?0:node.high;
    }

    public boolean hasLChild(){
        return this.lChild != null?true:false;
    }
    public boolean hasRChild(){
        return this.rChild != null?true:false;
    }
}
