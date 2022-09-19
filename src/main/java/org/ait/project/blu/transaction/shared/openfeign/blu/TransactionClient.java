package org.ait.project.blu.transaction.shared.openfeign.blu;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.ait.project.blu.transaction.config.openfeign.OpenFeignConfig;
import org.ait.project.blu.transaction.modules.transaction.dto.request.TransactionHistoryRequest;
import org.ait.project.blu.transaction.modules.transaction.dto.request.TransferOnUsRequest;
import org.ait.project.blu.transaction.modules.transaction.dto.request.TransferOtherBankRequest;
import org.ait.project.blu.transaction.shared.constant.common.PathBluClientAPIs;
import org.ait.project.blu.transaction.shared.openfeign.blu.balance.response.BalanceResponseDto;
import org.ait.project.blu.transaction.shared.openfeign.blu.history.response.TransactionHistoryResponseDto;
import org.ait.project.blu.transaction.shared.openfeign.blu.transfer.onus.response.TransferOnUsResponseDto;
import org.ait.project.blu.transaction.shared.openfeign.blu.transfer.otherbank.response.TransferOtherBankResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
    value = "${app.feign.config.name}",
    url = "${app.feign.config.url}",
    path = "${app.feign.config.path}",
    configuration = OpenFeignConfig.class,
    fallback = TransactionClientFallback.class
)
public interface TransactionClient {

    @GetMapping(PathBluClientAPIs.BALANCE)
    List<BalanceResponseDto> getBalance(@PathVariable String accountNo);

    @PostMapping(PathBluClientAPIs.TRANSFER_ONUS)
    TransferOnUsResponseDto transferOnUs(@RequestHeader Map<String, String> headers,
                                                   @RequestBody TransferOnUsRequest transferOnUs);

    @PostMapping(PathBluClientAPIs.TRANSFER_OTHER_BANK)
    TransferOtherBankResponseDto transferOtherBank(@RequestHeader Map<String, String> headers,
                                                         @RequestBody TransferOtherBankRequest transferOtherBank,
                                                         @PathVariable String accountNo);

    @PostMapping(PathBluClientAPIs.TRANSACTION_HISTORY)
    List<TransactionHistoryResponseDto> transactionHistory(@RequestHeader Map<String, String> headers,
                                                           @RequestBody TransactionHistoryRequest transactionHistoryRequest);

}
