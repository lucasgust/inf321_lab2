$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/Calculadora.feature");
formatter.feature({
  "id": "calculator",
  "description": "As a user\r\nI want to use a basic calculator\r\nSo that I dont need to calculate myself",
  "name": "Calculator",
  "keyword": "Feature",
  "line": 1
});
formatter.before({
  "duration": 8694650,
  "status": "passed"
});
formatter.scenario({
  "id": "calculator;sum-two-numbers",
  "description": "",
  "name": "Sum two numbers",
  "keyword": "Scenario",
  "line": 6,
  "type": "scenario"
});
formatter.step({
  "name": "I have a calculator",
  "keyword": "Given ",
  "line": 7
});
formatter.step({
  "name": "I sum 3 with 3",
  "keyword": "When ",
  "line": 8
});
formatter.step({
  "name": "the result should be 6",
  "keyword": "Then ",
  "line": 9
});
formatter.match({
  "location": "CalculadoraSteps.i_have_a_calculator()"
});
formatter.result({
  "duration": 211824132,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 6
    },
    {
      "val": "3",
      "offset": 13
    }
  ],
  "location": "CalculadoraSteps.i_sum_with(int,int)"
});
formatter.result({
  "duration": 3250587,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 21
    }
  ],
  "location": "CalculadoraSteps.the_result_should_be(int)"
});
formatter.result({
  "duration": 217238,
  "status": "passed"
});
formatter.scenarioOutline({
  "id": "calculator;multiply-two-numbers",
  "description": "",
  "name": "Multiply two numbers",
  "keyword": "Scenario Outline",
  "line": 11,
  "type": "scenario_outline"
});
formatter.step({
  "name": "I have a calculator",
  "keyword": "Given ",
  "line": 12
});
formatter.step({
  "name": "I multiply \u003cfirstNumber\u003e with \u003csecondNumber\u003e",
  "keyword": "When ",
  "line": 13
});
formatter.step({
  "name": "the result should be \u003cresult\u003e",
  "keyword": "Then ",
  "line": 14
});
formatter.examples({
  "id": "calculator;multiply-two-numbers;",
  "description": "",
  "name": "",
  "keyword": "Examples",
  "line": 16,
  "rows": [
    {
      "id": "calculator;multiply-two-numbers;;1",
      "cells": [
        "firstNumber",
        "secondNumber",
        "result"
      ],
      "line": 17
    },
    {
      "id": "calculator;multiply-two-numbers;;2",
      "cells": [
        "1",
        "0",
        "0"
      ],
      "line": 18
    },
    {
      "id": "calculator;multiply-two-numbers;;3",
      "cells": [
        "2",
        "2",
        "4"
      ],
      "line": 19
    },
    {
      "id": "calculator;multiply-two-numbers;;4",
      "cells": [
        "3",
        "10",
        "30"
      ],
      "line": 20
    }
  ]
});
formatter.before({
  "duration": 72413,
  "status": "passed"
});
formatter.scenario({
  "id": "calculator;multiply-two-numbers;;2",
  "description": "",
  "name": "Multiply two numbers",
  "keyword": "Scenario Outline",
  "line": 18,
  "type": "scenario"
});
formatter.step({
  "name": "I have a calculator",
  "keyword": "Given ",
  "line": 12
});
formatter.step({
  "name": "I multiply 1 with 0",
  "keyword": "When ",
  "line": 13,
  "matchedColumns": [
    0,
    1
  ]
});
formatter.step({
  "name": "the result should be 0",
  "keyword": "Then ",
  "line": 14,
  "matchedColumns": [
    2
  ]
});
formatter.match({
  "location": "CalculadoraSteps.i_have_a_calculator()"
});
formatter.result({
  "duration": 46755,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 11
    },
    {
      "val": "0",
      "offset": 18
    }
  ],
  "location": "CalculadoraSteps.i_mult_with(int,int)"
});
formatter.result({
  "duration": 303905,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 21
    }
  ],
  "location": "CalculadoraSteps.the_result_should_be(int)"
});
formatter.result({
  "duration": 179606,
  "status": "passed"
});
formatter.before({
  "duration": 59868,
  "status": "passed"
});
formatter.scenario({
  "id": "calculator;multiply-two-numbers;;3",
  "description": "",
  "name": "Multiply two numbers",
  "keyword": "Scenario Outline",
  "line": 19,
  "type": "scenario"
});
formatter.step({
  "name": "I have a calculator",
  "keyword": "Given ",
  "line": 12
});
formatter.step({
  "name": "I multiply 2 with 2",
  "keyword": "When ",
  "line": 13,
  "matchedColumns": [
    0,
    1
  ]
});
formatter.step({
  "name": "the result should be 4",
  "keyword": "Then ",
  "line": 14,
  "matchedColumns": [
    2
  ]
});
formatter.match({
  "location": "CalculadoraSteps.i_have_a_calculator()"
});
formatter.result({
  "duration": 51886,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 11
    },
    {
      "val": "2",
      "offset": 18
    }
  ],
  "location": "CalculadoraSteps.i_mult_with(int,int)"
});
formatter.result({
  "duration": 282239,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 21
    }
  ],
  "location": "CalculadoraSteps.the_result_should_be(int)"
});
formatter.result({
  "duration": 136272,
  "status": "passed"
});
formatter.before({
  "duration": 37632,
  "status": "passed"
});
formatter.scenario({
  "id": "calculator;multiply-two-numbers;;4",
  "description": "",
  "name": "Multiply two numbers",
  "keyword": "Scenario Outline",
  "line": 20,
  "type": "scenario"
});
formatter.step({
  "name": "I have a calculator",
  "keyword": "Given ",
  "line": 12
});
formatter.step({
  "name": "I multiply 3 with 10",
  "keyword": "When ",
  "line": 13,
  "matchedColumns": [
    0,
    1
  ]
});
formatter.step({
  "name": "the result should be 30",
  "keyword": "Then ",
  "line": 14,
  "matchedColumns": [
    2
  ]
});
formatter.match({
  "location": "CalculadoraSteps.i_have_a_calculator()"
});
formatter.result({
  "duration": 34210,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 11
    },
    {
      "val": "10",
      "offset": 18
    }
  ],
  "location": "CalculadoraSteps.i_mult_with(int,int)"
});
formatter.result({
  "duration": 202984,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "30",
      "offset": 21
    }
  ],
  "location": "CalculadoraSteps.the_result_should_be(int)"
});
formatter.result({
  "duration": 181887,
  "status": "passed"
});
formatter.before({
  "duration": 59869,
  "status": "passed"
});
formatter.scenario({
  "id": "calculator;division-by-zero",
  "description": "",
  "name": "Division by zero",
  "keyword": "Scenario",
  "line": 22,
  "type": "scenario"
});
formatter.step({
  "name": "I have a calculator",
  "keyword": "Given ",
  "line": 23
});
formatter.step({
  "name": "I divide 7 with 0",
  "keyword": "When ",
  "line": 24
});
formatter.step({
  "name": "should show an error with a message:",
  "keyword": "Then ",
  "line": 25,
  "doc_string": {
    "value": "/ by zero",
    "line": 26,
    "content_type": ""
  }
});
formatter.match({
  "location": "CalculadoraSteps.i_have_a_calculator()"
});
formatter.result({
  "duration": 51886,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "7",
      "offset": 9
    },
    {
      "val": "0",
      "offset": 16
    }
  ],
  "location": "CalculadoraSteps.i_div_with(int,int)"
});
formatter.result({
  "duration": 358642,
  "status": "passed"
});
formatter.match({
  "location": "CalculadoraSteps.should_show_an_error(String)"
});
formatter.result({
  "duration": 78127557,
  "status": "passed"
});
formatter.before({
  "duration": 56448,
  "status": "passed"
});
formatter.scenario({
  "id": "calculator;divide-two-numbers",
  "description": "",
  "name": "Divide two numbers",
  "keyword": "Scenario",
  "line": 30,
  "type": "scenario"
});
formatter.step({
  "name": "I have a calculator",
  "keyword": "Given ",
  "line": 31
});
formatter.step({
  "name": "I divide 9 with 3",
  "keyword": "When ",
  "line": 32
});
formatter.step({
  "name": "the result should be 3",
  "keyword": "Then ",
  "line": 33
});
formatter.match({
  "location": "CalculadoraSteps.i_have_a_calculator()"
});
formatter.result({
  "duration": 38202,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "9",
      "offset": 9
    },
    {
      "val": "3",
      "offset": 16
    }
  ],
  "location": "CalculadoraSteps.i_div_with(int,int)"
});
formatter.result({
  "duration": 289080,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 21
    }
  ],
  "location": "CalculadoraSteps.the_result_should_be(int)"
});
formatter.result({
  "duration": 174475,
  "status": "passed"
});
});