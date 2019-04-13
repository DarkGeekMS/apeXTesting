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
	public WebElement PostVote;
	public WebElement PostContent;
	public WebElement time;
	public WebElement CommentSpace;
	public WebElement InnerCommentButton;
	public WebElement Comment;
	public WebElement User;
	public WebElement SubReddit;
	
	public String FullPostId;
	public String PostBodyId;
	public String CommentButtonId;
	public String PostSaveButtonId;
	public String PostUpVoteId;
	public String PostDownVoteId;
	public String PostExtraId;
	public String PostVoteId;
	public String PostContentId;
	public String TimeId;
	public String UserId;
	public String SubRedditId;
	
	public String CommentSpaceId;
	public String InnerCommentButtonId;
	public String CommentId;
	public Post()
	{
		FullPostId = "postCol2";
		PostBodyId = "postBody";
		
		CommentButtonId = "commentButton";
		PostSaveButtonId = "SaveButton";
		PostUpVoteId = "up";
		PostDownVoteId = "down";
		PostExtraId = "DropButton";
		PostVoteId = "PostVote";
		PostContentId = "PostContent";
		TimeId = "timeAgo";
		UserId = "user";
		SubRedditId = "subred";
		
		CommentSpaceId = "CommentSpace";
		InnerCommentButtonId = "InnerCommentButton";
		CommentId = "Comment";
	}
}
