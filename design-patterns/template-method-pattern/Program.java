public abstract class PastaDish{
	// Make recipe method is our template method:
	// It's marked as final because this method cannot be overridden by subclasses
	// No specific dish will have their own version of makeRecipe
	// Ensures the consistency of making dishes.
	public final void makeRecipe(){
		boilWater();
		addPasta();
		cookPasta();
		drainAndPlate();
		addSauce();
		addProtein();
		addGarnish();
	}

	protected abstract void addPasta();
	protected abstract void addSauce();
	protected abstract void addProtein();
	protected abstract void addGarnish();

	private void boilWater(){
		System.out.println("Boiling Water");
	}

	private void cookPasta(){
		System.out.println("Cooking Pasta");
	}

	private void drainAndPlate(){
		System.out.println("Draining the pasta and Plate it");
	}
}

public class SpaghettiMeatballs extends PastaDish {
	protected void addPasta() {
		System.out.println("Add Spaghetti");
	}

	protected void addProtein(){
		System.out.println("Add Meatballs");
	}

	protected void addSauce(){
		System.out.println("Add Tomato Sauce");
	}

	protected void addGarnish(){
		System.out.println("Add Permesan Cheese");
	}
}

public class PennyAlfredo extends PastaDish{
	protected void addPasta(){
		System.out.println("Add penne");
	}

	protected void addProtein(){
		System.out.println("Add Chicken");
	}

	protected void addSauce(){
		System.out.println("Add Alfredo Sauce");
	}

	protected void addGarnish(){
		System.out.println("Add parsley");
	}
}