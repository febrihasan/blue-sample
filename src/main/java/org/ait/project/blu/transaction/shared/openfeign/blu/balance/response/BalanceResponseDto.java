package org.ait.project.blu.transaction.shared.openfeign.blu.balance.response;

import lombok.Data;

@Data
public class BalanceResponseDto {
	private String savingsProductName;
	private String shortProductName;
	private String accountNo;
	private int savingsProductId;
	private Currency currency;
	private int accountBalance;
	private DepositType depositType;
	private SubStatus subStatus;
	private Status status;
}