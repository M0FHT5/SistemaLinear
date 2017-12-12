package sistema.linear;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;

public class SistemaCTL {

	SistemaFRM tela;

	private double[] eq1 = new double [4];
	private double[] eq2 = new double [4];
	private double[] eq3 = new double [4];
	private double[] eqTemp1 = new double [4];
	private double[] eqTemp2 = new double [4];
	private double[] eqTemp3 = new double [4];
	private boolean imp = false;
	

	//Carrega a tela da aplicação
	public void exibir(){
		tela = new SistemaFRM();
		criaEventos();
		tela.setLocationRelativeTo(null);
		tela.setVisible(true);
	}

	//Cria os eventos
	private void criaEventos() {

		tela.getBtnResetar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetar();
			}
		});
		tela.getBtnProcessar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				processar();
			}
		});
		tela.getRes3().addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt){
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					processar();
				}
			}
		});
		
	}
	public void processar(){

		try {
			/*Bloco onde se adiciona os valores de cada coeficiente 
			  em 3 vetores que representam as 3 equações do sistema linear*/
			eq1[0] = Double.parseDouble(tela.getVarx1().getText());
			eq1[1] = Double.parseDouble(tela.getVary1().getText());
			eq1[2] = Double.parseDouble(tela.getVarz1().getText());
			eq1[3] = Double.parseDouble(tela.getRes1().getText());

			eq2[0] = Double.parseDouble(tela.getVarx2().getText());
			eq2[1] = Double.parseDouble(tela.getVary2().getText());
			eq2[2] = Double.parseDouble(tela.getVarz2().getText());
			eq2[3] = Double.parseDouble(tela.getRes2().getText());


			eq3[0] = Double.parseDouble(tela.getVarx3().getText());
			eq3[1] = Double.parseDouble(tela.getVary3().getText());
			eq3[2] = Double.parseDouble(tela.getVarz3().getText());
			eq3[3] = Double.parseDouble(tela.getRes3().getText());


			/*Bloco que determina qual equação tem o coeficiente de X mais próxima
			  ou igual a '1' para torná-la a primeira equação do sistema*/
			double pivo[] = {eq1[0], eq2[0], eq3[0]};
			double referencia = 0;
			for (int i = 0; i < pivo.length; i++) {
				if (pivo[i] != 0) {
					referencia = pivo[i];
					break;
				}
			}
			if (referencia == 0) {
				mensagem("erro",0);
				resetar();
			}
			double nearUm = referencia;
			double bestDis = Integer.MAX_VALUE;
			for (int i = 0; i < pivo.length; i++) {
				if (pivo[i] == 1) {
					nearUm = pivo[i];
					break;
				} else {
					double d = Math.abs(1 - pivo[i]);
					if (d < bestDis) {
						bestDis = d;
						nearUm=pivo[i];
					}
				}
			}
			
			/*Bloco que move as equações do sistema para 3 vetores temporário, 
			  ordenadas pela equação com o coeficiente dos pivos mais próximos 
			  ou iguais a 1, na tentativa de se assemelhar ao máximo a uma matriz
			  identidade*/
			if (eq1[0] == nearUm) {
				for (int i = 0; i < eq1.length; i++) {
					eqTemp1[i] = eq1[i];
				}if (eq2[1] < eq3[1]) {
					for (int i = 0; i < eq1.length; i++) {
						eqTemp2[i] = eq3[i];
						eqTemp3[i] = eq2[i];
					}
				}else {
					for (int i = 0; i < eq1.length; i++) {
						eqTemp2[i] = eq2[i];
						eqTemp3[i] = eq3[i];
					}
				}
			}else if (eq2[0] == nearUm) {
				for (int i = 0; i < eq2.length; i++) {
					eqTemp1[i] = eq2[i];
				}if (eq1[1] < eq3[1]) {
					for (int i = 0; i < eq2.length; i++) {
						eqTemp2[i] = eq3[i];
						eqTemp3[i] = eq1[i];
					}
				}else {
					for (int i = 0; i < eq1.length; i++) {
						eqTemp2[i] = eq1[i];
						eqTemp3[i] = eq3[i];
					}
				}
			}else if (eq3[0] == nearUm){
				for (int i = 0; i < eq3.length; i++) {
					eqTemp1[i] = eq3[i];
				}if (eq1[1] < eq2[1]) {
					for (int i = 0; i < eq2.length; i++) {
						eqTemp2[i] = eq2[i];
						eqTemp3[i] = eq1[i];
					}
				}else {
					for (int i = 0; i < eq1.length; i++) {
						eqTemp2[i] = eq1[i];
						eqTemp3[i] = eq2[i];
					}
				}
			}
			imprimeMatriz();
			isImpossivel();
			if (imp == true) {
				return;
			}

			//Bloco responsável por transformar o pivô da 1ª equação em '1'
			double pivo1 = eqTemp1[0];
			if (pivo1 != 1 && pivo1 != 0) {
				for (int i = 0; i < eqTemp1.length; i++) {
					eqTemp1[i] = eqTemp1[i] / pivo1;
				} 
			}
			//Bloco responsável por transformar os coeficientes de X² e X³ em '0'
			double coefX2 = eqTemp2[0];
			if (coefX2 != 0) {
				if (coefX2 < 0) {
					for (int i = 0; i < eqTemp2.length; i++) {
						eqTemp2[i] = eqTemp2[i] + (eqTemp1[i] * (coefX2 * -1));
					}
				} else if (coefX2 > 0) {
					for (int i = 0; i < eqTemp2.length; i++) {
						eqTemp2[i] = eqTemp2[i] - (eqTemp1[i] * (coefX2 * 1));
					}
				} 
			}
			imprimeMatriz();
			isImpossivel();
			if (imp == true) {
				return;
			}
			double coefX3 = eqTemp3[0];
			if (coefX3 != 0) {
				if (coefX3 < 0) {
					for (int i = 0; i < eqTemp3.length; i++) {
						eqTemp3[i] = eqTemp3[i] + (eqTemp1[i] * (coefX3 * -1));
					}
				} else if (coefX3 > 0) {
					for (int i = 0; i < eqTemp3.length; i++) {
						eqTemp3[i] = eqTemp3[i] - (eqTemp1[i] * coefX3);
					}
				} 
			}
			imprimeMatriz();
			isImpossivel();
			if (imp == true) {
				return;
			}
			
			if (eqTemp2[1] == 0 && eqTemp3[1] == 0) {
				double coeficienteA = eqTemp2[2];
				double coeficienteB = eqTemp3[2];
				for (int i = 0; i < eqTemp1.length; i++) {
					eqTemp2[i] = (eqTemp3[i] * coeficienteA) - (eqTemp2[i] * coeficienteB);
				}
				isImpossivel();
				if (imp == true) {
					return;
				}

				//Bloco que testa se o sistema é possível e indeterminado através da 2ª equação
				if (eqTemp2[0] == 0 && eqTemp2[1] == 0 && eqTemp2[2] == 0 && eqTemp2[3] == 0) {
					if (eqTemp3[2] != 1 && eqTemp3[2] != 0) {
						double pivo4 = eqTemp3[2];
						for (int i = 0; i < eqTemp3.length; i++) {
							eqTemp3[i] = eqTemp3[i] / pivo4;
						}
						imprimeMatriz();
						tela.getResultadoY().setText("a");
						String resultZ = Double.toString(eqTemp3[3]);
						tela.getResultadoZ().setText(resultZ);
						tela.getResultadoX().setText(format(-1 * eqTemp1[1]) + tela.getResultadoZ().getText() + format( -1 * eqTemp1[2] * eqTemp3[3] + eqTemp1[3]));
					}

				}
			}else {
				//Bloco responsável por transformar o pivô da 2ª equação em '1'
				if (eqTemp2[1] != 1 && eqTemp2[1] != 0) {
					double pivo2 = eqTemp2[1];
					for (int i = 0; i < eqTemp2.length; i++) {
						eqTemp2[i] = eqTemp2[i] / pivo2;
					}
				}
				//Bloco responsável por transformar os coeficientes de Y¹ e Y³ em '0'
				double coefY1 = eqTemp1[1];
				if (coefY1 != 0) {
					if (coefY1 < 0) {
						for (int i = 0; i < eqTemp1.length; i++) {
							eqTemp1[i] = eqTemp1[i] + (eqTemp2[i] * (coefY1 * -1));
						}
					} else if (coefY1 > 0) {
						for (int i = 0; i < eqTemp1.length; i++) {
							eqTemp1[i] = eqTemp1[i] - (eqTemp2[i] * coefY1);
						}
					} 
				}
				isImpossivel();
				if (imp == true) {
					return;
				}
				double coefY3 = eqTemp3[1];
				if (coefY3 != 0) {
					if (coefY3 < 0) {
						for (int i = 0; i < eqTemp3.length; i++) {
							eqTemp3[i] = eqTemp3[i] + (eqTemp2[i] * (coefY3 * -1));
						}
					} else if (coefY3 > 0) {
						for (int i = 0; i < eqTemp3.length; i++) {
							eqTemp3[i] = eqTemp3[i] - (eqTemp2[i] * coefY3);
						}
					} 
				}
				imprimeMatriz();
				isImpossivel();
				if (imp == true) {
					return;
				}
				//Bloco que testa se o sistema é possível e indeterminado a partir da 3ª equação
				if (eqTemp3[0] == 0 && eqTemp3[1] == 0 && eqTemp3[2] == 0 && eqTemp3[3] == 0) {
					
					tela.getResultadoZ().setText("a");
					tela.getResultadoY().setText(format(eqTemp2[2] * - 1) + "a " + format(eqTemp2[3]));
					tela.getResultadoX().setText(format(-1 * (eqTemp1[1] * eqTemp2[2] + eqTemp1[2])) + "a " + format(-1 * eqTemp1[1] * eqTemp2[3] + eqTemp1[3]));

				} else {
					//Bloco responsável por transformar o pivô da 3ª equação em 1
					if (eqTemp3[2] != 1 && eqTemp3[2] != 0) {
						double pivo3 = eqTemp3[2];
						for (int i = 0; i < eqTemp3.length; i++) {
							eqTemp3[i] = eqTemp3[i] / pivo3;
						}
					}
					//Bloco responsável por transformar as coeficientes de Z¹ e Z² em 0
					double coefZ1 = eqTemp1[2];
					if (coefZ1 != 0) {
						if (coefZ1 < 0) {
							for (int i = 0; i < eqTemp1.length; i++) {
								eqTemp1[i] = eqTemp1[i] + (eqTemp3[i] * (coefZ1 * -1));
							}
						} else if (coefZ1 > 0) {
							for (int i = 0; i < eqTemp1.length; i++) {
								eqTemp1[i] = eqTemp1[i] - (eqTemp3[i] * coefZ1);
							}
						} 
					}
					double coefZ2 = eqTemp2[2];
					if (coefZ2 != 0) {
						if (coefZ2 < 0) {
							for (int i = 0; i < eqTemp2.length; i++) {
								eqTemp2[i] = eqTemp2[i] + (eqTemp3[i] * (coefZ2 * -1));
							}
						} else if (coefZ2 > 0) {
							for (int i = 0; i < eqTemp1.length; i++) {
								eqTemp2[i] = eqTemp2[i] - (eqTemp3[i] * coefZ2);
							}
						} 
					}

					//Imprime o resultado na aplicação
					imprimeMatriz();
					if (imp == false) {
						String resultX = format(eqTemp1[3]);
						tela.getResultadoX().setText(resultX);
						String resultY = format(eqTemp2[3]);
						tela.getResultadoY().setText(resultY);
						String resultZ = format(eqTemp3[3]);
						tela.getResultadoZ().setText(resultZ);
					}
				}
			}
		} catch (NumberFormatException e) {
			mensagem("erro",0);
			resetar();
		} catch (HeadlessException e) {
			mensagem("erro",0);
			resetar();
		}
	}
	 
	//Determina o número mínimo e máximo de casas decimais e adiciona o sinal respectivo ao número
	public static String format(Number n){
		NumberFormat format = new DecimalFormat("+#,##0.0000;-#");
		format.setRoundingMode(RoundingMode.FLOOR);
		format.setMinimumFractionDigits(0);
		format.setMaximumFractionDigits(4);
		String formatValue = format.format(n);
		if (formatValue.equalsIgnoreCase("-0") || formatValue.equalsIgnoreCase("+0")) {
			formatValue = "0";
		}
		return formatValue;

	}
	//Testa se o sistema é impossível
	public void isImpossivel(){
		
		if (eqTemp1[0] == 0 && eqTemp1[1] == 0 && eqTemp1[2] == 0 && eqTemp1[3] != 0 ) {
			mensagem("imp", eqTemp1[3]);
			imp = true;
		}
		else if (eqTemp2[0] == 0 && eqTemp2[1] == 0 && eqTemp2[2] == 0 && eqTemp2[3] != 0 ) {
			mensagem("imp", eqTemp2[3]);
			imp = true;
		}
		else if (eqTemp3[0] == 0 && eqTemp3[1] == 0 && eqTemp3[2] == 0 && eqTemp3[3] != 0 ) {
			mensagem("imp", eqTemp3[3]);
			imp = true;
		}
		if (imp == true) {
			resetar();
		}
	}
	//Imprime matriz no console, de forma reduzida(não interfere no cálculo)
	public void imprimeMatriz(){
		String rightAlingFormat = "%8.2f";
		double[][] matriz = { eqTemp1, eqTemp2, eqTemp3 };
		for (int i = 0; i < matriz.length; i++) {
			System.out.print("|");
			for (int j = 0; j < eqTemp1.length; j++) {
				System.out.format(rightAlingFormat, matriz[i][j]);
			}
			System.out.print(" |\n");
		}
		System.out.println("");
	}
	//Imprime mensagens em painéis
	public void mensagem(String msg, double valor){
		if (msg.equals("erro")) {
			JOptionPane.showMessageDialog(null, "Campo(s) com dado(s) inválido(s), preencha corretamente!");
		}else if (msg.equals("imp")) {
			JOptionPane.showMessageDialog(null, "Sistema Impossível: 0X + 0Y + 0Z = " + format(valor));
		}
	}

	//Método que reseta a aplicação
	public void resetar(){
		tela.dispose();
		tela = new SistemaFRM();
		criaEventos();
		tela.setLocationRelativeTo(null);
		tela.setVisible(true);
	}

}
