package com.bdqn.ssm.controller;
import com.bdqn.ssm.entity.Bill;
import com.bdqn.ssm.entity.Provider;
import com.bdqn.ssm.entity.Role;
import com.bdqn.ssm.entity.User;
import com.bdqn.ssm.service.BillService;
import com.bdqn.ssm.service.ProviderService;
import com.bdqn.ssm.util.Constants;
import com.bdqn.ssm.util.PageSupport;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BillController {
    private Logger logger= Logger.getLogger(UserController.class);
    private BillService bs;
    public BillService getBs() { return bs; }
    public void setBs(BillService bs) { this.bs = bs;}
    private ProviderService ps;
    public ProviderService getPs() { return ps; }
    public void setPs(ProviderService ps) { this.ps = ps; }
    /**
     * 分页查询所有用户信息
     * @param model
     * @param productName
     * @param providerId
     * @param pageIndex
     * @return
     */
    @RequestMapping(value="billlist.html")
    public String getUserList(Model model,
                              @RequestParam(value="productName",required=false) String productName,
                              @RequestParam(value="providerId",required=false) String providerId,
                              @RequestParam(value="isPayment",required=false) String isPayment,
                              @RequestParam(value="pageIndex",required=false) String pageIndex){
        logger.info("getUserList ---- > 用户名queryUserName: " + productName);
        logger.info("getUserList ---- > 角色IDqueryUserRole: " + providerId);
        logger.info("getUserList ---- > 当前页面pageIndex: " + pageIndex);
        Integer _queryUserRole = null;
        Integer _queryIsPayment=null;
        List<Bill> userList = null;
        List<Provider> roleList = null;

        //设置页面容量
        int pageSize = Constants.pageSize;
        //当前页码
        int currentPageNo = 1;
          if(providerId!=null&&!providerId.equals("")){
              _queryUserRole=Integer.parseInt(providerId);
          }


        if(isPayment!=null&&!isPayment.equals("")){
            _queryIsPayment=Integer.parseInt(isPayment);
        }

        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                return "redirect:/syserror.html";
            }
        }
        //总数量（表）
        int totalCount = 0;
        try {
            totalCount = bs.getBillCount(productName,_queryUserRole,_queryIsPayment);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //总页数
        PageSupport pages=new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        System.out.println("输出："+currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();
        //控制首页和尾页
        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }
        try {
            userList = bs.getBillList(productName,_queryUserRole,currentPageNo,_queryIsPayment,pageSize);

            roleList = ps.getProviderList();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute("userList", userList);
        model.addAttribute("roleList", roleList);
        model.addAttribute("queryUserName", productName);
        model.addAttribute("queryUserRole", providerId);
        model.addAttribute("isPayment", isPayment);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currentPageNo", currentPageNo);
        return "billlist";
    }

}
