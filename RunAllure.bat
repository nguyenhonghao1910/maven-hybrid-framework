set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%libAllure\aspectjweaver-1.8.10.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllure\*;%ProjectPath%libAllureReport\*;%ProjectPath%libLog4J\*;%ProjectPath%libraries\*;%ProjectPath%libExtendV5\*;%ProjectPath%libReportNG\*;%ProjectPath%libSelenium\*;%ProjectPath%libExtendV2\*;%ProjectPath%libWebDriverManager.5\*" org.testng.TestNG "%ProjectPath%bin\runNopcommerce.xml"
pause