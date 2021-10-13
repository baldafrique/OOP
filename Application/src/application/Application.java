package application;

public class Application {

	public static void main(String[] args) {
		Presentation presentation = new Presentation(new BusinessLogic(new Database()));
		
		presentation.doPresentation();
	}

}
