package com.cbt.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * UI_helper class has the methods mainly used for ui testing. There are a few string manipulation methods added to deal with dates.
 */
public class UI_Helper {
    /**
     * You use this method if you want to stop execution of your code.
     *
     * @param seconds number of seconds you want your execution of code to wait.
     */
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Use this if you want to open a specific url at any time of your testing.
     *
     * @param URL url you want to open
     */
    public static void navigateToURL(String URL) {
        try {
            Driver.getDriver().navigate().to(URL);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /**
     * Use if you want to get text associated with the webelement
     *
     * @param element element you want to get the text associtated with it
     * @return text associated with the webelement
     */
    public static String get_text_from_element(WebElement element) {

        return element.getText();
    }

    /**
     * use this method if you need to get text associated with a list of elements
     * multiline string will be split by line
     * @param webelements list of elements you want to get the text associtated with it
     * @return list of strings/texts for the webelement inputted
     */
    public static List<String> get_text_from_element_list(List<WebElement> webelements) {
        List<String> webelementText = new ArrayList<>();
        for (int i = 0; i < webelements.size(); i++) {
            if (webelements.get(i).getText().trim().length() > 0) {
                String[] lines = webelements.get(i).getText().split("\\r?\\n");
                for (String text : lines) {
                    if (text.trim().length() > 0) {
                        webelementText.add(text.trim());
                    }
                }
            }
        }
        return webelementText;
    }
    /**
     * use this method if you need to get text associated with a list of elements in lowercas format
     * multiline string will be split by line
     * @param webelements list of elements you want to get the text associtated with it
     * @return list of strings/texts for the webelement inputted
     */
    public static List<String> get_text_from_element_list_tolowercase(List<WebElement> webelements) {
        List<String> webelementText = new ArrayList<>();
        for (int i = 0; i < webelements.size(); i++) {
            if (webelements.get(i).getText().trim().length() > 0) {
                String[] lines = webelements.get(i).getText().split("\\r?\\n");
                for (String text : lines) {
                    if (text.trim().length() > 0) {
                        webelementText.add(text.trim().toLowerCase());
                    }
                }
            }
        }
        return webelementText;
    }
    /**
     * use this method if you need to get text and other inner HTML text associated with a list of elements
     *
     * @param webelements list of elements you want to get the text associtated with it
     * @return list of strings/texts for the webelement inputted
     */
    public static List<String> get_innerHTML_from_element_list(List<WebElement> webelements) {
        List<String> webelementText = new ArrayList<>();
        for (int i = 0; i < webelements.size(); i++) {
            webelementText.add(webelements.get(i).getAttribute("innerHTML"));
        }
        return webelementText;
    }

    /**
     * Use this if you want to get the text in textarea/input box
     *
     * @param input_box webelement that has the text in it
     * @return text  in the input box
     */
    public static String get_text_from_input_box(WebElement input_box) {
        return input_box.getAttribute("value");
    }

    /**
     * Use this if you want to get the selected option in the dropdown.
     *
     * @param dropdown (header) weblement that has all the options under it
     * @return returns the text associated with the selected option.
     */
    public static String get_selected_option_dropdown(WebElement dropdown) {
        return new Select(dropdown).getFirstSelectedOption().getText();
    }

    /**
     * Use this if you want to select from a dropdown based on the visible text of options
     *
     * @param dropdown (header) weblement that has all the options under it
     * @param select   visible text you want to select from the dropdown
     */
    public static void select_by_visible_text_dropdown(WebElement dropdown, String select) {
        new Select(dropdown).selectByVisibleText(select);
    }

    /**
     * Use this if you want to select from a dropdown based on index. Index for the first option is 0.
     *
     * @param dropdown (header) weblement that has all the options under it
     * @param index    index starts from 0 and can have maximum value that is one fewer than the number of options
     */
    public static void select_by_index_dropdown(WebElement dropdown, int index) {
        new Select(dropdown).selectByIndex(index);
    }

    /**
     * Use this if you want ot select from a dropdown based on the value associated with one option.
     *
     * @param dropdown (header) weblement that has all the options under it
     * @param value    value attribute for the element on the website, get this by inspeting the element
     */
    public static void select_by_value_dropdown(WebElement dropdown, String value) {
        new Select(dropdown).selectByValue(value);
    }

    /**
     * Use this if you want to get the list of all text values of all webelements in the dropdown
     *
     * @param dropdown (header) weblement that has all the options under it
     * @return List of strings (text values of webelements)
     */
    public static List<String> get_list_dropdown(WebElement dropdown) {
        List<WebElement> dropdown_elements = new Select(dropdown).getOptions();
        List<String> dropdown_list = new ArrayList<>();
        for (WebElement element : dropdown_elements) {
            if (element.getText().length() != 0) {
                dropdown_list.add(element.getText());
            }
        }
        return dropdown_list;
    }

    /**
     * Use this if you want to select radio_button based on its value
     *
     * @param radio_buttons List of webelements for all the radio buttons in consideration
     * @param radio_value   value associated with the webelement you want to select
     */
    public static void select_radio_button_by_value(List<WebElement> radio_buttons, String radio_value) {
        for (WebElement element : radio_buttons) {
            if (element.getAttribute("value").contains(radio_value)) {
                element.click();
            }
        }
    }

    /**
     * Use this if you want to select radio_button based on index
     *
     * @param radio_buttons List of webelements for all the radio buttons in consideration
     * @param index         index of hte element you want to select, index starts from zero.
     */
    public static void select_radio_button_by_index(List<WebElement> radio_buttons, int index) {
        String webelement_to_string = radio_buttons.toString();
        radio_buttons.get(index).click();
    }

    /**
     * Use this if you want to check the box based on atribute  value
     *
     * @param checkboxes      List of webelements for checkboxes in consideration
     * @param attribute       -attribute name for the checkbox you want to select, such as type, name, i, value
     * @param attribute_value value associated with the attribute you want to use
     */
    public static void select_checkbox_by_attribute_value(List<WebElement> checkboxes, String attribute,
                                                          String attribute_value) {
        for (WebElement element : checkboxes) {
            if (element.getAttribute(attribute).equalsIgnoreCase(attribute_value)) {
                if (!element.isSelected()) {
                    element.click();
                }
            }
        }

    }

    /**
     * use this if you want to select a checkbox based on index
     *
     * @param checkboxes list of webelements for checkboxes
     * @param index      index associated with the checkbox in consideration, index starts from 0.
     */
    public static void select_checkbox_by_index(List<WebElement> checkboxes, int index) {

        if (!checkboxes.get(index).isSelected()) {
            checkboxes.get(index).click();
        }
    }

    /**
     * Use this to right click an element
     *
     * @param element element you want to right click
     */
    public static void right_click(WebElement element) {
        new Actions(Driver.getDriver()).contextClick(element).perform();
    }

    /**
     * Use this to double click an element
     *
     * @param element element you want to double click
     */
    public static void double_click(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).perform();
    }

    /**
     * Use this if you want to take a screenshot and save it in a folder
     *
     * @param foldername     directory for the folder you want to save the screenshots in such as "target/Screenshots/"
     * @param screenshotName any name that you want to associate your screenshot image with
     * @return returns the path for the screenshot taken, not commonly used but in the case neededd it will return something
     * like target/Screenshots/Screenshot_Test_2019_08_21_04_06_19.png
     */
    public static String getScreenshot(String foldername, String screenshotName) {
        String screenshotTime = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String targetPath = foldername + screenshotName + "_" + screenshotTime + ".png";
        File destination = new File(targetPath);
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException ioe) {
        }
        return targetPath;
    }


