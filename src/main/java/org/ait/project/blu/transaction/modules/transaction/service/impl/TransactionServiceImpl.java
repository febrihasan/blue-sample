package org.ait.project.blu.transaction.modules.transaction.service.impl;

import java.util.*;

import lombok.RequiredArgsConstructor;
import org.ait.project.blu.transaction.modules.transaction.dto.request.TransactionHistoryRequest;
import org.ait.project.blu.transaction.modules.transaction.dto.request.TransferOnUsRequest;
import org.ait.project.blu.transaction.modules.transaction.dto.request.TransferOtherBankRequest;
import org.ait.project.blu.transaction.modules.transaction.service.TransactionService;
import org.ait.project.blu.transaction.shared.constant.enums.HeadersEnum;
import org.ait.project.blu.transaction.shared.constant.enums.ResponseEnum;
import org.ait.project.blu.transaction.shared.dto.template.ResponseList;
import org.ait.project.blu.transaction.shared.dto.template.ResponseTemplate;
import org.ait.project.blu.transaction.shared.openfeign.blu.TransactionClient;
import org.ait.project.blu.transaction.shared.openfeign.blu.balance.response.BalanceResponseDto;
import org.ait.project.blu.transaction.shared.openfeign.blu.history.response.TransactionHistoryResponseDto;
import org.ait.project.blu.transaction.shared.openfeign.blu.transfer.onus.response.TransferOnUsResponseDto;
import org.ait.project.blu.transaction.shared.openfeign.blu.transfer.otherbank.response.TransferOtherBankResponseDto;
import org.ait.project.blu.transaction.shared.utils.ResponseHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final ResponseHelper responseHelper;

    private final TransactionClient client;

    @Override
    public ResponseEntity<ResponseTemplate<ResponseList<BalanceResponseDto>>>
    getBalance(String accountNo) {

        /*
         * Call feign client to posting transfer on us
         */
        List<BalanceResponseDto> result = client.getBalance(accountNo);

        return responseHelper.createResponseCollection(ResponseEnum.SUCCESS, null,
                Flux.fromIterable(result)) ;
    }

    @Override
    public Mono<TransferOnUsResponseDto> transferOnUs(TransferOnUsRequest transferOnUs) {

        /*
         * Set request headers for transfer on us with blu account
         */
        Map<String, String> headers = new HashMap<>();
        headers.put(HeadersEnum.X_API_KEY.getKey(), "abcdefghij0123456789");
        headers.put(HeadersEnum.CLIENT_ID.getKey(), "blu-digital");
        headers.put(HeadersEnum.COMPANY_CODE.getKey(), "099-099-099");

        /*
         * Call feign client for posting transfer on us with blu account
         */
        TransferOnUsResponseDto result = client.transferOnUs(headers, transferOnUs);

        return Mono.just(result);
    }

    @Override
    public Mono<TransferOtherBankResponseDto> transferOtherBank(TransferOtherBankRequest transferOtherBank,
                                                          String accountNo) {

        /*
         * Set request headers for transfer to another bank
         */
        Map<String, String> headers = new HashMap<>();
        headers.put(HeadersEnum.X_API_KEY.getKey(), "abcdefghij0123456789");
        headers.put(HeadersEnum.CLIENT_ID.getKey(), "blu-digital");
        headers.put(HeadersEnum.COMPANY_CODE.getKey(), "099-099-099");
        headers.put(HeadersEnum.PAYMENT_TYPE_ID.getKey(), "1");
        headers.put(HeadersEnum.PAYMENT_TYPE_NAME.getKey(), "transfer-other-bank");

        /*
         * Call feign client for posting transfer to another bank
         */
        TransferOtherBankResponseDto result = client.transferOtherBank(headers, transferOtherBank, accountNo);

        return Mono.just(result);
    }

    @Override
    public Flux<TransactionHistoryResponseDto> transactionHistory(TransactionHistoryRequest transactionHistoryRequest) {

        /*
         * Set request headers for transaction history
         */
        Map<String, String> headers = new HashMap<>();
        headers.put(HeadersEnum.X_API_KEY.getKey(), "abcdefghij0123456789");
        headers.put(HeadersEnum.ACCOUNT_TYPE.getKey(), "bluAccount");

        /*
         * Call feign client to posting transfer on us
         */
        List<TransactionHistoryResponseDto> result = client.transactionHistory(headers, transactionHistoryRequest);

        return Flux.fromIterable(result);
    }
}
