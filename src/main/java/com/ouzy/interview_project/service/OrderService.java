package com.ouzy.interview_project.service;

import javax.jws.WebService;

/**
 * @author OUZY
 * 预约功能接口类
 */
@WebService(name = "OrderService", // 暴露服务名称
        targetNamespace = "http://service.interview_project.ouzy.com"// 命名空间,一般是接口的包名倒序
)
public interface OrderService {

    /**
     * 查询所有可预约时间功能
     * @return
     */
    public String queryOrder();

    /**
     * 预约某时间段的服务功能
     * @param yy_date
     * @param yy_time
     * @return
     */
    public String doOrder(String yy_date, String yy_time);
}
