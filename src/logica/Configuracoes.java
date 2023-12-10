package logica;
public class Configuracoes {

    private static Configuracoes instance = new Configuracoes();

    public static Configuracoes getInstance() {
        return instance;
    }

    private int qtdPeixeA, qtdPeixeB;

    private int dimX, dimY;
    private int ra,rb, ma, mb;

    private int id, pontuacao;

    public void addPontuacao(){
        this.pontuacao = pontuacao+1;
    }

    public void addId(){
        id = id+1;
    }

    public void addQtdPeixeA(){
        qtdPeixeA = qtdPeixeA+1;
    }

    public void subQtdPeixeA(){
        qtdPeixeA = qtdPeixeA-1;
    }

    public void addQtdPeixeB(){
        qtdPeixeB = qtdPeixeB+1;
    }

    public void subQtdPeixeB(){
        qtdPeixeB = qtdPeixeB-1;
    }

    public void iniciaIDPontuacao(){
        id = 0;
        pontuacao = 1;
    }

    public int getQtdPeixeA() {
        return qtdPeixeA;
    }

    public int getQtdPeixeB() {
        return qtdPeixeB;
    }

    public int getDimX() {
        return dimX;
    }

    public int getDimY() {
        return dimY;
    }

    public int getRa() {
        return ra;
    }

    public int getRb() {
        return rb;
    }

    public int getMa() {
        return ma;
    }

    public int getMb() {
        return mb;
    }

    public int getId() {
        return id;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setQtdPeixeA(int qtdPeixeA) {
        this.qtdPeixeA = qtdPeixeA;
    }

    public void setQtdPeixeB(int qtdPeixeB) {
        this.qtdPeixeB = qtdPeixeB;
    }

    public void setDimX(int dimX) {
        this.dimX = dimX;
    }

    public void setDimY(int dimY) {
        this.dimY = dimY;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public void setMb(int mb) {
        this.mb = mb;
    }
}
