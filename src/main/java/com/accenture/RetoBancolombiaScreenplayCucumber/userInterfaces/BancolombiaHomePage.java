package com.accenture.RetoBancolombiaScreenplayCucumber.userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.grupobancolombia.com/wps/portal/acerca-de")
public class BancolombiaHomePage extends PageObject{
		
	public static final Target SELECT_PEOPLE = Target.the("Select people").locatedBy("//li[@id='linkPersonas']");
	public static final Target SELECT_NEED = Target.the("Select need").locatedBy("//a[contains(text(),'Necesidades')]");
	public static final Target SELECT_CAR_AND_MOTORCYCLE= Target.the("Carro o Moto").locatedBy("//a[contains(text(),'Carro')]");
	public static final Target BUTTON_SIMULATOR= Target.the("Button simulator").locatedBy("//a[@title='null']");
}
