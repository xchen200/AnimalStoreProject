package com.xiaoyi.models.interfaces;

import java.math.BigDecimal;

public interface Payment {
    public void pay(BigDecimal amount);

    public BigDecimal checkBalance();

}
