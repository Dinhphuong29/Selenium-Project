package TestCMS.pages;

import helpers.ExcelHelper;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Hashtable;

public class AllOrdersPage extends CommonPage{
    public AllOrdersPage(){
    }

    //Khởi tạo đối tượng ExcelHelper (file Excel)
    ExcelHelper excelHelper;

    //**Khai báo các element trên trang All Orders đó dạng đối tượng By (đối tượng By là đối tượng mới chỉ thiết lập cấu trúc chứ chưa tìm kiếm)**
    private By clickFilterByDeliveryStatus = By.xpath("//div[contains(text(),'Filter by Delivery Status')]");
    private By selectFilterByDeliveryStatus = By.xpath("//span[normalize-space()='Pending']");
    private By clickFilterByPaymentStatus = By.xpath("//div[contains(text(),'Filter by Payment Status')]");
    private By selectFilterByPaymentStatus = By.xpath("//a[@id='bs-select-2-1']");
    private By inputSearchOrderCode = By.xpath("(//input[@id='search']");
    private By buttonFilter = By.xpath("(//button[normalize-space()='Filter']");
    // **Hàm xử lý cho trang All Orders**
    //Hàm thay đổi Xpath itemNewPosManager theo ORDER CODE
//    public String changeItemNewPosManagerXpath(String orderCode){
//        return WebUI.getElementText(By.xpath("//td[contains(.,'" + orderCode + "')]"));
//    }

    public void verifySearchAllOrders(Hashtable<String, String> data){

        //Khởi tạo đối tượng ExcelHelper (file Excel)
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "AllOrders");
        WebUI.clickElement(clickFilterByDeliveryStatus);
        WebUI.clickElement(selectFilterByDeliveryStatus);
        WebUI.clickElement(clickFilterByPaymentStatus);
        WebUI.clickElement(selectFilterByPaymentStatus);
        WebUI.sleep(4);
        WebUI.clickElement(inputSearchOrderCode);
        WebUI.sleep(4);
        WebUI.setText(inputSearchOrderCode, data.get("ORDER CODE"));
        WebUI.sleep(2);
        WebUI.setKey(inputSearchOrderCode, Keys.ENTER);
        WebUI.clickElement(buttonFilter);

//        WebUI.assertEquals(changeItemNewPosManagerXpath(data.get("ORDER CODE")), data.get("ORDER CODE"), "FAIL!! The new posmanager not match.");
//        System.out.println("Text PosManager: " + changeItemNewPosManagerXpath(data.get("ORDER CODE")));
//        WebUI.clickElement(buttonView);
    }

    public void searchOrdersCode(Hashtable <String, String> data){
        WebUI.setText(inputSearchOrderCode, data.get("ORDER CODE"));
        WebUI.setKey(inputSearchOrderCode, Keys.ENTER);
    }

}
