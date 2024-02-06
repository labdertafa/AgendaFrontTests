@navigation
Feature: Navegación por las opciones del menu de opciones
  Como usuario quiero poder navegar por las distintas opciones del menú de opciones
  
  Background:
  	Given que el usuario se encuentra en la pagina de mantenimiento de contactos

#  Scenario: navegacion a la pagina de mantenimiento de medios de comunicacion
#    When el usuario hace click en la opcion medios de comunicacion
#    Then se muestra la pagina de mantenimiento de medios de comunicacion

#  Scenario: navegacion a la pagina de mantenimiento de ciudades
#    When el usuario hace click en la opcion Ciudades
#    Then se muestra la pagina de mantenimiento de ciudades

  Scenario: navegacion a la pagina de mantenimiento de direcciones
    When el usuario hace click en la opcion Direcciones
    Then se muestra la pagina de mantenimiento de direcciones

  Scenario: navegacion a la pagina de login
    When el usuario hace click en la opcion Salir
    Then se muestra la pagina de login
  