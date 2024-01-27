package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReadFile {
    private static final Logger logger = LogManager.getLogger();
    private String inputFile;
    private String path;

    public ReadFile(String[] args) {
        Options options = new Options();
        options.addOption("i", true, "Input File");
        options.addOption("p", true, "Path");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            inputFile = cmd.getOptionValue("i","");
            path = cmd.getOptionValue("p", "");
        } catch(Exception e) {
            logger.error("/!\\ An error has occurred /!\\");
        }
    }

    public String getInputFile() {
        return inputFile;
    }

    public String getPath() {
        return path;
    }
}
