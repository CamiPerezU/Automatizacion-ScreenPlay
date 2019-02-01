package com.accenture.RetoBancolombiaScreenplayCucumber.questions;

import com.accenture.RetoBancolombiaScreenplayCucumber.userInterfaces.ValidateForm;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Enabled;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateSelect implements Question<String>{
	
	private String option;
	private ValidateForm validateForm;
	
	public ValidateSelect(String option) {
		this.option = option;
	}

	@Override
	public String answeredBy(Actor actor) {
		Target target=validateForm.option(option);
		System.out.println(target);
		if(Enabled.of(target).viewedBy(actor).asBoolean()==true) {
			System.out.println("La opción "+option+" se encuentra en el campo");
		}
		else {
			System.out.println("La opción"+option+ " no se encuentra en el campo");
		}
		return Text.of(target).viewedBy(actor).asString();
	}
	
	public static ValidateSelect on(String option) {		
		return new ValidateSelect (option);
	}

}
