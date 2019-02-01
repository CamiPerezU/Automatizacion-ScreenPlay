package com.accenture.RetoBancolombiaScreenplayCucumber.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.CurrentlyEnabled;
import net.serenitybdd.screenplay.targets.Target;

public class ButtonEnabled implements Question<Boolean>{
	
	private final Target target;

	
	public ButtonEnabled(Target target) {
		this.target=target;

	}

	@Override
	public Boolean answeredBy(Actor actor) {
		return CurrentlyEnabled.of(target).viewedBy(actor).asBoolean();
	}
	
	public static ButtonEnabled isNotEnabled(Target target) {		
		return new ButtonEnabled(target);
	}

}
