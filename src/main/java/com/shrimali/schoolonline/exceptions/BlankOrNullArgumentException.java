package com.shrimali.schoolonline.exceptions;

public class BlankOrNullArgumentException extends Exception {

	private static final long serialVersionUID = 8553424126739230219L;

	public BlankOrNullArgumentException() {
		super();
	}

	public BlankOrNullArgumentException(String msg) {
		super(msg);
	}
}
