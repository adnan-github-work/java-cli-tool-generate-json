# CLI Tool

#To run the cli tool with jar that is at the root folder of project

Command:
java -jar cli-tool.jar "hello world"

Output:
HELLO WORLD
hElLo wOrLd
CSV created!

Command:
java -jar cli-tool.jar hello

Output:
HELLO
hElLo
CSV created!

Command:
java -jar cli-tool.jar -all "hello world"

Output:
HELLO WORLD
hElLo wOrLd
CSV created!

Command:
java -jar cli-tool-0.0.1.jar -toUpperCase "hello world"

Output:
HELLO WORLD

Command:
java -jar cli-tool-0.0.1.jar -toAlternateCase "hello world"

Output:
hElLo wOrLd

Command:
java -jar cli-tool-0.0.1.jar -createCSVFile "hello world"

Output:
CSV created!


#To run in IDE:

Configure the main class with 'arguments'

1: "hello world"
2: hello
3: -all "hello world"
4: -toUpperCase "hello world"
5: -toAlternateCase "hello world"
6: -createCSVFile "hello world"


# To execute the test cases just fire "gradle clean build"
or
# To execute the test cases one by one then open in IDE and run CLITest.java