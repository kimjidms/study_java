package 김은지_ch12;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class ArrayIterable<T> implements Iterable<T> {

    private List<String> list;

    public ArrayIterable(String[] arr) {
        list = Arrays.asList(arr);
    }

    @Override
    public Iterator<T> iterator() {

        Iterator tmp = list.iterator();

        while (tmp.hasNext()){
            System.out.println(tmp.next());
        }
        return tmp;
    }
}