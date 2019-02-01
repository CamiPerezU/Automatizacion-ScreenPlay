package com.accenture.RetoBancolombiaScreenplayCucumber.questions;

import com.accenture.RetoBancolombiaScreenplayCucumber.userInterfaces.ValidateForm;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class OptionsProduct implements Question<Integer>{
	
private ValidateForm validateForm;
	
	public OptionsProduct() {
		
	}

	@Override
	public Integer answeredBy(Actor actor) {
		System.out.println(validateForm.listMoney().size());
		return validateForm.listMoney().size();
	}
	
	public static OptionsProduct at() {
		return new OptionsProduct();		
	}

}