    /*@Author - Sunil Kumawat
     *Overloaded getScreenshot method to add the screenshots in screenshots folder and to add the same in testNG emailable report
     *call
     */
    public static String getScreenshot(String fileName) {
        File source = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        String targetPath = System.getProperty("user.dir") + "\\screenshots\\" + fileName + System.currentTimeMillis() + ".jpg";
        File destination = new File(targetPath);
        try {
            FileUtils.copyFile(source, destination);
            Reporter.log("<a href='" + destination.getAbsolutePath() + "'> <img src='" + destination.getAbsolutePath() + "' align='middle' height='314' width='700'/></a>");
            Reporter.log(" ");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return targetPath;

    }

    /**
     * This will return number of rows for  records on a webtable
     *
     * @param table_element Webelement that includes webtable
     * @return number of rows on table records
     */
    public static int get_row_count_webtable(WebElement table_element) {
        return table_element.findElements(By.tagName("tr")).size();
    }

    /**
     * This will return number of nonblank rows for  records on a webtable
     *
     * @param table_element Webelement that includes webtable
     * @return number of nonblank rows on table records
     */
    public static int get_nonblank_row_count_webtable(WebElement table_element) {
        int row_count = 0;
        for (int i = 1; i <= table_element.findElements(By.tagName("tr")).size(); i++) {
            if (table_element.findElements(By.xpath("//tr[" + i + "]/td")).size() > 0) {
                if (table_element.findElement(By.xpath("//tr[" + i + "]")).getText().trim().length() > 0) {
                    row_count++;
                }
            }
        }
        return row_count;
    }

    /**
     * This will return the number of columns on webtable
     *
     * @param table_element Webelement that includes webtable
     * @return number of columns on the webtable in consideration
     */
    public static int get_column_count_webtable(WebElement table_element) {
        return table_element.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).size();
    }

