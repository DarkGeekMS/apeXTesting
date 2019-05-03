package PageModel;

import java.awt.image.BufferedImage;

import org.openqa.selenium.WebElement;

public class profileSettingPage 
{
	
    public WebElement changepassbutton;
    public WebElement oldpasstxt;
    public WebElement newpasstxt;  
    public WebElement usernameTXT;   
    public WebElement cancelpassBtn;
    public WebElement savepassBTN;      
    public String changepassbuttonid;
    public String oldpasstxtplaceholder;
    public String newpasstxtplaceholder;
    public String usernameTXTid;
    public String cancelpassBtnid;
    public String savepassBTNid;
    
    public WebElement notificationRadiobutton;
    public String notificationRadiobuttonxpath; 
      
    public WebElement saveImgButton;
    public WebElement Psimage;
    public WebElement Pimage;
    public String Psimageid;
    public String Pimageid;
    public String saveImgButtonid;
    
    public WebElement passtodeactivateTXT;
    public WebElement deletefordeactivateBTN;
    public WebElement deactivateaccountBTN;
    public WebElement canceldeactivateBTN;
    public String deletefordeactivateBTNid;
    public String deactivateaccountBTNid;
    public String passtodeactivateTXTid;
    public String canceldeactivateBTNid;
    

  
	
    
    
      
       
   
    
   
	
	
	
	public profileSettingPage()
	{
		changepassbuttonid="ChangeButton";    
		oldpasstxtplaceholder="n-Old Password";
	    newpasstxtplaceholder="New Password";
	    usernameTXTid="username";
   	    cancelpassBtnid="goto-signin-btn";
	    savepassBTNid="register-btn";
		
	    notificationRadiobuttonxpath="//span[@class='slider round']";    
	    
	    Pimageid="imgId";
	    Psimageid="profilephoto";
	    saveImgButtonid="ChangeButton";
	    
	    deactivateaccountBTNid="deactivateaccount";
	    deletefordeactivateBTNid="register-btn";
	    passtodeactivateTXTid="n-password2";
	    canceldeactivateBTNid="goto-signin-btn";
	    		
	}
	
	public boolean bufferedImagesEqual(BufferedImage img1, BufferedImage img2) {
	    if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight())
	    {
	     for (int x = 0; x < img1.getWidth(); x++)
	     {
	      for (int y = 0; y < img1.getHeight(); y++) 
	      {
	       if (img1.getRGB(x, y) != img2.getRGB(x, y))
	        return false;
	       }
	      }
	     }
	    else 
	     {
	        return false;
	     }
	     return true;
	    }
	

}
