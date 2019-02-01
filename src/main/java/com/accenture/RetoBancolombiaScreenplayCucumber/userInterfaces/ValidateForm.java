package com.accenture.RetoBancolombiaScreenplayCucumber.userInterfaces;

import java.util.List;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateForm extends PageObject{
	
	public static final Target WANT_TO_SAVE = Target.the("What do you want to save").locatedBy("//form[@name='formAhorro']//div[2]//div[1]//div[1]//span[1]");
	public static final Target REACH_SAVINGS = Target.the("Reach your savings").locatedBy("//div[@min='1']//span[@class='ng-binding'][contains(text(),'Este campo es obligatorio.')]");
	public static final Target SELECT_PRODUCT = Target.the("Select product").locatedBy("//form[@name='formAhorro']//div[4]//div[1]//div[1]//span[1]");
	public static final Target MONEY_NEED = Target.the("Money do you need to achieve your goal").locatedBy("//form[@name='formAhorro']//div[5]//div[1]//div[1]//span[1]");
	public static final Target BUTTON_PLAN_SAVINGS = Target.the("Button plan savings").locatedBy("//form[@name='formAhorro']//div[8]");
	
	public static final Target SELECT_OPTION = Target.the("Select option").locatedBy("//select[@name='nmSelectAhorro']");
	public static final Target MONTHS = Target.the("Months savings").locatedBy("//input[@name='nmMesesAhorro']");
	public static final Target PRODUCT = Target.the("Select product").locatedBy("//select[@name='nmselectProducto']");
	public static final Target MONEY_GOAL = Target.the("Money need you goal").locatedBy("//input[@name='nmCantidadAhorro']");
	
	public Target option(String option) {

		Target OPTIONS_SELECT_SAVE = Target.the("Option what do you want to save")
				.locatedBy("//select[@name='nmSelectAhorro']/option[text() ='" + option + "']");
		return OPTIONS_SELECT_SAVE;
	}
	
	public Target options(String optionProduct) {
		Target OPTIONS_SELECT_PRODUCT = Target.the("Select prodcut")
				.locatedBy("//select[@name='nmselectProducto']/option[text() ='"+optionProduct+"']");
		return OPTIONS_SELECT_PRODUCT;
	}
	
	public List<WebElementFacade> listOption(){
		List<WebElementFacade> listOptions = findAll(By.xpath("//select[@name='nmSelectAhorro']/option"));
		return listOptions;
	}
	
	public List<WebElementFacade> listMoney(){
		List<WebElementFacade> listMoney = findAll(By.xpath("//select[@name='nmselectProducto']/option"));
		return listMoney;
	}
	

}