    /**
     * This will return the string value on a webtable based on the column number and row number inputted
     *
     * @param table_element Webelement that includes webtable
     * @param row_number    row number of the record you want to get from the webtable
     * @param column_number column number of the record you want to get from the webtable
     * @return The text value of the record in the webtable
     */
    public static String get_cell_data_on_webtable(WebElement table_element, int row_number, int column_number) {
        return table_element.findElement(By.xpath("//tr[" + row_number + "]/td[" + column_number + "]")).getText();

    }

    /**
     * Use this if webtable has clickable cells on it
     *
     * @param table_element Webelement that includes webtable
     * @param row_number    row number for the cell you want to click
     * @param column_number column number for the cell you want to click
     */
    public static void click_cell_on_webtable(WebElement table_element, int row_number, int column_number) {
        table_element.findElement(By.xpath("//tr[" + row_number + "]/td[" + column_number + "]")).click();

    }

    /**
     * Use this if you want to get column number and row number of a record/records on a webtable
     *
     * @param table_element Webelement that includes webtable
     * @param value         the value of a record you are looking for on a webtable, such as "Visa" as method of payment
     * @return List of Map objects, somehting like this [{column=3, row=5}, {column=3, row=6}, {column=3, row=8}]
     */
    public static List<Map<String, Integer>> get_data_location_on_webtable(WebElement table_element, String value) {
        List<Map<String, Integer>> data_location_list = new ArrayList<>();
        for (int row_number = 1; row_number <= get_row_count_webtable(table_element); row_number++) {
            try {
                for (int column_number = 1; column_number <= get_column_count_webtable(
                        table_element); column_number++) {
                    Map<String, Integer> data_location_map = new HashMap<>();
                    if (table_element.findElement(By.xpath("//tr[" + row_number + "]/td[" + column_number + "]"))
                            .getText().equalsIgnoreCase(value)) {
                        data_location_map.put("column", column_number);
                        data_location_map.put("row", row_number);
                        data_location_list.add(data_location_map);
                    }
                }
            } catch (NoSuchElementException e) {

            }
        }
        return data_location_list;
    }

    /**
     * Use this method if you want to get list of DATA on column in a webtable
     *
     * @param table_element Webelement that includes webtable
     * @param column_number column number that you want to get the record from, it starts from 1
     * @return list of webtable record on the column in consideration
     */
    public static List<String> get_data_on_a_column_webtable(WebElement table_element, int column_number) {
        List<String> data_on_column = new ArrayList<>();
        List<WebElement> column_list = table_element.findElements(By.xpath("//tr/td[" + column_number + "]"));
        for (int i = 0; i < column_list.size(); i++) {
            if (column_list.get(i).getText().trim().length() > 0) {
                data_on_column.add(column_list.get(i).getText());
            }
        }
        return data_on_column;
    }

    /**
     * Use this method if you want to get the list of DATA on a row in a webtable
     * This METHOD WILL NOT INCLUDE ROWS THAT HAS NO DATA ON THEM
     *
     * @param table_element webelement that includes webtable
     * @param row_number    row number that you want to get the record from, it starts from 1
     * @return list of webtable record on the row in consideration
     */
    public static List<String> get_data_on_a_row_webtable(WebElement table_element, int row_number) {
        List<String> data_on_row = new ArrayList<>();
        try {
            for (int column_number = 1; column_number <= get_column_count_webtable(
                    table_element); column_number++) {
                if (table_element.findElement(By.xpath("//tr[" + row_number + "]")).getText().trim().length() > 0) {
                    data_on_row.add(table_element.findElement(By.xpath("//tr[" + row_number + "]/td[" + column_number + "]"))
                            .getText());
                }
            }
        } catch (NoSuchElementException e) {

        }
        return data_on_row;
    }


