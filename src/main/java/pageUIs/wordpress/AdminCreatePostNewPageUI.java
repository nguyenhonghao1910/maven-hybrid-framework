package pageUIs.wordpress;

public class AdminCreatePostNewPageUI {
	
	public static final String TITLE_POST_TEXTBOX="css=h1.editor-post-title__input";
//	public static final String BODY_POST_BEFORE_SENDKEY="xpath=//p[@aria-label='Add block']";
//	public static final String BODY_POST_SENDKEY="xpath=//p[@aria-label='Empty block; start writing or type forward slash to choose a block']";
	public static final String BODY_POST_BEFORE_SENDKEY="css=p[class*='block-editor-default']";
	public static final String BODY_POST_SENDKEY="css=p.block-editor-rich-text__editable";
	public static final String PRE_PUBLISH_BUTTON="css=div[aria-label='Editor top bar'] button[class*='editor-post-publish-button']";
	public static final String PUBLISH_BUTTON="css=div[aria-label='Editor publish'] button[class*='editor-post-publish-button']";
	public static final String RETURN_PUBLISHED_AND_UPDATE_MESSAGE="xpath=//div[@class='components-snackbar__content' and text()='%s']";
	public static final String POPUP_CREATE_POST="xpath=//button[@type='button' and @aria-label='Close dialog']";


}
