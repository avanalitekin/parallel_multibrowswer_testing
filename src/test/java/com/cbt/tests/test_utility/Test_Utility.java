package com.cbt.tests.test_utility;

import com.aventstack.extentreports.Status;
import com.cbt.tests.TestBase;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cbt.reports.ExtentTestManager.extent_report;
import static com.cbt.reports.ExtentTestManager.extent_test_logger;
import static com.cbt.utilities.Driver.getDriver;
import com.cbt.utilities.UI_Helper;
import static com.cbt.utilities.UI_Helper.sleep;

import java.util.List;






public class Test_Utility extends TestBase {


        @Test(priority = 1)
    public void login_test() {
            String methodName = new Throwable().getStackTrace()[0].getMethodName();
            System.out.println(methodName);
            extent_test_logger=extent_report.createTest(methodName);
        getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/VerifyLogin.aspx");
        pages.test_page_login().login();
    }

        @Test(priority = 2)
    public void test_navigateTo() {
            String methodName = new Throwable().getStackTrace()[0].getMethodName();
            System.out.println(methodName);
            extent_test_logger=extent_report.createTest(methodName);
        getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/VerifyLogin.aspx");
        UI_Helper.navigateToURL("https://www.google.com");
        sleep(2);
        UI_Helper.navigateToURL("https://www.amazon.com");
        sleep(2);
        getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/VerifyLogin.aspx");
    }

        @Test(priority = 3)
    public void test_get_text_box_value() {
            String methodName = new Throwable().getStackTrace()[0].getMethodName();
            System.out.println(methodName);
            extent_test_logger=extent_report.createTest(methodName);
        getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/VerifyLogin.aspx");
        pages.test_page_login().username_box.sendKeys("Tester");
        sleep(2);
        String text_box_value = UI_Helper.get_text_from_input_box(pages.test_page_login().username_box);
        System.out.println(text_box_value);
    }

        @Test(priority = 4)
    public void test_get_selected_dropdown() {
            String methodName = new Throwable().getStackTrace()[0].getMethodName();
            System.out.println(methodName);
            extent_test_logger=extent_report.createTest(methodName);
        getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/VerifyLogin.aspx");
        pages.test_page_login().login();
        pages.test_page_order().oder_link.click();
        System.out.println(UI_Helper.get_selected_option_dropdown(pages.test_page_order().product_dropdown));
    }

        @Test(priority = 5)
    public void test_select_by_visible_text() {
            String methodName = new Throwable().getStackTrace()[0].getMethodName();
            System.out.println(methodName);
            extent_test_logger=extent_report.createTest(methodName);
        getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/VerifyLogin.aspx");
        pages.test_page_login().login();
        pages.test_page_order().oder_link.click();
        UI_Helper.select_by_visible_text_dropdown(pages.test_page_order().product_dropdown, "ScreenSaver");
        sleep(3);
    }

        @Test(priority = 6)
    public void test_select_by_index() {
            String methodName = new Throwable().getStackTrace()[0].getMethodName();
            System.out.println(methodName);
            extent_test_logger=extent_report.createTest(methodName);
        getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/VerifyLogin.aspx");
        pages.test_page_login().login();
        pages.test_page_order().oder_link.click();
        UI_Helper.select_by_index_dropdown(pages.test_page_order().product_dropdown, 2);
            sleep(3);
            UI_Helper.select_by_index_dropdown(pages.test_page_order().product_dropdown, 0);
            sleep(3);
    }

        @Test(priority = 7)
    public void test_select_by_value() {
            String methodName = new Throwable().getStackTrace()[0].getMethodName();
            System.out.println(methodName);
            extent_test_logger=extent_report.createTest(methodName);
        getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/VerifyLogin.aspx");
        pages.test_page_login().login();
        pages.test_page_order().oder_link.click();
        UI_Helper.select_by_value_dropdown(pages.test_page_order().product_dropdown, "ScreenSaver");
        sleep(3);
    }

