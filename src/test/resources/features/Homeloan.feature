
Feature: Home Loan Borrowing Estimation Calculator

  @HomeLoan01
  Scenario Outline: Verifying Home Loan borrowing estimation of a person based on Loan details
    Given Verify landing page of Home Loan Borrowing calculator screen
    When User enter valid details "<Application_Type>" "<Dependents>" "<Property>" "<Your_Income>" "<Other_Income>" "<Living_Expenses>" "<Current_HomeLoanRepmts>" "<OtherLoanReptns>" "<Other_Commts>" "<Total_creditCardlimits>"
    Then Click on Work out how much I could borrow button and Verif Home Loan Borrowing estimation

    Examples: 
      | Application_Type | Dependents | Property        | Your_Income | Other_Income | Living_Expenses | Current_HomeLoanRepmts | OtherLoanReptns | Other_Commts | Total_creditCardlimits |
      | Single           |          0 | Home to live in |       80000 |        10000 |             500 |                      0 |             100 |            0 |                  10000 |

  @HLoan02
  Scenario: User click on Startover button
    Given User click on Startover button

  @HomeL03
  Scenario Outline: Verify Message for Home Loan Details, Living Expenses as one and Other values as zero
    Given User should be on Home Loan Borrowing calculator screen
    When User enter valid Details "<Application_Type>" "<Dependents>" "<Property>" "<Your_Income>" "<Other_Income>" "<Living_Expenses>" "<Current_HomeLoanRepmts>" "<OtherLoanReptns>" "<Other_Commts>" "<Total_creditCardlimits>"
    Then Verify the error Message

    Examples: 
      | Application_Type | Dependents | Property        | Your_Income | Other_Income | Living_Expenses | Current_HomeLoanRepmts | OtherLoanReptns | Other_Commts | Total_creditCardlimits |
      | Single           |          0 | Home to live in |           0 |            0 |               1 |                      0 |               0 |            0 |                      0 |