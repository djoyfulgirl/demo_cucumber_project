Feature: Verify  Search Functionality

@SearchButton
Scenario Outline: To  search an item
Given i Launch the browser
When i entered the searchitem  "<searchitem>"
Then  i click the search icon
Then  i verify the page



 Examples: 
      | searchitem               |  
      | Bag                           | 
