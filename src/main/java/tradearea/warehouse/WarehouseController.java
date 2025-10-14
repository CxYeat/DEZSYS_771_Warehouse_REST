package tradearea.warehouse;

import org.springframework.web.bind.annotation.GetMapping;
import tradearea.model.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.MediaType;
import tradearea.model.WarehouseData;

@RestController
public class WarehouseController {

    @Autowired
    private WarehouseService service;
	
    @GetMapping("/")
    public String warehouseMain() {
    	String mainPage = "This is the warehouse application! (DEZSYS_WAREHOUSE_REST) <br/><br/>" +
                          "<a href='http://localhost:8080/warehouse/001/json'>Link to warehouse/001/json</a><br/>"
                + "<a href='http://localhost:8080/warehouse/001/xml'>Link to warehouse/001/xml</a><br/>";
        return mainPage;
    }

    @GetMapping(value="/warehouse/{inID}/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public WarehouseData warehouseJSON( @PathVariable String inID ) {
        return service.getWarehouseData( inID );
    }

    @GetMapping(value ="/warehouse/{inID}/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public WarehouseData warehouseXML(@PathVariable String inID ) {
        return service.getWarehouseData( inID );
    }

}