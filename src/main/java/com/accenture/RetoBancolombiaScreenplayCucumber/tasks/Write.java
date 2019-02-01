package com.accenture.RetoBancolombiaScreenplayCucumber.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.Keys;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class Write implements Task{
	
	private Target target;
	private String data;
	
	public Write(Target target, String data) {
		this.data = data;
		this.target = target;
	}

	@Override
	@Step("Enter value")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(data).into(target).thenHit(Keys.ENTER));

	}

	public static Write at(Target target, String data) {
		return instrumented(Write.class, target, data) ;
	}

}
