import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {

    @Test
    public void test_username() {
        String user_name = "Saroj";
        Users user = new Users();
        user.setUser(user_name);
        String value = user.getUser();
        assertEquals(user_name,value);

    }

    @Test
    public void test_password() {
        String Password = "12345";
        Users pass = new Users();
        pass.setUser("98765");
        String value = pass.getUser();
        assertEquals(pass,value);
    }

    @Test
    public void test_deopdown() {
        String choose_location = "Udayapur";
        Users location = new Users();
        location.setUser(choose_location);
        String get_location = location.getUser();
        assertEquals(get_location,choose_location);

    }


    @Test
    public void TestCustomerid() {
        String customerid = "1001";
        Users c_id = new Users();
        c_id.setUser("1002");
        String customer_id = c_id.getUser();
        assertEquals(customerid,customer_id);

    }


    @Test
    public void testAccountNumber() {
        String ac_no = "123456789";
        Users account_number = new Users();
        account_number.setUser(ac_no);
        String value = account_number.getUser();
        assertEquals(value,value);

    }

    @Test
    public void test_customer() {
        String t_customer = "1";
        Users customer = new Users();
        customer.setUser("504");
        String customerid = customer.getUser();
        assertEquals(t_customer,customerid);
    }



    @Test
    public void testPin() {
        String pin = "8520";
        Users pin_no = new Users();
        pin_no.setUser(pin);
        String pin_number = pin_no.getUser();
        assertEquals(pin,pin_number);

    }}
