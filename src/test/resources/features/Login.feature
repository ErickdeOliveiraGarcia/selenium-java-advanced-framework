@UI @Login
Feature: User Login Functionality

  As a Sauce Demo User
  I want to log into the application
  So that I can purchase items

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user logs in with username "standard_user" and password "secret_sauce"
    Then the user should be redirected to the inventory page