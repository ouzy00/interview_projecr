package com.ouzy.interview_project.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.ouzy.interview_project.mapper.OrderMapper;
import com.ouzy.interview_project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author OUZY
 * 预约功能实现类
 */
@WebService(serviceName = "OrderService", // 与接口中指定的name一致
        targetNamespace = "http://service.interview_project.ouzy.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.ouzy.interview_project.service.OrderService"// 接口地址
)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;


    /**
     * 查询所有可预约时间功能
     * @return
     */
    @Override
    public String queryOrder() {
        List list = orderMapper.queryOrder();
        String result = JSONArray.toJSONString(list);
        return result;
    }

    /**
     * 预约某时间段的服务功能
     * @param yy_date
     * @param yy_time
     * @return
     */
    @Override
    public String doOrder(String yy_date, String yy_time) {
        //获取预约信息表id
        String id = orderMapper.queryOrderId();
        Map map = new HashMap();
        map.put("id",id);
        map.put("yy_date",yy_date);//预约日期
        map.put("yy_time",yy_time);//预约时间段

        //当前日期
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyyMMdd");
        String nowDate = dateFormat.format(date);

        //预约日期校验
        if ((Long.parseLong(yy_date) < Long.parseLong(nowDate)+2) || (Long.parseLong(yy_date) > Long.parseLong(nowDate)+7)){
            return "401"; //401:“所选日期不在可预约日期范围内”
        }

        //预约时间校验
        if ((Long.parseLong(yy_time) < 900) || (Long.parseLong(yy_time) > 1500)){
            return "402"; //402:“所选时间不在可预约时间范围内”
        }

        //查询校验是否可预约
        int num = orderMapper.queryOrderNum(map);
        if (num == 0){
            return "403";//403:“所选时间不在可预约时间范围内”
        }

        //执行预约操作
        orderMapper.doOrder(map);
        orderMapper.updateOrderAll(map);
        return "预约成功";
    }
}
