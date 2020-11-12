package CollectionDemo;

import java.util.*;

public class IteratorDemo {

    Map m1 = new HashMap<>();
    List a = new ArrayList<>();
    Iterator iterator = a.iterator();
    Iterator iterator2 = a.iterator();

    public IteratorDemo() {
        m1.put(1, 1);
        m1.put(2, 2);
        Iterator iterator = a.iterator();
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

/*        编译器应该将数组初始为什么呢？明显就有歧义了，为了避免这种有奇异的情况，Java的语法才这样规定。
        换句话说，只有在没有指定初始值的时候，才能给出初始大小，这两个信息只能给出一个，比如：*/
        int test[] = new int[3];
        int[] test2 = new int[3];
        int[] test23 = new int[]{12,3,3};

        String a = "123";
    }
}

