

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SplashScreen extends JWindow {
	private int showtime;
	private static Timer timer;
	private static int counter = 0;
	private static JProgressBar progress = new JProgressBar();

	public SplashScreen(int d) 
	{
		showtime = d;
	}

	public void exhibitSplash() throws Exception {
		JPanel Screen = (JPanel) getContentPane();
		Screen.setBackground(Color.WHITE);
		Dimension sc = Toolkit.getDefaultToolkit().getScreenSize();//set to the center of the screen
		setBounds((sc.width-700)/2, (sc.height-500)/2, 700, 500);
		JLabel welcome = new JLabel(new ImageIcon("newlogo.png"));
		EmptyBorder border = new EmptyBorder(15, 0, 0, 0);
		welcome.setBorder(border);

		JPanel instruc = new JPanel(new GridLayout(5, 1));
		instruc.setBackground(Color.WHITE);
		JLabel intro = new JLabel(
				"Game by Shuang Wu.");
		intro.setHorizontalAlignment(JLabel.CENTER);
		intro.setFont(new Font("Andalus", Font.PLAIN, 20));
		intro.setForeground(Color.DARK_GRAY);

		Image image = ImageIO.read(new File("grid.png"));
		Image scaledImage = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		JLabel labelpng = new JLabel(new ImageIcon(scaledImage));

		JLabel label1 = new JLabel("   (1) Select X or O to start ");
        label1.setHorizontalAlignment(JLabel.CENTER);

		JLabel label2 = new JLabel(
				"   (2) X will go first, if you choose O you will go second");
        label2.setHorizontalAlignment(JLabel.CENTER);

		JLabel label3 = new JLabel(
				"   (3) It's really hard to beat the computer, are you ready?.");
        label3.setHorizontalAlignment(JLabel.CENTER);

		label1.setFont(new Font("Andalus", Font.BOLD, 17));

		label1.setForeground(Color.DARK_GRAY);
		label2.setFont(new Font("Andalus", Font.BOLD, 17));
		label2.setForeground(Color.DARK_GRAY);
		label3.setFont(new Font("Andalus", Font.BOLD, 17));
		label3.setForeground(Color.DARK_GRAY);

		instruc.add(intro);
		instruc.add(labelpng);
		instruc.add(label1);
		instruc.add(label2);
		instruc.add(label3);

		progress.setMaximum(50);
		
		Screen.add(progress, BorderLayout.SOUTH);
		LoadSplash();
		Screen.add(welcome, BorderLayout.NORTH);
		Screen.add(instruc, BorderLayout.CENTER);
		Screen.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
		setVisible(true);
		try {
			Thread.sleep(showtime);
		} catch (Exception e) {
		}

		setVisible(false);
	}

	public void LoadSplash() {
		ActionListener al = new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				progress.setValue(++counter);
				if (counter == 600) {
					timer.stop();
					setVisible(false);
					return;
				}
			}
		};
		timer = new Timer(100, al);
		timer.start();
	}

	public void VisiblethenDisappear() throws Exception {
		exhibitSplash();
	}
}