        @Test(priority = 8)
    public void test_get_dropdown_list() {
            String methodName = new Throwable().getStackTrace()[0].getMethodName();
            System.out.println(methodName);
            extent_test_logger=extent_report.createTest(methodName);
        getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/VerifyLogin.aspx");
        pages.test_page_login().login();
        pages.test_page_order().oder_link.click();
        System.out.println(UI_Helper.get_list_dropdown(pages.test_page_order().product_dropdown));
        sleep(3);
    }

        @Test(priority = 9)
    public void test_select_radio_button_by_value() {
            String methodName = new Throwable().getStackTrace()[0].getMethodName();
            System.out.println(methodName);
            extent_test_logger=extent_report.createTest(methodName);
        getDriver().get("http://demo.guru99.com/test/radio.html");
        String option="Option 1";
//        String option="Option 2";
//        String option = "Option 3";
        UI_Helper.select_radio_button_by_value(pages.test_radio_checkbox().radio_buttons, option);
        sleep(3);
    }

        @Test(priority = 10)
    public void test_select_radio_button_by_index() {
            String methodName = new Throwable().getStackTrace()[0].getMethodName();
            System.out.println(methodName);
            extent_test_logger=extent_report.createTest(methodName);
        getDriver().get("http://demo.guru99.com/test/radio.html");
        UI_Helper.select_radio_button_by_index(pages.test_radio_checkbox().radio_buttons, 2);
        sleep(3);
    }

    @Test(priority = 11)
    public void test_select_checkbox_by_value() {
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
            System.out.println(methodName);
        extent_test_logger=extent_report.createTest(methodName);
        getDriver().get("http://demo.guru99.com/test/radio.html");
//        String attribute="id";
//        String attribute_value="vfb-6-0";
//        String attribute_value="vfb-6-1";
//        String attribute_value="vfb-6-2";


        String attribute="value";
                String attribute_value = "checkbox1";
//        String attribute_value="checkbox2";
//        String attribute_value="checkbox3";
        UI_Helper.select_checkbox_by_attribute_value(pages.test_radio_checkbox().check_boxes,attribute,attribute_value);
            sleep(3);
        }

        @Test(priority=12)
        public void test_select_checkbox_by_index(){
            String methodName = new Throwable().getStackTrace()[0].getMethodName();
            System.out.println(methodName);
            extent_test_logger=extent_report.createTest(methodName);
        getDriver().get("http://demo.guru99.com/test/radio.html");
        UI_Helper.select_checkbox_by_index(pages.test_radio_checkbox().check_boxes,0);
        UI_Helper.select_checkbox_by_index(pages.test_radio_checkbox().check_boxes,2);
        sleep(3);
        }

    @Test(priority = 13)
    public void test_select_right_click_double_click() {
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
            System.out.println(methodName);
        extent_test_logger=extent_report.createTest(methodName);
        getDriver().get("http://demo.guru99.com/test/simple_context_menu.html");
        UI_Helper.double_click(pages.double_click_rigth_click().double_click);
        sleep(1);
        getDriver().switchTo().alert().accept();
        UI_Helper.right_click(pages.double_click_rigth_click().right_click);
        sleep(1);

    }
    @Test(priority = 14)
    public void test_screenshot() {
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
            System.out.println(methodName);
        extent_test_logger=extent_report.createTest(methodName);
        getDriver().get("https://www.amazon.com");
        String foldername="target/Screenshots/";
        String screen_shot_name="Screenshot_Test";
       System.out.println(UI_Helper.getScreenshot(foldername,screen_shot_name));

    }

