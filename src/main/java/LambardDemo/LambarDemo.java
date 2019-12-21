package LambardDemo;

/**
 * @description:
 * @author: HuFan
 * @time: 2019/12/209:39 下午
 **/
public class LambarDemo {

    public static class PretendEat {
        static void Peat() {
            System.out.println("假装我是eat");
        }
    }

    private void testEat(ActionEat ae) {
        ae.eat();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        new LambarDemo().testEat(PretendEat::Peat);
    }
}

interface ActionEat {
    void eat();
}