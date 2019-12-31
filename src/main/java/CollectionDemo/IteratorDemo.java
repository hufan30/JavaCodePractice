package CollectionDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IteratorDemo {

    Map m1 = new HashMap<>();

    public IteratorDemo() {
        m1.put(1, 1);
        m1.put(2, 2);
    }

    /**
     * 测试在构造迭代器之后修改对应的映射,
     * 应该会报一个ConcurrentModificationException异常；
     */
    public void testIterator() {
        Iterator it = m1.entrySet().iterator();
        while (it.hasNext()) {
            it.next();
            m1.put(3, 3);
        }
    }

    public static void main(String[] args) {
        IteratorDemo id = new IteratorDemo();
        id.testIterator();
    }
}

