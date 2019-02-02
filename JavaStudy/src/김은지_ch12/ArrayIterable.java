package 김은지_ch12;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class ArrayIterable<T> implements Iterable<T> {

    private List<String> list;

    public ArrayIterable(String[] arr) {
        list = Arrays.asList(arr);
        Collections.sort(list);
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) list.iterator();
    }
}