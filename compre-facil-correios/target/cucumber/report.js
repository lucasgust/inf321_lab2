$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/CompreFacil.feature");
formatter.feature({
  "line": 1,
  "name": "Freight Calculator",
  "description": "As a User\n\tI want to inform my zip code to know the price and how many days to receive my product\n\tSo that I do not need to calculate myself",
  "id": "freight-calculator",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 6,
  "name": "Calculating freight price - API Integration",
  "description": "",
  "id": "freight-calculator;calculating-freight-price---api-integration",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "User press button to calculate",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "system connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "system sends the file with all mandatory tags \u003cnCdEmpresa\u003e \u003csDsSenha\u003e \u003cnCdServico\u003e \u003csCepOrigem\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "\u003csCepDestino\u003e \u003cnVlPeso\u003e \u003cnCdFormato\u003e \u003cnVlComprimento\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "\u003cnVlAltura\u003e \u003cnVlLargura\u003e \u003cnVlDiametro\u003e \u003csCdMaoPropria\u003e \u003cnVlValorDeclarado\u003e \u003csCdAvisoRecebimento\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "system connects to Correios API",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "correios API returns \u003csCodigo\u003e \u003csValor\u003e \u003csValorMaoPropria\u003e \u003csValorAvisoRecebimento\u003e \u003csValorDeclarado\u003e",
  "keyword": "And "
});
formatter.examples({
  "line": 16,
  "name": "",
  "description": "",
  "id": "freight-calculator;calculating-freight-price---api-integration;",
  "rows": [
    {
      "cells": [
        "nCdEmpresa",
        "sDsSenha",
        "nCdServico",
        "sCepOrigem",
        "sCepDestino",
        "nVlPeso",
        "nCdFormato",
        "nVlComprimento",
        "nVlAltura",
        "nVlLargura",
        "nVlDiametro",
        "sCdMaoPropria",
        "nVlValorDeclarado",
        "sCdAvisoRecebimento",
        "sCodigo",
        "sValor",
        "sValorMaoPropria",
        "sValorAvisoRecebimento",
        "sValorDeclarado"
      ],
      "line": 17,
      "id": "freight-calculator;calculating-freight-price---api-integration;;1"
    },
    {
      "cells": [
        "",
        "",
        "40010",
        "13495-000",
        "13417-780",
        "100",
        "1",
        "15",
        "5",
        "6",
        "8",
        "N",
        "0",
        "N",
        "40010",
        "13,20",
        "0,00",
        "0,00",
        "0,00"
      ],
      "line": 18,
      "id": "freight-calculator;calculating-freight-price---api-integration;;2"
    },
    {
      "cells": [
        "",
        "",
        "40010",
        "13495-000",
        "13417-780",
        "100",
        "2",
        "15",
        "5",
        "6",
        "8",
        "N",
        "0",
        "N",
        "40010",
        "13,20",
        "0,00",
        "0,00",
        "0,00"
      ],
      "line": 19,
      "id": "freight-calculator;calculating-freight-price---api-integration;;3"
    },
    {
      "cells": [
        "",
        "",
        "40010",
        "13495-000",
        "13417-780",
        "100",
        "3",
        "15",
        "5",
        "6",
        "8",
        "N",
        "0",
        "N",
        "40010",
        "13,20",
        "0,00",
        "0,00",
        "0,00"
      ],
      "line": 20,
      "id": "freight-calculator;calculating-freight-price---api-integration;;4"
    },
    {
      "cells": [
        "",
        "",
        "40045",
        "13495-000",
        "13417-780",
        "100",
        "1",
        "15",
        "5",
        "6",
        "8",
        "N",
        "0",
        "N",
        "40010",
        "13,20",
        "0,00",
        "0,00",
        "0,00"
      ],
      "line": 21,
      "id": "freight-calculator;calculating-freight-price---api-integration;;5"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 86266508,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Calculating freight price - API Integration",
  "description": "",
  "id": "freight-calculator;calculating-freight-price---api-integration;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "User press button to calculate",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "system connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "system sends the file with all mandatory tags   40010 13495-000",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "13417-780 100 1 15",
  "matchedColumns": [
    4,
    5,
    6,
    7
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "5 6 8 N 0 N",
  "matchedColumns": [
    8,
    9,
    10,
    11,
    12,
    13
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "system connects to Correios API",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "correios API returns 40010 13,20 0,00 0,00 0,00",
  "matchedColumns": [
    16,
    17,
    18,
    14,
    15
  ],
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.before({
  "duration": 114822,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Calculating freight price - API Integration",
  "description": "",
  "id": "freight-calculator;calculating-freight-price---api-integration;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "User press button to calculate",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "system connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "system sends the file with all mandatory tags   40010 13495-000",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "13417-780 100 2 15",
  "matchedColumns": [
    4,
    5,
    6,
    7
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "5 6 8 N 0 N",
  "matchedColumns": [
    8,
    9,
    10,
    11,
    12,
    13
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "system connects to Correios API",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "correios API returns 40010 13,20 0,00 0,00 0,00",
  "matchedColumns": [
    16,
    17,
    18,
    14,
    15
  ],
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.before({
  "duration": 110770,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Calculating freight price - API Integration",
  "description": "",
  "id": "freight-calculator;calculating-freight-price---api-integration;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "User press button to calculate",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "system connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "system sends the file with all mandatory tags   40010 13495-000",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "13417-780 100 3 15",
  "matchedColumns": [
    4,
    5,
    6,
    7
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "5 6 8 N 0 N",
  "matchedColumns": [
    8,
    9,
    10,
    11,
    12,
    13
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "system connects to Correios API",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "correios API returns 40010 13,20 0,00 0,00 0,00",
  "matchedColumns": [
    16,
    17,
    18,
    14,
    15
  ],
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.before({
  "duration": 70472,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Calculating freight price - API Integration",
  "description": "",
  "id": "freight-calculator;calculating-freight-price---api-integration;;5",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "User press button to calculate",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "system connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "system sends the file with all mandatory tags   40045 13495-000",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "13417-780 100 1 15",
  "matchedColumns": [
    4,
    5,
    6,
    7
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "5 6 8 N 0 N",
  "matchedColumns": [
    8,
    9,
    10,
    11,
    12,
    13
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "system connects to Correios API",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "correios API returns 40010 13,20 0,00 0,00 0,00",
  "matchedColumns": [
    16,
    17,
    18,
    14,
    15
  ],
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenarioOutline({
  "line": 23,
  "name": "Calculating freight deadline - API Integration",
  "description": "",
  "id": "freight-calculator;calculating-freight-deadline---api-integration",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 24,
  "name": "User types the \u003csCepOrigem\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "System provides \u003csCepDestino\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "System provides \u003cnCdServico\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "User press button to calculate",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "System connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "Correios API returns \u003csCodigo\u003e \u003csPrazoEntrega\u003e \u003csEntregaDomiciliar\u003e \u003csEntregaSabado\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 31,
  "name": "",
  "description": "",
  "id": "freight-calculator;calculating-freight-deadline---api-integration;",
  "rows": [
    {
      "cells": [
        "sCepOrigem",
        "sCepDestino",
        "nCdServico",
        "sCodigo",
        "sPrazoEntrega",
        "sEntregaDomiciliar",
        "sEntregaSabado"
      ],
      "line": 32,
      "id": "freight-calculator;calculating-freight-deadline---api-integration;;1"
    },
    {
      "cells": [
        "13495000",
        "13480000",
        "40010",
        "40010",
        "1",
        "S",
        "S"
      ],
      "line": 33,
      "id": "freight-calculator;calculating-freight-deadline---api-integration;;2"
    },
    {
      "cells": [
        "13480000",
        "13495000",
        "40010",
        "40010",
        "1",
        "S",
        "S"
      ],
      "line": 34,
      "id": "freight-calculator;calculating-freight-deadline---api-integration;;3"
    },
    {
      "cells": [
        "13490013",
        "05311900",
        "40010",
        "40010",
        "1",
        "S",
        "S"
      ],
      "line": 35,
      "id": "freight-calculator;calculating-freight-deadline---api-integration;;4"
    },
    {
      "cells": [
        "05311900",
        "13490013",
        "40010",
        "40010",
        "1",
        "S",
        "S"
      ],
      "line": 36,
      "id": "freight-calculator;calculating-freight-deadline---api-integration;;5"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 113844,
  "status": "passed"
});
formatter.scenario({
  "line": 33,
  "name": "Calculating freight deadline - API Integration",
  "description": "",
  "id": "freight-calculator;calculating-freight-deadline---api-integration;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 24,
  "name": "User types the 13495000",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "System provides 13480000",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "System provides 40010",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "User press button to calculate",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "System connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "Correios API returns 40010 1 S S",
  "matchedColumns": [
    3,
    4,
    5,
    6
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.before({
  "duration": 113145,
  "status": "passed"
});
formatter.scenario({
  "line": 34,
  "name": "Calculating freight deadline - API Integration",
  "description": "",
  "id": "freight-calculator;calculating-freight-deadline---api-integration;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 24,
  "name": "User types the 13480000",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "System provides 13495000",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "System provides 40010",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "User press button to calculate",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "System connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "Correios API returns 40010 1 S S",
  "matchedColumns": [
    3,
    4,
    5,
    6
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.before({
  "duration": 120688,
  "status": "passed"
});
formatter.scenario({
  "line": 35,
  "name": "Calculating freight deadline - API Integration",
  "description": "",
  "id": "freight-calculator;calculating-freight-deadline---api-integration;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 24,
  "name": "User types the 13490013",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "System provides 05311900",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "System provides 40010",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "User press button to calculate",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "System connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "Correios API returns 40010 1 S S",
  "matchedColumns": [
    3,
    4,
    5,
    6
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.before({
  "duration": 87094,
  "status": "passed"
});
formatter.scenario({
  "line": 36,
  "name": "Calculating freight deadline - API Integration",
  "description": "",
  "id": "freight-calculator;calculating-freight-deadline---api-integration;;5",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 24,
  "name": "User types the 05311900",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "System provides 13490013",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "System provides 40010",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "User press button to calculate",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "System connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "Correios API returns 40010 1 S S",
  "matchedColumns": [
    3,
    4,
    5,
    6
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenarioOutline({
  "line": 38,
  "name": "Calculating freight price and deadline - API Integration",
  "description": "",
  "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 39,
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 40,
  "name": "User press button to calculate",
  "keyword": "When "
});
formatter.step({
  "line": 41,
  "name": "system connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "system sends the file with all mandatory tags \u003cnCdEmpresa\u003e \u003csDsSenha\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "\u003cnCdServico\u003e \u003csCepOrigem\u003e \u003csCepDestino\u003e \u003cnVlPeso\u003e \u003cnCdFormato\u003e \u003cnVlComprimento\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "\u003cnVlAltura\u003e \u003cnVlLargura\u003e \u003cnVlDiametro\u003e \u003csCdMaoPropria\u003e \u003cnVlValorDeclarado\u003e \u003csCdAvisoRecebimento\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "Correios API returns \u003cFreightCost\u003e and \u003cDeadline\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 47,
  "name": "",
  "description": "",
  "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;",
  "rows": [
    {
      "cells": [
        "nCdEmpresa",
        "sDsSenha",
        "nCdServico",
        "sCepOrigem",
        "sCepDestino",
        "nVlPeso",
        "nCdFormato",
        "nVlComprimento",
        "nVlAltura",
        "nVlLargura",
        "nVlDiametro",
        "sCdMaoPropria",
        "nVlValorDeclarado",
        "sCdAvisoRecebimento",
        "sCodigo",
        "FreightCost",
        "Deadline"
      ],
      "line": 48,
      "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;;1"
    },
    {
      "cells": [
        "",
        "",
        "40010",
        "13495-000",
        "13417-780",
        "100",
        "1",
        "15",
        "5",
        "6",
        "8",
        "N",
        "0",
        "N",
        "40010",
        "16,50",
        "1"
      ],
      "line": 49,
      "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;;2"
    },
    {
      "cells": [
        "",
        "",
        "40010",
        "13495-000",
        "13417-780",
        "100",
        "2",
        "15",
        "5",
        "6",
        "8",
        "N",
        "0",
        "N",
        "40010",
        "16,50",
        "1"
      ],
      "line": 50,
      "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;;3"
    },
    {
      "cells": [
        "",
        "",
        "40010",
        "13495-000",
        "13417-780",
        "100",
        "3",
        "15",
        "5",
        "6",
        "8",
        "N",
        "0",
        "N",
        "40010",
        "16,50",
        "1"
      ],
      "line": 51,
      "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;;4"
    },
    {
      "cells": [
        "",
        "",
        "40045",
        "13495-000",
        "13417-780",
        "100",
        "1",
        "15",
        "5",
        "6",
        "8",
        "N",
        "0",
        "N",
        "40010",
        "16,50",
        "1"
      ],
      "line": 52,
      "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;;5"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 161406,
  "status": "passed"
});
formatter.scenario({
  "line": 49,
  "name": "Calculating freight price and deadline - API Integration",
  "description": "",
  "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 39,
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 40,
  "name": "User press button to calculate",
  "keyword": "When "
});
formatter.step({
  "line": 41,
  "name": "system connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "system sends the file with all mandatory tags  ",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "40010 13495-000 13417-780 100 1 15",
  "matchedColumns": [
    2,
    3,
    4,
    5,
    6,
    7
  ],
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "5 6 8 N 0 N",
  "matchedColumns": [
    8,
    9,
    10,
    11,
    12,
    13
  ],
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "Correios API returns 16,50 and 1",
  "matchedColumns": [
    16,
    15
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.before({
  "duration": 105044,
  "status": "passed"
});
formatter.scenario({
  "line": 50,
  "name": "Calculating freight price and deadline - API Integration",
  "description": "",
  "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 39,
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 40,
  "name": "User press button to calculate",
  "keyword": "When "
});
formatter.step({
  "line": 41,
  "name": "system connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "system sends the file with all mandatory tags  ",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "40010 13495-000 13417-780 100 2 15",
  "matchedColumns": [
    2,
    3,
    4,
    5,
    6,
    7
  ],
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "5 6 8 N 0 N",
  "matchedColumns": [
    8,
    9,
    10,
    11,
    12,
    13
  ],
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "Correios API returns 16,50 and 1",
  "matchedColumns": [
    16,
    15
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.before({
  "duration": 104136,
  "status": "passed"
});
formatter.scenario({
  "line": 51,
  "name": "Calculating freight price and deadline - API Integration",
  "description": "",
  "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 39,
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 40,
  "name": "User press button to calculate",
  "keyword": "When "
});
formatter.step({
  "line": 41,
  "name": "system connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "system sends the file with all mandatory tags  ",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "40010 13495-000 13417-780 100 3 15",
  "matchedColumns": [
    2,
    3,
    4,
    5,
    6,
    7
  ],
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "5 6 8 N 0 N",
  "matchedColumns": [
    8,
    9,
    10,
    11,
    12,
    13
  ],
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "Correios API returns 16,50 and 1",
  "matchedColumns": [
    16,
    15
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.before({
  "duration": 100713,
  "status": "passed"
});
formatter.scenario({
  "line": 52,
  "name": "Calculating freight price and deadline - API Integration",
  "description": "",
  "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;;5",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 39,
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 40,
  "name": "User press button to calculate",
  "keyword": "When "
});
formatter.step({
  "line": 41,
  "name": "system connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "system sends the file with all mandatory tags  ",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "40045 13495-000 13417-780 100 1 15",
  "matchedColumns": [
    2,
    3,
    4,
    5,
    6,
    7
  ],
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "5 6 8 N 0 N",
  "matchedColumns": [
    8,
    9,
    10,
    11,
    12,
    13
  ],
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "Correios API returns 16,50 and 1",
  "matchedColumns": [
    16,
    15
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenarioOutline({
  "line": 54,
  "name": "Getting address - API Integration",
  "description": "",
  "id": "freight-calculator;getting-address---api-integration",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 55,
  "name": "I have a valid and registered zip code \u003ccep\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 56,
  "name": "I press button to search",
  "keyword": "When "
});
formatter.step({
  "line": 57,
  "name": "system connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "system sends the file with the mandatory tag \u003ccep\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 59,
  "name": "Correios API returns \u003ccep\u003e \u003clogradouro\u003e \u003ccomplemento\u003e \u003cbairro\u003e \u003clocalidade\u003e \u003cuf\u003e \u003cibge\u003e \u003cgia\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 61,
  "name": "",
  "description": "",
  "id": "freight-calculator;getting-address---api-integration;",
  "rows": [
    {
      "cells": [
        "cep",
        "logradouro",
        "complemento",
        "bairro",
        "localidade",
        "uf",
        "ibge",
        "gia"
      ],
      "line": 62,
      "id": "freight-calculator;getting-address---api-integration;;1"
    },
    {
      "cells": [
        "01001000",
        "Pra�a da S�",
        "lado �mpar",
        "S�",
        "S�o Paulo",
        "SP",
        "3550308",
        "1004"
      ],
      "line": 63,
      "id": "freight-calculator;getting-address---api-integration;;2"
    },
    {
      "cells": [
        "01311300",
        "Avenida Paulista",
        "de 1867 ao fim - lado �mpar",
        "Bela Vista",
        "S�o Paulo",
        "SP",
        "3550308",
        "1004"
      ],
      "line": 64,
      "id": "freight-calculator;getting-address---api-integration;;3"
    },
    {
      "cells": [
        "22041080",
        "Rua Anita Garibaldi",
        "",
        "Copacabana",
        "Rio de Janeiro",
        "RJ",
        "3304557",
        ""
      ],
      "line": 65,
      "id": "freight-calculator;getting-address---api-integration;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 102110,
  "status": "passed"
});
formatter.scenario({
  "line": 63,
  "name": "Getting address - API Integration",
  "description": "",
  "id": "freight-calculator;getting-address---api-integration;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 55,
  "name": "I have a valid and registered zip code 01001000",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 56,
  "name": "I press button to search",
  "keyword": "When "
});
formatter.step({
  "line": 57,
  "name": "system connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "system sends the file with the mandatory tag 01001000",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 59,
  "name": "Correios API returns 01001000 Pra�a da S� lado �mpar S� S�o Paulo SP 3550308 1004",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "CompreFacilSteps.i_press_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.before({
  "duration": 134378,
  "status": "passed"
});
formatter.scenario({
  "line": 64,
  "name": "Getting address - API Integration",
  "description": "",
  "id": "freight-calculator;getting-address---api-integration;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 55,
  "name": "I have a valid and registered zip code 01311300",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 56,
  "name": "I press button to search",
  "keyword": "When "
});
formatter.step({
  "line": 57,
  "name": "system connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "system sends the file with the mandatory tag 01311300",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 59,
  "name": "Correios API returns 01311300 Avenida Paulista de 1867 ao fim - lado �mpar Bela Vista S�o Paulo SP 3550308 1004",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "CompreFacilSteps.i_press_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.before({
  "duration": 129628,
  "status": "passed"
});
formatter.scenario({
  "line": 65,
  "name": "Getting address - API Integration",
  "description": "",
  "id": "freight-calculator;getting-address---api-integration;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 55,
  "name": "I have a valid and registered zip code 22041080",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 56,
  "name": "I press button to search",
  "keyword": "When "
});
formatter.step({
  "line": 57,
  "name": "system connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "system sends the file with the mandatory tag 22041080",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 59,
  "name": "Correios API returns 22041080 Rua Anita Garibaldi  Copacabana Rio de Janeiro RJ 3304557 ",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "CompreFacilSteps.i_press_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.before({
  "duration": 1227066,
  "status": "passed"
});
formatter.scenario({
  "line": 67,
  "name": "Empty zip code",
  "description": "",
  "id": "freight-calculator;empty-zip-code",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 68,
  "name": "I do not have a zip code \u003ccep\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 69,
  "name": "I press button to search",
  "keyword": "When "
});
formatter.step({
  "line": 70,
  "name": "should show an error with a message:",
  "keyword": "Then ",
  "doc_string": {
    "content_type": "",
    "line": 71,
    "value": "O campo CEP n�o foi informado."
  }
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "CompreFacilSteps.i_press_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.before({
  "duration": 142689,
  "status": "passed"
});
formatter.scenario({
  "line": 75,
  "name": "Invalid zip code",
  "description": "",
  "id": "freight-calculator;invalid-zip-code",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 76,
  "name": "I have an invalid zip code \u003ccep\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 77,
  "name": "I press button to search",
  "keyword": "When "
});
formatter.step({
  "line": 78,
  "name": "should show an error with a message:",
  "keyword": "Then ",
  "doc_string": {
    "content_type": "",
    "line": 79,
    "value": "O CEP informado � inv�lido. O formato correto � compsoto por {8} d�gitos."
  }
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "CompreFacilSteps.i_press_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.before({
  "duration": 67189,
  "status": "passed"
});
formatter.scenario({
  "line": 83,
  "name": "Address not found",
  "description": "",
  "id": "freight-calculator;address-not-found",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 84,
  "name": "I have a valid but not registered zip code \u003ccep\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 85,
  "name": "I press button to search",
  "keyword": "When "
});
formatter.step({
  "line": 86,
  "name": "system connects to Correios API",
  "keyword": "And "
});
formatter.step({
  "line": 87,
  "name": "system sends the file with the mandatory tag \u003ccep\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 88,
  "name": "system returns an empty address object",
  "keyword": "And "
});
formatter.step({
  "line": 89,
  "name": "should show an error with a message:",
  "keyword": "Then ",
  "doc_string": {
    "content_type": "",
    "line": 90,
    "value": "O CEP informado n�o foi encontrado."
  }
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "CompreFacilSteps.i_press_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});