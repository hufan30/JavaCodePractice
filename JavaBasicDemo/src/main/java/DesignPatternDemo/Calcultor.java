package DesignPatternDemo;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/5/269:31 下午
 **/
public class Calcultor {
    public static void main(String[] args) {
        //1+2+3+4
//        new AddExpression(new NumExpression(1),new AddExpression(2,));
        new test();
        new Calcultor.test();

    }

    interface Expression {
        int getValue();
    }

    public class AddExpression implements Expression {
        Expression left;
        Expression right;

        public void AddExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int getValue() {
            return left.getValue() + right.getValue();
        }
    }

    public class NumExpression implements Expression {
        int num;

        public void NumExpression(int num) {
            this.num = num;
        }

        @Override
        public int getValue() {
            return num;
        }
    }

    public static class test{

    }

    private static class testPrivateStaticClass{}

}
