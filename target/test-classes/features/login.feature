@smoketest
Feature: Login a la agenda
  Como usuario quiero poder loguearme en la agenda y verificar que cualquier posible error es tomado en consideración


# 	Scenario Outline: hacer login en la agenda
#    Given que el usuario se encuentra en la página de entrada de la agenda
#    When el usuario escribe su email <email> y su password <password>
#    Then el usuario entra a la aplicacion
#    Examples: 
#      | email                  | password   |
#      | "marvielma@yahoo.es"   | "maria"    |
#      | "rafaelt458@yahoo.es"  | "rafa"     |
#      | "rafaelt458@gmail.com" | "1234"     |

#	Scenario Outline: hacer login en la agenda con credenciales incorrectas
#		Given que el usuario se encuentra en la página de entrada de la agenda
#		When el usuario escribe su email <email> y su password <password> con al menos un dato incorrecto
#		Then se muestra el mensaje de error correspondiente
#		Examples: 
#      | email                  | password |
#      | "marvielma@yahoo.es"   | "mari"   |
#      | "rafaelt@yahoo.es"     | "rafa2"  |
#      | "rafaelt4@gmail.com"   | "1234"   |
  
	Scenario: entrar al campo email, no escribir nada y cambiar al campo password
		Given que el usuario se encuentra en la página de entrada de la agenda
		When el usuario entra al campo email y no escribe nada y luego entra al campo password
		Then aparece un mensaje de error en rojo debajo del campo email
		
	Scenario: entrar al campo password, no escribir nada y cambiar al campo login
		Given que el usuario se encuentra en la página de entrada de la agenda
		When el usuario entra al campo password y no escribe nada y luego entra al campo email
		Then aparece un mensaje de error en rojo debajo del campo password
		
#	Scenario Outline: escribir en el campo email un dato con formato incorrecto
#		Given que el usuario se encuentra en la página de entrada de la agenda
#		When el usuario escribe campo email el dato <dato> con formato incorrecto y luego entra al campo password
#		Then aparece el mensaje de formato incorrecto debajo del campo email
#		Examples:
#		| dato               |
#		| "rafaelt458"       |
#		| "rafaelt458.yahoo" |
#		| "rafaelt458@"      |