    @Test(priority = 15)
    public void test_webtable_methods() {
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
            System.out.println(methodName);
        extent_test_logger=extent_report.createTest(methodName);
        getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/VerifyLogin.aspx");
        pages.test_page_login().login();
        pages.view_all_orders().view_all_orders_link.click();
        System.out.println("row count all: "+UI_Helper.get_row_count_webtable(pages.view_all_orders().web_table));
        System.out.println("non_blank_row_count: "+UI_Helper.get_nonblank_row_count_webtable(pages.view_all_orders().web_table));
        System.out.println(UI_Helper.get_column_count_webtable(pages.view_all_orders().web_table));
        System.out.println(UI_Helper.get_cell_data_on_webtable(pages.view_all_orders().web_table,5,9));
        System.out.println(UI_Helper.get_cell_data_on_webtable(pages.view_all_orders().web_table,5,10));
        UI_Helper.click_cell_on_webtable(pages.view_all_orders().web_table,2,1);
        sleep(3);
        UI_Helper.click_cell_on_webtable(pages.view_all_orders().web_table,2,13);
        sleep(3);
        pages.view_all_orders().view_all_orders_link.click();
        sleep(3);
        System.out.println(UI_Helper.get_data_location_on_webtable(pages.view_all_orders().web_table,"MyMoney"));
        System.out.println(UI_Helper.get_all_data_on_webtable(pages.view_all_orders().web_table));
       List<String> column_list=UI_Helper.get_data_on_a_column_webtable(pages.view_all_orders().web_table,3);
for (String data:column_list){
    System.out.println(data);
}
List<String> row_list=UI_Helper.get_data_on_a_row_webtable(pages.view_all_orders().web_table,3);
        for (String data:row_list){
            System.out.println(data);
        }
       sleep(1);

    }
    @Test(priority=16)
    public void test_wait_for_visibility(){
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
            System.out.println(methodName);
        extent_test_logger=extent_report.createTest(methodName);
        getDriver().get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
        pages.wait_visibiliy_clickabality().click_me_to_start.click();
        UI_Helper.wait_for_visibility(pages.wait_visibiliy_clickabality().webdriver_text,14);
        System.out.println(pages.wait_visibiliy_clickabality().webdriver_text.isDisplayed());
        pages.wait_visibiliy_clickabality().click_me_to_start.click();
        sleep(3);

    }

    @Test(priority=17)
    public void test_scroll_methods() {
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
            System.out.println(methodName);
        extent_test_logger=extent_report.createTest(methodName);
        getDriver().get("https://www.amazon.com");
        UI_Helper.scroll_up_or_down_to_pixels(5000);
        sleep(3);
        UI_Helper.scroll_up_or_down_to_pixels(2500);
        sleep(3);
        UI_Helper.scroll_up_or_down_to_pixels(0);
        sleep(3);
        UI_Helper.scroll_into_view(pages.scroll_into_view().get_to_know_us);
        sleep(3);
        UI_Helper.scroll_into_view(pages.scroll_into_view().today_s_deals);
        sleep(3);
    }

    @Test(priority = 18)
    public void test_highlight_element(){
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
            System.out.println(methodName);
        extent_test_logger=extent_report.createTest(methodName);
        getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/VerifyLogin.aspx");
        extent_test_logger.log(Status.INFO,"higlighting username box");
        UI_Helper.highLight_Element(pages.test_page_login().username_box);
        extent_test_logger.log(Status.INFO,"higlighting password box");
        UI_Helper.highLight_Element(pages.test_page_login().password_box);
        extent_test_logger.log(Status.INFO,"higlighting login buttons");
        UI_Helper.highLight_Element(pages.test_page_login().login_button);
        pages.test_page_login().login();
        extent_test_logger.log(Status.INFO,"verifying title");
        Assert.assertTrue(getDriver().getTitle().equals("amazon"));
        extent_test_logger.log(Status.INFO, "title verified");

    }

    @Test(priority = 19)
    public void test_popup_windows(){
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
            System.out.println(methodName);
        extent_test_logger=extent_report.createTest(methodName);
        String log="testing if something goes to extent report";
        extent_test_logger.log(Status.INFO,"looding the page");
        getDriver().get("http://www.naukri.com/");
        extent_test_logger.log(Status.INFO,"getting the title");
        System.out.println(getDriver().getTitle());
        extent_test_logger.log(Status.INFO,"swtiching window");
        UI_Helper.switch_to_other_window_or_popup(getDriver());
        extent_test_logger.log(Status.INFO,"getting the title of child window");
        System.out.println(getDriver().getTitle());
        UI_Helper.switch_to_other_window_or_popup(getDriver());
    }

    }

