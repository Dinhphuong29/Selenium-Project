package TestCMS.pages;

import helpers.ExcelHelper;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Hashtable;

public class PosManagerPage extends CommonPage{
    //Khai báo hàm xây dựng
    public PosManagerPage(){
    }

    //Khởi tạo đối tượng ExcelHelper (file Excel)
    ExcelHelper excelHelper;
    //**Khai báo các element trên trang Add New Product đó dạng đối tượng By (đối tượng By là đối tượng mới chỉ thiết lập cấu trúc chứ chưa tìm kiếm)**
    //Product Name
    private By searchByProductName = By.xpath("//input[@placeholder='Search by Product Name/Barcode']");
    private By selectAllCategories = By.xpath("//div[contains(text(),'All categories')]");
    private By inputAllCategories = By.xpath("//select[@name='poscategory']//following-sibling::div[1]//div[1]//input[1]");

    private By selectAllBrands = By.xpath("//div[contains(text(),'All Brands')]");
    private By inputAllBrands = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");

    private By selectWalkInCustomers = By.xpath("//div[contains(text(),'Walk In Customer')]");
    private By inputWalkInCustomers = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By icon = By.xpath("//i[@class='las la-truck']");
    private By info = By.xpath("//span[@class='aiz-rounded-check flex-shrink-0 mt-1']");
    private By addProduct = By.xpath("//div[3]//div[1]//div[3]//i[1]");



    //private By inputName = By.xpath("//input[@id='name']");

    //private By inputEmail = By.xpath("//input[@id='email']");

//    private By inputAddress = By.xpath("//div[@id='shipping_address']//textarea[@id='address']");
//    private By inputCountry = By.xpath("//div[@id='shipping_address']//select[@name='country_id']");
//
//    private By inputStatus = By.xpath("//div[@id='shipping_address']//select[@name='state_id']");
//
//    private By inputCity = By.xpath("//div[@id='shipping_address']//select[@name='city_id']");
//    private By inputPosttalCode = By.xpath("//div[@id='shipping_address']//input[@id='postal_code']");
//
//    private By inputPhone = By.xpath("//div[@id='shipping_address']//input[@id='phone']");

    private By clickButtonConfirm = By.xpath("//button[@id='confirm-address']");
    //private By clickButtonClose = By.xpath("//button[@id='close-button']");

    private By selectShipping = By.xpath("//button[normalize-space()='Shipping']");
    private By inputShipping = By.xpath("//input[@name='shipping']");
    private By selectDiscount = By.xpath("//button[normalize-space()='Discount']");
    private By inputDiscount = By.xpath("//input[@name='discount']");
    private By clickButtonPlaceOrder = By.xpath("//button[normalize-space()='Place Order']");
    //Hàm nhập thông tin trong trang
    public void enterDataPosManeger(Hashtable<String, String> data) {

        WebUI.waitForPageLoaded();

        WebUI.setText(searchByProductName, data.get("PRODUCT NAME"));
        //WebUI.setKey(searchByProductName,Keys.ENTER);
        WebUI.sleep(2);
        WebUI.clickElement(selectAllCategories);
        WebUI.sleep(2);
        WebUI.clickElement(inputAllCategories);
        WebUI.sleep(2);
        WebUI.setText(inputAllCategories, data.get("All CATEGORIES"));
        WebUI.sleep(2);
        WebUI.setKey(inputAllCategories, Keys.ENTER);
        WebUI.clickElement(selectAllBrands);
        WebUI.clickElement(inputAllBrands);
        WebUI.setText(inputAllBrands, data.get("ALL BRANDS"));
        WebUI.setKey(inputAllBrands, Keys.ENTER);
        WebUI.clickElement(selectWalkInCustomers);
        WebUI.setText(inputWalkInCustomers, data.get("WALK IN CUSTOMERS"));
        WebUI.setKey(inputWalkInCustomers, Keys.ENTER);

        WebUI.clickElement(icon, 30);
        WebUI.sleep(2);
        WebUI.clickElement(info);
        WebUI.clickElement(clickButtonConfirm);
        WebUI.sleep(3);
        WebUI.clickElement(addProduct);
        WebUI.sleep(2);

//        WebUI.clickElement(inputName);
//        WebUI.setText(inputName, data.get("NAME"));
//
//        WebUI.clickElement(inputEmail);
//        WebUI.setText(inputEmail, data.get("EMAIL"));

//        WebUI.clickElement(inputAddress);
//        WebUI.setText(inputAddress, data.get("ADDRESS"));
//
//        WebUI.clickElement(inputCountry);
//        WebUI.sleep(1);
//        WebUI.setText(inputCountry, data.get("COUNTRY"));
//        WebUI.sleep(4);
//        WebUI.clickElement(inputStatus);
//        WebUI.sleep(3);
//        WebUI.setText(inputStatus, data.get("STATUS"));
//        WebUI.clickElement(inputCity);
//        WebUI.sleep(1);
//        WebUI.setText(inputCity, data.get("CITY"));
//        WebUI.sleep(2);
//        WebUI.clickElement(inputPosttalCode);
//        WebUI.sleep(2);
//        WebUI.setText(inputPosttalCode, data.get("POSTAL CODE"));
//        WebUI.clickElement(inputPhone);
//        WebUI.setText(inputPhone, data.get("PHONE"));

        //WebUI.sleep(2);
        //WebUI.clickElement(clickButtonClose, 30);
        WebUI.clickElement(inputShipping);
        WebUI.clearText(inputShipping);
        WebUI.setText(inputShipping, data.get("SHIPPING"));

        WebUI.clickElement(inputDiscount);
        WebUI.clearText(inputDiscount);
        WebUI.setText(inputDiscount, data.get("DISCOUNT"));
        WebUI.clickElement(clickButtonPlaceOrder,30);
    }
    }


