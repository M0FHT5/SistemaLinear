package sistema.linear;


import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.KeyboardFocusManager;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SistemaFRM extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5989601781049364726L;
	private JPanel contentPane;
	private JTextField varx1;
	private JTextField varx2;
	private JTextField varx3;
	private JTextField vary1;
	private JTextField vary2;
	private JTextField vary3;
	private JTextField varz1;
	private JTextField varz2;
	private JTextField varz3;
	private JTextField res1;
	private JTextField res2;
	private JTextField res3;
	private JTextField resultadoX;
	private JTextField resultadoY;
	private JTextField resultadoZ;
	private JButton btnResetar;
	private JButton btnProcessar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaFRM frame = new SistemaFRM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SistemaFRM() {
		setResizable(false);
		setTitle("SISTEMA DE EQUAÇÕES LINEARES    @M0FHT5 v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsiraOsValores = new JLabel("Informe os valores dos coeficientes e termos independentes das equações:");
		lblInsiraOsValores.setBounds(10, 11, 460, 20);
		contentPane.add(lblInsiraOsValores);

		varx1 = new JTextField();
		varx1.addActionListener(trFocus);
		varx1.setHorizontalAlignment(SwingConstants.CENTER);
		varx1.setBounds(10, 55, 54, 20);
		contentPane.add(varx1);
		varx1.setColumns(10);

		varx2 = new JTextField();
		varx2.addActionListener(trFocus);
		varx2.setHorizontalAlignment(SwingConstants.CENTER);
		varx2.setBounds(10, 93, 54, 20);
		contentPane.add(varx2);
		varx2.setColumns(10);

		varx3 = new JTextField();
		varx3.addActionListener(trFocus);
		varx3.setHorizontalAlignment(SwingConstants.CENTER);
		varx3.setBounds(10, 132, 54, 20);
		contentPane.add(varx3);
		varx3.setColumns(10);

		vary1 = new JTextField();
		vary1.addActionListener(trFocus);
		vary1.setHorizontalAlignment(SwingConstants.CENTER);
		vary1.setBounds(99, 55, 54, 20);
		contentPane.add(vary1);
		vary1.setColumns(10);

		vary2 = new JTextField();
		vary2.addActionListener(trFocus);
		vary2.setHorizontalAlignment(SwingConstants.CENTER);
		vary2.setColumns(10);
		vary2.setBounds(99, 93, 54, 20);
		contentPane.add(vary2);

		vary3 = new JTextField();
		vary3.addActionListener(trFocus);
		vary3.setHorizontalAlignment(SwingConstants.CENTER);
		vary3.setColumns(10);
		vary3.setBounds(99, 132, 54, 20);
		contentPane.add(vary3);

		varz1 = new JTextField();
		varz1.addActionListener(trFocus);
		varz1.setHorizontalAlignment(SwingConstants.CENTER);
		varz1.setColumns(10);
		varz1.setBounds(198, 55, 54, 20);
		contentPane.add(varz1);

		varz2 = new JTextField();
		varz2.addActionListener(trFocus);
		varz2.setHorizontalAlignment(SwingConstants.CENTER);
		varz2.setColumns(10);
		varz2.setBounds(198, 93, 54, 20);
		contentPane.add(varz2);

		varz3 = new JTextField();
		varz3.addActionListener(trFocus);
		varz3.setHorizontalAlignment(SwingConstants.CENTER);
		varz3.setColumns(10);
		varz3.setBounds(198, 132, 54, 20);
		contentPane.add(varz3);
		
		JLabel lblX = new JLabel("X +");
		lblX.setBounds(68, 58, 21, 14);
		contentPane.add(lblX);

		JLabel lblX_1 = new JLabel("X +");
		lblX_1.setBounds(68, 96, 21, 14);
		contentPane.add(lblX_1);

		JLabel lblX_2 = new JLabel("X +");
		lblX_2.setBounds(68, 135, 21, 14);
		contentPane.add(lblX_2);

		JLabel lblY = new JLabel("Y +");
		lblY.setBounds(163, 58, 21, 14);
		contentPane.add(lblY);

		JLabel lblY_1 = new JLabel("Y +");
		lblY_1.setBounds(163, 96, 21, 14);
		contentPane.add(lblY_1);

		JLabel lblY_2 = new JLabel("Y +");
		lblY_2.setBounds(163, 135, 21, 14);
		contentPane.add(lblY_2);

		JLabel lblZ = new JLabel("Z                               =");
		lblZ.setBounds(262, 58, 130, 14);
		contentPane.add(lblZ);

		JLabel lblZ_1 = new JLabel("Z                               =");
		lblZ_1.setBounds(262, 96, 130, 14);
		contentPane.add(lblZ_1);

		JLabel lblZ_2 = new JLabel("Z                               =");
		lblZ_2.setBounds(262, 135, 130, 14);
		contentPane.add(lblZ_2);

		res1 = new JTextField();
		res1.addActionListener(trFocus);
		res1.setHorizontalAlignment(SwingConstants.CENTER);
		res1.setColumns(10);
		res1.setBounds(402, 55, 54, 20);
		contentPane.add(res1);

		res2 = new JTextField();
		res2.addActionListener(trFocus);
		res2.setHorizontalAlignment(SwingConstants.CENTER);
		res2.setColumns(10);
		res2.setBounds(402, 93, 54, 20);
		contentPane.add(res2);

		res3 = new JTextField();
		res3.addActionListener(trFocus);
		res3.setHorizontalAlignment(SwingConstants.CENTER);
		res3.setColumns(10);
		res3.setBounds(402, 132, 54, 20);
		contentPane.add(res3);

		btnResetar = new JButton("Resetar");
		btnResetar.setBounds(349, 183, 107, 23);
		contentPane.add(btnResetar);

		btnProcessar = new JButton("Processar");
		btnProcessar.setBounds(10, 183, 107, 23);
		contentPane.add(btnProcessar);

		JLabel lblResultado = new JLabel("RESULTADO:");
		lblResultado.setBounds(10, 231, 89, 20);
		contentPane.add(lblResultado);

		JLabel lblX_3 = new JLabel("X =");
		lblX_3.setBounds(99, 234, 21, 14);
		contentPane.add(lblX_3);

		resultadoX = new JTextField();
		resultadoX.setHorizontalAlignment(SwingConstants.RIGHT);
		resultadoX.setColumns(10);
		resultadoX.setBounds(122, 231, 87, 20);
		contentPane.add(resultadoX);

		JLabel lblY_3 = new JLabel("Y =");
		lblY_3.setBounds(219, 234, 21, 14);
		contentPane.add(lblY_3);

		resultadoY = new JTextField();
		resultadoY.setHorizontalAlignment(SwingConstants.RIGHT);
		resultadoY.setColumns(10);
		resultadoY.setBounds(242, 231, 92, 20);
		contentPane.add(resultadoY);

		JLabel lblZ_3 = new JLabel("Z =");
		lblZ_3.setBounds(344, 234, 21, 14);
		contentPane.add(lblZ_3);

		resultadoZ = new JTextField();
		resultadoZ.setHorizontalAlignment(SwingConstants.RIGHT);
		resultadoZ.setColumns(10);
		resultadoZ.setBounds(367, 231, 89, 20);
		contentPane.add(resultadoZ);
		
	}
	Action trFocus = new AbstractAction() {
		/**
		 * Configura a tecla "enter" para transferir o foco para o próximo
		 * JTextField quando pressionada
		 */
		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent e) {
			KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
			manager.getFocusOwner().transferFocus();	
		}
	};
	public JTextField getVarx1() {
		return varx1;
	}

	public JTextField getVarx2() {
		return varx2;
	}

	public JTextField getVarx3() {
		return varx3;
	}

	public JTextField getVary1() {
		return vary1;
	}

	public JTextField getVary2() {
		return vary2;
	}

	public JTextField getVary3() {
		return vary3;
	}

	public JTextField getVarz1() {
		return varz1;
	}

	public JTextField getVarz2() {
		return varz2;
	}

	public JTextField getVarz3() {
		return varz3;
	}

	public JTextField getRes1() {
		return res1;
	}

	public JTextField getRes2() {
		return res2;
	}

	public JTextField getRes3() {
		return res3;
	}

	public JTextField getResultadoX() {
		return resultadoX;
	}

	public JTextField getResultadoY() {
		return resultadoY;
	}

	public JTextField getResultadoZ() {
		return resultadoZ;
	}

	public JButton getBtnResetar() {
		return btnResetar;
	}

	public JButton getBtnProcessar() {
		return btnProcessar;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

}
