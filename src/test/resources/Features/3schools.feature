Feature: Test Tiltle on the 3schools page

  @3Shools
  Scenario: validate title on 3schools  page
    Given check the Firefox browser is open
    When navigate to 3schools home page
    Then validate title text
