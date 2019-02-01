package com.accenture.RetoBancolombiaScreenplayCucumber.stepDefinitions;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.containsString;

import org.openqa.selenium.WebDriver;

import com.accenture.RetoBancolombiaScreenplayCucumber.exceptions.MessageErrorPage;
import com.accenture.RetoBancolombiaScreenplayCucumber.interations.Tab;
import com.accenture.RetoBancolombiaScreenplayCucumber.questions.ButtonEnabled;
import com.accenture.RetoBancolombiaScreenplayCucumber.questions.ButtonVisible;
import com.accenture.RetoBancolombiaScreenplayCucumber.questions.Options;
import com.accenture.RetoBancolombiaScreenplayCucumber.questions.OptionsProduct;
import com.accenture.RetoBancolombiaScreenplayCucumber.questions.TheWarningMessage;
import com.accenture.RetoBancolombiaScreenplayCucumber.questions.ValidateBotton;
import com.accenture.RetoBancolombiaScreenplayCucumber.questions.ValidateMonths;
import com.accenture.RetoBancolombiaScreenplayCucumber.questions.ValidateSelect;
import com.accenture.RetoBancolombiaScreenplayCucumber.tasks.GoTo;
import com.accenture.RetoBancolombiaScreenplayCucumber.tasks.OpenTheBrowser;
import com.accenture.RetoBancolombiaScreenplayCucumber.tasks.Write;
import com.accenture.RetoBancolombiaScreenplayCucumber.userInterfaces.BancolombiaHomePage;
import com.accenture.RetoBancolombiaScreenplayCucumber.userInterfaces.ValidateForm;
import com.accenture.RetoBancolombiaScreenplayCucumber.utils.DataExcel;
import com.accenture.RetoBancolombiaScreenplayCucumber.utils.ExcelReader;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

public class BancolombiaStepDefinitions {

	@Managed(driver = "chrome")
	private WebDriver herBrowser;

	private Actor camila = Actor.named("Camila");
	
	private BancolombiaHomePage bancolombiaHomePage;
	
	@Before
	public void setUp() {
		camila.can(BrowseTheWeb.with(herBrowser));
		herBrowser.manage().window().maximize();

	}
	
	@Given("^que Accenture Testing se encuentra en el formulario de Bancolombia simulador de ahorro$")
	public void queAccentureTestingSeEncuentraEnElFormularioDeBancolombiaSimuladorDeAhorro() {
		camila.wasAbleTo(OpenTheBrowser.at(bancolombiaHomePage), GoTo.thePage(BancolombiaHomePage.SELECT_PEOPLE),
				GoTo.thePage(BancolombiaHomePage.SELECT_NEED), GoTo.thePage(BancolombiaHomePage.SELECT_CAR_AND_MOTORCYCLE),
				GoTo.thePage(BancolombiaHomePage.BUTTON_SIMULATOR), Tab.Change(herBrowser));
		
	}
	
	//Primer scenario when
	@When("^camila quiere validar que cada uno de los campos son obligatorios$")
	public void camilaQuiereValidarQueCadaUnoDeLosCamposSonObligatorios() {
		System.out.println("Se Ejecuto el when");		
	}
	
	//Segundo Escenario when
	@When("^camila quiere validar que se encuentran cada elemento de la lista desplegable$")
	public void validarListaDesplegable() {
		camila.attemptsTo(GoTo.thePage(ValidateForm.SELECT_OPTION));				
	}
	
	//Tercer escenario when
	@When("^camila quiere llenar el campo$")
	public void camilaQuiereLlenarElCampo() {
		String data = "5";
		camila.attemptsTo(Write.at(ValidateForm.MONTHS, data));		
	}
	
	//Cuarto escenario when
	@When("^camila quiere validar que al seleccionar un elemento en el campo para que quieres ahorrar pero saldra un error el cual \"([^\"]*)\"$")
	public void validarCampoParaQueQuieresAhorrar(String errorMessage) {
		camila.attemptsTo(GoTo.thePage(ValidateForm.PRODUCT));
		
	}
	
