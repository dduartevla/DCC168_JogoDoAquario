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
        System.out.println(">>>>BEM VINDO AO JOGO DO AQUÁRIO<<<<");
        System.out.print("Para jogar movimente os peixes de acordo com as regras abaixo. \n" +
                "\nREGRAS DOS PEIXES DO TIPO A: \n" +
                "   1)Podem se movimentar para células adjacentes vazias \n" +
                "   2)Se reproduzem após \"RA\" movimentos se existe uma célula adjacente vazia. \n" +
                "   3)Morrem se não se movimentarem por \"MA\" rodadas seguidas.\n" +
                "\nREGRAS DOS PEIXES DO TIPO B: \n" +
                "   1)Se existe um peixe do tipo A em uma célula adjacente, se move para lá e come o peixe A.\n" +
                "   2)Após comer \"RB\" peixes ele se reproduz se: \n" +
                "       - não houver nehum peixe a sua volta;\n" +
                "       - houver uma célual adjacente livre. \n" +
                "   3)Se não comer por \"MB\" rodadas ele morre.\n" +
                "\nPONTUAÇÃO E FUNCIONAMENTO: " +
                "\n   - É o número de rodadas até que o jogo seja encerrado." +
                "\n   - O jogo se encera se não houver mais peixes do tipo B, ou se o jogador decidir encerrar.\n" +
                "\n\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n" +
                "DEFINA AGORA AS CONDIÇÕES INICIAIS DO AQUÁRIO\n\n");

         do {
            jogo.loopingJogo();
            System.out.println("Deseja jogar novamente? Digite \"s\" para sim e \"n\" para não.");
            String str = sc.next().trim();
            if (str.equals("n") || str.equals("N")){
                jogarNovamente = false;
            }
        }while (jogarNovamente);
        System.out.println("\n FIM DO JOGO \n" +
                "PONTUAÇÂO FINAL: " + Configuracoes.getInstance().getPontuacao());



    }

}
