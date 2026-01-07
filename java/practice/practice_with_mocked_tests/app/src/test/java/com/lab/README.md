# Practice Writing and Running Tests with mocks


### Table for checking test suite bug coverage

# Bug Coverage Table

**X = test fails due to bug**

| SUT | Test name | Correct | Buggy Helper Wrong Length | Buggy Helper Allow Day ≤30 | Buggy Helper Allow Month 0 | Buggy Helper Incorrect Format False | Buggy Helper Messy Luhn | Buggy SSSN No Length Check | Buggy SSSN No Luhn | Buggy SSSN No Trim | Buggy SSSN Wrong Year |
|-----|-----------|---------|---------------------------|----------------------------|-----------------------------|------------------------------------|-------------------------|---------------------------|----------------------|---------------------|----------------------|
| SSNHelper | helperShouldReturnFalseIncorrectLength |  | X |  |  |  |  |  |  |  |  |
| SSNHelper | helperReturnTrueValidDay |  |  | X |  |  |  |  |  |  |  |
| SSNHelper | helperReturnFalseInvalidMonth |  |  |  | X |  |  |  |  |  |  |
| SSNHelper | helperReturnTrueFormatFalse |  |  |  |  | X |  |  |  |  |  |
| SSNHelper | helperReturnFalseIncorrectFormat |  |  |  |  | X |  |  |  |  |  |
| SSNHelper | helperShouldReturnTrueCorrectLuhn |  |  |  |  |  | X |  |  |  |  |
| SwedishSocialSecurityNumber | shouldContainThrowLenException |  |  |  |  |  |  | X |  |  |  |
| SwedishSocialSecurityNumber | shouldContainThrowLuhnException |  |  |  |  |  |  |  | X |  |  |
| SwedishSocialSecurityNumber | shouldContainThrowTrimException |  |  |  |  |  |  |  |  | X |  |
| SwedishSocialSecurityNumber | shouldNotAllowWrongYear |  |  |  |  |  |  |  |  |  | X |
| **Coverage** |  | 100% | 100% | 100% | 100% | 100% | 100% | 100% | 100% | 100% | 100% |


