CC5CAT3
=======

CC5CAT3

To build the project use Gradle. You can get it from http://www.gradle.org/

After you have installed/unpacked gradle, open a shell and switch to the root directory (where the gradle.build file is). Be sure that you set the gradle executable in your path.
- To build the jar execute 'gradle jar' or 'gradle build' (with gradle build the tests will be also executed)
- To build an eclipse project execute 'gradle eclipse'

There are currently problems with whitespaces in path. So be sure that there aren't any whitespaces in the path.

After you have executed the build command switch to build\libs and execute 

java -jar CC5CAT3.jar [file]
e.g. java -jar CC5CAT3.jar test.txt

That means the test.txt file is in the current dir. The file path must be relative to the current folder.

If the application starts you see a list of available analyzer. Select an analyzer you like (e.g. 0 for BrownEyesAnalyzer) and hit enter. Type 'list' to see the list of available analyzers again. Type 'exit' to quit the application.

(The commands should be typed without quotation marks)

Brief explanation of the design:
The AnalyzerContext holds the available analyzer, which can be switched at runtime. For that purpose each Analyzer must implement the interface IAnalyzer and the method execute(...) which will be than called through the general class AnalyzerContext.
However, common methods such isPurine which are used by more than one analyzer can be implemented as static methods in AnalyzerCommon. Furthermore the basic return type of functions is a boolean or an integer. There are data containers for complex types such counting of nucleobases.

Additional:
There are also test cases for simple/common data input and for the reference data. For the test case complementary computing there wasn't the possibility to do it manually. So I print the output on std. However, the simple data case works. 
Furthermore I have checked the correct output of the reference data in a simple editor called notepad++ e.g. count g,t,c or a or look for distinct sequences of 'ggg'. The reference input is checked against this information. Also have a look at the comments.