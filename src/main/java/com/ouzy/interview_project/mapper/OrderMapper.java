package com.ouzy.interview_project.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Mapper
public interface OrderMapper {

    /**
     * 查询可预约时间
     * @return
     */
    public List queryOrder();

    /**
     * 获取预约信息表id
     * @return
     */
    public String queryOrderId();

    /**
     * 查询某个时间段内可预约次数
     * @return
     */
    public int queryOrderNum(Map map);

    /**
     * 更新可预约信息表
     * @param map
     * @return
     */
    public int updateOrderAll(Map map);

    /**
     * 执行预约
     * @param map
     * @return
     */
    public int doOrder(Map map);
}
