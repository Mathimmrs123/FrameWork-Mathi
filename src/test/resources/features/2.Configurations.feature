@Configurations
Feature: Verify LMX Configuration Proposal negotiation validity feature

  Scenario Outline: Configurations
  Given Click Configurations tab and click proposal icon
  
  Scenario Outline: Negoatiation expiry
  When Check negotiation expiry tab inside the proposal menu
  
  Scenario Outline: Negative date
  Then User provide decimal values and negative values and check whether it allows to save
  
  Scenario Outline: Update Negotiation validity
  Then User update the negotiation expiry validity and click save button
  
  Scenario Outline: Validate Success messgage
  Then User Validate the success message after update the validity date
  
  Scenario Outline: Validate Updated data
  Then User Validate the provided date should be retained after updated the validity.