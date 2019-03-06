# AmazonAutomation

This is the sample test project to demonstrate the Automatation of WebApplications/WebSites using Selenium. The
webiste used in the project is "https://www.amazon.com" although the approach taken can be used to validate amazon website of other locales as well Like India, Australia, USA, Canada etc.


#Getting Started

Clone the project, all the dependent jars has been attaches with the project itself

#Running the tests
>Go to config.properties and set desired browser[Chrome/Firefox] and set the amazon locale in the URL parmeter
>Go to test.java.testcases package to run the desired Testcases
>Run as junit Application to run the desired testcases


#TestScope

Given Project tests the Basic Amazon functionlaties and its core components like webisire launch,
Selection of Categories (Parametrized) as per the requiremet. Making search and getting results and its other information 
like Price, Delivery Expected date etc as Assert as per the requirement of the TestScope and Test Matrix


#Coding Style and Tests

Used POM model for the automation on any 2 browser ie, firefox and chrome [IE to be supported in next release]. Used open jnuit for the open 
By using POM and pagefactories enables the Framweork to accomodate the changes in locators while keeping the functional componnets undisturbed. Components are genric and can be used as per the requirement of the testcases.
Tests can been coded to cover the core functionalities and print its result in the o/p TestResults.xlsx sheet that will give the end user about the status of the executed test results.


#Build With
Framework Used: Junit 
Model of Framework: Page object Model
Reporting Medium: TestResults.xlsx

#Author
Prakhar Verma


