package com.alibaba.dubbo.demo.provider;

import com.alibaba.dubbo.demo.DemoService;

/**
 * Created by 46043 on 2017/7/13.
 */
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
