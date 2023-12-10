package trabalhodcc168;
import java.util.Scanner;

import logica.Configuracoes;
import logica.Jogo;


public class TrabalhoDCC168 {
	
	private static Scanner sc;

	public static void main(String[] args) {
        sc = new Scanner(System.in);
        Jogo jogo = new Jogo();
        boolean jogarNovamente = true;
        System.out.println(">>>>BEM VINDO AO JOGO DO AQU�RIO<<<<");
        System.out.print("Para jogar movimente os peixes de acordo com as regras abaixo. \n" +
                "\nREGRAS DOS PEIXES DO TIPO A: \n" +
                "   1)Podem se movimentar para c�lulas adjacentes vazias \n" +
                "   2)Se reproduzem ap�s \"RA\" movimentos se existe uma c�lula adjacente vazia. \n" +
                "   3)Morrem se n�o se movimentarem por \"MA\" rodadas seguidas.\n" +
                "\nREGRAS DOS PEIXES DO TIPO B: \n" +
                "   1)Se existe um peixe do tipo A em uma c�lula adjacente, se move para l� e come o peixe A.\n" +
                "   2)Ap�s comer \"RB\" peixes ele se reproduz se: \n" +
                "       - n�o houver nehum peixe a sua volta;\n" +
                "       - houver uma c�lual adjacente livre. \n" +
                "   3)Se n�o comer por \"MB\" rodadas ele morre.\n" +
                "\nPONTUA��O E FUNCIONAMENTO: " +
                "\n   - � o n�mero de rodadas at� que o jogo seja encerrado." +
                "\n   - O jogo se encera se n�o houver mais peixes do tipo B, ou se o jogador decidir encerrar.\n" +
                "\n\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n" +
                "DEFINA AGORA AS CONDI��ES INICIAIS DO AQU�RIO\n\n");

         do {
            jogo.loopingJogo();
            System.out.println("Deseja jogar novamente? Digite \"s\" para sim e \"n\" para n�o.");
            String str = sc.next().trim();
            if (str.equals("n") || str.equals("N")){
                jogarNovamente = false;
            }
        }while (jogarNovamente);
        System.out.println("\n FIM DO JOGO \n" +
                "PONTUA��O FINAL: " + Configuracoes.getInstance().getPontuacao());



    }

}
