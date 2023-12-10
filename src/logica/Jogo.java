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
            System.out.println("Deseja encerrar? Digite \"s\" para sim e \"n\" para não.");
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
               if (aquario.getPosicao(i,j) != null && !aquario.getPosicao(i, j).moveuNaRodada()){ //se não moveu na rodada
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


    /* >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> INICIALIZAÇÃO DO JOGO <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    private void iniciarJogo(){
        configuracaAmbiente();
        this.aquario = new Aquario(Configuracoes.getInstance().getDimX(), Configuracoes.getInstance().getDimY());
        posicionaPeixesAInicio();
        posicionaPeixesBInicio();
        aquario.imprimeAquario();
    }

    private void posicionaPeixesAInicio(){ // so usado quando inicia ao jogo
        for (int i=0; i<Configuracoes.getInstance().getQtdPeixeA(); i++){
            boolean add=false;
            while (!add) {// não coloca peixe onde já tem peixe
                PeixeA peixe = new PeixeA(Configuracoes.getInstance().getId(),
                        getRandomNumberUsing(Configuracoes.getInstance().getDimX()- 1),
                        getRandomNumberUsing(Configuracoes.getInstance().getDimY() - 1));
                Configuracoes.getInstance().addId();
                if (aquario.getPosicao(peixe.getPosicaoX(),peixe.getPosicaoY())==null) {
                    aquario.addPeixe(peixe);
                    add = true;
                }
            }
        }
    }
    private void posicionaPeixesBInicio(){ // so usado quando inicia o jogo
        for (int i=0; i<Configuracoes.getInstance().getQtdPeixeB(); i++){
            boolean add=false;
            while (!add) { // não coloca peixe onde já tem peixe
                PeixeB peixe = new PeixeB(Configuracoes.getInstance().getId(),
                        getRandomNumberUsing(Configuracoes.getInstance().getDimX() - 1),
                        getRandomNumberUsing(Configuracoes.getInstance().getDimY() - 1));
                Configuracoes.getInstance().addId();
                if (aquario.getPosicao(peixe.getPosicaoX(),peixe.getPosicaoY())==null) {
                    aquario.addPeixe(peixe);
                    add = true;
                }
            }
        }
    }
    private void configuracaAmbiente(){
        System.out.println(">>>>CONFIGURAÇÃO DO AMBIENTE DO AQUÁRIO<<<<");
        setDimX();
        setDimY();
        setQtdPeixeA();
        setQtdPeixeB();
        setRa();
        setMa();
        setRb();
        setMb();

        System.out.println("\n\nO ambiente foi configurado com a seguinte configuração: \n" +
                "   - Tamanho do aquário: " + Configuracoes.getInstance().getDimX() + "x" + Configuracoes.getInstance().getDimY()+ "\n" +
                "   - Quantidade peixe A: " + Configuracoes.getInstance().getQtdPeixeA() + "\n" +
                "   - Quantidade peixe B: " + Configuracoes.getInstance().getQtdPeixeB() + "\n" +
                "   - Resistencia peixe A: " + Configuracoes.getInstance().getMa() + "\n" +
                "   - Limite reprodução peixe A: " + Configuracoes.getInstance().getRa() + "\n" +
                "   - Resistencia peixe B: " + Configuracoes.getInstance().getMb() + "\n" +
                "   - Limite reprodução peixe B: " + Configuracoes.getInstance().getRb() + "\n" +
                "===============================================================================\n");

    }

    public void setQtdPeixeA(){
        boolean validacao = false;
        int in ;
        while (!validacao) {
            System.out.println("Informe a quantidade inicial de peixes do tipo A: ");
            try {
                in = sc.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Informe apenas números.");
                sc.next();
                in=-1;
            }
            if (in > 0) {
                validacao = true;
                Configuracoes.getInstance().setQtdPeixeA(in);
            }
        }
    }

    public void setQtdPeixeB(){
        boolean validacao = false;
        int in;
        while (!validacao) {
            System.out.println("Informe a quantidade inicial de peixes do tipo B: ");
            try {
                in = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Informe apenas números.");
                sc.next();
                in=-1;
            }
            if (in > 0) {
                validacao = true;
                Configuracoes.getInstance().setQtdPeixeB(in);
            }
        }
    }

    public void setDimX(){
        boolean validacao = false;
        int in;
        while (!validacao) {
            System.out.println("Informe a dimensão \"x\" do aquário: ");
            try {
                in = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Informe apenas números.");
                sc.next();
                in=-1;
            }
            if (in > 0) {
                validacao = true;
                Configuracoes.getInstance().setDimX(in);
            }
        }
    }

    public void setDimY(){
        boolean validacao = false;
        int in;
        while (!validacao) {
            System.out.println("Informe a dimensão \"y\" do aquário: ");
            try {
                in = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Informe apenas números.");
                sc.next();
                in=-1;
            }
            if (in > 0) {
                validacao = true;
                Configuracoes.getInstance().setDimY(in);
            }
        }
    }

    public void setRa(){
        boolean validacao = false;
        int in;
        while (!validacao) {
            System.out.println("Informe o valor de \"RA\": ");
            try {
                in = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Informe apenas números.");
                sc.next();
                in=-1;
            }
            if (in > 0) {
                validacao = true;
                Configuracoes.getInstance().setRa(in);
            }
        }
    }

    public void setMa(){
        boolean validacao = false;
        int in;
        while (!validacao) {
            System.out.println("Informe o valor de \"MA\": ");
            try {
                in = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Informe apenas números.");
                sc.next();
                in=-1;
            }
            if (in > 0) {
                validacao = true;
                Configuracoes.getInstance().setMa(in);
            }
        }
    }

    public void setRb(){
        boolean validacao = false;
        int in;
        while (!validacao) {
            System.out.println("Informe o valor de \"RB\": ");
            try {
                in = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Informe apenas números.");
                sc.next();
                in=-1;
            }
            if (in > 0) {
                validacao = true;
                Configuracoes.getInstance().setRb(in);
            }
        }
    }

    public void setMb(){
        boolean validacao = false;
        int in;
        while (!validacao) {
            System.out.println("Informe o valor de \"MB\": ");
            try {
                in = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Informe apenas números.");
                sc.next();
                in=-1;
            }
            if (in > 0) {
                validacao = true;
                Configuracoes.getInstance().setMb(in);
            }
        }
    }

    public int getRandomNumberUsing(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    /* >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ========================= <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
}
