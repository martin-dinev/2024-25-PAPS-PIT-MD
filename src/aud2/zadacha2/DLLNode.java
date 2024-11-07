package aud2.zadacha2;
public class DLLNode<E> {
    protected E element;
    protected int brPojavuvanja;
    protected DLLNode<E> pred, succ;

    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
        this.brPojavuvanja=1;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public int getBrPojavuvanja() {
        return brPojavuvanja;
    }

    public void setBrPojavuvanja(int brPojavuvanja) {
        this.brPojavuvanja = brPojavuvanja;
    }

    public DLLNode<E> getPred() {
        return pred;
    }

    public void setPred(DLLNode<E> pred) {
        this.pred = pred;
    }

    public DLLNode<E> getSucc() {
        return succ;
    }

    public void setSucc(DLLNode<E> succ) {
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString() + "(" + this.brPojavuvanja + ")";
    }
}


