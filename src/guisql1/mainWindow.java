package guisql1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class mainWindow {

	protected Shell shell;
	private Text text;
	private Text text_1;
	
	private String userName = null;
    private String password = null;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			mainWindow window = new mainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		CLabel lblNewLabel = new CLabel(shell, SWT.NONE);
		lblNewLabel.setBottomMargin(5);
		lblNewLabel.setTouchEnabled(true);
		lblNewLabel.setImage(SWTResourceManager.getImage(mainWindow.class, "/org/eclipse/jface/fieldassist/images/error_ovr@2x.png"));
		lblNewLabel.setBounds(189, 24, 55, 32);
		lblNewLabel.setText("");
		
		CLabel lblNewLabel_1 = new CLabel(shell, SWT.NONE);
		lblNewLabel_1.setBounds(57, 93, 78, 21);
		lblNewLabel_1.setText("Username:");
		
		CLabel lblNewLabel_2 = new CLabel(shell, SWT.NONE);
		lblNewLabel_2.setBounds(57, 131, 61, 21);
		lblNewLabel_2.setText("Password:");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(143, 93, 181, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(143, 131, 181, 21);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		btnNewButton.setBounds(171, 188, 75, 25);
		btnNewButton.setText("Login");
		
		//Add event listener
		  btnNewButton.addListener(SWT.Selection, new Listener() {
	            public void handleEvent(Event event) {
	 
	                userName = text.getText();
	                password = text_1.getText();
	 
	                if (userName == null || userName.isEmpty() || password == null || password.isEmpty()) {
	                    String errorMsg = null;
	                    MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_ERROR);
	 
	                    messageBox.setText("Alert");
	                    if (userName == null || userName.isEmpty()) {
	                        errorMsg = "Please enter username";
	                    } else if (password == null || password.isEmpty()) {
	                        errorMsg = "Please enter password";
	                    }
	                    if (errorMsg != null) {
	                        messageBox.setMessage(errorMsg);
	                        messageBox.open();
	                    }
	                } else {
	                    MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_WORKING);
	                    messageBox.setText("Info");
	                    messageBox.setMessage("Valid");
	                    messageBox.open();
	                }
	            }
	        });

	}
}
