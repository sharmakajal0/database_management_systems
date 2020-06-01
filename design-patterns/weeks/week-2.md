# Week 2

Behavioural Pattern focus on how independent objects work towards a common goal.

## Template method pattern

UML for template methods pattern:

We have PastaDish Superclass:
+ make Recipe(): void // Template Method for recipe that calls other methods
- boidWater(): void // Common steps
- cookPasta(): void // Common steps
- drainAndPlate(): void // Common steps
	+ addPasta(): void
	+ addSauce(): void // abstract method of pastadish, it will be up to pastadish to provide the addSauce method body to add the right Sauce
	+ addProtein(): void
	+ addGarnish(): void

<strong>Subclasses of PastaDish class:</strong>
1. <b>SpaghettiMeatballs</b>
	+ addPasta(): void
	+ addSauce(): void
	+ addProtein(): void
	+ addGarnish(): void

2. <b>PennyAlfredo</b>
	+ addPasta(): void
	+ addSauce(): void
	+ addProtein(): void
	+ addGarnish(): void

The template method is helpful if you have two classes with similar functionality. When you notice two classes with a very similar order of operations, you can choose to use a template method.

The template method pattern is a practical application of generalization and inheritance.

When writing software, you might notice two separate classes that share similarities like each having a method with a very similar algorithm. Rather than making changes to these algorithms in two places, you can consolidate the algorithms to one place within a template method of superclass for two classes.

You generalize from two separate methods to one template method within a superclass which will be inherited by the two classes.

# Chain of Responsibility Design pattern

It sounds like, A chain of objects that are responsible for handling requests. The main thing is that your request is met.

In software design, the chain of responsibility is a series of handler objects that are linked together. These handlers have methods that are written to handle specific requests.

When a client object sends a request, the first handler in the chain will try to process it. If the handler can process the request, the request ends at this handler. And if it cannot, the handler will send the request to next handler in the chain who will process the request. and the chain goes on


*Request* -> Handler1(processing of request, if it processes the request, then the request will stop here otherwise it will send it to Handler2) => Handler2(processing of request, if it processes the request, then the request will stop here otherwise it will send it to Handler3) => Handler3(processing of request, if it processes the request, then the request will stop here otherwise it will send it to Handler4) => ...... => HandlerN(....)

Each object tries to handle the object until one is able to succesfully handle the request. If none of the handlers can process the request, then the request is not satisfied.

## UML diagram for CRDP

<strong>Abstract superclass Handler:</strong>(one is connected to the next in chain)
+handleRequest()

<strong>Subclasses of Handler:</strong>
ConcreteHandler1:
	+handleRequest()
ConcreteHandler2:
	+handleRequest()


Problems with chain of responsibility:
- there's a mistake in the filter, it doesn't meets the request and forgets to pass on the request to the next filter

Each filter goes through the following steps:
- Check if rule matches.
- If it matches, do something specific.
- If it doesn't match, call the next filter in the list.

You can use the template pattern to ensure that each class will handle the request in a similar way following the required steps.
The intent of this pattern is to avoid coupling the sender to the receiver by giving more than one object the chance to handle the request. Whoever sends the request doesn't have to bother with who will handle the request. He just sends the request the first thing and hopefully someone will take care of it. This decouples the sender and receiver from each other.

# State Pattern

<b>When should you use the State Pattern?</b>
The state Pattern is primarily used when you need to change the behaviour of an object based upon the state that it's in at run-time.

UML diagram 

interface: state
	+insertDollar()
	+ejectMoney()
	+dispense()

	<strong>State Classes</strong>

	<IdleState>
		+insertDollar()
		+ejectMoney()
		+dispense()

	<HasOneDollarState>
		+insertDollar()
		+ejectMoney()
		+dispense()

	<OutOfStock>
		+insertDollar()
		+ejectMoney()
		+dispense()

# Command Pattern

The Command Pattern encapsulates the request as an object of its own. Usually, when one object makes a request for a second object to do an action, the first object will call a method of the second object and the second object would complete the task.

A sender object creates a command object. The command pattern has another object that invokes the command objects to complete whatever task it is supposed to do, called the invoker.

A command manager can also be used which basically keeps track of the commands, manipulates them and invokes them.

Purposes for using the command pattern: 
- Store and schedule different requests. When an object calls a method of another object, you can't really do anything to the method calls. Turning the different requests in your software into command objects can allow you to treat them as the way you would treat other objects.
	- You can store these command objects into lists
	- You can manipulate them before they are completed
	- You can put them onto a queue
-It decouples the objects of software program

<strong>Invoker</strong>
<b>Command</b>
	+execute()
	+unexecute()
	+isReversible():boolean

<b>Receiver</b>
	+action()

<b>Concrete Command</b>
	+execute()
	+unexecute()
	+isReversible():boolean

# Observer Pattern

We'll have a subject superclass, that defines three methods:
- Allow a new observer to subscribe.
- Allow a current observer to unsubscribe.
- Notify all observers about a new blog post.

UML Diagram:
Subject
+ registerObserver(Observer): void
+ unregisterObserver(Observer): void
+ notify(): void

Interface: Observer
+ update(): void

Blog
+ getState(): String

Subscriber
+ update(): void