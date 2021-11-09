package com.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class DamageNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	public DamageNotFoundException(String message){
        super(message);
    }

}

