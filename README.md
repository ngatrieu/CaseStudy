# CaseStuty project

Framework Architecture
--------------
	Project-Name
		|
		|_config
		|	|_conf.properties
		|_src/main/java
		|	|_DataProvider
		|	|	|_ConfigReader.java
		|	|	|...
		|	|_Enums
		|	|	|_DriverType.java
		|	|	|_EnvironmentType.java
		|	|	|...
		|	|_Lib
		|	|	|_DriverManager.java
		|	|	|_FileReaderLib
		|	|	|_PageObjectManager
		|	|	|...
		|	|_Pages
		|	|	|_UploadPage.java
		|	|	|...
		|	|_Utilities
		|	|	|_TestContext.java
		|	|	|_Utils.java
		|	|	|...
		|_src/test/java
		|	|_runner
		|	|	|_CucumberTest.java
		|	|_stepDefinition
		|	|	|_Hooks.java
		|	|	|_UploadStepDef.java
		|	|	|...
		|_src/test/resources
		|	|_data
		|	|	|...
		|	|_features
		|	|	|_upload.feature
		|	|	|...

* **src/test/resources/features** - all the cucumber features files (files .feature ext) goes here.
* **src/test/java/StepDefinition** - you can define step definition under this package for your feature steps. Hooks where you can configure all before and after test settings Hooks.java
* **src/test/java/Runner** - cucumber Runner where you can configure your glue code location (step definitions), define test result output format.(html, json, xml).
* **src/test/resources/data** - storing data to test  
* **/config** - config your test environment, browser,...
* **src/main/java/Lib** - DriverManager.java contains code for initializing driver instances for respective driver.
* **src/main/java/Enums** - contains the constants.
* **src/main/java/Pages** - contains the page objects.
* **src/main/java/Utilities** - contains helpers and utility codes.


Setup
--------------
* `install JDK: Java 11 recommended`
* `install IDE tool like: IntelliJ IDEA`
* `download & install maven at: https://maven.apache.org/install.html`
* `check maven version: mvn --version`
* `setup allure report: brew install allure (on MAC)`
* `check allure version: allure --version`

Running test
--------------

Go to your project directory from terminal and hit following commands
* `At project terminal, in first time of run, call "mvn clean install" to makesure all dependencies downloaded then run the test. And from second time of run, just call "mvn clean test" to run`
* `At current project path, call "allure serve target/allure-results" to view report.`





