package org.ait.project.blu.transaction.shared.openfeign.blu.balance.response;

import lombok.Data;

@Data
public class DepositType{
	private String code;
	private int id;
	private String value;
}