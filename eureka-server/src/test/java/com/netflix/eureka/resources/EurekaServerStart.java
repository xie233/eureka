package com.netflix.eureka.resources;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;



//添加server 调试
public class EurekaServerStart {
    private static Server server;

    public static void main(String[] args) throws Exception{

        startServer();

    }

    private static void startServer() throws Exception {
        server = new Server(8671);

        WebAppContext webAppCtx = new WebAppContext(new File("F:/a_java/eurekaFun/eureka/eureka-server/src/main/webapp").getAbsolutePath(), "/");
        webAppCtx.setDescriptor(new File("F:/a_java/eurekaFun/eureka/eureka-server/src/main/webapp/WEB-INF/web.xml").getAbsolutePath());
        webAppCtx.setResourceBase(new File("F:/a_java/eurekaFun/eureka/eureka-server/src/main/resources").getAbsolutePath());
        webAppCtx.setClassLoader(Thread.currentThread().getContextClassLoader());
        server.setHandler(webAppCtx);
        server.start();


    }

}
