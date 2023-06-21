package Lib;

import DataProviders.ConfigReader;

public class FileReaderLib {
    private static final FileReaderLib fileReaderManager = new FileReaderLib();
    private static ConfigReader configFileReader;

    private FileReaderLib() {}

    public static FileReaderLib getInstance() {
        return fileReaderManager;
    }

    public ConfigReader getConfigFileReader() {
        return (configFileReader == null) ? new ConfigReader() : configFileReader;
    }
}
