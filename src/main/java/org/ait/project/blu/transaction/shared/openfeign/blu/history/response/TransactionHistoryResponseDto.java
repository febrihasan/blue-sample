package org.ait.project.blu.transaction.shared.openfeign.blu.history.response;

import lombok.Data;

import java.util.List;

@Data
public class TransactionHistoryResponseDto {
	private String accountNo;
	private int lastId;
	private List<TransactionHistoryItem> transactionHistory;
}