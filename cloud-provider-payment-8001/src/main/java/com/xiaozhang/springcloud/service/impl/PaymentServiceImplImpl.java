package com.xiaozhang.springcloud.service.impl;

import com.xiaozhang.springcloud.dao.PaymentDao;
import com.xiaozhang.springcloud.entities.Payment;
import com.xiaozhang.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auther: ZhangH
 * @date: 2020/12/25 16:13
 * @version: 1.0
 */
@Service
public class PaymentServiceImplImpl implements PaymentService {

    @Resource
    private  PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
