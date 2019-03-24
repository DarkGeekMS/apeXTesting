package PageModel;

import org.openqa.selenium.WebElement;

public class SignUpPage {
	public WebElement SignUpButton;
	public WebElement Email;
	public WebElement Next;
	public WebElement Back;
	public WebElement UserName;
	public WebElement Password;
	public WebElement Finish;
	public WebElement Success;
	public WebElement ErrorLabel;
	public String SignUpButtonId;
	public String EmailId;
	public String NextId;
	public String BackId;
	public String UserNameId;
	public String PasswordId;
	public String FinishId;
	public String SuccessId;
	public String ErrorLabelId;
	public SignUpPage()
	{
		SignUpButtonId = "SignUp";
		EmailId = "Email";
		NextId = "Next";
		BackId = "Back";
		UserNameId = "SignUpUserName";
		PasswordId = "password";
		FinishId = "SignUpFinish";
		SuccessId = "SignUpSucces";
		ErrorLabelId = "EmailError";
	}
}
