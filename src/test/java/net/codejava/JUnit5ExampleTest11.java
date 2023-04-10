package net.codejava;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

@SpringBootTest
public class JUnit5ExampleTest11 {

    @Autowired
    // create private instance of SalesDAO
    private SalesDAO salesDAO = new SalesDAO();;

    @Test
    void testInsert() {
      Sale sale = new Sale("test item 123", 1, 1);
      salesDAO.save(sale);
      // list all the records
      List<Sale> listSale = salesDAO.list();
      // print a comment about the latest item on the list
      System.out.println("Expected item on the list: test item 123");
      System.out.println("Actual item on the list: " + listSale.get(listSale.size()-1).getItem());
      // assert that the latest item on the list is "test item 123"
      assertEquals("test item 123", listSale.get(listSale.size()-1).getItem());
      // clean up the database
      salesDAO.delete(listSale.get(listSale.size()-1).getId());
      System.out.println("\n\nTest11-1 Successful!\n\n");
    }

    // test clear button by setting amount to 100 and then clicking clear button to set amount to 0 and then checking if amount is 0
    @Test
    void testClear() {
      Sale sale = new Sale("test item 123", 1, 100);
      salesDAO.save(sale);
      // list all the records
      List<Sale> listSale = salesDAO.list();
      // print a comment about the latest item on the list
      System.out.println("Expected item on the list: test item 123");
      System.out.println("Actual item on the list: " + listSale.get(listSale.size()-1).getItem());
      // assert that the latest item on the list is "test item 123"
      assertEquals("test item 123", listSale.get(listSale.size()-1).getItem());
      // set amount to 0
      salesDAO.setAmountToZero(listSale.get(listSale.size()-1).getId());
      // list all the records
      listSale = salesDAO.list();
      // print a comment about the latest item on the list
      System.out.println("Expected amount on the list: 0");
      System.out.println("Actual amount on the list: " + listSale.get(listSale.size()-1).getAmount());
      // assert that the latest item on the list is "test item 123"
      assertEquals(0, listSale.get(listSale.size()-1).getAmount());
      // clean up the database
      salesDAO.delete(listSale.get(listSale.size()-1).getId());
      System.out.println("\n\nTest11-2 Successful!\n\n");
    }
}