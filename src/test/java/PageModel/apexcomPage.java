package PageModel;

import org.openqa.selenium.WebElement;

public class apexcomPage {
	public WebElement apexcom;
    public WebElement apexcompost;
    public WebElement posttitle;
    public WebElement apeName;
    public WebElement apeTitleName;
    public WebElement subscribebutton;
    public WebElement createpostbutton;
    public WebElement user;
    public WebElement post1Time;
    public WebElement commentButton;
    public WebElement innercommentButton;
    public WebElement saveButton;
    public WebElement repotform;
    public WebElement dropButton;
    public WebElement report;
    public WebElement hide;
    
    public String hideid;    
    public String reportid;
    public String dropButtonid;    
    public String repotformClass;
    public String saveButtonid;    
    public String innercommentButtonid;
    public String commentButtonid;
    public String post1Timeid;    
    public String userid;
    public String createpostbuttonid;    
    public String subscribebuttonid;
    public String apeTitleNameid;
    public String apeNameid;
    public String posttitleid;
    public String apexcompostid;
	public String apexcomid;
	
	public apexcomPage()
	{
		apexcomid="subred";
		apexcompostid="postslink";	
		posttitleid="postslink";
		apeNameid="Apexcomname";
		apeTitleNameid="Name";
		subscribebuttonid="subscribebutton";
		createpostbuttonid="createpostbutton";
		userid="user";
		post1Timeid="timeAgo";
		innercommentButtonid="InnerCommentButton";
		commentButtonid="commentButton";
		saveButtonid="SaveButton";
		dropButtonid="DropButton";
		hideid="HideIcon";
	    repotformClass="v--modal-background-click";
		reportid="ReportIcon";

	}
	
	

}
