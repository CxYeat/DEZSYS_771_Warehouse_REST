package tradearea.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Alles neu
@Setter
@Getter
@NoArgsConstructor
public class ProductData {

    private String productID;
    private String productName;
    private String productCategory;
    private int productQuantity;
    private String productUnit;

}