    /**
     * Use this method if you want to get all the data on a table as a List of Map objects
     * @param table_element Webelement that includes webtable
     * @return it will return something like this, [{Zip=748, #=2, State=US, Product=ScreenSaver, Street=5, Ringer Street, City=Las Vegas, NV, Card Number=123456789012, Exp=02/07, Date=03/12/2010, Name=Paul Brown, Card=MasterCard}, {Zip=76743, #=1, State=Canada, Product=FamilyAlbum, Street=9, Maple Valley, City=Whitestone, British, Card Number=770077007700, Exp=01/09, Date=03/07/2010, Name=Mark Smith, Card=VISA}, {Zip=21233, #=1, State=Canada, Product=ScreenSaver, Street=17, Park Avenue, City=Salmon Island, Card Number=444555444555, Exp=03/09, Date=02/26/2010, Name=Steve Johns, Card=MasterCard}, {Zip=23233, #=1, State=US, Product=MyMoney, Street=45, Stone st., City=Bringtone, TX, Card Number=333222333222, Exp=07/10, Date=02/15/2010, Name=Charles Dodgeson, Card=American Express}, {Zip=21444, #=1, State=Great Britain, Product=MyMoney, Street=7, Flower Street, City=Earlcastle, Card Number=999888777888, Exp=04/10, Date=01/05/2010, Name=Susan McLaren, Card=MasterCard}, {Zip=81734, #=1, State=US, Product=FamilyAlbum, Street=14, North av., City=Milltown, WI, Card Number=111222111222, Exp=06/08, Date=12/31/2009, Name=Bob Feather, Card=VISA}, {Zip=53665, #=2, State=US, Product=MyMoney, Street=3, Garden st., City=Hillsberry, UT, Card Number=398743242342, Exp=03/09, Date=12/21/2009, Name=Samuel Clemens, Card=MasterCard}, {Zip=63325, #=2, State=US, Product=FamilyAlbum, Street=23, Owk Street, City=Greentown, CA, Card Number=770000770000, Exp=03/08, Date=12/04/2009, Name=Clare Jefferson, Card=MasterCard}]
     */
    public static List<Map<String, Object>> get_all_data_on_webtable(WebElement table_element) {
        List<Map<String, Object>> table_data = new ArrayList<>();

        for (int row_number = 1; row_number <= get_row_count_webtable(table_element); row_number++) {
            Map<String, Object> data_location_map = new HashMap<>();
            try {
                for (int column_number = 1; column_number <= get_column_count_webtable(
                        table_element); column_number++) {

                    String header = table_element.findElement(By.xpath("//tr/th[" + column_number + "]")).getText()
                            .trim();
                    if (header.length() > 0) {
                        Object data = table_element
                                .findElement(By.xpath("//tr[" + row_number + "]/td[" + column_number + "]")).getText();
                        data_location_map.put(header, data);
                    }

                }
                table_data.add(data_location_map);
            } catch (NoSuchElementException e) {

            }
        }
        return table_data;
    }

    /**
     * Use this method if you want to get list of items on a table when table is not regular and no row order or column order exist
     * @param table_element webelement that includes the table in consideration
     * @return list of  items on the table in consideration
     */
    public static List<String> get_all_nonblank_cell_data_on_webtable(WebElement table_element) {
        List<String> table_data = new ArrayList<>();
        List<WebElement> webtable_content = table_element.findElements(By.xpath("//td"));
        for (WebElement element : webtable_content) {
            if (element.getText().trim().length() > 0) {
                table_data.add(element.getText().trim());
            }
        }
        return table_data;
    }
    /**
     * This is explicit wait. Use this if a specific element needs more time than implicit wait stated in your code for  visibility
     * @param element webelement you need to wait to be visible
     * @param timeToWaitInSec number of seconds you need to wait for the element to be visible
     * @return This will return Webelement with visibility condition set.
     */
    public static WebElement wait_for_visibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This is explicit wait. Use this if a specific element needs more time than implicit wait stated in your code for  clickability of an element
     * @param element webelement you need to wait to be clickable
     * @param timeToWaitInSec number of seconds you need to wait for the element to be clickable
     * @return This will return Webelement with clickability condition set.
     */
    public static WebElement wait_for_clickability(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Use this to scroll up or down by entering pixel number
     * @param pixel_number by default pixel is  set to zero, the greater the number from zero the further you school down,
     *                     the closer  the number to zero you scroll up.
     */
    public static void scroll_up_or_down_to_pixels(int pixel_number) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("scroll(0," + pixel_number + ")");

    }

