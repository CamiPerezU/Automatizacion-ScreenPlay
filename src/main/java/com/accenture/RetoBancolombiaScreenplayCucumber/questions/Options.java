package com.accenture.RetoBancolombiaScreenplayCucumber.questions;

import com.accenture.RetoBancolombiaScreenplayCucumber.userInterfaces.ValidateForm;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Options implements Question<Integer>{
	
	private ValidateForm validateForm;
	
	public Options() {
		
	}

	@Override
	public Integer answeredBy(Actor actor) {
		System.out.println(validateForm.listOption().size());
		return validateForm.listOption().size();
	}
	
	public static Options at() {
		return new Options();		
	}

}
