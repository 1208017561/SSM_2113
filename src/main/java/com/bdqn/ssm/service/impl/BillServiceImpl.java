package com.bdqn.ssm.service.impl;
import com.bdqn.ssm.dao.BillDao;
import com.bdqn.ssm.entity.Bill;
import com.bdqn.ssm.service.BillService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Resource
    private BillDao bd;
    public BillDao getBd() { return bd; }
    public void setBd(BillDao bd) { this.bd = bd; }


    @Override
    public List<Bill> getBillList(String productName, Integer queryProviderId, Integer pageIndex, Integer isPayment, Integer pageSize) {
        return bd.getBillList(productName,queryProviderId,pageIndex,isPayment,pageSize);
    }

    @Override
    public int getBillCount(String productName, Integer queryProviderId, Integer isPayment) {
        return bd.getBillCount(productName,queryProviderId,isPayment);
    }

    /**
     * 添加用户信息
     * @param
     * @return
     */
    @Override
    public void addBill(Bill bill) {
        bd.addBill(bill);
    }
    /**
     * 修改用户信息
     * @param bill
     */
    @Override
    public void updateBill(Bill bill) {
     bd.addBill(bill);
    }
    /**
     * 删除用户信息
     * @param bill
     */
    @Override
    public void delete(Bill bill) {
        bd.addBill(bill);
    }
    /**
     * 通过id查询用户信息
     * @param bid
     * @return
     */
    @Override
    public Bill getBillById(String bid) {
        return bd.getBillById(bid);
    }
}
