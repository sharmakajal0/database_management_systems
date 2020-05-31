public class StatePattern{
	public static void main(String args[]){
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.insertDollar();
		vendingMachine.ejectMoney();
		vendingMachine.dispense();
	}
}