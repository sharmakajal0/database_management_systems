# Week 1
Design Pattern - A design pattern is a practical proven solution to a recurring design problem.
- Design Pattern are conceptual. It is knowledge that you can apply within your software design to guide its structure, and make it more flexible and reusable.

Q. Why should you use design patterns?
Ans. 
- Design patterns help software developers so that instead of building everything from scratch, they have a guide that helps them solve design problems in the way experts do.
- Design patterns are already proven by experts, and they have gone through the hardships.
- Design patterns help to create a design vocabulary.

## Gang of Four Design Patterns Catalog:

A trope is a story telling device or convention often found in fiction.

Pattern Language: A collection of patterns that are related to a certain problem space is called Pattern Language.

Categories of pattern:

1. Creational Patterns: Creational Patterns tackles how you handle creating new objects. There are several different patterns based upon creating and cloning objects. If you're creating a new object similar to an existing one, you might clone existing objects.

Languages like JavaScript does not contain traditional classes to be instantiated. Objects are instead cloned and expanded to meet the puposes of those particular instances, called prototypes. An implementation language, is how we design pattern language is realized, which can heavily influence what patterns are possible to use.

2. Structural Patterns: Describes how objects are connected to each other. Not only do structural patterns describe how different objects have relationships, but also how subclasses and classes interact through inheritance. Structural Patterns use these relationships, and describe how they should work to achieve a particular design goal.

3. Behavioural Patterns: These patterns focus on how objects distribute work. They describe how each object does a single cohesive function. Also focuses on how independent objects work towards a common goal. Lays out the overall goal and purpose for each of the objects.

Some patterns have elements that could make them span categories.
Patterns will help you as a designer to develop an intuition for and appreciate object-oriented design.
By looking for specific design patterns, you can better recognize object-oriented design elsewhere.
Patterns come with their share of consequences.
Some patterns may be more resource-intensive, like more memory, or processing.

By learning different design patterns, you will be able design software for different purposes and in different ways.

# Singleton Pattern

- Enforces one and only one object of a singleton class
- has the singleton object globally accesible.
```
public class ExampleSingleton { // lazy construction
	// private static ExampleSingleton uniqueInstance = null;
	private ExampleSingleton(){
		...
	}
	
	public static ExampleSingleton 	getInstance() {
		if (uniqueInstance == null){
			uniqueInstance = newExampleSingleton();
		}
		
		return uniqueInstance;
	}
}
```

-- Achieved by having a private constructor with a public method that instantiates the class, if it is not already instantiated.
Lazy Creation: The object is not created until it's truly needed. Helpful if the object is large.

Trade-offs:
If there are multiple computing threads running, there could be issues caused by the threads trying to access the shared single object.

# Factory Method Pattern

```
Knife orderKnife(String knifeType) {
	Knife knife;
	<!--  create knife object - concrete instantiation -->
	if (knifeType.equals("steak")){
		knife = new SteakKnife();
	} else if (knifeType.equals("chefs")){
		knife = new ChefsKnife();
	} else if (knifeType.equals("bread")){
		knife = new BreadKnife();
	} else if (knifeType.equals("paring")){
		knife = new ParingKnife();
	}
	<!-- Prepare the knife -->
	knife.Sharpen();
	knife.polish();
	knife.package();

	return knife();
}
```

Another method can be creating a knifeFactory class

```
public class KnifeFactory{
	public knife createKnife(String knifeType) {
		Knife knife = null;

		if (knifeType.equals("steak")){
			knife = new SteakKnife();
		} else if (knifeType.equals("chefs")){
			knife = new ChefsKnife();
		}
		return knife;
	}
}
```

Adding knifestore class

```
public class KnifeStore {
	private KnifeFactory factory;
	
	public KnifeStore(KnifeFactory factory) {
		this.factory = factory;
	}
	public Knife orderKnife(String knifeType) {
		Knife knife;
		knife = factory.createKnife(knifeType);
		
		knife.sharpen();
		knife.polish();
		knife.package();
		
		return knife;
	}
}
```

Benefits:
If there are multiple clients that want to instantiate the same set of classes, then by using a Factory object, you have cut out redundant code and made the software easier to modify.

Factory Method: The factory method design intent is to define an interface for creating objects, but let the subclasses decide which class to instantiate. 

```
public abstract class KnifeStore{
	public Knife orderKnife(String knifeType) {
		Knife knife;
		knife = createKnife(knifeType);
		
		knife.sharpen();
		knife.polish();
		knife.package();
		
		return knife;
	}
	
	abstract Knife createKnife(String knifeType);
}

public BudgetKnifeStore extends KnifeStore{
	Knife createKnife(String knifeType) {
		if (knifeType.equals("steak")){
			knife = new SteakKnife();
		} else if (knifeType.equals("chefs")){
			knife = new ChefsKnife();
		}
		else return null;
	}
}
		
```

# Facade Pattern

The facade design pattern provides a single simplified interface for client classes to interact with the subsystem.
A facade simply acts as a point of entry into your subsystem. In software, a facade design pattern does exactly what a waiter or salesperson would do in real life. A facade is a wrapper class that encapsulates subsystem in order to hide the subsystem complexity. This wrapper class will allow a client class to interact with the subsystem through the facade.

A facade class can be used to wrap all the interfaces and classes for a subsystem.

Steps:
1. Design the interface:
```
public interface IAccount{
	public void deposit(BigDecimal amount);
	public void withdraw(BigDecimal amount);
	public void transfer(BigDecimal amount);
	public int getAccountNumber();
}
```
2. Implement the interface with one or more classes:
```
public class Checking implements IAccount {...}
public class Saving implements IAccount {...}
public class Investment implements IAccount {...}
```

