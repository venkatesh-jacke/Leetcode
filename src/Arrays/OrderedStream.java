package Arrays;

import java.util.ArrayList;
import java.util.List;

//1656. Design an Ordered Stream
public class OrderedStream {
    String[] stream;
    int ptr = 0;

    public OrderedStream(int n) {
        stream = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey - 1] = value;
        List<String> list = new ArrayList<>();
        while (ptr < stream.length && stream[ptr] != null) {
            list.add(stream[ptr++]);
        }
        return list;
    }
}
