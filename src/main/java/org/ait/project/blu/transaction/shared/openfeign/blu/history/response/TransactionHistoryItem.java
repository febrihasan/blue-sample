package org.ait.project.blu.transaction.shared.openfeign.blu.history.response;

import lombok.Data;

import java.util.List;

@Data
public class TransactionHistoryItem{
	private List<Integer> date;
	private int amount;
	private boolean interestedPostedAsOn;
	private String submittedByUsername;
	private PaymentDetailData paymentDetailData;
	private String productName;
	private TransactionType transactionType;
	private int accountId;
	private Transfer transfer;
	private String createdDate;
	private String accountNo;
	private Currency currency;
	private int id;
	private double runningBalance;
	private boolean reversed;
}