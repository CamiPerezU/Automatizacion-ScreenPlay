package com.accenture.RetoBancolombiaScreenplayCucumber.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

public class ButtonVisible implements Question<Boolean>{
	
	private final Target target;

	
	public ButtonVisible(Target target) {
		this.target=target;

	}

	@Override
	public Boolean answeredBy(Actor actor) {
		return Visibility.of(target).viewedBy(actor).asBoolean();
	}
	
	public static ButtonVisible on(Target target) {		
		return new ButtonVisible(target);
	}

}
