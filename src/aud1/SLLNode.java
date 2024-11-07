package aud1;
public class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    public E getElement() {
        return element;
    }

    public SLLNode<E> getSucc() {
        return succ;
    }


}

