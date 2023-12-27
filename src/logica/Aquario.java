package logica;
import java.util.ArrayList;
import java.util.List;

public class Aquario {

    private Peixe[][] aquario;

    private final int dimX;
    private final int dimY;

    public Aquario (int dimX, int dimY){
        this.dimX = dimX;
        this.dimY = dimY;
        this.aquario = new Peixe[dimX][dimY];
    }

    public void addPeixe(Peixe peixe){
        if (verificaPosicao(peixe.getPosicaoX(),peixe.getPosicaoY())) {
            aquario[peixe.getPosicaoX()][peixe.getPosicaoY()] = peixe;

        }
        else {
            throw new IllegalArgumentException("POSIÇÃO FORA DOS LIMITES DO AQUÁRIO");
        }
    }

    private boolean verificaPosicao(int x, int y){
        if (x >= dimX || y >= dimY){
            return false;
        }
        return true;
    }

    public Peixe getPosicao (int x, int y){
        if (verificaPosicao(x,y)) {
            return aquario[x][y];
        }
        else {
            return null;
        }
    }

    public void setPosicaoNula(int x, int y){ //quando o peixe morre de inanição
        if (verificaPosicao(x,y)) {
            aquario[x][y]=null;
        }
    }

    public void setPosicao(Peixe peixe, int x, int y) {
        if (verificaPosicao(x, y)) {
            aquario[x][y] = peixe;
        } else {
            throw new IllegalArgumentException("POSIÇÃO FORA DOS LIMITES DO AQUÁRIO");
        }
    }

    public PosicaoAdjacente[] olhaAoRedor(int x, int y){ 
    	//retorna posicoes adjacentes válidas onde não é válido fica nulo
        PosicaoAdjacente[] pa;
        List<PosicaoAdjacente> lPa = new ArrayList<>();

        for (int i = Math.max(0, x - 1); i <= Math.min(dimX - 1, x + 1); i++) {
            for (int j = Math.max(0, y - 1); j <= Math.min(dimY - 1, y + 1); j++) {
                // Verifica se a posição não é a posição atual
                if (i != x || j != y) {
                    PosicaoAdjacente p = new PosicaoAdjacente(i,j);
                    lPa.add(p);
                }
            }
        }

        pa = lPa.toArray(new PosicaoAdjacente[lPa.size()]);
        return pa;
    }

    public Peixe[] pegaPeixesAoRedor(int x, int y){ //retorna posicoes adjacentes vazias e válidas
        PosicaoAdjacente[] posAdjacente = olhaAoRedor(x,y);
        Peixe[] pa = new Peixe[posAdjacente.length];

        for (int i=0; i< posAdjacente.length; i++){
            pa[i] = aquario[posAdjacente[i].x][posAdjacente[i].y];
        }
        return pa;
    }

    public void imprimeAquario(){
        for (int i = 0; i < aquario.length; i++) {
            for (int j = 0; j < aquario[i].length; j++) {
                if (aquario[i][j] == null) {
                    System.out.printf(" [ "+ i + j + "      " +" ] ");
                } else {
                    System.out.printf(" [ "+ i + j  + "  "+aquario[i][j].toString() + " ] ");
                }
            }
            System.out.println(); // Adiciona uma quebra de linha após cada linha da matriz
        }
    }

}
