package com.accenture.RetoBancolombiaScreenplayCucumber.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
//import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateMonths implements Question<Boolean>{
	
	private Target target;
	
	public ValidateMonths(Target target) {
		this.target = target;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		return CurrentVisibility.of(target).viewedBy(actor).asBoolean();
	}
	
	public static ValidateMonths at(Target target) {
		return new ValidateMonths(target);
	}

}
