package BravoListener;

/**
 * 短信服务类，监听用户下单事件。只要下单成功，就会监听到
 */
public class SmsService implements BravoApplicationListener<OrderSuccessEvent> {
    /**
     * 事件下单成功的监听回调方法
     * @param event
     */
    @Override
    public void onApplicationEvent(OrderSuccessEvent event) {
        // 调用方法，发送短信
        this.sendSms();
    }

    public void sendSms() {
        try {
            Thread.sleep(1000L * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("发送短信成功...");
    }
}
