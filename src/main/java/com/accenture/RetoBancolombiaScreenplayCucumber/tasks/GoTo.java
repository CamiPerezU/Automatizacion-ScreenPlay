package com.accenture.RetoBancolombiaScreenplayCucumber.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class GoTo implements Task{
	
private Target bancolombiaPortal;
	
	public GoTo(Target bancolombiaPortal) {
		this.bancolombiaPortal = bancolombiaPortal;
	}
	
	@Override
	@Step("Page Simulator")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(bancolombiaPortal));
	}

	public static GoTo thePage(Target bancolombiaPortal) {		
		return instrumented(GoTo.class, bancolombiaPortal);
	}

}
