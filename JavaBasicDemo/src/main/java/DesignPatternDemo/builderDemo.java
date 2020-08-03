package DesignPatternDemo;

public class builderDemo {
    public static void main(String[] args) {
        Car car = new Builder().build();
        System.out.println(car.toString());
    }
    static final class Car {
        /**
         * 必需属性
         */
        final String carBody;//车身
        final String tyre;//轮胎
        final String engine;//发动机
        final String aimingCircle;//方向盘
        final String safetyBelt;//安全带
        /**
         * 可选属性
         */
        final String decoration;//车内装饰品
        /**
         * car 的构造器 持有 Builder,将builder制造的组件赋值给 car 完成构建
         * @param builder
         */
        public Car(Builder builder) {
            this.carBody = builder.carBody;
            this.tyre = builder.tyre;
            this.engine = builder.engine;
            this.aimingCircle = builder.aimingCircle;
            this.decoration = builder.decoration;
            this.safetyBelt = builder.safetyBelt;
        }

    }
}
final class Builder {
    String carBody;
    String tyre;
    String engine;
    String aimingCircle;
    String decoration;
    String safetyBelt;

    public Builder() {
        this.carBody = "宝马";
        this.tyre = "宝马";
        this.engine = "宝马";
        this.aimingCircle = "宝马";
        this.decoration = "宝马";
    }
    /**
     * 实际属性配置方法
     * @param carBody
     * @return
     */
    public Builder carBody(String carBody) {
        this.carBody = carBody;
        return this;
    }

    public Builder tyre(String tyre) {
        this.tyre = tyre;
        return this;
    }
    public Builder safetyBelt(String safetyBelt) {
        if (safetyBelt == null) throw new NullPointerException("没系安全带，你开个毛车啊");
        this.safetyBelt = safetyBelt;
        return this;
    }
    public Builder engine(String engine) {
        this.engine = engine;
        return this;
    }

    public Builder aimingCircle(String aimingCircle) {
        this.aimingCircle = aimingCircle;
        return this;
    }

    public Builder decoration(String decoration) {
        this.decoration = decoration;
        return this;
    }
    /**
     * 最后创造出实体car
     * @return
     */
    public builderDemo.Car build() {
        return new builderDemo.Car(this);
    }
}
