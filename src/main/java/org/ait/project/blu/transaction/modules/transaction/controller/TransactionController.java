package org.ait.project.blu.transaction.modules.transaction.controller;

import lombok.RequiredArgsConstructor;
import org.ait.project.blu.transaction.modules.transaction.common.PathTransactionApi;
import org.ait.project.blu.transaction.modules.transaction.dto.request.TransactionHistoryRequest;
import org.ait.project.blu.transaction.modules.transaction.dto.request.TransferOnUsRequest;
import org.ait.project.blu.transaction.modules.transaction.dto.request.TransferOtherBankRequest;
import org.ait.project.blu.transaction.modules.transaction.service.TransactionService;
import org.ait.project.blu.transaction.shared.dto.template.ResponseList;
import org.ait.project.blu.transaction.shared.dto.template.ResponseTemplate;
import org.ait.project.blu.transaction.shared.openfeign.blu.balance.response.BalanceResponseDto;
import org.ait.project.blu.transaction.shared.openfeign.blu.history.response.TransactionHistoryResponseDto;
import org.ait.project.blu.transaction.shared.openfeign.blu.transfer.onus.response.TransferOnUsResponseDto;
import org.ait.project.blu.transaction.shared.openfeign.blu.transfer.otherbank.response.TransferOtherBankResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class TransactionController implements TransactionService {

    private final TransactionService transactionService;

    @GetMapping(PathTransactionApi.BALANCE)
    public ResponseEntity<ResponseTemplate<ResponseList<BalanceResponseDto>>>
    getBalance(@PathVariable String accountNo) {
        return transactionService.getBalance(accountNo);
    }

    @PostMapping(PathTransactionApi.TRANSFER_ONUS)
    public Mono<TransferOnUsResponseDto> transferOnUs(@RequestBody TransferOnUsRequest transferOnUs) {
        return transactionService.transferOnUs(transferOnUs);
    }

    @PostMapping(PathTransactionApi.TRANSFER_OTHER_BANK)
    public Mono<TransferOtherBankResponseDto> transferOtherBank(@RequestBody TransferOtherBankRequest transferOtherBank,
                                                          @PathVariable String accountNo) {
        return transactionService.transferOtherBank(transferOtherBank, accountNo);
    }

    @PostMapping(PathTransactionApi.TRANSACTION_HISTORY)
    public Flux<TransactionHistoryResponseDto> transactionHistory(@RequestBody TransactionHistoryRequest transactionHistoryRequest) {
        return transactionService.transactionHistory(transactionHistoryRequest);
    }

}
