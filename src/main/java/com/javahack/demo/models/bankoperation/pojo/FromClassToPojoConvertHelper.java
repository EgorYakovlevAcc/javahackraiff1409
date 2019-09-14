package com.javahack.demo.models.bankoperation.pojo;

import com.javahack.demo.models.bankoperation.Transaction;

public class FromClassToPojoConvertHelper {
    private FromClassToPojoConvertHelper() {
    }
    public static com.javahack.demo.models.bankoperation.pojo.Transaction convert(Transaction transaction) {
        com.javahack.demo.models.bankoperation.pojo.Transaction transaction1 =
                new com.javahack.demo.models.bankoperation.pojo.Transaction();
        transaction1.setDate(transaction.getDate());
        transaction1.setValue(transaction.getValue());
        return transaction1;
    }
}
