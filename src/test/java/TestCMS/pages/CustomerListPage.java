package TestCMS.pages;

import helpers.ExcelHelper;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Hashtable;

public class CustomerListPage extends CommonPage{
    //Khai báo hàm xây dựng
    public CustomerListPage(){
    }

    //Khởi tạo đối tượng ExcelHelper (file Excel)
    ExcelHelper excelHelper;
    private By  inputSearchCustomer = By.xpath("(//input[@id='search']");
    public void searchCustomer(Hashtable<String, String> data){
        WebUI.clickElement(inputSearchCustomer);
        WebUI.setText(inputSearchCustomer, "Đinh Thị Thu Phương");
        WebUI.setKey(inputSearchCustomer, Keys.ENTER);
    }
}
