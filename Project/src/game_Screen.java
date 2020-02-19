import javax.swing.ImageIcon;
import javax.swing.JFrame; // importing JFrame library 
import javax.swing.JLabel;

public class game_Screen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static int HEIGHT= 1920;
	private final static int WIDTH= 1024;
	private final static String GAME_TITLE= "";
	
	public game_Screen(String GAME_TITLE, int HEIGHT, int WIDTH) {
		super(GAME_TITLE);
		setSize(HEIGHT,WIDTH);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon("")));
		
		}
	
	public static void main(String[] args) {
		new game_Screen(GAME_TITLE,HEIGHT,WIDTH).setVisible(true);
	}
}
