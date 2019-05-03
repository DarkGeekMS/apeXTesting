package PageModel;

import org.openqa.selenium.WebElement;

public class profilePage 
{
    public WebElement UsernameLogo;
    public WebElement blockBTN;
    public WebElement newpostBTN;
   public WebElement createpostdiv;
   public WebElement confirmblockBTN;
   public WebElement UnblockBTN;

   
   public String UsernameLogoid;
   public String blockBTNid;
   public String newpostBTNid;
   public String createpostdivid;
   public String confirmblockBTNclass;
   public String UnblockBTNid;

   
    public String sortbyXPATH;
    public String createPostdivid;
	public profilePage()
	{
		 UsernameLogoid="";
		 newpostBTNid="createpostbutton";
		 createpostdivid="createPost";
		 confirmblockBTNclass="swal-button swal-button--confirm";
		 UnblockBTNid="button";
		 
		createPostdivid="createpostbutton";  
		blockBTNid="reportlink";
		sortbyXPATH="//button[@id='loggedbutton']/span[@id='selected']";
	}
		

}
	
