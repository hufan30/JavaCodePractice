package DesignPatternDemo;

/**
 * @description: 演示组合模式
 * @author: HuFan
 * @time: 2020/5/269:31 下午
 **/
public class Calcultor {
    public static void main(String[] args) {
        //1+2+3+4
        AddExpression addExpression = new AddExpression(new NumExpression(1),
                new AddExpression(new NumExpression(2),
                        new AddExpression(new NumExpression(3), new NumExpression(4))));
        //这里的俄罗斯套娃就是为了展示组合模式；
        System.out.println(addExpression.getValue());
      }

    interface Expression {
        int getValue();
    }

    public static class AddExpression implements Expression {
        Expression left;
        Expression right;

        public AddExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int getValue() {
            return left.getValue() + right.getValue();
        }
    }

    public static class NumExpression implements Expression {
        int num;

        public NumExpression(int num) {
            this.num = num;
        }

        @Override
        public int getValue() {
            return num;
        }
    }

    public static class test {

    }

    private static class testPrivateStaticClass {
    }

}
