Feature: Certificate page
  As a user,
  I want to open Certificate Page and do

  Scenario Outline: Field number Certificate
    Given I open Certificate page
    When  I entered the invalid data <number> in the field "Номер сертификата"
    Then  Then the output should be <output>
    Examples:
    |number     | output                  |
    |"2223"     | "Сертифікат не знайдено"|
    |"24856"    | "Сертифікат не знайдено"|
    |"278235"   | "Сертифікат не знайдено"|
    |"2125674"  | "Сертифікат не знайдено"|