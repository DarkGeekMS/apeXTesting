package PageModel;
import org.openqa.selenium.WebElement;

public class Message {
	public WebElement messageButton;
	public WebElement sendButton;
	public WebElement inboxButton;
	public WebElement allButton;
	public WebElement readButton;
	public WebElement unreadButton;
	public WebElement sentButton;
	public WebElement Span;
	public WebElement to;
	public WebElement subject;
	public WebElement text;
	public WebElement send;
	public String spanId;
	public String messageButtonXPath;
	public String sendId;
	public String inboxId;
	public String sentId;
	public String allId;
	public String readId;
	public String unreadId;
	public String toXPath;
	public String subjectXPath;
	public String textId;
	public String sendButtonXpath;
	public Message() {
		spanId="selectted";
		messageButtonXPath = "//*[@id='mainNav']/div[1]/div[4]/div/button[1]";
		sendId = "send";
		inboxId = "inbox";
		sentId = "sent";
		allId = "all";
		readId = "read";
		unreadId = "unread";
		toXPath = "//*[@id='app']//div[@class='send-message']/input[1]";
		subjectXPath = "//*[@id='app']//div[@class='send-message']/input[2]";
		textId = "text";
		sendButtonXpath = "//*[@id='app']//div[@class='send-message']/button";
	}
}
