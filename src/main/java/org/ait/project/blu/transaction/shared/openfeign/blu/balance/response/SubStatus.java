package org.ait.project.blu.transaction.shared.openfeign.blu.balance.response;

import lombok.Data;

@Data
public class SubStatus{
	private String code;
	private boolean inactive;
	private boolean dormant;
	private boolean escheat;
	private boolean blockDebit;
	private boolean block;
	private int id;
	private boolean none;
	private boolean blockCredit;
	private String value;
}