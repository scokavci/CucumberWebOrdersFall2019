@login
Feature: Login
  As a user, I want to log in with username/password and verify logo page

  Scenario:
    Given user is on the login page
    When user logs in as tester
    Then user should verify logo page
