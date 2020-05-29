public interface Webpage {
	public void display();
}

public class BasicWebpage implements Webpage{
	private String html = ...;
	private String stylesheet = ...;
	private String scripts = ...;

	public void display() {
		System.out.println("Basic web page");
	}
}

public abstract class WebpageDecorator implements Webpage {
	protected Webpage page;

	public WebpageDecorator(Webpage webpage){
		this.page = webpage;
	}

	public void display(){
		this.page.display();
	}
}

public class AuthorizedWebpage extends WebpageDecorator{
	public AuthorizedWebpage(Webpage decoratedPage){
		super(decoratedPage);
	}

	public void authorizedUser(){
		System.out.println("Authrizing User");
	}

	public display(){
		super.display();
		this.authorizedUser();
	}
}

public class AuthenticatedWebpage extends WebpageDecorator{
	public AuthenticatedWebpage(Webpage decoratedPage){
		super(decoratedPage);
	}

	public void authenticatedUser(){
		System.out.println("Authenticating User");
	}

	public display(){
		super.display();
		this.authenticateUser();
	}
}

public class Program{
	public static void main(String arg[]){
		Webpage myPage = new BasicWebpage();
		myPage = new AuthorizedWebpage(myPage);
		myPage = new AuthenticatedWebpage(myPage);
		myPage.display();
	}
}