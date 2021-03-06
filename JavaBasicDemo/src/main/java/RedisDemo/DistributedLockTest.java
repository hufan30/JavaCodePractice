package RedisDemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

import java.util.UUID;

/**
 * @author hufan
 * @date 2020/7/4 9:00 下午
 * @annotation
 */
public class DistributedLockTest {
    public static void main(String[] args) throws InterruptedException {
        //10个客户端
        //get key
        //+1
        //set key
        //这里默认的jedisPool,应该是默认本地6379端口；
        JedisPool jedisPool = new JedisPool();
        DistributedLock distributedLock = new DistributedLock();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {

                try (Jedis jedis = jedisPool.getResource();) {
                    String uuid = distributedLock.lock(jedis);
                    String key = jedis.get("key");
                    if (key == null) {
                        key = "1";
                    } else {
                        key = "" + (Integer.parseInt(key) + 1);
                    }
                    jedis.set("key", key);
                    System.out.println(key);
                    distributedLock.unlock(jedis,uuid);
                }
            }).start();
        }
        Thread.sleep(5000);
    }
}

class DistributedLock {

    public DistributedLock() {
    }

    /**
     * 分布式锁，这里先向里面set if not exist;
     * 若是锁被别人拿了就一直循环，联系到乐观锁的概念；
     * @param jedis
     * @return
     */
    String lock(Jedis jedis) {
        String uuid = UUID.randomUUID().toString();

        while (true) {
            Long num = jedis.setnx("lock", uuid);
            if (num == 1) {
                System.out.println("LOCK"+uuid);
                return uuid;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            init();
        }
    }

    void init(){
        final Thread thread = new Thread(() -> {
            final Jedis jedis = new Jedis();
            jedis.subscribe(new JedisPubSub() {
                @Override
                public void onMessage(String channel, String message) {
                    System.out.println(channel+message);
                }
            }, "DistributedLock");
        });
        thread.setDaemon(true);
        thread.start();
    }

    void unlock(Jedis jedis,String uuid) {
        try {
            while(true) {
                String num = jedis.get("lock");
                if (num.equals(uuid)) {
                    System.out.println("Unlock!");
                    jedis.del("lock");
                    return;
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
           throw new RuntimeException(e);
        }
    }
}

