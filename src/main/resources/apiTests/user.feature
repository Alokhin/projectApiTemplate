Feature: InternalCampaignTest


#  Scenario: As Administrator want be able to add new customer to old customer's campaign
#    Given Give customers from campaigns
#    When Add customers to campaign
#    Then Check that the customers are added
#    And Remove customers from campaign
#    Then Check that the customers are removed
#
#  Scenario: I want to able to get all campaigns
#    Given Give all campaigns
#    Then Check that all campaigns are displayed
#
#  Scenario: I want to get one campaign from id
#    Given Give id's campaign
#    Then Check that id's campaign is displayed
#
#  Scenario: I want get all campaign for one customer
#    Given Give all customer's campaigns
#    Then Check that all customer's campaign is displayed

  Scenario: Add new user
    Given Add new user
    Then User is created
    When I update user
    When I deleted user











