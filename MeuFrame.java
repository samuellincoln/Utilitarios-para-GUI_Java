import java.awt.event.ActionEvent;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class MeuFrame extends JFrameEngine {
	private static final long serialVersionUID = 1L;
	public MeuFrame(String name, String[] maplines, HashMap<String, JComponent> mapcomponents) {
		super(name, maplines, mapcomponents);
	}
	public static void main (String [] args) {
		String [] strmaplines = new String [] {
			  "a b c"
			, "d e f"
			, "g h i"
			, "j figura figura2"
			, "k l m"
		};
		HashMap <String, JComponent> map = new HashMap <String, JComponent> ();
		map.put("a", instButton ("Botao A", MeuFrame::logicaBotaoA));
		map.put("b", instButton ("Botao B", MeuFrame::logicaBotaoB));
		map.put("c", instButton ("Botao C", MeuFrame::logicaBotaoC));
		map.put("d", instButton ("Botao D", MeuFrame::logicaBotaoD));
		map.put("e", instButton ("Botao E", MeuFrame::logicaBotaoE));
		map.put("f", instButton ("Botao F", MeuFrame::logicaBotaoF));
		map.put("g", instComboBox (new String [] {"Senna", "Schumacher"}, e -> {System.out.println ("Escolheu " + ((JComboBox)e.getSource()).getSelectedItem());}));
		map.put("h", instTextField (10));
		map.put("i", instTextArea (10, 10));
		map.put("j", instJList (new String [] {"Hamilton", "Verstappen"}));
		map.put("figura", instImage ("C:\\Users\\samue\\Software\\eclipse-workspace\\ProjetoManipulacaoImagens\\sennacelebrates4wc_graphicssenna1994wc.jpg", 100, 100));
		map.put("figura2", instImage ("D:\\Downloads\\77Y.gif", 100, 100));
		JFrameEngine gen = new JFrameEngine ("GUI Facil", strmaplines, map);
	}
	private static void logicaBotaoA (ActionEvent e) {
		System.out.println ("Implementei o comportamento do Botao A");
	}
	private static void logicaBotaoB (ActionEvent e) {
		System.out.println ("Implementei o comportamento do Botao B");
	}
	private static void logicaBotaoC (ActionEvent e) {
		System.out.println ("Implementei o comportamento do Botao C");
	}
	private static void logicaBotaoD (ActionEvent e) {
		System.out.println ("Implementei o comportamento do Botao D");
	}
	private static void logicaBotaoE (ActionEvent e) {
		System.out.println ("Implementei o comportamento do Botao E");
	}
	private static void logicaBotaoF (ActionEvent e) {
		System.out.println ("Implementei o comportamento do Botao F");
	}
}
