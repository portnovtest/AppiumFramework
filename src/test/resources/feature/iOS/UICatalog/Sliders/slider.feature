Feature: About Testing UICatalog App

  In order tpo automate UICatalog App
  As a Native Appium Test
  I will write Appium scripts

  Scenario: Testing UICatalog App

    Given I navigated to Slider interface
    Then I moved slider
      | sliderType |
      | Default    |
      | Tinted     |
      | Custom     |

