package org.ait.project.blu.transaction.modules.transaction.service;

import org.ait.project.blu.transaction.modules.transaction.dto.request.TransactionHistoryRequest;
import org.ait.project.blu.transaction.modules.transaction.dto.request.TransferOnUsRequest;
import org.ait.project.blu.transaction.modules.transaction.dto.request.TransferOtherBankRequest;
import org.ait.project.blu.transaction.shared.dto.template.ResponseList;
import org.ait.project.blu.transaction.shared.dto.template.ResponseTemplate;
import org.ait.project.blu.transaction.shared.openfeign.blu.balance.response.BalanceResponseDto;
import org.ait.project.blu.transaction.shared.openfeign.blu.history.response.TransactionHistoryResponseDto;
import org.ait.project.blu.transaction.shared.openfeign.blu.transfer.onus.response.TransferOnUsResponseDto;
import org.ait.project.blu.transaction.shared.openfeign.blu.transfer.otherbank.response.TransferOtherBankResponseDto;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {

    ResponseEntity<ResponseTemplate<ResponseList<BalanceResponseDto>>>
    getBalance(String accountNo);

    Mono<TransferOnUsResponseDto> transferOnUs(TransferOnUsRequest transferOnUs);

    Mono<TransferOtherBankResponseDto> transferOtherBank(TransferOtherBankRequest transferOtherBankRequest, String accountNo);

    Flux<TransactionHistoryResponseDto> transactionHistory(TransactionHistoryRequest transactionHistoryRequest);

}
