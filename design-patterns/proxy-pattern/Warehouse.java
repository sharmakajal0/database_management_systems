public class Warehouse implements IOrder {
	private Hashtable<String, Integer> stock;
	private String address;

	public void fulfillOrder(Order order){
		for(Item item: order.itemList)
			this.stock.replace(item.sku, stock.get(item)-1);
	}

	public int currentInventory(Item item) {
		if(stock.containsKey(item.sku))
			return stock.get(item.sku).intValue();
		return 0;
	}
}