    /**
     * Use this method if you want to scroll until an element is  into your view at the top of the screen
     * @param element webelement that you want to be viewed at the top of the screen by scrolling
     */
    public static void scroll_into_view(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true)", element);
    }

    /**
     * Use this mehtod to highlight  webelements
     * @param element webelement you want to highlight
     */
    public static void highLight_Element(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript(
                "arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            e.getMessage();
        }
    }

    /**
     * Use this method if you want to switch ot anather window. If you have more than  one windows/tabs open calling this mehtod will switch to the next one
     * @param driver WebDriver instance you are using in your test class
     */
    public static void switch_to_other_window_or_popup(WebDriver driver) {
        String parent_handle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String window_handle : windowHandles) {
            if (!window_handle.equals(parent_handle)) {
                driver.switchTo().window(window_handle);
            }
        }
    }

    @SuppressWarnings("finally")
    public static boolean validatePageLinks() {

        // ****************Verify Hyperlinks on Home Page are working fine*************
        String url = "";
        Boolean result = true;
        HttpURLConnection huc = null;
        int respCode = 200;
        List<WebElement> links = Driver.getDriver().findElements(By.xpath("//a[@href]"));
        Iterator<WebElement> it = links.iterator();
        while (it.hasNext()) {
            url = it.next().getAttribute("href");
            if (url == null || url.isEmpty() || url.contains("javascript")) {

                continue;
            }
            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
                if (respCode >= 400) {

                    result = false;
                }
            } catch (MalformedURLException e) {

                System.out.println("Malformed URL= " + url);
            } catch (IOException e) {
                System.out.println("Malformed URL= " + url);
            } finally {
                continue;
            }
        }
        return result;
    }

    /**
     * Use this method if you want to move over to a webelement.
     * @param element Weblement you want to move to
     */
    public static void move_to_element(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * Use this method if you want to clear default content and set new value for the input box.
     * @param element WebElement that you want to set the value for
     * @param keys the value you want to set for the input box
     */
    public static void clear_and_send_keys(WebElement element, String keys){
        element.clear();
        element.sendKeys(keys);
    }

    /**
     * use this method to set value (send keys) to an input box
     * @param element webelement you want to set the value for
     * @param keys the value you want to set for the webelement/input box
     */
    public static void js_send_keys(WebElement element, String keys){
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].value='"+keys+"';", element);
    }

    /**
     * Use this method if you want to get a string in the MMddYYYY format from YYYY_MM_dd_hh_mm_ss.
     * @param date_string String in YYYY_MM_dd_hh_mm_ss format
     * @return  String in MMddYYYY format
     */
    public static String date_from_YYYY_MM_dd_hh_mm_ss_to_MMddYYYY(String date_string) {
        return date_string.substring(5, 7) + date_string.substring(8, 10) + date_string.substring(0, 4);
    }
    /**
     * Use this method if you want to get a string in the YYYYMMdd format from YYYY_MM_dd_hh_mm_ss.
     * @param date_string String in YYYY_MM_dd_hh_mm_ss format
     * @return  String in YYYYMMdd format
     */
    public static String date_from_YYYY_MM_dd_hh_mm_ss_to_YYYYMMdd(String date_string) {
        return date_string.substring(0, 4) + date_string.substring(5, 7) + date_string.substring(8, 10);
    }

    /**
     * Use this method to insert decimal point for string values of currency
     * @param str string value of currency without decimal point
     * @return returns string value of currency with decimal point
     */
    public static String insert_decimal_point(String str) {
        if (str.length() > 2) {
            return str.substring(0, str.length() - 2) + "." + str.substring(str.length() - 2);
        }
        if (str.length() == 2) {
            return "0." + str;
        } else {
            return "0.0" + str;
        }
    }
}