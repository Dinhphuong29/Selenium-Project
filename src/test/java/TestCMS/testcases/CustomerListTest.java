package TestCMS.testcases;

import TestCMS.pages.CustomerListPage;
import TestCMS.pages.DashboardPage;
import TestCMS.pages.LoginPage;
import common.BaseTest;
import dataproviders.DataProviderFactory;
import helpers.ExcelHelper;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class CustomerListTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerListPage customerListPage;
    ExcelHelper excelHelper;
    @Test(dataProvider = "data_provider_posmanager_excel_hashtable", dataProviderClass = DataProviderFactory.class)
    public void testSearchNewOrder(Hashtable<String, String> data){

        loginPage = new LoginPage();

        //Khởi tạo đối tượng ExcelHelper (file Excel)
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Login");

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(excelHelper.getCellData("EMAIL", 1), excelHelper.getCellData("PASSWORD", 1));

        //LIÊN KẾT TRANG: từ trang dashboardPage sang trang customerListPage
        customerListPage = dashboardPage.clickMenuCustomerListWithMenuCustomers();
        customerListPage.searchCustomer(data);

    }
}