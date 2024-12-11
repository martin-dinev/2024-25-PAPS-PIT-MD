package aud7;
public interface DoublyHashable<K> {

    public int hashCode();
    // Return the (raw) hash code to use for this key.

    public int stepCode();
    // Return the (raw) step size to use for this key.

}