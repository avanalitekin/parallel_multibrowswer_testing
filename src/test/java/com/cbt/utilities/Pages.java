package com.cbt.utilities;

import  com.cbt.pages.*;

public class Pages {

    private EPLoginPage epLoginPage;
    private LoginPage loginPage;
    private Test_Page_Login test_page_login;
    private Test_Page_Order test_page_order;
    private Test_Radio_Checkbox test_radio_checkbox;
    private Double_Click_Rigth_Click double_click_rigth_click;
    private View_All_Orders view_all_orders;
    private Wait_Visibility_Clickability wait_visibiliy_clickability;
    private Scroll_Into_View scroll_into_view;
    private WayToGo wayToGo;



    public EPLoginPage epLoginPage() {
        if(epLoginPage==null) {
            epLoginPage=new EPLoginPage();
        }
        return epLoginPage;
    }

    public LoginPage loginPage() {
        if(loginPage==null) {
            loginPage=new LoginPage();
        }
        return loginPage;
    }

    public Test_Page_Login test_page_login() {
        if(test_page_login==null) {
            test_page_login=new Test_Page_Login();
        }
        return test_page_login;
    }

    public Test_Page_Order test_page_order() {
        if(test_page_order==null) {
            test_page_order=new Test_Page_Order();
        }
        return test_page_order;
    }


    public Test_Radio_Checkbox test_radio_checkbox() {
        if(test_radio_checkbox==null) {
            test_radio_checkbox=new Test_Radio_Checkbox();
        }
        return test_radio_checkbox;
    }

    public Double_Click_Rigth_Click double_click_rigth_click() {
        if(double_click_rigth_click==null) {
            double_click_rigth_click=new Double_Click_Rigth_Click();
        }
        return double_click_rigth_click;
    }

    public View_All_Orders view_all_orders() {
        if(view_all_orders==null) {
            view_all_orders=new View_All_Orders();
        }
        return view_all_orders;
    }

    public Wait_Visibility_Clickability wait_visibiliy_clickabality() {
        if(wait_visibiliy_clickability==null) {
            wait_visibiliy_clickability=new Wait_Visibility_Clickability();
        }
        return wait_visibiliy_clickability;
    }
    public Scroll_Into_View scroll_into_view() {
        if(scroll_into_view==null) {
            scroll_into_view=new Scroll_Into_View();
        }
        return scroll_into_view;
    }

    public WayToGo wayToGo() {
        if(wayToGo==null) {
            wayToGo=new WayToGo();
        }
        return wayToGo;
    }
}
