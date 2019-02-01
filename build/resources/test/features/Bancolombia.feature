@Feature
Feature: Simulador de ahorro e inversion
 Como usuario
 Quiero ingresar en el formulario de ahorro e inversion
 Para validar que este funcionando correctamente

Background: Abrir el navegador en la pagina grupo Bancolombia e ingresar en el formulario de simulador de ahorro
Given que Accenture Testing se encuentra en el formulario de Bancolombia simulador de ahorro

@Scenario1
Scenario: Prueba a realizar - Validar que los campos son obligatorios
When camila quiere validar que cada uno de los campos son obligatorios 
Then ella espera que cada uno de los campos tenga la alerta

@Scenario2
Scenario: Prueba a realizar - Validar lista desplegable del campo para que quieres ahorrar
When camila quiere validar que se encuentran cada elemento de la lista desplegable
Then elegir un elemento desde un archivo excel

@Scenario3
Scenario: Prueba a realizar - Llenar el campo cuantos meses te faltan para alcanzar tu meta
When camila quiere llenar el campo 
Then validar que no sale ningun mensaje de error

@Scenario4
Scenario: Prueba a realizar - Validar lista desplegable del campo selecciona el producto
When camila quiere validar que al seleccionar un elemento en el campo para que quieres ahorrar
Then elegir un elemento desde el archivo excel

@Scenario5
Scenario: Prueba a realizar - llenar campo cuanto dinero te falta para lograr tu meta y enviar formulario
When camila quiere completar el formulario llenado el ultimo campo del formulario 
Then ella validar que se puede enviar el formulario