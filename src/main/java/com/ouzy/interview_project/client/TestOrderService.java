package com.ouzy.interview_project.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

/**
 * @author OUZY
 * 预约订单功能测试类
 *
 */
public class TestOrderService {

    public static void main(String[] args) {
        //创建动态客户端
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient("http://localhost:8080/demo/api?wsdl");
        // 需要密码的情况需要加上用户名和密码
        //client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,PASS_WORD));
        HTTPConduit conduit = (HTTPConduit) client.getConduit();
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(2000);  //连接超时
        httpClientPolicy.setAllowChunking(false);    //取消块编码
        httpClientPolicy.setReceiveTimeout(120000);     //响应超时
        conduit.setClient(httpClientPolicy);
        //client.getOutInterceptors().addAll(interceptors);//设置拦截器
        try{
            Object[] objects = new Object[0];
            // invoke("方法名",参数1,参数2,参数3....);
            // 功能1：查询所有可预约时间段
//          objects = client.invoke("queryOrder");
//          System.out.println("返回数据:" + objects[0]);
            // 功能2：执行预约操作
            objects = client.invoke("doOrder","abc","20191017","1000");
            System.out.println("返回数据:" + objects[0]);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
