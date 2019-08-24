package org.smart4j.framework.controller;

import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.bean.Data;
import org.smart4j.framework.bean.FileParam;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.bean.View;
import org.smart4j.framework.model.Customer;
import org.smart4j.framework.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Action("get:/customer")
    public View index() {
        List<Customer> customerList = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList", customerList);
    }

    @Action("post:/customer_create")
    public Data createSubmit(Param param){
        Map<String,Object> fieldMap = param.getFieldMap();
        FileParam fileParam = param.getFile("photo");
        boolean result = customerService.createCustomer(fieldMap,fileParam);
        return new Data(result);
    }

}