3. Create the facade class and wrap the classes that implement the interface:
```
public class BankService {
	private Hashtable<int, IAccount> bankAccounts;
	public BankService() {
		this.bankAccounts = new Hashtable<int, IAccount>;
	}
	public int createNewAccount(String type, BigDecimal initAmount){
		IAccount newAccount = null
		switch (type){
			case "chequing":
				newAccount = new Chequing(initAmount);
				break;
			case "saving":
				newAccount = new Saving(initAmount);
				break;
			case "investment":
				newAccount = new Investment(initAmount);
				break;
			default:
				System.out.println("Invalid account type");
				break;
		}
		if (newAccount != null){
			this.bankAccounts.put(newAccount.getAccountNumber(), newAccount);
			return newAccount.getAccountNumber();
		}
		return -1;
	}
	public void transferMoney(int to, int from, BigDecimal amount){
		IAccount toAccount = this.bankAccounts.get(to);
		IAccount fromAccount = this.bankAccount.get(from);
		fromAccount.transfer(toAccount, amount);
	}
}
```

4. Use the facade class to access the subsystem:
```
public class Customer{
	public static void main(String arg[]){
		BankService myBankService = new BankService();

		int mySaving = myBankService.createNewAccount("Saving", new BigDecimal(500.00));

		int myInvestment = myBankService.createNewAccount("investment", newBigDecimal(1000.00));

		myBankService.transferMoney(mySaving, myInvestment, new BigDecimal(300.00));
	}
}
```

# Adapter Pattern

The Adapter Design Pattern will help facilitate communication between two exisiting systems by providing a compatible interface.

Steps:
1. Design the target Interface:

```
public interface WebRequester{
	public int request(Object);
}
```

2. Implement the target Interface with the adapter class:

```
public class WebAdapter implements WebRequester{
	private WebService service;

	public void connect(WebService currentService){
		this.service = currentService;
	}

	public int request(Object request) {
		Json result = this.toJson(request);
		Json response = service.request(result);
		if (response != null){
			return 200;
		}
		return 500;
	}
	private Json toJson(Object input){...}
}
```

3. Send the request from the client to the adapter using the target interface:
```
public class WebClient {
	private WebRequester webRequester;

	public WebClient(WebRequester webRequester){
		this.webRequester = webRequester;
	}

	private Object makeObject(){}
	public void doWork(){
		Object object = makeObject();
		int status = webRequester.request(object);

		if(status == 200){
			System.out.println("OK");
		} else {
			System.out.println("NOT Ok");
		}
		return;
	}
} 
```

```
public class Program{
	public static void main(String args[]){
		String webHost = "Host: https://google.com\n\r";
		WebService service = new WebService(webHost);
		WebAdapter adapter = new WebAdapter();
		adapter.connect(service);
		WebClient client = new WebClient(adapter);
		client.doWork();
	}
}
```

- The adaptee is hidden from the client by the wrapper adapter class.

An adapter is meant to:
- Wrap the adaptee and expose a target interface to the client.
- Indirectly change the adaptee's interface into one that the client is expecting by implementing a target interface.
- Indirectly translate the client's request into that the one adaptee is expecting.
- Reuse an existing adaptee with an incompatible interface.

An adapter is an effective solution. In summary, an adapter is meant to:
- Wrap the adaptee and exposes a target interface to the client.
- Indirect change the adaptee's interface into one that the client is expecting by implementing a target interface.
- Indirectly translate the client's request into one that the adaptee is expecting.
- Reuse an existing adaptee with an incompatible interface.


# Composite Pattern

Two Goals:
- To compose nested structure objects.
- To deal with the classes for these objects uniformly.

A component interface serves as the supertype for the set of classes so that they can all be dealt with uniformly. Done by enforcing polymorphism.
An abstract superclass can also be used in placed of an interface as both are allowed for polymorphism.

A composite object can contain other composite object, since the composite class is a subtype of component. This is known as recursive composition. This term is also a synonym for composite design patterns.

Issues:
- How do we use individual types of objects to build a tree like structure?
- How can we treat the individual types of objects uniformly without checking their types?

To summarize:
Composite design pattern is used to solve the issues of how to build a tree-like structure of objects, and how to treat the individual types of these objects uniformly. Enforcing polymorphism across each class through implementing an interface (or inheriting from super class). Using a technique called recursive composition which allows objects to be composed of other objects that are of a common type.

# Proxy Pattern

The proxy class wraps the real subject class i.e., hides the reference to an instance of the real subject class.

Why proxy class?
- To act as a virtual proxy.
- To act as a protection proxy.
- To act as a remote proxy.

Main features of Proxy Pattern:
- To use the proxy class to wrap the real subject class.
- To have a polymorphic design so that the client class can expect the same interface for the proxy and real subject classes.
- To use a lightweight proxy in place of a resource intensive object until it is actually needed.
- To implement some form of intelligent verification of requests from client code in order to determine if, how, and to whom the request should be forwarded to.
- To present a local representation of a system that is not in the same physical or virtual space.

# Decorator Pattern

Decorator is an abstract class. Just like the concrete component class, it implements the component interface. The main differences are that decorator aggregates other types of components, which will allow us to "stack" components on top of each other, and decorator serves as the abstract superclass of concrete decorator classes that will provide an increment of behaviour.

The key concepts of this design pattern are:
- we can add, in effect, any number of behaviour dynamically to an object at runtime by using aggregation as a substitute for pure inheritance.
- Polymorphism is achieved by implementing a single interface.
- Aggregation lets us create a stack of objects.
- Each decorator object in the stack is aggregated in one-to-one relationship with the object below it in the stack.
- By combining aggregation and polymorphism, we can recursively invoke the same behaviour down the stack and have the behaviour execute upwards from the concrete component object.