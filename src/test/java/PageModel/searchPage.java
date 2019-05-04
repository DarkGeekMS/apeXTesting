package PageModel;

import org.openqa.selenium.WebElement;

public class searchPage {
	public WebElement searchTXT;
    public WebElement postsBTN;
    public WebElement UsersBTN;
    public WebElement createcommunityBTN;
    public WebElement errormsg1;
    public WebElement errormsg2;
    public WebElement post1;
    public WebElement user1;
    
    public String errormsg2id;
    public String user1id;
    public String post1id;
    public String errormsg1id;
    public String searchTXTclass;
    public String postsBTNclass;
    public String UsersBTNid;
    public String createcommunityBTNBTN;

	public searchPage()
	{
		errormsg2id="subDiv";
		searchTXTclass ="form-control";
		postsBTNclass="router-link-exact-active router-link-active";
		UsersBTNid="h";
		createcommunityBTNBTN="";
		user1id="name";
		errormsg1id="subDiv";
		
	}

}


