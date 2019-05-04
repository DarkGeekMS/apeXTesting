package PageModel;

import org.openqa.selenium.WebElement;

public class Post {
	
	public WebElement FullPost;
	public WebElement PostBody;
	public WebElement PostFooter;
	public WebElement CommentButton;
	public WebElement PostSaveButton;
	public WebElement PostUpVote;
	public WebElement PostDownVote;
	public WebElement PostExtra;
	public WebElement HideIcon;
	public WebElement Report;
	public WebElement PostVote;
	public WebElement PostContent;
	public WebElement time;
	public WebElement CommentSpace;
	public WebElement InnerCommentButton;
	public WebElement Comment;
	public WebElement User;
	public WebElement SubReddit;
	public WebElement Message;
	
	public String FullPostXPath;
	public String PostBodyXPath;
	public String CommentButtonXPath;
	public String PostSaveButtonXPath;
	public String PostUpVoteXPath;
	public String PostDownVoteXPath;
	public String PostExtraXPath;
	public String PostVoteXPath;
	public String PostContentId;
	public String TimeId;
	public String UserId;
	public String SubRedditId;
	public String PostHideXpath;
	public String PostReportXpath;
	public String CommentSpaceId;
	public String InnerCommentButtonId;
	public String CommentId;
	public Post()
	{
		FullPostXPath = "//*[@id='post']";
		PostBodyXPath = "//*[@id='postBody']";
		CommentButtonXPath = "//*[@id='post']//footer//button[@id='commentButton']";
		PostSaveButtonXPath = "//*[@id='post']//footer//button[@id='SaveButton']";
		PostUpVoteXPath = "//*[@id='post']//button[@id='up']";
		PostDownVoteXPath = "//*[@id='post']//button[@id='down']";
		PostExtraXPath = "//*[@id='post']//button[@id='DropButton']";
		PostVoteXPath = "//*[@id='post']//h5[@id='PostVote']";
		PostHideXpath = "//*[@id='post']//button[@id='DropButton']//following-sibling::ul/li[1]";
		PostReportXpath = "//*[@id='post']//button[@id='DropButton']//following-sibling::ul/li[2]";
		PostContentId = "PostContent";
		TimeId = "timeAgo";
		UserId = "user";
		SubRedditId = "subred";
		
		CommentSpaceId = "CommentSpace";
		InnerCommentButtonId = "InnerCommentButton";
		CommentId = "Comment";
	}
}
