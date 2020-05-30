# Week 2

Behavioural Pattern focus on how independent objects work towards a common goal.

## Template method pattern

UML for template methods pattern:

We have PastaDish Superclass:
+ make Recipe(): void // Template Method for recipe that calls other methods
- boidWater(): void // Common steps
- cookPasta(): void // Common steps
- drainAndPlate(): void // Common steps
# addPasta(): void
# addSauce(): void // abstract method of pastadish, it will be up to pastadish to provide the addSauce method body to add the right Sauce
# addProtein(): void
# addGarnish(): void

<strong>Subclasses of PastaDish class:</strong>
1. <b>SpaghettiMeatballs</b>
# addPasta(): void
# addSauce(): void
# addProtein(): void
# addGarnish(): void

2. <b>PennyAlfredo</b>
# addPasta(): void
# addSauce(): void
# addProtein(): void
# addGarnish(): void

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
The state Pattern
