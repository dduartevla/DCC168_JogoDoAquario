package logica;
public class PeixeB extends Peixe{

    private int rb,mb;

    public PeixeB(int id, int posicaoX, int posicaoY){
        super(id, posicaoX, posicaoY);
        rb = 0;
        mb = 0;
    }

    public int getR() {
        return rb;
    }

    public void setR(int rb) {
        this.rb = rb;
    }

    public int getM() {
        return mb;
    }

    public void setM(int mb) {
        this.mb = mb;
    }

    public String toString(){
        return String.format("B-%02d",getId());
    }

    public void moverNoAquario(int x, int y,Aquario aquario, PosicaoAdjacente[] posAoRedor) {

        for(int i=0; i<posAoRedor.length;i++){//percorre vetor de posições adjacentes ao peixe selecionado
            if (posAoRedor[i] !=null) {//ve se tem uma posição válida
                Peixe auxPeixe = aquario.getPosicao(x,y);//auxPeixe recebe o peixe que vai ser movido
                try{
                if (!auxPeixe.moveuNaRodada()) {
                    if (aquario.getPosicao(posAoRedor[i].x, posAoRedor[i].y) instanceof PeixeA) {
                        aquario.setPosicaoNula(x, y);//apaga o peixe da posicao anteriror
                        aquario.setPosicao(auxPeixe, posAoRedor[i].x, posAoRedor[i].y);
                        aquario.getPosicao(posAoRedor[i].x, posAoRedor[i].y).setMoveuNaRodada(true);
                        auxPeixe.setR(auxPeixe.getR() + 1);
                    } else if (aquario.getPosicao(posAoRedor[i].x, posAoRedor[i].y) == null){
                        aquario.setPosicaoNula(x, y);//apaga o peixe da posicao anteriror
                        aquario.setPosicao(auxPeixe, posAoRedor[i].x, posAoRedor[i].y);
                        auxPeixe.setM(auxPeixe.getM()+1);
                        break;
                    }
                }
                } catch (NullPointerException e){}
            }
        }
    }

/*1*/    public void reproduzir(Aquario aquario, PosicaoAdjacente[] posAoRedor) {
/*1*/
/*1*/        //pegando os peixes ao redor
/*1*/        Peixe[] peixesAoRedor = aquario.pegaPeixesAoRedor(this.getPosicaoX(), this.getPosicaoY());
/*1*/
/*1*/        //verificando se tem peixes tipoB ao redor
/*1*/        boolean podeReproduzir = true;
/*1,5*/      for (int i=0; i<peixesAoRedor.length; i++){
/*2*/            if (peixesAoRedor[i] instanceof PeixeB) {
/*3*/                podeReproduzir = false;
/*3*/                break;
/*4*/            }
/*5*/        }
/*5*/
/*6*/        if (podeReproduzir) {
/*7*/            //faz a reprodução do peixe B para a peimeira célula livre disponível
/*7,13*/         for (int i = 0; i < posAoRedor.length; i++) {
/*8*/                if (posAoRedor[i] !=null) {
/*9*/                    Peixe peixe = aquario.getPosicao(posAoRedor[i].x, posAoRedor[i].y);
/*9*/                    if (peixe == null) {
/*10*/                        int x = posAoRedor[i].x;
/*10*/                        int y = posAoRedor[i].y;
/*10*/                        aquario.setPosicao(criaNovoPeixe(x, y), x, y);
/*10*/                        this.mb = this.mb +1;
/*10*/                        break;
/*11*/                    }
/*12*/                }
/*13*/            }
/*14*/        }
/*14*/
/*15*/    }

    @Override
    public Peixe criaNovoPeixe(int posX, int posY) {
        PeixeB peixe = new PeixeB(Configuracoes.getInstance().getId(), posX, posY);
        Configuracoes.getInstance().addId();
        Configuracoes.getInstance().addQtdPeixeB();
        return peixe;
    }
}
