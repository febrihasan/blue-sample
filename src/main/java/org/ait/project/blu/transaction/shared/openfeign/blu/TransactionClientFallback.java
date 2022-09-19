package org.ait.project.blu.transaction.shared.openfeign.blu;

import java.util.List;
import java.util.Map;
import org.ait.project.blu.transaction.modules.transaction.dto.request.TransactionHistoryRequest;
import org.ait.project.blu.transaction.modules.transaction.dto.request.TransferOnUsRequest;
import org.ait.project.blu.transaction.modules.transaction.dto.request.TransferOtherBankRequest;
import org.ait.project.blu.transaction.shared.openfeign.blu.balance.response.BalanceResponseDto;
import org.ait.project.blu.transaction.shared.openfeign.blu.history.response.TransactionHistoryResponseDto;
import org.ait.project.blu.transaction.shared.openfeign.blu.transfer.onus.response.TransferOnUsResponseDto;
import org.ait.project.blu.transaction.shared.openfeign.blu.transfer.otherbank.response.TransferOtherBankResponseDto;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.stereotype.Component;

@Component
public class TransactionClientFallback implements TransactionClient {

  /**.
   * When Openfeign Call failed, then do this
   */

    @Override
    public List<BalanceResponseDto> getBalance(String accountNo) {
        System.out.println("Error: " + accountNo);
        throw new NoFallbackAvailableException("Balance not found",
                new RuntimeException());
    }

    @Override
    public TransferOnUsResponseDto transferOnUs(Map<String, String> headers,
                                                          TransferOnUsRequest transferOnUs) {
        throw new NoFallbackAvailableException("Transfer is failed",
                new RuntimeException());
    }

    @Override
    public TransferOtherBankResponseDto transferOtherBank(Map<String, String> headers,
                                                                    TransferOtherBankRequest transferOtherBank,
                                                                    String accountNo) {
        throw new NoFallbackAvailableException("Transfer to another bank is failed",
                new RuntimeException());
    }

    @Override
    public List<TransactionHistoryResponseDto> transactionHistory(Map<String, String> headers, TransactionHistoryRequest transactionHistoryRequest) {
        throw new NoFallbackAvailableException("Transaction history is failed",
                new RuntimeException());
    }
}
