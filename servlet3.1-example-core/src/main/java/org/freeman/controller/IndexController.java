package org.freeman.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by freeman on 2016/5/10.
 */
@RestController
public class IndexController {

    private static final ExecutorService executor = Executors.newFixedThreadPool(100);

    public IndexController() {
        System.out.println("init ");
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public Map<String, Object> index() {
        Map<String, Object> result = new HashMap<String, Object>(10);
        for (int i = 0; i < 10; i++) {
            result.put(String.valueOf(i), String.valueOf(i));
        }
        return result;
    }

    @RequestMapping("async")
    public Callable<Map<String, Object>> processUpload(HttpServletRequest request,
                                                       final HttpServletResponse response) {
        System.out.println("线程名称：" + Thread.currentThread().getName());

        return () -> {
            System.out.println("线程名称：" + Thread.currentThread().getName());
            Map<String, Object> result = new HashMap<String, Object>(10);
            for (int i = 0; i < 10; i++) {
                result.put(String.valueOf(i), String.valueOf(i));
            }
            Thread.sleep(2000);
            return result;
        };
    }


}

