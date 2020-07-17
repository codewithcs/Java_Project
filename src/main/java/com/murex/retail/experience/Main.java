package com.murex.retail.experience;

import java.io.IOException;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.nio.file.NoSuchFileException;
import static com.murex.retail.experience.Reader.getDataFromDB;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String FILEPATH = "src/main/resources/Inventory.csv";


    public static void main(String[] args) {

        try {
            Parser parser = new Parser(FILEPATH);
            List<String> parsedCSV = parser.readCSV();
            parser.replaceCommasAndLog(parsedCSV);

            InventoryParser inventoryParser = new InventoryParser();
            Inventory inventory = new Inventory(inventoryParser.createObjects(parsedCSV));

            Analyser analyser = new Analyser();
            analyser.performAnalysis(inventory);

            Writer writer = new Writer();
            writer.writeListToDb(inventory.getParsedInventory());

            List<ComputerComponent> list = getDataFromDB();
            Inventory inventory1 = new Inventory(list);
            analyser.performAnalysis(inventory1);

        } catch (NoSuchFileException e) {
            LOGGER.error("File not found", e);

        } catch (IOException e) {
            LOGGER.error("Error", e);
        }
    }


}

