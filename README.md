# SimpleAdServer
Simple Ad Server

The application has been created using Jersey2 and Maven has been used to dependency control.

1. Download the application
2. Update Maven Dependencies
3. Execute Test Class test.SimpleAdServerTest
It will create a JettyTestContainer 
Test Cases validate the following scenarios:

a) Create Ad
b) Create Ad Fail - if Ad Already Exists
c) Fetch Existing Ad Details
d) Fetch Ad Details Failed - if Ad is not present
e) Fetch Ad Details Failed - if Ad is expired


The Application can also be deployed on Tomcat and url can be directly invoked using any Rest Client or browser.
