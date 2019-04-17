package com.bdqn.ssm.dao;
import com.bdqn.ssm.entity.Bill;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.Max;
import java.util.List;

public interface BillDao {
    //分页查询账单信息
    public List<Bill> getBillList(@Param("productName") String productName,
                                  @Param("queryProviderId")Integer queryProviderId,
                                  @Param("pageIndex")Integer pageIndex,
                                  @Param("isPayment" )Integer isPayment,
                                  @Param("pageSize")Integer pageSize);

    //统计账单总记录数
    public  int getBillCount(@Param("productName")String productName,
                             @Param("queryProviderId")Integer queryProviderId,
                             @Param("isPayment" )Integer isPayment);

    //添加订单信息
    public void addBill(Bill bill);

    //修改订单信息
    public  void updateBill(Bill bill);

    //删除订单信息
    public  void delete(Bill bill);

    //通过ID查询订单记录
    public  Bill getBillById(String bid);
}
