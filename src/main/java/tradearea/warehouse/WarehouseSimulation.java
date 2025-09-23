package tradearea.warehouse;

import tradearea.model.ProductData;
import tradearea.model.WarehouseData;

import java.util.*;

public class WarehouseSimulation {

    private final Map<String, String> warehouses = new HashMap<>();

    public WarehouseSimulation() {
        warehouses.put("001", "Linz Bahnhof");
        warehouses.put("002", "Wien Hafen");
        warehouses.put("003", "Grazer Zentrum");
        warehouses.put("004", "Salzburg Bahnhof");
    }

	private double getRandomDouble( int inMinimum, int inMaximum ) {
		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum; 
		double rounded = Math.round(number * 100.0) / 100.0; 
		return rounded;
		
	}
	private int getRandomInt( int inMinimum, int inMaximum ) {
		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum;
		Long rounded = Math.round(number);
		return rounded.intValue();
	}
    private ProductData createProduct() {
        Random random = new Random();
        Map<String, String> products = new HashMap<>();
        products.put("Bio Orangensaft", "Getraenk");
        products.put("Bio Butter", "Milchprodukte");
        products.put("Türkische Salami", "Fleisch");
        products.put("Bosnisches Sudzuk", "Fleisch");
        products.put("Persil Discs Color", "Waschmittel");
        products.put("Ariel Waschmittel Color", "Waschmittel");

        List<String> keys = new ArrayList<>(products.keySet());
        String name = keys.get(random.nextInt(keys.size()));
        String category = products.get(name);

        int quantity = getRandomInt(100, 5000);
        String unit;
        switch (category) {
            case "Getraenk": unit = "Packung 1L"; break;
            case "Milchprodukte": unit = "Packung 250g"; break;
            case "Fleisch": unit = "Packung 500g"; break;
            case "Waschmittel": unit = "Packung 3KG"; break;
            default: unit = "Stück";
        }

        return new ProductData(
                "00-" + getRandomInt(100000, 999999),
                name,
                category,
                quantity,
                unit
        );
    }

    private List<ProductData> createProducts(int count) {
        List<ProductData> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(createProduct());
        }
        return list;
    }

	public WarehouseData getData(String inID) {
        WarehouseData data = new WarehouseData();
        data.setWarehouseID(inID);
        String name = warehouses.getOrDefault(inID, "Unbekanntes Lager");
        data.setWarehouseName(name);
        data.setProductData(createProducts(5));
        return data;
	}
}
