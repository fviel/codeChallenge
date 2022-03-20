
import com.viel.codechallenge.services.ResourcesService;
import java.io.InputStream;
import org.junit.Test;
import static org.junit.Assert.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fernando
 */
public class ResourcesServiceTest {
    
    @Test
    public void canFindWallet(){
        
        ResourcesService rs = new ResourcesService();
        InputStream is = rs.getFileFromResourcesAsInputStream("wallet.csv");        
        assertNotNull(is); 
    }
}
