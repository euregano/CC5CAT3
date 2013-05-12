CC5CAT3
=======

CC5CAT3

To build the project use Gradle you can get it from http://www.gradle.org/

After you have installed/unpacked gradle, open a shell and switch to the root directory (where the gradle.build file is).
- To build the jar execute 'gradle jar' or 'gradle build' (with gradle build the tests will be executed)
- To build a eclipse project execute 'gradle eclipse'

I have problems with gradle if the the path has with whitespaces. So be sure that there are no whitespaces in the path.

After you have executed the build command switch to build\libs and execute 

java -jar CC5CAT3.jar [file]
e.g. java -jar CC5CAT3.jar test.txt

That means the test.txt file is in the current dir. The file path must be relative to the current folder.

If the applications starts you see a list. Please select the analyzer which you like to perform and hit enter. If you like to see the analyzer list again type 'list'.
With 'exit' the application terminates.

Brief explanation of the design:

The AnalyzerContext holds the available analyzer, which can be switched at runtime. For that purpose each Analyzer must implement the interface IAnalyzer and the method execute(...) which will be than called by the general class AnalyzerContext.
However, common methods such isPurine which are used by more than one analyzer can be implemented as static methods in AnalyzerCommon. Furthermore the basic return type of functions is a boolean or an integer. There exists are data containers for complex types such counting of nucleobases.