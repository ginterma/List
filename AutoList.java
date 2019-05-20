import java.util.*;

public class AutoList implements List {
    public int size = 0;
    public Object[] number;

    public AutoList() {
        this.number = new Object[0];

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(Object p) {
        if (indexOf(p) != -1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(number, size);
    }

    @Override
    public Object[] toArray(Object[] t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Object object) {
        number = Arrays.copyOf(number, size + 1);
        number[size + 1] = object;
        return true;

    }

    @Override
    public boolean remove(Object object) {
        int index = indexOf(object);
        if (size < index) {
            return false;
        }
        number[index] = null;
        size--;
        return true;
    }

    @Override
    public boolean containsAll(Collection collection) {
        for (Object number : collection)
            if (!contains(number))
                return false;

        return true;
    }

    @Override
    public boolean addAll(Collection collection) {
        for (Object object : collection) {
            add(object);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection collection) {
        for (Object number : collection) {
            if (!this.remove(number))
                return false;
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        int i;
        for (i = 0; i < size; i++) {
            number[i] = null;
        }
    }

    @Override
    public Object get(int index) {
        return number[index];
    }

    @Override
    public Object set(int index, Object element) {
        return number[index] = element;
    }

    @Override
    public void add(int index, Object element) {

        number[index] = element;

    }

    @Override
    public Object remove(int index) {
        Object object = number[index];
        System.arraycopy(number, index + 1, number, index, size - 1);
        number[size--] = null;

        return object;
    }

    @Override
    public int indexOf(Object object) {

        for (int i = 0; i < size; i++) {
            if (number[i] == object)
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {

        for (int i = size; i < 1; i--) {
            if (number[i] == object)
                return i;
        }
        return -1;
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int start, int end) {
        int size1=end-start;
         Object[] array = new Object[size1];

         for(int i =0; i<size1;i++)
         {
             array[i]=number[start+i];
         }
        return Arrays.asList(array);
    }


}