package org.ait.project.blu.transaction.shared.openfeign.blu.balance.response;

import lombok.Data;

@Data
public class Status{
	private boolean transferOnHold;
	private String code;
	private boolean rejected;
	private boolean transferInProgress;
	private boolean submittedAndPendingApproval;
	private boolean active;
	private boolean approved;
	private boolean prematureClosed;
	private boolean closed;
	private boolean matured;
	private int id;
	private boolean withdrawnByApplicant;
	private String value;
}