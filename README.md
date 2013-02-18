*(Preventively Forked from https://github.com/iainrose/page-objects on Nov 30, 2012)

TODO: Learn clever encapsulation of Selenium Calls.

This project seems to be rigorous in its attempt to build an abstaction layyer on top of Selenium Webdriver. 
Very interesting, never used (complex dependencies)*

This project is an example of building a test automation framework using WebDriver w Java, TestNG, Gradle with Eclipse.

It extends the basic tutorial found on the Selenium Wiki and runs a couple of tests against www.icdp-online.org

http://code.google.com/p/selenium/wiki/GettingStarted
http://code.google.com/p/selenium/wiki/PageObjects

There are a couple of key concepts demonstrated in this project that will help you get started.

- Switching the navigation of the tests from one page object to another
- Abstracting the test setup into a BaseTest class
- Using TestNG and Gradle to run the tests

Creating the IDE project
------------------------

Eclipse
cd ~/<checkout dir>/page-objects
./gradlew eclipse

If you don't want to use Gradle you can also do this manually, as explained here by Simon Stewart aka The WebDriver guy.
http://www.youtube.com/watch?v=Eft3qGFoqwE

If you want to update the version of Selenium or TestNG you are using just update the version numbers in build.gradle and rerun the above commands to regenerate your project.

Writing the Tests
-----------------

I find using a Test Driven (Test) Development approach works well here.
- Write the test
- Create the Page Object Methods
- Create the Page Object Locators
- Run the test and debug until it passes

Note also that the tests don't know anything about WebDriver .... keep it that way!

Building the Page Objects
-------------------------

You can use the PageFactory helper to define your locators

http://code.google.com/p/selenium/wiki/PageFactory

However, I prefer to store them as By objects

There are several reasons for this:

- The WebElement will get looked up each time you use the locator which can help avoid stale element exceptions
- You can reuse your locators in methods that assert the presence or absence of a WebElement (return driver.findElements(yourByObjectLocator).size() > 0)
- Personally I think they look cleaner in the code

Running the tests via the IDE
-----------------------------

Right click on the test and select 'run' or 'debug'

Running the tests using Gradle
------------------------------
Install Gradle with 3 "apt" Commands: See http://yarovoy.com/post/34120695751/install-gradle-12-on-ubuntuu 

Unset JAVA_OPTS

Unless you have Gradle installed, you'll need to use the Gradle wrapper which is included in the project
./gradlew or gradle.bat on Windows

To run all tests (uses Firefox by default)
./gradlew clean test

To run a single test class
./gradle clean test -Dtest.single="ExampleTest"

To run only tests belonging to group 1 (as defined in the includegroup1 task in build.gradle)
./gradlew clean includegroup1

To run only tests not belonging to group 1 (as defined in the excludegroup1 task in build.gradle)
./gradlew clean excludegroup1

To run tests in Chrome
./gradle clean test -DBROWSER=chrome

To run tests in IE
gradle.bat clean test -DBROWSER=internetExplorer



All and any feedback welcome and appreciated, I'm still learning too.
<<<<<<< HEAD
@sudo_f
=======
@iainrose
>>>>>>> 1828bb6677daec118f57121d792a29d4f1ce0751
