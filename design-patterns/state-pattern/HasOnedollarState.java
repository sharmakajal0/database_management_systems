public void HasOneDollarState implements State{
	public void insertDollar(VendingMachine vendingMachine){
		System.out.println("Already have one dollar");

		vendingMachine.doReturnMoney();
		vendingMachine.setState(VendingMachine.getIdleState());
	}

	public void ejectMoney(VendingMachine vendingMachine){
		System.out.println("returning money");

		vendingMachine.doReturnMoney();
		vendingMachine.setState(VendingMachine.getIdleState());
	}

	public void dispense(Vendingmachine vendingMachine){
		System.out.println("Releasing product");

		if(vendingMachine.getCount() > 1){
			vendingMachine.doReleaseProduct();
			vendingMachine.setState(Vendingmachine.getIdleState());
		} else {
			vendingMachine.doReleaseProduct();
			vendingMachine.setState(vendingMachine.getOutOfStockState());
		}
	}
}