	//Quinto escenario when
	@When("^camila quiere completar el formulario llenado el ultimo campo del formulario$")
	public void camilaQuiereCompletarElFormularioLlenadoElUltimoCampoDelFormulario() {
		String data = "10";
		camila.attemptsTo(Write.at(ValidateForm.MONEY_GOAL, data));
	}
	
	
	
	//Primer escenario then
	@Then("^ella espera que cada uno de los campos tenga la alerta$")
	public void ellaEsperaQueCadaUnoDeLosCamposTengaLaAlerta() {
		camila.should(eventually(seeThat(TheWarningMessage.isPresent(ValidateForm.WANT_TO_SAVE), containsString("Este campo es obligatorio."))),
				seeThat(TheWarningMessage.isPresent(ValidateForm.REACH_SAVINGS), containsString("Este campo es obligatorio.")),
				seeThat(TheWarningMessage.isPresent(ValidateForm.SELECT_PRODUCT), containsString("Este campo es obligatorio.")),
				seeThat(TheWarningMessage.isPresent(ValidateForm.MONEY_NEED), containsString("Este campo es obligatorio.")),
				seeThat(ButtonVisible.on(ValidateForm.BUTTON_PLAN_SAVINGS)), seeThat(ButtonEnabled.isNotEnabled(ValidateForm.BUTTON_PLAN_SAVINGS)));
	}
	
	//Segundo escenario then
	@Then("^elegir un elemento desde un archivo excel$")
	public void elegirElementoDesdeUnArchivoExcel() throws Exception{
		DataExcel.setExcelFile("C:\\Users\\camila.perez\\eclipse-workspace\\RetoBancolombiaScreenplayCucumber\\src\\test\\resources\\Excel\\DatasExcel.xlsx", "Ahorrar");
		camila.should(seeThat(ValidateSelect.on("Viaje"), containsString(DataExcel.getCellData(0, 0))),
				seeThat(ValidateSelect.on("Educación"), containsString(DataExcel.getCellData(1, 0))),
				seeThat(ValidateSelect.on("Vivienda"), containsString(DataExcel.getCellData(2, 0))),
				seeThat(ValidateSelect.on("Vehículo"), containsString(DataExcel.getCellData(3, 0))),
				seeThat(ValidateSelect.on("Entretenimiento"), containsString(DataExcel.getCellData(4, 0))),
				seeThat(ValidateSelect.on("Retiro para la vejez"), containsString(DataExcel.getCellData(5, 0))),
				seeThat(ValidateSelect.on("Otro"), containsString(DataExcel.getCellData(6, 0))),
				seeThat(Options.at(), comparesEqualTo(8)));
	}
	
	//Tercer escenario then
	@Then("^validar que no sale ningun mensaje de error$")
	public void validarQueNoSaleNingunMensajeDeError() {
		camila.should(seeThat(ValidateMonths.at(ValidateForm.MONTHS)));
		
	}
	
	//Cuarto escenario then
	@Then("^elegir un elemento desde el archivo excel pero entonces saldra un error (.*)$")
	public void elegirUnElementoDesdeElArchivoExcel(String errorMessage) throws Exception{
			ExcelReader.FileContentResult("C:\\Users\\camila.perez\\eclipse-workspace\\RetoBancolombiaScreenplayCucumber\\src\\test\\resources\\Excel\\Excel.xlsx", "excel" );
			camila.should(seeThat(ValidateSelect.on("Fiducuenta"), containsString(ExcelReader.getCellData(0, 0))),
					seeThat(ValidateSelect.on("Cuenta Ahorrador"), containsString(ExcelReader.getCellData(1, 0))),
					seeThat(OptionsProduct.at(), comparesEqualTo(3)).orComplainWith(MessageErrorPage.class, MessageErrorPage.setMessage(errorMessage)));
		
	}
	
	//Quinto escenario then
	@Then("^ella validar que se puede enviar el formulario$")
	public void ellaValidarQueSePuedeEnviarElFormulario() {
		camila.should(seeThat(ValidateBotton.on(ValidateForm.BUTTON_PLAN_SAVINGS)));
	}

}
