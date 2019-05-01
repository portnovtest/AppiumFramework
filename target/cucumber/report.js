$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("slider.feature");
formatter.feature({
  "line": 1,
  "name": "About Testing UICatalog App",
  "description": "\nIn order tpo automate UICatalog App\nAs a Native Appium Test\nI will write Appium scripts",
  "id": "about-testing-uicatalog-app",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 7,
  "name": "Testing UICatalog App",
  "description": "",
  "id": "about-testing-uicatalog-app;testing-uicatalog-app",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I navigated to Slider interface",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I moved slider",
  "rows": [
    {
      "cells": [
        "sliderType"
      ],
      "line": 11
    },
    {
      "cells": [
        "Default"
      ],
      "line": 12
    },
    {
      "cells": [
        "Tinted"
      ],
      "line": 13
    },
    {
      "cells": [
        "Custom"
      ],
      "line": 14
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "SliderSteps.I_navigated_to_Slider_interface()"
});
formatter.result({
  "duration": 1805113355,
  "status": "passed"
});
formatter.match({
  "location": "SliderSteps.I_moved_slider(DataTable)"
});
formatter.result({
  "duration": 5248643649,
  "status": "passed"
});
});