package proyecto_conversor;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.awt.Color;
import java.awt.Font;

public class ConvesorDivisas {

	private JFrame frame;
	private JTextField txt;
	private JButton btn;
	private JComboBox<Moneda> cmb;
	private JLabel lbl;
	
	public enum Moneda{
		pesosColombiano_dolar,
		pesoColombiano_euro,
		pesosColombiano_libraEsterlina,
		pesoColombiano_yenJapones,
		pesoColombiano_wonSoulCoreano,
		dolar_pesoColombiano,
		euro_pesoColombiano,
		libraEsterlina_pesoColombiano,
		yenJapones_pesoColombiano,
		wonSoulCoreano_pesoColombiano
	}
	
	public double dolar = 4000.90;
	public double euro = 4389.33;
	public double libraEsterlina = 5107.11;
	public double yenJapones = 27.88;
	public double wonSurCoreano = 3.10;
	
	public double valorInput = 0.00;
	private JTextField txtConvesorDeDivisas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConvesorDivisas window = new ConvesorDivisas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConvesorDivisas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(66, 160, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txt = new JTextField();
		txt.setBounds(80, 144, 158, 35);
		frame.getContentPane().add(txt);
		txt.setColumns(10);
		
		cmb = new JComboBox<Moneda>();
		cmb.setFont(new Font("Oswald", Font.PLAIN, 15));
		cmb.setModel(new DefaultComboBoxModel<>(Moneda.values()));
		cmb.setBounds(84, 87, 282, 35);
		frame.getContentPane().add(cmb);
		
		// evento boton
		btn = new JButton("Convertir");
		btn.setFont(new Font("Oswald", Font.PLAIN, 15));
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});
		btn.setBounds(260, 147, 116, 29);
		frame.getContentPane().add(btn);
		
		lbl = new JLabel("00.00");
		lbl.setBounds(155, 201, 180, 29);
		frame.getContentPane().add(lbl);
		
		txtConvesorDeDivisas = new JTextField();
		txtConvesorDeDivisas.setFont(new Font("Oswald", Font.BOLD | Font.ITALIC, 40));
		txtConvesorDeDivisas.setText("Convesor De Divisas");
		txtConvesorDeDivisas.setBounds(45, 11, 354, 65);
		frame.getContentPane().add(txtConvesorDeDivisas);
		txtConvesorDeDivisas.setColumns(10);
	}
	
	// funcion del boton
	public void Convertir() {
		// validacion de números
		if(Validar(txt.getText())) {
			Moneda moneda = (Moneda) cmb.getSelectedItem();
			
			switch (moneda) {
			
			case pesosColombiano_dolar: 
				PesosAMoneda(dolar);
				break;
			case pesoColombiano_euro: 
				PesosAMoneda(euro);
				break;
			case pesosColombiano_libraEsterlina: 
				PesosAMoneda(libraEsterlina);
				break;
			case pesoColombiano_yenJapones:
				PesosAMoneda(yenJapones);
				break;
			case pesoColombiano_wonSoulCoreano:
				PesosAMoneda(wonSurCoreano);
				break;
			case dolar_pesoColombiano: 
				MonedaAPesos(dolar);
				break;
			case euro_pesoColombiano: 
				MonedaAPesos(euro);
				break;
			case libraEsterlina_pesoColombiano: 
				MonedaAPesos(libraEsterlina);
				break;
			case yenJapones_pesoColombiano: 
				MonedaAPesos(yenJapones);
				break;
			case wonSoulCoreano_pesoColombiano:
				PesosAMoneda(wonSurCoreano);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + moneda);
			
			}		
		}
	}
	
	public void PesosAMoneda(double moneda) {
		double res = valorInput / moneda;
		lbl.setText(Redondear(res));
	}
	
	public void MonedaAPesos(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(Redondear(res));
	}
	
	// redondear decimales
	public String Redondear(double valor) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(valor);
	}
	
	// validar input
	public boolean Validar(String texto) {
		try {
			double x = Double.parseDouble(texto);
			if(x > 0);
			valorInput = x;
			return true;
		}catch(NumberFormatException e) {
			lbl.setText("Solamente números !!");
			return false;
		}
	}
}