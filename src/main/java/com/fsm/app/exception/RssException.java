package com.fsm.app.exception;

import javax.xml.bind.JAXBException;

import org.hibernate.metamodel.domain.Superclass;

public class RssException extends Exception {
	public RssException(Throwable cause) {
		super(cause);
	}

	public RssException(JAXBException e) {
		super(e);
	}
}
