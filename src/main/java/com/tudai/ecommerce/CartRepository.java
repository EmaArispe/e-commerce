package com.tudai.ecommerce;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisClientConfig;
import redis.clients.jedis.params.SetParams;

import java.util.ArrayList;
import java.util.List;

public class CartRepository {

    private Jedis jedis;
    private Gson gson;

    private final String pathCart = "userCart:";

    private final int TTL = 60;

    public CartRepository() {
        this.gson = new Gson();
        this.jedis = new Jedis("localhost", 6379, new JedisClientConfig() {
            @Override
            public String getPassword() {
                return "root";
            }
        });
    }

    public void addItem(int userId, CartEntry cartEntry) {
        String key = pathCart + String.valueOf(userId);
        String value = this.jedis.get(key);
        SetParams params = new SetParams();
        params.ex(TTL);
        List<CartEntry> entries;
        if (value != null) {
            entries = this.gson.fromJson(value, new TypeToken<ArrayList<CartEntry>>(){}.getType());
        } else {
            entries = new ArrayList<>();
        }
        entries.add(cartEntry);
        this.jedis.set(key, this.gson.toJson(entries), params);
    }
}
