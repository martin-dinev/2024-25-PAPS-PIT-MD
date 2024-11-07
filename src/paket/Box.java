package paket;
public class Box <T>{
    T[] objects;
    public Box(int golemina) {
        objects = (T[]) new Object[golemina];
    }
    T get(int index) {
        return objects[index];
    }
    void set(int index, T value) {
        objects[index] = value;
    }

    @Override
    public String toString() {
        return "Goleminata e " + objects.length + " prviot element e "  + objects[0];
    }

    T getFirst() {
        return objects[0];
    }
}
