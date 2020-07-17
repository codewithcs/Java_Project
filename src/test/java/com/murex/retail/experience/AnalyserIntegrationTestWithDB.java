package com.murex.retail.experience;

import org.apache.logging.log4j.core.util.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.murex.retail.experience.Reader.getDataFromDB;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnalyserIntegrationTestWithDB {

    static Analyser analyser;


    static Inventory inventory;
    static List<ComputerComponent> list;
    static Inventory inventoryDB;
    static Writer writer;
    @BeforeAll
    public static void setUp() throws IOException{


        Parser parser = new Parser("src/main/resources/Inventory.csv");
        List<String> parsedCSV = parser.readCSV();
        analyser = new Analyser();
        InventoryParser inventoryParser = new InventoryParser();
        inventory = new Inventory(inventoryParser.createObjects(parsedCSV));
        writer = new Writer();
        writer.writeListToDb(inventory.getParsedInventory());
        list = getDataFromDB();
        inventoryDB = new Inventory(list);
    }

    @Test
    void test_perform_analysis() throws URISyntaxException, IOException {
        String actualResult = analyser.performAnalysis(inventoryDB);
        String expectedResult = Files.lines(Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("performAnalysis")).toURI())).collect(Collectors.joining("\n"));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_sort_and_print_method() throws IOException, URISyntaxException {

        String actualResult = analyser.sortAndPrint((inventoryDB.getParsedInventory()));
        String expectedResult = Files.lines(Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("expectedResultOfSortAndPrint")).toURI())).collect(Collectors.joining("\n"));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_get_avg_price_method(){
        double actualResult = analyser.computeAvgPriceOfAllComponents((inventoryDB.getParsedInventory()));
        assertEquals(145.83, actualResult);
    }

    @Test
    void test_get_avg_price_of_cpu_components_method(){
        double actualResult = analyser.computeAvgPriceOfCPUComponents((inventoryDB.getParsedInventory()));
        assertEquals(92.43, actualResult);
    }

    @Test
    void test_method_returning_cheapest_object_details(){
        String actualResult = analyser.cheapestComponent((inventoryDB.getParsedInventory()));
        assertEquals("Optional[b5709966-76a6-48fb-ab72-18be9135230a\tMouse\tCaselogicEMS-800OpticalMouse\tCaseLogic\t2.2Wx0.5Lx4.4D\tBlack\t4\t45\n" +
                "]", actualResult);

    }

    @Test
    void test_print_most_expensive_of_each_category() throws URISyntaxException, IOException {
        String actualResult = analyser.getMostExpensiveOfEachCategory((inventoryDB.getParsedInventory()));
        String expectedResult = Files.lines(Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("expectedResultPrintMostExpensiveOfEachCategory")).toURI())).collect(Collectors.joining("\n"));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_report_of_quantity_of_components_per_category(){
        String actualResult = analyser.reportOfQuantityOfComponentsByCategory(inventoryDB.getParsedInventory());
        String expectedResult = "{Storage=82, Monitor=192, Mouse=312, Memory=141, Keyboard=285, CPU=1131, GPU=55}";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_report_of_quantity_of_components_per_category_and_brand(){
        String actualResult = analyser.reportOfQuantityOfComponentsByCategoryAndBrand(inventoryDB.getParsedInventory());
        String expectedResult = "{Storage={WesternDigital=15, Kingston=27, Samsung=10, Seagate=30}, Monitor={ViewSonic=20, LG=45, Samsung=47, Asus=80}, Mouse={Apple=20, Cougar=40, Razer=52, Kingston=15, CaseLogic=135, Microsoft=50}, Memory={Team=40, Kingston=89, Patriot=12}, Keyboard={Apple=20, logitech=90, RAZER=22, Microsoft=153}, CPU={AMD=210, Intel=921}, GPU={NVIDIA=55}}";
        assertEquals(expectedResult, actualResult);
    }


}