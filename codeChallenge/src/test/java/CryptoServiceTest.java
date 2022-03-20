
import com.google.gson.Gson;
import com.viel.codechallenge.entities.HistoryQuotationResponse;
import com.viel.codechallenge.services.CryptoService;
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
public class CryptoServiceTest {
    
    @Test
    public void testCryptoServiceAvalability(){
        CryptoService cs = new CryptoService();  
        String resp = cs.getAllAssets();
        assertNotNull(resp); 
    }
    
    @Test
    public void testIfQuotationIsRight(){
        CryptoService cs = new CryptoService();
        HistoryQuotationResponse resp = cs.getAssetHistoryAsObject("bitcoin", "d1", "1617753600000", "1617753601000"); 
        String expectedValue = "56999.9728252053067291";
        String receivedValue = resp.getData().get(0).getPriceUsd();
        assertEquals(expectedValue, receivedValue); 
    }
    
}
