package com.xiaoyi.models.payments;

import com.xiaoyi.exceptions.NegativeBalanceException;
import com.xiaoyi.models.interfaces.Payment;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class Paypal implements Payment {

    private BigDecimal balance;

    @Override
    public void pay(BigDecimal amount) {
        if (amount.compareTo(balance) > 0) {
            throw new NegativeBalanceException(String.format("Payment rejected because current balance %s is less then " +
                    "requested amount %s", balance.toString(), amount.toString()));
        }
        balance = balance.subtract(amount);
    }

    @Override
    public BigDecimal checkBalance() {
        return balance;
    }
}
