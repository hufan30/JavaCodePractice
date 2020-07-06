package RedisDemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

/**
 * @author hufan
 * @date 2020/7/6 2:42 下午
 * @annotation
 */
public class RedisPubSubTest {
    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool();
        SubThread subThread = new SubThread(jedisPool);
        SubThread subThread2 = new SubThread(jedisPool);
        subThread.start();
        subThread2.start();

        //这里留意到此处的jedis和订阅的jedis不是同一个；
        try(Jedis jedis = jedisPool.getResource()) {
            for (int i = 0; i < 10; i++) {
                jedis.publish("myChannel", String.valueOf(i));
            }
        }

    }
}

class MySub extends JedisPubSub {
    @Override
    public void onMessage(String channel, String message) {
        System.out.println(channel + ":" + message);
    }
}

class SubThread extends Thread {

    JedisPool pool;

    public SubThread(JedisPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        try (Jedis jedis = pool.getResource()) {
            jedis.subscribe(new MySub(), "myChannel");
        }
    }
}
