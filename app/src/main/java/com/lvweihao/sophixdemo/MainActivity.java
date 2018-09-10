package com.lvweihao.sophixdemo;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(1024){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return super.sizeOf(key, value);
            }

            @Override
            protected void entryRemoved(boolean evicted, String key, Bitmap oldValue, Bitmap newValue) {
                super.entryRemoved(evicted, key, oldValue, newValue);
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap(0, 0.75f, true);
        linkedHashMap.put(0, 0);
        linkedHashMap.put(1, 1);
        linkedHashMap.put(2, 2);
        linkedHashMap.put(3, 3);
        linkedHashMap.put(4, 4);
        linkedHashMap.put(5, 5);
        linkedHashMap.put(6, 6);
        linkedHashMap.put(7, 7);
        Object a = linkedHashMap.put(8, 8);
        Object b = linkedHashMap.put(8, 9);
        linkedHashMap.get(0);
        linkedHashMap.get(2);

        for (Map.Entry<Integer, Integer> key : linkedHashMap.entrySet()) {
            Log.e("lwh", key.getKey() + ": " + key.getValue());
        }
    }
}
