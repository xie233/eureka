package com.netflix;

import com.netflix.appinfo.*;

import com.netflix.discovery.DefaultEurekaClientConfig;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClientConfig;

import com.netflix.discovery.util.InstanceInfoGenerator;



public class ClientTest {
    private static DiscoveryClient discoveryClient;



//添加 client 调试
    public static void main(String[] args) throws Throwable{

        new Thread(()->{

                InstanceInfo instanceInfo = InstanceInfoGenerator.takeMore(3,4,8082);
                EurekaClientConfig clientConfig = new DefaultEurekaClientConfig();
                EurekaInstanceConfig eurekaInstanceConfig = new MyDataCenterInstanceConfig();
                ApplicationInfoManager applicationInfoManager = new ApplicationInfoManager(eurekaInstanceConfig,instanceInfo);
                discoveryClient = new DiscoveryClient(applicationInfoManager,clientConfig);

        },"t1").start();
        new Thread(()->{

                InstanceInfo instanceInfo2 = InstanceInfoGenerator.takeMore(3,4,8088);
                EurekaClientConfig clientConfig2 = new DefaultEurekaClientConfig();
                EurekaInstanceConfig eurekaInstanceConfig = new MyDataCenterInstanceConfig();
                ApplicationInfoManager applicationInfoManager = new ApplicationInfoManager(eurekaInstanceConfig,instanceInfo2);
                discoveryClient = new DiscoveryClient(applicationInfoManager,clientConfig2);

        },"t2").start();

Thread.sleep(Long.MAX_VALUE);


    }
}
