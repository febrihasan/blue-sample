package org.ait.project.blu.transaction.shared.openfeign.blu.balance.response;

import lombok.Data;

@Data
public class Currency{
	private String displayLabel;
	private String code;
	private int decimalPlaces;
	private String nameCode;
	private int inMultiplesOf;
	private String name;
}