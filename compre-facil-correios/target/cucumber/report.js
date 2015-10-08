$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/CompreFacil.feature");
formatter.feature({
  "id": "freight-calculator",
  "description": "As a User\r\n\tI want to inform my zip code to know the price and how many days to receive my product\r\n\tSo that I do not need to calculate myself",
  "name": "Freight Calculator",
  "keyword": "Feature",
  "line": 1
});
formatter.scenarioOutline({
  "id": "freight-calculator;calculating-freight-price---api-integration",
  "description": "",
  "name": "Calculating freight price - API Integration",
  "keyword": "Scenario Outline",
  "line": 6,
  "type": "scenario_outline"
});
formatter.step({
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given ",
  "line": 7
});
formatter.step({
  "name": "User press button to calculate",
  "keyword": "When ",
  "line": 8
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "And ",
  "line": 9
});
formatter.step({
  "name": "system sends the file with all mandatory tags \u003cnCdEmpresa\u003e \u003csDsSenha\u003e \u003cnCdServico\u003e \u003csCepOrigem\u003e",
  "keyword": "And ",
  "line": 10
});
formatter.step({
  "name": "\u003csCepDestino\u003e \u003cnVlPeso\u003e \u003cnCdFormato\u003e \u003cnVlComprimento\u003e",
  "keyword": "And ",
  "line": 11
});
formatter.step({
  "name": "\u003cnVlAltura\u003e \u003cnVlLargura\u003e \u003cnVlDiametro\u003e \u003csCdMaoPropria\u003e \u003cnVlValorDeclarado\u003e \u003csCdAvisoRecebimento\u003e",
  "keyword": "And ",
  "line": 12
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "Then ",
  "line": 13
});
formatter.step({
  "name": "correios API returns \u003csCodigo\u003e \u003csValor\u003e \u003csValorMaoPropria\u003e \u003csValorAvisoRecebimento\u003e \u003csValorDeclarado\u003e",
  "keyword": "And ",
  "line": 14
});
formatter.examples({
  "id": "freight-calculator;calculating-freight-price---api-integration;",
  "description": "",
  "name": "",
  "keyword": "Examples",
  "line": 16,
  "rows": [
    {
      "id": "freight-calculator;calculating-freight-price---api-integration;;1",
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
      "line": 17
    },
    {
      "id": "freight-calculator;calculating-freight-price---api-integration;;2",
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
      "line": 18
    },
    {
      "id": "freight-calculator;calculating-freight-price---api-integration;;3",
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
      "line": 19
    },
    {
      "id": "freight-calculator;calculating-freight-price---api-integration;;4",
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
      "line": 20
    },
    {
      "id": "freight-calculator;calculating-freight-price---api-integration;;5",
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
      "line": 21
    }
  ]
});
formatter.before({
  "duration": 79350872,
  "status": "passed"
});
formatter.scenario({
  "id": "freight-calculator;calculating-freight-price---api-integration;;2",
  "description": "",
  "name": "Calculating freight price - API Integration",
  "keyword": "Scenario Outline",
  "line": 18,
  "type": "scenario"
});
formatter.step({
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given ",
  "line": 7
});
formatter.step({
  "name": "User press button to calculate",
  "keyword": "When ",
  "line": 8
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "And ",
  "line": 9
});
formatter.step({
  "name": "system sends the file with all mandatory tags   40010 13495-000",
  "keyword": "And ",
  "line": 10,
  "matchedColumns": [
    0,
    1,
    2,
    3
  ]
});
formatter.step({
  "name": "13417-780 100 1 15",
  "keyword": "And ",
  "line": 11,
  "matchedColumns": [
    4,
    5,
    6,
    7
  ]
});
formatter.step({
  "name": "5 6 8 N 0 N",
  "keyword": "And ",
  "line": 12,
  "matchedColumns": [
    8,
    9,
    10,
    11,
    12,
    13
  ]
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "Then ",
  "line": 13
});
formatter.step({
  "name": "correios API returns 40010 13,20 0,00 0,00 0,00",
  "keyword": "And ",
  "line": 14,
  "matchedColumns": [
    17,
    16,
    18,
    14,
    15
  ]
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
  "duration": 138186,
  "status": "passed"
});
formatter.scenario({
  "id": "freight-calculator;calculating-freight-price---api-integration;;3",
  "description": "",
  "name": "Calculating freight price - API Integration",
  "keyword": "Scenario Outline",
  "line": 19,
  "type": "scenario"
});
formatter.step({
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given ",
  "line": 7
});
formatter.step({
  "name": "User press button to calculate",
  "keyword": "When ",
  "line": 8
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "And ",
  "line": 9
});
formatter.step({
  "name": "system sends the file with all mandatory tags   40010 13495-000",
  "keyword": "And ",
  "line": 10,
  "matchedColumns": [
    0,
    1,
    2,
    3
  ]
});
formatter.step({
  "name": "13417-780 100 2 15",
  "keyword": "And ",
  "line": 11,
  "matchedColumns": [
    4,
    5,
    6,
    7
  ]
});
formatter.step({
  "name": "5 6 8 N 0 N",
  "keyword": "And ",
  "line": 12,
  "matchedColumns": [
    8,
    9,
    10,
    11,
    12,
    13
  ]
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "Then ",
  "line": 13
});
formatter.step({
  "name": "correios API returns 40010 13,20 0,00 0,00 0,00",
  "keyword": "And ",
  "line": 14,
  "matchedColumns": [
    17,
    16,
    18,
    14,
    15
  ]
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
  "duration": 99699,
  "status": "passed"
});
formatter.scenario({
  "id": "freight-calculator;calculating-freight-price---api-integration;;4",
  "description": "",
  "name": "Calculating freight price - API Integration",
  "keyword": "Scenario Outline",
  "line": 20,
  "type": "scenario"
});
formatter.step({
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given ",
  "line": 7
});
formatter.step({
  "name": "User press button to calculate",
  "keyword": "When ",
  "line": 8
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "And ",
  "line": 9
});
formatter.step({
  "name": "system sends the file with all mandatory tags   40010 13495-000",
  "keyword": "And ",
  "line": 10,
  "matchedColumns": [
    0,
    1,
    2,
    3
  ]
});
formatter.step({
  "name": "13417-780 100 3 15",
  "keyword": "And ",
  "line": 11,
  "matchedColumns": [
    4,
    5,
    6,
    7
  ]
});
formatter.step({
  "name": "5 6 8 N 0 N",
  "keyword": "And ",
  "line": 12,
  "matchedColumns": [
    8,
    9,
    10,
    11,
    12,
    13
  ]
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "Then ",
  "line": 13
});
formatter.step({
  "name": "correios API returns 40010 13,20 0,00 0,00 0,00",
  "keyword": "And ",
  "line": 14,
  "matchedColumns": [
    17,
    16,
    18,
    14,
    15
  ]
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
  "duration": 80639,
  "status": "passed"
});
formatter.scenario({
  "id": "freight-calculator;calculating-freight-price---api-integration;;5",
  "description": "",
  "name": "Calculating freight price - API Integration",
  "keyword": "Scenario Outline",
  "line": 21,
  "type": "scenario"
});
formatter.step({
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given ",
  "line": 7
});
formatter.step({
  "name": "User press button to calculate",
  "keyword": "When ",
  "line": 8
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "And ",
  "line": 9
});
formatter.step({
  "name": "system sends the file with all mandatory tags   40045 13495-000",
  "keyword": "And ",
  "line": 10,
  "matchedColumns": [
    0,
    1,
    2,
    3
  ]
});
formatter.step({
  "name": "13417-780 100 1 15",
  "keyword": "And ",
  "line": 11,
  "matchedColumns": [
    4,
    5,
    6,
    7
  ]
});
formatter.step({
  "name": "5 6 8 N 0 N",
  "keyword": "And ",
  "line": 12,
  "matchedColumns": [
    8,
    9,
    10,
    11,
    12,
    13
  ]
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "Then ",
  "line": 13
});
formatter.step({
  "name": "correios API returns 40010 13,20 0,00 0,00 0,00",
  "keyword": "And ",
  "line": 14,
  "matchedColumns": [
    17,
    16,
    18,
    14,
    15
  ]
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
  "id": "freight-calculator;calculating-freight-deadline---api-integration",
  "description": "",
  "name": "Calculating freight deadline - API Integration",
  "keyword": "Scenario Outline",
  "line": 23,
  "type": "scenario_outline"
});
formatter.step({
  "name": "User types the \u003csCepOrigem\u003e",
  "keyword": "Given ",
  "line": 24
});
formatter.step({
  "name": "System provides \u003csCepDestino\u003e",
  "keyword": "And ",
  "line": 25
});
formatter.step({
  "name": "System provides \u003cnCdServico\u003e",
  "keyword": "And ",
  "line": 26
});
formatter.step({
  "name": "User press button to calculate",
  "keyword": "When ",
  "line": 27
});
formatter.step({
  "name": "System connects to Correios API",
  "keyword": "And ",
  "line": 28
});
formatter.step({
  "name": "Correios API returns \u003csCodigo\u003e \u003csPrazoEntrega\u003e \u003csEntregaDomiciliar\u003e \u003csEntregaSabado\u003e",
  "keyword": "Then ",
  "line": 29
});
formatter.examples({
  "id": "freight-calculator;calculating-freight-deadline---api-integration;",
  "description": "",
  "name": "",
  "keyword": "Examples",
  "line": 31,
  "rows": [
    {
      "id": "freight-calculator;calculating-freight-deadline---api-integration;;1",
      "cells": [
        "sCepOrigem",
        "sCepDestino",
        "nCdServico",
        "sCodigo",
        "sPrazoEntrega",
        "sEntregaDomiciliar",
        "sEntregaSabado"
      ],
      "line": 32
    },
    {
      "id": "freight-calculator;calculating-freight-deadline---api-integration;;2",
      "cells": [
        "13495000",
        "13480000",
        "40010",
        "40010",
        "1",
        "S",
        "S"
      ],
      "line": 33
    },
    {
      "id": "freight-calculator;calculating-freight-deadline---api-integration;;3",
      "cells": [
        "13480000",
        "13495000",
        "40010",
        "40010",
        "1",
        "S",
        "S"
      ],
      "line": 34
    },
    {
      "id": "freight-calculator;calculating-freight-deadline---api-integration;;4",
      "cells": [
        "13490013",
        "05311900",
        "40010",
        "40010",
        "1",
        "S",
        "S"
      ],
      "line": 35
    },
    {
      "id": "freight-calculator;calculating-freight-deadline---api-integration;;5",
      "cells": [
        "05311900",
        "13490013",
        "40010",
        "40010",
        "1",
        "S",
        "S"
      ],
      "line": 36
    }
  ]
});
formatter.before({
  "duration": 130488,
  "status": "passed"
});
formatter.scenario({
  "id": "freight-calculator;calculating-freight-deadline---api-integration;;2",
  "description": "",
  "name": "Calculating freight deadline - API Integration",
  "keyword": "Scenario Outline",
  "line": 33,
  "type": "scenario"
});
formatter.step({
  "name": "User types the 13495000",
  "keyword": "Given ",
  "line": 24,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "System provides 13480000",
  "keyword": "And ",
  "line": 25,
  "matchedColumns": [
    1
  ]
});
formatter.step({
  "name": "System provides 40010",
  "keyword": "And ",
  "line": 26,
  "matchedColumns": [
    2
  ]
});
formatter.step({
  "name": "User press button to calculate",
  "keyword": "When ",
  "line": 27
});
formatter.step({
  "name": "System connects to Correios API",
  "keyword": "And ",
  "line": 28
});
formatter.step({
  "name": "Correios API returns 40010 1 S S",
  "keyword": "Then ",
  "line": 29,
  "matchedColumns": [
    3,
    4,
    5,
    6
  ]
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
  "duration": 106297,
  "status": "passed"
});
formatter.scenario({
  "id": "freight-calculator;calculating-freight-deadline---api-integration;;3",
  "description": "",
  "name": "Calculating freight deadline - API Integration",
  "keyword": "Scenario Outline",
  "line": 34,
  "type": "scenario"
});
formatter.step({
  "name": "User types the 13480000",
  "keyword": "Given ",
  "line": 24,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "System provides 13495000",
  "keyword": "And ",
  "line": 25,
  "matchedColumns": [
    1
  ]
});
formatter.step({
  "name": "System provides 40010",
  "keyword": "And ",
  "line": 26,
  "matchedColumns": [
    2
  ]
});
formatter.step({
  "name": "User press button to calculate",
  "keyword": "When ",
  "line": 27
});
formatter.step({
  "name": "System connects to Correios API",
  "keyword": "And ",
  "line": 28
});
formatter.step({
  "name": "Correios API returns 40010 1 S S",
  "keyword": "Then ",
  "line": 29,
  "matchedColumns": [
    3,
    4,
    5,
    6
  ]
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
  "duration": 258411,
  "status": "passed"
});
formatter.scenario({
  "id": "freight-calculator;calculating-freight-deadline---api-integration;;4",
  "description": "",
  "name": "Calculating freight deadline - API Integration",
  "keyword": "Scenario Outline",
  "line": 35,
  "type": "scenario"
});
formatter.step({
  "name": "User types the 13490013",
  "keyword": "Given ",
  "line": 24,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "System provides 05311900",
  "keyword": "And ",
  "line": 25,
  "matchedColumns": [
    1
  ]
});
formatter.step({
  "name": "System provides 40010",
  "keyword": "And ",
  "line": 26,
  "matchedColumns": [
    2
  ]
});
formatter.step({
  "name": "User press button to calculate",
  "keyword": "When ",
  "line": 27
});
formatter.step({
  "name": "System connects to Correios API",
  "keyword": "And ",
  "line": 28
});
formatter.step({
  "name": "Correios API returns 40010 1 S S",
  "keyword": "Then ",
  "line": 29,
  "matchedColumns": [
    3,
    4,
    5,
    6
  ]
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
  "duration": 117660,
  "status": "passed"
});
formatter.scenario({
  "id": "freight-calculator;calculating-freight-deadline---api-integration;;5",
  "description": "",
  "name": "Calculating freight deadline - API Integration",
  "keyword": "Scenario Outline",
  "line": 36,
  "type": "scenario"
});
formatter.step({
  "name": "User types the 05311900",
  "keyword": "Given ",
  "line": 24,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "System provides 13490013",
  "keyword": "And ",
  "line": 25,
  "matchedColumns": [
    1
  ]
});
formatter.step({
  "name": "System provides 40010",
  "keyword": "And ",
  "line": 26,
  "matchedColumns": [
    2
  ]
});
formatter.step({
  "name": "User press button to calculate",
  "keyword": "When ",
  "line": 27
});
formatter.step({
  "name": "System connects to Correios API",
  "keyword": "And ",
  "line": 28
});
formatter.step({
  "name": "Correios API returns 40010 1 S S",
  "keyword": "Then ",
  "line": 29,
  "matchedColumns": [
    3,
    4,
    5,
    6
  ]
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
  "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration",
  "description": "",
  "name": "Calculating freight price and deadline - API Integration",
  "keyword": "Scenario Outline",
  "line": 38,
  "type": "scenario_outline"
});
formatter.step({
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given ",
  "line": 39
});
formatter.step({
  "name": "User press button to calculate",
  "keyword": "When ",
  "line": 40
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "And ",
  "line": 41
});
formatter.step({
  "name": "system sends the file with all mandatory tags \u003cnCdEmpresa\u003e \u003csDsSenha\u003e",
  "keyword": "And ",
  "line": 42
});
formatter.step({
  "name": "\u003cnCdServico\u003e \u003csCepOrigem\u003e \u003csCepDestino\u003e \u003cnVlPeso\u003e \u003cnCdFormato\u003e \u003cnVlComprimento\u003e",
  "keyword": "And ",
  "line": 43
});
formatter.step({
  "name": "\u003cnVlAltura\u003e \u003cnVlLargura\u003e \u003cnVlDiametro\u003e \u003csCdMaoPropria\u003e \u003cnVlValorDeclarado\u003e \u003csCdAvisoRecebimento\u003e",
  "keyword": "And ",
  "line": 44
});
formatter.step({
  "name": "Correios API returns \u003cFreightCost\u003e and \u003cDeadline\u003e",
  "keyword": "Then ",
  "line": 45
});
formatter.examples({
  "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;",
  "description": "",
  "name": "",
  "keyword": "Examples",
  "line": 47,
  "rows": [
    {
      "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;;1",
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
      "line": 48
    },
    {
      "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;;2",
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
      "line": 49
    },
    {
      "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;;3",
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
      "line": 50
    },
    {
      "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;;4",
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
      "line": 51
    },
    {
      "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;;5",
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
      "line": 52
    }
  ]
});
formatter.before({
  "duration": 131955,
  "status": "passed"
});
formatter.scenario({
  "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;;2",
  "description": "",
  "name": "Calculating freight price and deadline - API Integration",
  "keyword": "Scenario Outline",
  "line": 49,
  "type": "scenario"
});
formatter.step({
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given ",
  "line": 39
});
formatter.step({
  "name": "User press button to calculate",
  "keyword": "When ",
  "line": 40
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "And ",
  "line": 41
});
formatter.step({
  "name": "system sends the file with all mandatory tags  ",
  "keyword": "And ",
  "line": 42,
  "matchedColumns": [
    0,
    1
  ]
});
formatter.step({
  "name": "40010 13495-000 13417-780 100 1 15",
  "keyword": "And ",
  "line": 43,
  "matchedColumns": [
    2,
    3,
    4,
    5,
    6,
    7
  ]
});
formatter.step({
  "name": "5 6 8 N 0 N",
  "keyword": "And ",
  "line": 44,
  "matchedColumns": [
    8,
    9,
    10,
    11,
    12,
    13
  ]
});
formatter.step({
  "name": "Correios API returns 16,50 and 1",
  "keyword": "Then ",
  "line": 45,
  "matchedColumns": [
    16,
    15
  ]
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
  "duration": 137086,
  "status": "passed"
});
formatter.scenario({
  "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;;3",
  "description": "",
  "name": "Calculating freight price and deadline - API Integration",
  "keyword": "Scenario Outline",
  "line": 50,
  "type": "scenario"
});
formatter.step({
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given ",
  "line": 39
});
formatter.step({
  "name": "User press button to calculate",
  "keyword": "When ",
  "line": 40
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "And ",
  "line": 41
});
formatter.step({
  "name": "system sends the file with all mandatory tags  ",
  "keyword": "And ",
  "line": 42,
  "matchedColumns": [
    0,
    1
  ]
});
formatter.step({
  "name": "40010 13495-000 13417-780 100 2 15",
  "keyword": "And ",
  "line": 43,
  "matchedColumns": [
    2,
    3,
    4,
    5,
    6,
    7
  ]
});
formatter.step({
  "name": "5 6 8 N 0 N",
  "keyword": "And ",
  "line": 44,
  "matchedColumns": [
    8,
    9,
    10,
    11,
    12,
    13
  ]
});
formatter.step({
  "name": "Correios API returns 16,50 and 1",
  "keyword": "Then ",
  "line": 45,
  "matchedColumns": [
    16,
    15
  ]
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
  "duration": 133420,
  "status": "passed"
});
formatter.scenario({
  "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;;4",
  "description": "",
  "name": "Calculating freight price and deadline - API Integration",
  "keyword": "Scenario Outline",
  "line": 51,
  "type": "scenario"
});
formatter.step({
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given ",
  "line": 39
});
formatter.step({
  "name": "User press button to calculate",
  "keyword": "When ",
  "line": 40
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "And ",
  "line": 41
});
formatter.step({
  "name": "system sends the file with all mandatory tags  ",
  "keyword": "And ",
  "line": 42,
  "matchedColumns": [
    0,
    1
  ]
});
formatter.step({
  "name": "40010 13495-000 13417-780 100 3 15",
  "keyword": "And ",
  "line": 43,
  "matchedColumns": [
    2,
    3,
    4,
    5,
    6,
    7
  ]
});
formatter.step({
  "name": "5 6 8 N 0 N",
  "keyword": "And ",
  "line": 44,
  "matchedColumns": [
    8,
    9,
    10,
    11,
    12,
    13
  ]
});
formatter.step({
  "name": "Correios API returns 16,50 and 1",
  "keyword": "Then ",
  "line": 45,
  "matchedColumns": [
    16,
    15
  ]
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
  "duration": 133420,
  "status": "passed"
});
formatter.scenario({
  "id": "freight-calculator;calculating-freight-price-and-deadline---api-integration;;5",
  "description": "",
  "name": "Calculating freight price and deadline - API Integration",
  "keyword": "Scenario Outline",
  "line": 52,
  "type": "scenario"
});
formatter.step({
  "name": "Items \u003cWheight\u003e \u003cWidth\u003e \u003cHeight\u003e \u003cLength\u003e",
  "keyword": "Given ",
  "line": 39
});
formatter.step({
  "name": "User press button to calculate",
  "keyword": "When ",
  "line": 40
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "And ",
  "line": 41
});
formatter.step({
  "name": "system sends the file with all mandatory tags  ",
  "keyword": "And ",
  "line": 42,
  "matchedColumns": [
    0,
    1
  ]
});
formatter.step({
  "name": "40045 13495-000 13417-780 100 1 15",
  "keyword": "And ",
  "line": 43,
  "matchedColumns": [
    2,
    3,
    4,
    5,
    6,
    7
  ]
});
formatter.step({
  "name": "5 6 8 N 0 N",
  "keyword": "And ",
  "line": 44,
  "matchedColumns": [
    8,
    9,
    10,
    11,
    12,
    13
  ]
});
formatter.step({
  "name": "Correios API returns 16,50 and 1",
  "keyword": "Then ",
  "line": 45,
  "matchedColumns": [
    16,
    15
  ]
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
  "id": "freight-calculator;getting-address---api-integration",
  "description": "",
  "name": "Getting address - API Integration",
  "keyword": "Scenario Outline",
  "line": 54,
  "type": "scenario_outline"
});
formatter.step({
  "name": "I have a valid and registered zip code \u003ccep\u003e",
  "keyword": "Given ",
  "line": 55
});
formatter.step({
  "name": "I press button to search",
  "keyword": "When ",
  "line": 56
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "And ",
  "line": 57
});
formatter.step({
  "name": "system sends the file with the mandatory tag \u003ccep\u003e",
  "keyword": "And ",
  "line": 58
});
formatter.step({
  "name": "Correios API returns \u003ccep\u003e \u003clogradouro\u003e \u003ccomplemento\u003e \u003cbairro\u003e \u003clocalidade\u003e \u003cuf\u003e \u003cibge\u003e \u003cgia\u003e",
  "keyword": "Then ",
  "line": 59
});
formatter.examples({
  "id": "freight-calculator;getting-address---api-integration;",
  "description": "",
  "name": "",
  "keyword": "Examples",
  "line": 61,
  "rows": [
    {
      "id": "freight-calculator;getting-address---api-integration;;1",
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
      "line": 62
    },
    {
      "id": "freight-calculator;getting-address---api-integration;;2",
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
      "line": 63
    },
    {
      "id": "freight-calculator;getting-address---api-integration;;3",
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
      "line": 64
    },
    {
      "id": "freight-calculator;getting-address---api-integration;;4",
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
      "line": 65
    }
  ]
});
formatter.before({
  "duration": 182170,
  "status": "passed"
});
formatter.scenario({
  "id": "freight-calculator;getting-address---api-integration;;2",
  "description": "",
  "name": "Getting address - API Integration",
  "keyword": "Scenario Outline",
  "line": 63,
  "type": "scenario"
});
formatter.step({
  "name": "I have a valid and registered zip code 01001000",
  "keyword": "Given ",
  "line": 55,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "I press button to search",
  "keyword": "When ",
  "line": 56
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "And ",
  "line": 57
});
formatter.step({
  "name": "system sends the file with the mandatory tag 01001000",
  "keyword": "And ",
  "line": 58,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "Correios API returns 01001000 Pra�a da S� lado �mpar S� S�o Paulo SP 3550308 1004",
  "keyword": "Then ",
  "line": 59,
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7
  ]
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
  "duration": 157612,
  "status": "passed"
});
formatter.scenario({
  "id": "freight-calculator;getting-address---api-integration;;3",
  "description": "",
  "name": "Getting address - API Integration",
  "keyword": "Scenario Outline",
  "line": 64,
  "type": "scenario"
});
formatter.step({
  "name": "I have a valid and registered zip code 01311300",
  "keyword": "Given ",
  "line": 55,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "I press button to search",
  "keyword": "When ",
  "line": 56
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "And ",
  "line": 57
});
formatter.step({
  "name": "system sends the file with the mandatory tag 01311300",
  "keyword": "And ",
  "line": 58,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "Correios API returns 01311300 Avenida Paulista de 1867 ao fim - lado �mpar Bela Vista S�o Paulo SP 3550308 1004",
  "keyword": "Then ",
  "line": 59,
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7
  ]
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
  "duration": 124990,
  "status": "passed"
});
formatter.scenario({
  "id": "freight-calculator;getting-address---api-integration;;4",
  "description": "",
  "name": "Getting address - API Integration",
  "keyword": "Scenario Outline",
  "line": 65,
  "type": "scenario"
});
formatter.step({
  "name": "I have a valid and registered zip code 22041080",
  "keyword": "Given ",
  "line": 55,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "I press button to search",
  "keyword": "When ",
  "line": 56
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "And ",
  "line": 57
});
formatter.step({
  "name": "system sends the file with the mandatory tag 22041080",
  "keyword": "And ",
  "line": 58,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "Correios API returns 22041080 Rua Anita Garibaldi  Copacabana Rio de Janeiro RJ 3304557 ",
  "keyword": "Then ",
  "line": 59,
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7
  ]
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
  "duration": 2174318,
  "status": "passed"
});
formatter.scenario({
  "id": "freight-calculator;empty-zip-code",
  "description": "",
  "name": "Empty zip code",
  "keyword": "Scenario",
  "line": 67,
  "type": "scenario"
});
formatter.step({
  "name": "I do not have a zip code \u003ccep\u003e",
  "keyword": "Given ",
  "line": 68
});
formatter.step({
  "name": "I press button to search",
  "keyword": "When ",
  "line": 69
});
formatter.step({
  "name": "should show an error with a message:",
  "keyword": "Then ",
  "line": 70,
  "doc_string": {
    "value": "O campo CEP n�o foi informado.",
    "line": 71,
    "content_type": ""
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
  "duration": 146250,
  "status": "passed"
});
formatter.scenario({
  "id": "freight-calculator;invalid-zip-code",
  "description": "",
  "name": "Invalid zip code",
  "keyword": "Scenario",
  "line": 75,
  "type": "scenario"
});
formatter.step({
  "name": "I have an invalid zip code \u003ccep\u003e",
  "keyword": "Given ",
  "line": 76
});
formatter.step({
  "name": "I press button to search",
  "keyword": "When ",
  "line": 77
});
formatter.step({
  "name": "should show an error with a message:",
  "keyword": "Then ",
  "line": 78,
  "doc_string": {
    "value": "O CEP informado � inv�lido. O formato correto � compsoto por {8} d�gitos.",
    "line": 79,
    "content_type": ""
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
  "duration": 86870,
  "status": "passed"
});
formatter.scenario({
  "id": "freight-calculator;address-not-found",
  "description": "",
  "name": "Address not found",
  "keyword": "Scenario",
  "line": 83,
  "type": "scenario"
});
formatter.step({
  "name": "I have a valid but not registered zip code \u003ccep\u003e",
  "keyword": "Given ",
  "line": 84
});
formatter.step({
  "name": "I press button to search",
  "keyword": "When ",
  "line": 85
});
formatter.step({
  "name": "system connects to Correios API",
  "keyword": "And ",
  "line": 86
});
formatter.step({
  "name": "system sends the file with the mandatory tag \u003ccep\u003e",
  "keyword": "And ",
  "line": 87
});
formatter.step({
  "name": "system returns an empty address object",
  "keyword": "And ",
  "line": 88
});
formatter.step({
  "name": "should show an error with a message:",
  "keyword": "Then ",
  "line": 89,
  "doc_string": {
    "value": "O CEP informado n�o foi encontrado.",
    "line": 90,
    "content_type": ""
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