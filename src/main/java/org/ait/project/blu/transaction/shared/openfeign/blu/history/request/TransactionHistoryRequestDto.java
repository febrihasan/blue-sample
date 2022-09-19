package org.ait.project.blu.transaction.shared.openfeign.blu.history.request;

import lombok.Data;

import java.util.List;

@Data
public class TransactionHistoryRequestDto {
	private String transactionTypeValue;
	private String endDate;
	private List<String> accountNo;
	private String lastId;
	private String pageSize;
	private String startDate;
}