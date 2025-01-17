# java-cucumber-docker-example

## Contents


## Description

Example project showcasing how to run selenium cucumber tests with docker in Java.

## How to run the tests

There are two ways to run the tests either directly in the IDE or via Docker.

### How to run via docker

- Start the docker services
> docker compose up -d

- Set "remote" to true in resources/config/webdriver.yml
> remote: ${REMOTE:-true}

## Explaining the code

### driver package

This package contains all of the classes related to driver creation and initialisation.

This project makes use of the WebDriver Manager by BoniGarcia,
so no driver binaries are needed to be downloaded manually.

### pages package

This package should contain any classes for web pages that are under test.

### runner package

Contains any runners that are used to run the tests. 

Multiple runners can be added should you wish to run specific tags.

### stepdefs package

Contains the Hooks class which contains the beforeAll and afterAll hooks for driver initialisation and shutdown.

Also contains the relevant step definitions for the cucumber feature files.

### webdriver.yml

Located in the resources/config package, this yaml file contains the different run configurations for the tests. 
For example, the browser to test against, headless or not, timeout etc.

### features package

Contains all of the cucumber features