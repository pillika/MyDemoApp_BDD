# My Demo App Testing
This repository contains test automation scripts for testing e-commerce **"My Demo App"** using Appium, IntelliJ, Android Studio, a physical Samsung Galaxy S21s device running Android 12, Appium Inspector, Cucumber, and Selenium and Java 17.0

## Table of Contents
    - Overview
    - Prerequisites
    - Setup
    - Running Tests
    - Projects tested functionalities
    - Contributing
    - License

## Overview
  This project focuses on the automated testing of e-commerce "My Demo App" using a combination of Appium, Cucumber, and Selenium and TestNG library. It is designed to run BDD (Behavior-Driven Development) test cases written in Gherkin syntax. The locators were determined using Appium Inspector (equiped with physical device). The tests are executed on a physical Samsung Galaxy A21s device running Android 12.

## Prerequisites
Ensure you have the following software/tools installed before setting up and running the tests:
    
-IntelliJ
-Android Studio
-Appium
-Node.js and npm
-Cucumber
-Selenium
-Physical device (preferably Android 12, with screen dimensions
-Appium Server
-[MyDemoApp](https://github.com/saucelabs/my-demo-app-rn) 

## Setup
### Clone this repository to your local machine: run command `git clone` in cmd 
```bash```
  https://github.com/pillika/MyDemoApp_BDD.git
### Open the project in IntelliJ.
### Install the following dependencies from
```bash```
    https://mvnrepository.com/
- java-client:9.0.0
- testng:7.8.0
- cucumber-java:7.14.1
- cucumber-core:7.14.1
- cucumber-junit:7.14.1
- cucumber-testng:7.14.1
- gherkin:27.0.0
- selenium-java:4.16.1
- commons-math3:3.5

### Configure the Appium server in "DriverFactory":
- IPAddress `"127.0.0.1"`
- Port`4723`
- Set base path `/wd/hub`
- Set the path to your main.js file
 `.withAppiumJS(new File("C:\\Program Files\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js")`

- Set the path to your node.exe file
`.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe")`

or launch a server with Appium GUI with the same IP adress, port and path as stated above.

### Set up the Android driver:
- Set your device name
                `.setDeviceName("Ugne A21s"))`
- Set your Udid  (run command `adb devices` in cmd)
                `.setUdid("R58NA0C07VL")`
- Set App Activity (if you are using physical device)
               `.setAppActivity("com.saucelabs.mydemoapp.rn.MainActivity")`
- Set App Package (if you are using physical device)
               `.setAppPackage("com.saucelabs.mydemoapp.rn")`
- Set platform name
               `.setPlatformName("Android")`
- Set platform version
               `.setPlatformVersion("12")`;

Follow the instructions on [how to get app package and activity](https://www.automationtestinghub.com/apppackage-and-appactivity-name/)

If you are using emulator :
- Instead of App package and activity, set path to the app
            `.setApp(System.getProperty("user.dir") + "/apps/MyDemoApp.apk")`

## Running tests
Run command `mvn clean` test or `mvn clean install` to run BDD tests, or use IntelliJ GUI functionality.

## Projects tested functionalities:
   - Login
   - Logout
   - Products list
   - Sort products
   - Detailed product description
   - Checkout

## Contributors
edON QA course

