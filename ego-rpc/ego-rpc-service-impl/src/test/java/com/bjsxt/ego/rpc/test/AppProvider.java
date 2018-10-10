package com.bjsxt.ego.rpc.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class AppProvider {

    @Test
    public void test() throws IOException {
        String[] configLocations=new String[]{"applicationContext_mapper.xml",
                "applicationContext_dubbo.xml",
                "applicationContext_service.xml",
                "applicationContext_tx.xml","aplicationContext_cache.xml"};

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(configLocations);
        System.out.println(ac);
        ac.start();
        System.out.println("服务启动");
        System.in.read();

    }

}
