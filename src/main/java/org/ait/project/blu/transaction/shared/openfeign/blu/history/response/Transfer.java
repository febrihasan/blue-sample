package org.ait.project.blu.transaction.shared.openfeign.blu.history.response;

import lombok.Data;

import java.util.List;

@Data
public class Transfer{
	private String transferDescription;
	private String savingsAccount;
	private String clientName;
	private int transferAmount;
	private Currency currency;
	private int id;
	private List<Integer> transferDate;
	private boolean reversed;
}