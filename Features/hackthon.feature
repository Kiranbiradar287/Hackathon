Feature: Make my trip

  Scenario: Cab Selection
    Given user can see cab selection And click on cab
    Then user enter the from city
    Then user enter the to city
    Then user select the date
    Then user click on apply button
    When user click on search button
    Then user see car type section And select SUV car
    Then print car name And car price
    
  Scenario: Gift section
    When user click on more option And click on giftcards
    Then user scroll down And click on weddinggift
    Then user Enter all the Deatil
    When user click on buy now button
    Then print the error mail msg
    
   Scenario: Hotel Booking Section
    When user click on hotel section
    Then user see room option and click
    Then user click on Adult list and print the list
  
    
