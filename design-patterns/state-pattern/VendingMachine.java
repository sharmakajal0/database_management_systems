public class VendingMachine{

	private State idleState;
	private State hasOneDollarState;
	private State outOfStockState;

	private State currentState;
	private int count;

	public VendingMachine(int count){
		if (count > 0){
			currentState = State.Idle;
			this.count = count;
		} else {
			currentState = State.OutOfStock;
			this.count = 0;
		}
	}

	public void insertDollar(){
		if (currentState == State.Idle){
			currentState = State.HasOneDollar;
		} else if (currentState == State.HasOneDollar) {
			doReturnMoney();
			currentState = State.Idle;
		} else if (currentState == State.OutOfStock){
			doReturnMoney();
		}

		currentState.insertDollar(this);
	}

	public void ejectMoney(){
		System.out.println("Ejecting your money");
		currentState.ejectMoney(this);
	}

	public void dispense(){
		System.out.println("Here's what you want");
		currentState.dispense(this);
	}
}