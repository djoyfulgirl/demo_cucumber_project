Feature: Verify Login Functionality
@loginpage
  Scenario Outline: To test Login
    Given Launch the browser
    When i click on sigin button
    Then i enter  UserName "<username>"
    Then i click the continue button
    Then  i enter Password "<password>"
    Then i click the signin button
    And  i verify the title of the page

    Examples: 
      | username                 | password  |
      | tawakalthassan@gmail.com | olaseun16 |
