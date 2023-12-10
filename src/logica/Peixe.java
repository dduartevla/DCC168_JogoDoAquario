package logica;
public abstract class Peixe {

    private final int id;
    private int posicaoX;
    private int posicaoY;

    private boolean moveuNaRodada;
    public Peixe(int id, int posicaoX, int posicaoY){
        this.id = id;
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.moveuNaRodada = false;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    public int getId(){
        return id;
    }

    public abstract int getR();
    public abstract void setR(int r);
    public abstract int getM();
    public abstract void setM(int m);

    public abstract void moverNoAquario(int x, int y,Aquario aquario, PosicaoAdjacente[] paVazias);

    public abstract void reproduzir(Aquario aquario, PosicaoAdjacente[] paVazias);

    public abstract Peixe criaNovoPeixe(int posX, int posY);

    public boolean moveuNaRodada(){
        return this.moveuNaRodada;
    }

    public void setMoveuNaRodada(boolean moveuNaRodada){
        this.moveuNaRodada = moveuNaRodada;
    }



}
