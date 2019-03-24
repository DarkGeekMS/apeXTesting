package PageModel;

import org.openqa.selenium.WebElement;

public class Post {
	public WebElement FullPost;
	public WebElement PostRow;
	public WebElement PostCol1;
	public WebElement PostCol2;
	public WebElement CommentButton;
	public WebElement PostSaveButton;
	public WebElement PostUpVote;
	public WebElement PostDownVote;
	public WebElement PostExtra;
	public WebElement PostVote;
	public WebElement PostContent;
	public WebElement HideIcon;
	public WebElement CommentSpace;
	public WebElement InnerCommentButton;
	public WebElement Comment;
	public String FullPostId;
	public String PostRowId;
	public String PostCol1Id;
	public String PostCol2Id;
	public String CommentButtonId;
	public String PostSaveButtonId;
	public String PostUpVoteId;
	public String PostDownVoteId;
	public String PostExtraId;
	public String PostVoteId;
	public String PostContentId;
	public String HideIconId;
	public String CommentSpaceId;
	public String InnerCommentButtonId;
	public String CommentId;
	public Post()
	{
		FullPostId = "PostItme";
		PostRowId = "postRow";
		PostCol1Id = "postCol1";
		PostCol2Id = "postCol2";
		CommentButtonId = "commentButton";
		PostSaveButtonId = "SaveButton";
		PostUpVoteId = "up";
		PostDownVoteId = "down";
		PostExtraId = "DropButton";
		PostVoteId = "PostVote";
		PostContentId = "PostContent";
		HideIconId = "HideIcon";
		CommentSpaceId = "CommentSpace";
		InnerCommentButtonId = "InnerCommentButton";
		CommentId = "Comment";
	}
}
