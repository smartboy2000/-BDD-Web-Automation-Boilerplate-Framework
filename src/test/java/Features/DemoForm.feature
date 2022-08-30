Feature: Demo Form

  @DemoForm
  Scenario: Fill Demo Form

    Given User is on Demo Form Page
    When User Enter Firstname & Lastname
      | firstName | lastName |
      | QA        | Tester   |
    And User Enter Email
      | email            |
      | tes123@gmail.com |
    And User Select Gender
    And User Enter Mobile Number
      | mobileNumber |
      | 5424156245   |
    And User Enter Subject
      | subjectName |
      | computer    |
    And User Choose Hobby
    And User Enter Address
      | address          |
      | 202 High lane US |
    And User navigate to second page
      | url |
      |  https://courses.letskodeit.com/practice   |
    And User navigate to third page
      | url |
      |  https://www.google.co.in/   |
