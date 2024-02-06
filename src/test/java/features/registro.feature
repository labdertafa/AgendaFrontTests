@smoketest
Feature: Registro de nuevos usuarios
  Como usuario quiero poder registrarme en la aplicacion

  Background:
  	Given que el usuario se encuentra en la pagina de registro de nuevos usuarios
  
  Scenario: Registro de nuevos usuarios exitosamente
    When el usuario introduce informacion valida en los campos 
    And pulsa sobre el boton 
    Then el sistema te envía a la página de login 
    And te muestrar el mensaje indicando que el usuario ha sido creado

    Scenario: Registro de nuevos usuarios con datos inválidos
    When el usuario introduce informacion inválida en los campos y pusa sobre el boón Registrar 
    Then el sistema muestra un popup con un mensaje de error
  