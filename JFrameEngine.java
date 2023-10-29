import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JFrameEngine extends JFrame {
	//@Author: Samuel Lincoln Magalhaes Barrocas (Outubro de 2023)
	//Classe criada para simplificar a construcao de interfaces graficas com o usuario em Java
	//Atraves de JFrameEngine, a criacao de interfaces fica MUITO mais facil. Veja no codigo MeuFrame.java
	//Como ocorre essa utilizacao...
	private static final long serialVersionUID = 1L;
	public static final int CONSTANT = 60;
	private void boilerplate (Double s1, Double s2) {
		this.setSize(s1.intValue() + 1, s2.intValue() + 1);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public JFrameEngine (String name, String [] maplines, HashMap <String, JComponent> mapcomponents) {
		super (name);
		this.setLayout(new FlowLayout ());
		Double s1 = 0.0;
		Double s2 = 0.0;
		for (String line : maplines) {
			JPanel p = instPanel (line.split(" "), mapcomponents);
			s1 = p.getPreferredSize().getWidth() > s1? p.getPreferredSize().getWidth() : s1;
			s2 += p.getPreferredSize().getHeight();
			this.add (p);
		}
		boilerplate (s1 + CONSTANT, s2 + CONSTANT);
	}
	private static JPanel instPanel (String [] linetokens, HashMap <String, JComponent> mapcomponents) {
		JPanel p = new JPanel ();
		for (String tok : linetokens) {
			if (mapcomponents.keySet().contains(tok)) {
				p.add (mapcomponents.get(tok));
			}
			else {
				System.err.println ("WARNING: JComponent not found for token " + tok + " !!");
			}
		}
		return p;
	}
	public static JButton instButton (String name, ActionListener al) {
		JButton b = new JButton (name);
		b.addActionListener(al);
		return b;
	}
	public static JRadioButton instRadioButton (String name, ActionListener al) {
		JRadioButton b = new JRadioButton (name);
		b.addActionListener(al);
		return b;
	}
	public static JTextField instTextField (int width) {
		JTextField f = new JTextField (width);
		return f;
	}
	public static JTextArea instTextArea (int width, int height) {
		JTextArea a = new JTextArea (width, height);
		return a;
	}
	public static <T> JComboBox <T> instComboBox (T [] options, ActionListener al) {
		JComboBox <T> combo = new JComboBox <T> (options);
		combo.addActionListener(al);
		return combo;
	}
	public static <T> JList <T> instJList (T [] options) {
		JList <T> jlist = new JList <T> (options);
		return jlist;
	}
	public static JLabel instImage (String path, int w, int h) {
		try {
			Image i1 = new ImageIcon (new File (path).toURL()).getImage();
			Image resizedimage = i1.getScaledInstance(w, h, Image.SCALE_DEFAULT);
			ImageIcon iiscaled = new ImageIcon (resizedimage);
			return new JLabel (iiscaled);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return new JLabel ("Error");
	}
}
