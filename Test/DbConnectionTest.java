//import java.awt.*;
//import java.sql.ResultSet;
//
//import static org.junit.Assert.*;
//
//public class DbConnectionTest {
//
//    @org.junit.Test
//    public void insert() {
//        String data = "50000";
//        String acc = "15120";
//        String pass = "12345";
//        DbConnection db = new DbConnection();
//        String query = "Insert into account(account_number,password,amount) values('"+acc+"','"+pass+"','"+data+"') ";
//        int row = db.insert(query);
//        assertEquals(1,row);
//
//    }
//
//    @org.junit.Test
//    public void select() {
//        String acc = "15120";
//        try{
//        DbConnection db = new DbConnection();
//        String query = "Select account_number from account where account_number ='"+acc+"'";
//
//        ResultSet rs = db.select(query);
//
//        while (rs.next()){
//            String data = rs.getString("account_number");
//            assertEquals(acc,data);
//        }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
//
//    @org.junit.Test
//    public void update() {
//    }
//
//    @org.junit.Test
//    public void delete() {
//    }
//}