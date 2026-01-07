# Practice Writing and Running Tests


### Table for checking test suite bug coverage

| Test name ↓ \ Version → | Password | BugDoesNotTrim | BugToShortPassword | BugVeryShort | BugWrongExceptionMessage | BugMissingPasswordLengthCheck | BugMissingNumberCheck | BugIsPasswordSameAlwaysTrue | BugWrongHashingAlgorithm |
|---|---|---|---|---|---|---|---|---|---|
| shouldAlwaysPass | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ |
| constructorShouldTrimWhiteSpacesForPasswordWithSpaces | ✅ | ❌ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ |
| constructorShouldNotAllowShortPasswords | ✅ | ✅ | ❌ | ❌ | ✅ | ❌ | ✅ | ✅ | ✅ |
| constructorShouldNotAllowVeryShortPasswords | ✅ | ✅ | ✅ | ❌ | ✅ | ❌ | ✅ | ✅ | ✅ |
| constructorShouldHaveCorrectExceptionMessage | ✅ | ✅ | ✅ | ✅ | ❌ | ❌ | ✅ | ✅ | ✅ |
| constructorShouldCheckForNumber | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ❌ | ✅ | ✅ |
| isPasswordSameShouldBeFalseWithDiefferentPasswords | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ❌ | ✅ |
| differentPasswordShouldNotBeTheSame | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ❌ | ❌ |
| **Coverage** | **96.77%** | **100%** | **100%** | **100%** | **100%** | **100%** | **100%** | **93.33%** | **100%** |
