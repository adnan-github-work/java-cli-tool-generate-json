package com.cli.tool;

import com.cli.tool.handlers.Handler;
import com.cli.tool.operations.FileUtil;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.cli.tool.Constants.DIRECT_INPUT;
import static com.cli.tool.Constants.FILE_INPUT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CLITest {

    private FileUtil createFileUtil;
    private FileUtil readFileUtil;
    String fileName = "person.txt";
    String expectedOutputFromFile = "{\n" +
            "  \"person\" : [ {\n" +
            "    \"firstName\" : \"John\",\n" +
            "    \"lastName\" : \"Keynes\",\n" +
            "    \"age\" : 29,\n" +
            "    \"favouriteColour\" : \"red\"\n" +
            "  }, {\n" +
            "    \"firstName\" : \"Sarah\",\n" +
            "    \"lastName\" : \"Robinson\",\n" +
            "    \"age\" : 54,\n" +
            "    \"favouriteColour\" : \"blue\"\n" +
            "  } ]\n" +
            "}";
    String getExpectedOutputForDirectInput = "{\n" +
            "  \"person\" : [ {\n" +
            "    \"firstName\" : \"john\",\n" +
            "    \"lastName\" : \"keats\",\n" +
            "    \"age\" : 67,\n" +
            "    \"favouriteColour\" : \"black\"\n" +
            "  } ]\n" +
            "}";



    @Before
    public void setUpTestData(){
        readFileUtil = new FileUtil(fileName);
    }

    @Test
    public void testGeneratePersonJsonByReadingFile() throws IOException {

        assertEquals(expectedOutputFromFile, readFileUtil.readFile().toJSONString());

    }

    @Test
    public void testGeneratePersonJsonByReadingFileNotFound() throws IOException {
        readFileUtil = new FileUtil("dummy.txt");
        assertNull(readFileUtil.readFile());
    }

    @Test
    public void testHandlerGeneratePersonJsonByReadingFile() throws IOException {
        String arg[] = {"-f", fileName};
        assertEquals(expectedOutputFromFile, Handler.handleCommands(createOptions(), arg).toJSONString());

    }

    @Test
    public void testHandlerGeneratePersonJsonByReadingFileNotFount() throws IOException {
        String arg[] = {"-f", "file.txt"};
        assertNull(Handler.handleCommands(createOptions(), arg));
    }

    @Test
    public void testHandlerGeneratePersonJsonByDirectInput() throws IOException {
        String arg[] = {"-d", "john", "keats", "67", "British", "black"};
        assertEquals(getExpectedOutputForDirectInput, Handler.handleCommands(createOptions(), arg).toJSONString());

    }

    @Test
    public void testHandlerGeneratePersonJsonByDirectInputFailed() throws IOException {
        String arg[] = {"-d", "john", "keats", "67"};
        assertNull(Handler.handleCommands(createOptions(), arg));
    }

    private static Options createOptions() {
        Options options = new Options();

        options.addOption(Option.builder("d")
                .longOpt(DIRECT_INPUT)
                .hasArg(true)
                .desc("require user direct input to give person details  and then generate the json output")
                .required(false)
                .build());
        options.addOption(Option.builder("f")
                .longOpt(FILE_INPUT)
                .hasArg(true)
                .desc("require text file as an input to give person details  and then generate the json output")
                .required(false)
                .build());
        return options;
    }

}
