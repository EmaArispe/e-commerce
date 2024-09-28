package com.tudai.ecommerce;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisClientConfig;

public class EccmmerceServer {

    private CartRepository repository;

    public EccmmerceServer() {
        this.repository = new CartRepository();
    }

    public void addItem(int userId, CartEntry cartEntry) {
        this.repository.addItem(userId, cartEntry);
    }

}
