package logica;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Jogo {

    Scanner sc = new Scanner(System.in);
    private Aquario aquario;

    public Jogo(){
        Configuracoes.getInstance().iniciaIDPontuacao();
    }

    public void loopingJogo(){
        boolean encerrar = false;
        iniciarJogo();
        while (Configuracoes.getInstance().getQtdPeixeB() > 0 && !encerrar){
            rodada();
            System.out.println("Deseja encerrar? Digite \"s\" para sim e \"n\" para n�o.");
            String str = sc.next().trim();
            if (str.equals("s") || str.equals("S"))
                encerrar = true;
        }
    }

    private void rodada(){
        System.out.println("\n===============================================================================\n");
        System.out.println("RODADA " + Configuracoes.getInstance().getPontuacao() + "\n");

        for (int i = 0; i < Configuracoes.getInstance().getDimX(); i++) {
            for (int j = 0; j < Configuracoes.getInstance().getDimY(); j++) {
               verificaPosicao(i,j);
               if (aquario.getPosicao(i,j) != null && !aquario.getPosicao(i, j).moveuNaRodada()){ //se n�o moveu na rodada
                   aquario.getPosicao(i,j).setM(aquario.getPosicao(i,j).getM() +1);
               }
            }
        }
        resetMoveuPeixe();// reseta o verificador se moveu na rodada para false
        aquario.imprimeAquario();
        Configuracoes.getInstance().addPontuacao();
    }

    private void resetMoveuPeixe(){
        for (int i = 0; i < Configuracoes.getInstance().getDimX(); i++) {
            for (int j = 0; j < Configuracoes.getInstance().getDimY(); j++) {
                if (aquario.getPosicao(i,j) != null){
                    aquario.getPosicao(i,j).setMoveuNaRodada(false);
                }
            }
        }
    }

    private void verificaPosicao(int x, int y){
        if (aquario.getPosicao(x,y) != null){
            if (aquario.getPosicao(x,y) instanceof PeixeA){
                lidaComPeixeA(x,y);
            } else {
                lidaComPeixeB(x,y);
            }
        }
    }


     private void lidaComPeixeA(int x, int y){

        if (aquario.getPosicao(x,y).getM() == Configuracoes.getInstance().getMa()){ // nesse caso peixe morreu sozinho
            aquario.setPosicaoNula(x,y);
            Configuracoes.getInstance().subQtdPeixeA();
        } else {
            PosicaoAdjacente[] pa = aquario.olhaAoRedor(x,y);
            if (aquario.getPosicao(x,y).getR() == Configuracoes.getInstance().getRa()){ //peixe esta apto a reproduzir
                aquario.getPosicao(x,y).reproduzir(aquario,pa);
            } else {
                aquario.getPosicao(x,y).moverNoAquario(x,y,aquario,pa);
            }
        }
    }

    private void lidaComPeixeB(int x, int y){
        if (aquario.getPosicao(x,y).getM() == Configuracoes.getInstance().getMb()){ // nesse caso peixe morreu sozinho
            aquario.setPosicaoNula(x,y);
            Configuracoes.getInstance().subQtdPeixeB();
        } else {
            PosicaoAdjacente[] pa = aquario.olhaAoRedor(x,y);
            if (aquario.getPosicao(x,y).getR() == Configuracoes.getInstance().getRb()){ //peixe esta apto a reproduzir
                aquario.getPosicao(x,y).reproduzir(aquario,pa);
            } else {
                aquario.getPosicao(x,y).moverNoAquario(x,y,aquario,pa);
            }
        }
    }


    /* >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> INICIALIZA��O DO JOGO <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    private void iniciarJogo(){
        configuracaAmbiente();
    }
    
    public String auxIniciarJogo(int[] valores){    	
    	int dimX, dimY, qtdA,  qtdB,  ra,  ma,  rb, mb;
		dimX = valores[0];
		dimY = valores[1];
		qtdA = valores[2];
		qtdB = valores[3];
		ra = valores[4];
		ma = valores[5];
		rb = valores[6];
		mb = valores[7];        
    	if (dimX<1 || dimY<1){
    		return "Tamanhao inv�lido de aqu�rio";
    	} else if (qtdA<1 || qtdB<1 || qtdA > dimX*dimY || qtdB > dimX*dimY){
    		return "Quantidade de peixes inv�lida";
    	} else if (ra<1 || ma<1 || rb<1 || mb<1){
    		return "Condi��es do ambiente inv�lidas.";
    	}else{     	
	    	Configuracoes.getInstance().setDimX(dimX);
	        Configuracoes.getInstance().setDimY(dimY);
	        Configuracoes.getInstance().setQtdPeixeA(qtdA);
	        Configuracoes.getInstance().setQtdPeixeB(qtdB);
	        Configuracoes.getInstance().setRa(ra);
	        Configuracoes.getInstance().setMa(ma);
	        Configuracoes.getInstance().setRb(rb);
	        Configuracoes.getInstance().setMb(mb);
	        
	        System.out.println("\n\nO ambiente foi configurado com a seguinte configura��o: \n" +
	                "   - Tamanho do aqu�rio: " + Configuracoes.getInstance().getDimX() + "x" +
	        		Configuracoes.getInstance().getDimY()+ "\n" +
	                "   - Quantidade peixe A: " + Configuracoes.getInstance().getQtdPeixeA() + "\n" +
	                "   - Quantidade peixe B: " + Configuracoes.getInstance().getQtdPeixeB() + "\n" +
	                "   - Resistencia peixe A: " + Configuracoes.getInstance().getMa() + "\n" +
	                "   - Limite reprodu��o peixe A: " + Configuracoes.getInstance().getRa() + "\n" +
	                "   - Resistencia peixe B: " + Configuracoes.getInstance().getMb() + "\n" +
	                "   - Limite reprodu��o peixe B: " + Configuracoes.getInstance().getRb() + "\n" +
	                "===============================================================================\n");
	        
	        this.aquario = new Aquario(Configuracoes.getInstance().getDimX(),
	        		Configuracoes.getInstance().getDimY());
	        posicionaPeixesAInicio();
	        posicionaPeixesBInicio();
	        aquario.imprimeAquario();
	        return "Ambiente criado com sucesso.";
    	}
    }
    
    private void configuracaAmbiente(){
        System.out.println(">>>>CONFIGURA��O DO AMBIENTE DO AQU�RIO<<<<");
        int valores[] = new int[8];
        
        for (int i=0; i<8; i++){
        	setValor(i,valores);
        }
        
        auxIniciarJogo(valores);
    }

    private void posicionaPeixesAInicio(){ // so usado quando inicia ao jogo
        for (int i=0; i<Configuracoes.getInstance().getQtdPeixeA(); i++){
            boolean add=false;
            int cont = 0;
            int controle = Configuracoes.getInstance().getDimX() * Configuracoes.getInstance().getDimY();
            while (!add && cont < controle) {// n�o coloca peixe onde j� tem peixe
                PeixeA peixe = new PeixeA(Configuracoes.getInstance().getId(),
                        getRandomNumberUsing(Configuracoes.getInstance().getDimX()- 1),
                        getRandomNumberUsing(Configuracoes.getInstance().getDimY() - 1));
                Configuracoes.getInstance().addId();
                if (aquario.getPosicao(peixe.getPosicaoX(),peixe.getPosicaoY())==null) {
                    aquario.addPeixe(peixe);
                    add = true;
                }
                cont++;
            }
        }
    }
    private void posicionaPeixesBInicio(){ // so usado quando inicia o jogo
        for (int i=0; i<Configuracoes.getInstance().getQtdPeixeB(); i++){
            boolean add=false;
            int cont = 0;
            int controle = Configuracoes.getInstance().getDimX() * Configuracoes.getInstance().getDimY();
            while (!add && cont < controle) { // n�o coloca peixe onde j� tem peixe
                PeixeB peixe = new PeixeB(Configuracoes.getInstance().getId(),
                        getRandomNumberUsing(Configuracoes.getInstance().getDimX() - 1),
                        getRandomNumberUsing(Configuracoes.getInstance().getDimY() - 1));
                Configuracoes.getInstance().addId();
                if (aquario.getPosicao(peixe.getPosicaoX(),peixe.getPosicaoY())==null) {
                    aquario.addPeixe(peixe);
                    add = true;
                }
                cont++;
            }
        }
    }
    

    public void setValor(int i, int vals[]){
        boolean validacao = false;
        int in ;
        while (!validacao) {
            System.out.println("Informe o valor: ");
            try {
                in = sc.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Informe apenas n�meros.");
                sc.next();
                in=-1;
            }
            if (in > 0) {
                validacao = true;
                vals[i] = in;
            }
        }
    }

    

    public int getRandomNumberUsing(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    /* >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ========================= <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
}
