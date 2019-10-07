# assignmentCred

Functional Requirements:

Conditional expression supports any infix expression --- added sample test cases for running via the main function

Supported operators >, >=, <=, <, ==, !=, BETWEEN, ALLOF, NONEOF --- added support classes for all operators

The module is extensible to allow new attributes and new operators without major changes --- For adding an attribute, a variable needs to be added in the class User or Address or UserInfo, and a getter function needs to be added and constructor should be modified.

--- For adding a new operator, an operator class needs to be defined which implements the LogicalOperator interface, and an instance of the new class needs to be added in the populateOperators() function of the ConditionEvaluator class.

User attributes supported

--- { User = { Name Address = { firstLine secondLine City State Country PinCode } Email Phone Age Gender } PastOrderAmount PreferredModeOfPayment AccountType CustomerType }

Assumptions

Just keep in mind the following while creating the conditional expression :

---Between each operand and operator use whitespace. Whitespace is also required before and after brackets ()