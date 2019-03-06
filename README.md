# AmazonAutomation

This is the sample test project to demonstrate the Automation of WebApplications/WebSites using Selenium. The
website used in the project is "https://www.amazon.com" although the approach taken can be used to validate amazon website of other Locales as well Like India, Australia, USA, Canada etc.


#Getting Started

Clone the project, all the dependent jars has been attaches with the project itself

#Running the tests

Go to config.properties and set desired browser[Chrome/Firefox] and set the amazon locale in the URL parmeter, 
Go to test.java.testcases package to run the desired Testcases
Run as junit Application to run the desired testcases


#TestScope

Given Project tests the Basic Amazon functionalities and its core components like website launch,
Selection of Categories (Parameterized) as per the requirement. Making search and getting results and its other information 
like Price, Delivery Expected date etc as Assert as per the requirement of the TestScope and Test Matrix


#Coding Style and Tests

Used Open Source Junit Framework based on  POM model for the automation. Current support is for both chrome and IE( that can be parameterized in config.properties).
Using POM and Pagefactories enables the Framework to accomodate the changes in locators while keeping the functional components undisturbed. Components are generic and can be used as per the requirement of the testcases.
Tests has/can been coded to cover the core functionalities and print its result in the o/p TestResults.xlsx , that serves as the reporting for the end user.


#Build With
Framework Used: Junit 
Model of Framework: Page object Model
Reporting Medium: TestResults.xlsx

#Author
Prakhar Verma


