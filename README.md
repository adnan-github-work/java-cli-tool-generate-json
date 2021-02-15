# Person Generator CLI Tool

#To run the person cli tool with person-cli-tool jar that is at the root folder of project

Command:
java -jar person-cli-tool.jar -f file_path

Output in logs:
{
"person": [
{
"first_name": "John",
"last_name": "Keynes",
"age": "29",
"favourite_colour": "red"
},
{
"first_name": "Sarah",
"last_name": "Robinson",
"age": "54",
"favourite_colour": "blue"
}
]
}

Command:
java -jar person-cli-tool.jar -d John Keats 25 British Red

Output:
{
"person": [
{
"first_name": "John",
"last_name": "Keats",
"age": "25",
"favourite_colour": "Red"
}]
}


#To run in IDE:

Configure the main class with 'arguments'

From direct input: 
-d John Keats 25 British Red 

From file input:
-f file_path


# To execute the test cases just fire "gradle clean build"
or
# To execute the test cases one by one then open in IDE and run CLITest.java
