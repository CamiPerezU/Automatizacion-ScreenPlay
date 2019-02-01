package com.accenture.RetoBancolombiaScreenplayCucumber.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.CurrentlyEnabled;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateBotton implements Question<Boolean>{
	
	private Target target;
	
	public ValidateBotton(Target target) {
		this.target = target;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		return CurrentlyEnabled.of(target).viewedBy(actor).asBoolean();
	}
	
	public static ValidateBotton on(Target target) {
		return new ValidateBotton(target);
	}

}
