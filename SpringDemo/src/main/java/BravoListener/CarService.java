package BravoListener;

/**
 * @author bravo
 * @date 2020-02-09 18:09
 */
public class CarService implements BravoApplicationListener<OtherEvent> {

    @Override
    public void onApplicationEvent(OtherEvent event) {
        System.out.println("监听到OtherEvent，CarService执行了");
    }
}
