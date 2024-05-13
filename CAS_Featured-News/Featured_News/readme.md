CAS Project Requirements:

Featured News

Problem Statement: Featured News

Validate news displayed in SharePoint BeCognizant.
Get news details from BeCognizant.
Validate associate details (News or Article written).
Validate hyperlinks
Validate share options.

(Suggested Site: https://be.cognizant.com)

Detailed Description: Main Project

Navigate to Be. Cognizant Website and capture the user information.
Validate the news displayed in BeCognizant.
Validate news header and tooltip are displayed same.
Click on each news to and print all the data displayed.
Validate associate details are displayed in pop up when hovered.
Validate hyperlinks displayed in newsletter.
Validate share option is displayed when we click on each news and print all the options displayed in share option.
Print number of likes and views for each news.
Note: Take all necessary screenshots for all the testcases and print all the data in the console.

Key Automation Scope

Handling alert, different browser windows, search option.
Navigating back to home page.
Extract multiple options items & store in collections.
Capture warning message.
Data Driven approach.
Cross Browser Testing.


Selenium Automation Testing Project: Featured News

Project OverView:
This is a java selenium project automate to Be.Cognizant Website.It includes TestNG,Page Object Model to make the project and use Apache POI for data-driven testing to create Excel file.It includes extentReportManager for generating the test report.

Project Structure:

1.Maven Repository
Maven Version: 3.9.3

2.Dependencies
Apache POI
Version: 5.2.2
Purpose: Used for reading and writing Excel files, facilitating data-driven testing.

TestNG
Version: 7.7.1
Purpose: Framework for test automation that allows for parallel execution and flexible test configuration.

Extent Report
Version: 5.0.9
Purpose: Generates interactive and detailed HTML reports to enhance test result analysis.

Selenium
Version: 4.15.0
Purpose: Enables interaction with web elements, navigation, and form submission in the browser.


Automation Test Flow:
1.Open https://be.cognizant.com
Navigate to the https://be.cognizant.com

2.capture User Information
After navigating this website take details of user 
print it in console
capture screenshot of the page


3.Validate the news displayed in BeCognizant.
validate the News Header and Tooltip is displayed and print all the data after clicking each news
print it in console


4.Hover on Associate Details 
Hover on associate details and display details

5.Validate hyperlinks displayed in newsletter.
validate all hyperlinks present in each news page
print it in console

6.Validate share option is displayed when we click on each news and print all the options displayed in share option.
validate share option is dispalyed and enabled of this page
share options print it in console
capture screenshot of pages

7.Print number of likes and views for each news.
Scroll down to the page and take total likes and total views
print it in console

How to Run the Tests
1.Open Eclipse IDE:
Launch Eclipse IDE on your machine.

2.Import Project:
Select File -> Import from the menu.
Choose Existing Maven Projects and click Next.
Browse to the directory where you cloned the repository and select the project.

3.Update Maven Project:
Right-click on the project in the Project Explorer.
Choose Maven -> Update Project.

4.Click OK to update dependencies.
Set Up Configuration:
Open the src/test/resources/config.properties file.
Update any configuration parameters like browser type, URLs, etc., as needed.

5.Run Test Suite:
Locate the test suite file (e.g., src/test/java/TestSuite.java).
Right-click on the file and choose Run As -> TestNG Suite.

6.View Reports:
After execution, open the test-output folder.
Find the Extent Report HTML file (index.html) for detailed test reports.

Author Information:
Moupali Sen(2317616)