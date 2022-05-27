
# Testing Suite

## Get Category API Endpoint
#### This API will get the category details after passing a category id.

## Prerequisite for setting up the project 
#### * Java 8 needs to be installed and make sure that environment variable paths have configured properly.
#### * Need to install maven 3.8.1+. Please set environment variable paths accordingly.
#### * Java based IDE of your preference.

## How to download and open the project in IDE
#### * Clone the project from git repository.
#### * Open the IDE and open the project as a maven project.
#### * Click on terminal in the IDE and type "mvn clean compile -DskipTests" and press enter. This will download all the dependencies in the pom.xml file and compile the project.

## How to Execute the tests
#### * Method 1- There is a regression.xml file under test package. Need to right-click on it and run.
#### * Method 2 - In the terminal type "mvn clean test"  and press enter.

## CategoryTest Class
#### * Contains the get category test method.
#### * This class can be used for all the tests related to category.

## URIs class
#### * All the URIs will be stored in this class.

## Constants File
#### * Includes all the constants used in the project

## StatusCode Class
#### * This class maintain the status codes of HTTP responses.

## RequestHandler Class
#### * This class is used to handle all the requests methods.
