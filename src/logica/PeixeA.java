package logica;
public class PeixeA extends Peixe{

    private int ra, ma;
    public PeixeA(int id, int posicaoX, int posicaoY){
        super(id, posicaoX, posicaoY);
        ra = 0;
        ma = 0;
    }

    public int getR() {
        return ra;
    }

    public void setR(int ra) {
        this.ra = ra;
    }

    public int getM() {
        return ma;
    }

    public void setM(int ma) {
        this.ma = ma;
    }

    public String toString(){
        return String.format("A-%02d",getId());
    }

    public void moverNoAquario(int x, int y,Aquario aquario, PosicaoAdjacente[] posAoRedor) {
        for(int i=0; i<posAoRedor.length;i++){//percorre vetor de posições adjacentes ao peixe selecionado
            if (posAoRedor[i] !=null) {//ve se tem uma posição válida
                Peixe auxPeixe = aquario.getPosicao(x,y);//auxPeixe recebe o peixe que vai ser movido
                if (!auxPeixe.moveuNaRodada()) {
                    if (aquario.getPosicao(posAoRedor[i].x, posAoRedor[i].y) == null) { //verifica se a posição onde vai inserir está vazia
                        aquario.setPosicaoNula(x, y);//apaga o peixe da posicao anteriror
                        aquario.setPosicao(auxPeixe, posAoRedor[i].x, posAoRedor[i].y);
                        auxPeixe.setR(auxPeixe.getR() + 1);
                        aquario.getPosicao(posAoRedor[i].x, posAoRedor[i].y).setMoveuNaRodada(true);
                        break;
                    }
                }
            }
        }
    }

    public void reproduzir(Aquario aquario, PosicaoAdjacente[] posAoRedor) {

        for(int i=0; i<posAoRedor.length;i++){
            if (posAoRedor[i] !=null) {
                Peixe peixe = aquario.getPosicao(posAoRedor[i].x, posAoRedor[i].y);
                if ( peixe == null) {
                    int x = posAoRedor[i].x;
                    int y = posAoRedor[i].y;
                    aquario.setPosicao(criaNovoPeixe(x,y),x,y);
                    break;
                }
            }
        }

    }

    @Override
    public Peixe criaNovoPeixe(int posX, int posY) {
        PeixeA peixe = new PeixeA(Configuracoes.getInstance().getId(), posX, posY);
        peixe.setR(0);
        Configuracoes.getInstance().addId();
        Configuracoes.getInstance().addQtdPeixeA();
        return peixe;
    }
}
