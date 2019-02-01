package com.accenture.RetoBancolombiaScreenplayCucumber.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class TheWarningMessage implements Question<String>{
	
	private Target target;
	
	public TheWarningMessage(Target target) {
		this.target = target;

	}

	@Override
	public String answeredBy(Actor actor) {
		return Text.of(target).viewedBy(actor).asString();
	}
	
	public static TheWarningMessage isPresent(Target target) {		
		return new TheWarningMessage(target);
	}

}
