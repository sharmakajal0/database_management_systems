public class IdleState implements State{
	public void insertDollar(VendingMachine vendingMachine){
		System.out.println("dollar inserted");

		vendingMachine.setState(
			vendingMachine.getHasOneDollarState()
			);
	}

	public void ejectMoney(VendingMachine vendingMachine){
		System.out.println("no money to return");
	}

	public void dispense(VendingMachine vendingMachine){
		System.out.println("patment required");
	}
}