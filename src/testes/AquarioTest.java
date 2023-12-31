package testes;
import static org.junit.Assert.*;

import org.junit.Test;

import logica.Aquario;
import logica.Configuracoes;
import logica.Jogo;
import logica.Peixe;
import logica.PeixeA;
import logica.PeixeB;
import logica.PosicaoAdjacente;

public class AquarioTest {
	
	
	@Test
	public void ct1(){
		Jogo jogo = new Jogo();
		
		int[] valores = {5,3,3,3,5,10,5,10};
		
		jogo.auxIniciarJogo(valores);
		
		assertEquals(5,Configuracoes.getInstance().getDimX());
	}
	
	@Test
	public void ct2(){
		Jogo jogo = new Jogo();
		
		int[] valores = {5,3,3,3,5,10,5,10};
		
		jogo.auxIniciarJogo(valores);
		
		assertEquals(3,Configuracoes.getInstance().getDimY());
	}
	
	@Test
	public void ct3(){
		Jogo jogo = new Jogo();
		
		int[] valores = {5,3,3,3,5,10,5,10};
		
		jogo.auxIniciarJogo(valores);
		
		assertEquals(3,Configuracoes.getInstance().getQtdPeixeA());
	}
	
	@Test
	public void ct4(){
		Jogo jogo = new Jogo();
		
		int[] valores = {5,3,3,3,5,10,5,10};
		
		jogo.auxIniciarJogo(valores);	
		assertEquals(5,Configuracoes.getInstance().getRa());
	}
	
	@Test
	public void ct5(){
		Jogo jogo = new Jogo();
		
		int[] valores = {5,3,3,3,5,10,5,10};
		
		jogo.auxIniciarJogo(valores);		
		assertEquals(10,Configuracoes.getInstance().getMa());
	}
	
	@Test
	public void ct6(){
		Jogo jogo = new Jogo();
		
		int[] valores = {5,3,3,3,5,10,5,10};
		
		jogo.auxIniciarJogo(valores);		
		assertEquals(5,Configuracoes.getInstance().getRb());
	}
	
	@Test
	public void ct7(){
		Jogo jogo = new Jogo();
		
		int[] valores = {5,3,3,3,5,10,5,10};
		
		jogo.auxIniciarJogo(valores);		
		assertEquals(10,Configuracoes.getInstance().getMb());
	}
	
	
	@Test
	public void ct8(){
		Jogo jogo = new Jogo();
		int[] valores = {5,5,10,15,3,5,2,4};		
		
		String str = jogo.auxIniciarJogo(valores);
			
		assertEquals("Ambiente criado com sucesso.", str);
	}
	
	@Test
	public void ct9(){
		Jogo jogo = new Jogo();
		int[] valores = {0,5,3,8,2,3,1,5};		
		
		String str = jogo.auxIniciarJogo(valores);
			
		assertEquals("Tamanhao inv�lido de aqu�rio", str);
	}
	
	@Test
	public void ct10(){
		Jogo jogo = new Jogo();
		int[] valores = {4,4,20,16,2,-1,3,6};		
		
		String str = jogo.auxIniciarJogo(valores);
			
		assertEquals("Quantidade de peixes inv�lida", str);
	}
	
	@Test
	public void ct11(){
		Jogo jogo = new Jogo();
		int[] valores = {4,-3,20,16,2,-1,3,6};		
		
		String str = jogo.auxIniciarJogo(valores);
			
		assertEquals("Tamanhao inv�lido de aqu�rio", str);
	}
	
	@Test
	public void ct12(){
		Jogo jogo = new Jogo();
		int[] valores = {6,6,15,10,4,2,5,-2};		
		
		String str = jogo.auxIniciarJogo(valores);
			
		assertEquals("Condi��es do ambiente inv�lidas.", str);
	}
	
	@Test
	public void ct13(){
		Jogo jogo = new Jogo();
		int[] valores = {3,3,0,0,0,0,0,0};		
		
		String str = jogo.auxIniciarJogo(valores);
			
		assertEquals("Quantidade de peixes inv�lida", str);
	}
	
	@Test
	public void ct14(){
		Jogo jogo = new Jogo();
		int[] valores = {20,20,400,400,10,10,20,20};		
		
		String str = jogo.auxIniciarJogo(valores);
			
		assertEquals("Ambiente criado com sucesso.", str);
	}
	
	@Test
	public void ct15(){
		Jogo jogo = new Jogo();
		int[] valores = {5,0,3,3,5,10,5,10};		
		
		String str = jogo.auxIniciarJogo(valores);
			
		assertEquals("Tamanhao inv�lido de aqu�rio", str);
	}
	
	@Test
	public void ct16(){
		Jogo jogo = new Jogo();
		int[] valores = {5,3,3,0,5,10,5,10};		
		
		String str = jogo.auxIniciarJogo(valores);
			
		assertEquals("Quantidade de peixes inv�lida", str);
	}
	
	@Test
	public void ct17(){
		Jogo jogo = new Jogo();
		int[] valores = {4,4,15,17,2,1,3,6};		
		
		String str = jogo.auxIniciarJogo(valores);
			
		assertEquals("Quantidade de peixes inv�lida", str);
	}
	
	@Test
	public void ct18(){
		Jogo jogo = new Jogo();
		int[] valores = {4,4,15,0,2,1,3,6};		
		
		String str = jogo.auxIniciarJogo(valores);
			
		assertEquals("Quantidade de peixes inv�lida", str);
	}
	
	@Test
	public void ct19(){
		Jogo jogo = new Jogo();
		int[] valores = {4,4,5,5,0,1,3,6};		
		
		String str = jogo.auxIniciarJogo(valores);
			
		assertEquals("Condi��es do ambiente inv�lidas.", str);
	}
	
	@Test
	public void ct20(){
		Jogo jogo = new Jogo();
		int[] valores = {4,4,5,5,3,0,3,6};		
		
		String str = jogo.auxIniciarJogo(valores);
			
		assertEquals("Condi��es do ambiente inv�lidas.", str);
	}
	
	@Test
	public void ct21(){
		Jogo jogo = new Jogo();
		int[] valores = {4,4,5,5,3,3,0,6};		
		
		String str = jogo.auxIniciarJogo(valores);
			
		assertEquals("Condi��es do ambiente inv�lidas.", str);
	}
	
	@Test
	public void ct22(){
		Jogo jogo = new Jogo();
		int[] valores = {4,4,5,5,3,1,3,0};		
		
		String str = jogo.auxIniciarJogo(valores);
			
		assertEquals("Condi��es do ambiente inv�lidas.", str);
	}
	

	@Test
	public void ct23(){
		Aquario aquario = new Aquario(3,3);
		Peixe peixe = new PeixeA(23,1,1);
		
		aquario.addPeixe(peixe);
		
		PosicaoAdjacente[] posAoRedor = aquario.olhaAoRedor(1, 1);
		
		peixe.moverNoAquario(1, 1, aquario, posAoRedor);
			
		assertEquals(23,aquario.getPosicao(0, 0).getId());
	}

	@Test
	public void ct24(){
		Aquario aquario = new Aquario(3,3);
		Peixe peixe = new PeixeA(23,1,1);
		peixe.setMoveuNaRodada(true);
		
		aquario.addPeixe(peixe);
		
		PosicaoAdjacente[] posAoRedor = aquario.olhaAoRedor(1, 1);
		
		peixe.moverNoAquario(1, 1, aquario, posAoRedor);
			
		assertEquals(23,aquario.getPosicao(1, 1).getId());
	}
	
	@Test
	public void ct25(){
		Aquario aquario = new Aquario(3,3);
		Peixe peixe = new PeixeA(23,1,1);
		peixe.setMoveuNaRodada(true);
		
		aquario.addPeixe(peixe);
		
		PosicaoAdjacente[] posAoRedor = new PosicaoAdjacente[0];
		
		peixe.moverNoAquario(1, 1, aquario, posAoRedor);
			
		assertEquals(23,aquario.getPosicao(1, 1).getId());
	}
	
	@Test
	public void ct26(){
		Aquario aquario = new Aquario(3,3);
		Peixe peixe = new PeixeA(23,1,1);
		Peixe peixe2 = new PeixeA(26,0,0);
		
		aquario.addPeixe(peixe);
		aquario.addPeixe(peixe2);
		PosicaoAdjacente[] posAoRedor = aquario.olhaAoRedor(1, 1);
		
		
		peixe.moverNoAquario(1, 1, aquario, posAoRedor);
			
		assertEquals(23,aquario.getPosicao(0, 1).getId());
	}
	
	
	@Test
	public void ct27() {

		Aquario aquario = new Aquario(3,3);
		
		PosicaoAdjacente[] posAoRedor = aquario.olhaAoRedor(1, 1);
		
		String str = "";
		
		for (int i=0; i< posAoRedor.length; i++){
			str = str + posAoRedor[i].x + "," + posAoRedor[i].y + " | ";		
		}
		
		assertEquals("0,0 | 0,1 | 0,2 | 1,0 | 1,2 | 2,0 | 2,1 | 2,2 | ", str);
		
	}
	
	@Test
	public void ct28() {

		Aquario aquario = new Aquario(3,3);
		
		PosicaoAdjacente[] posAoRedor = aquario.olhaAoRedor(0, 0);
		
		String str = "";
		
		for (int i=0; i< posAoRedor.length; i++){
			str = str + posAoRedor[i].x + "," + posAoRedor[i].y + " | ";		
		}
		
		assertEquals("0,1 | 1,0 | 1,1 | ", str);
		
	}
	
	@Test
	public void ct29() {

		Aquario aquario = new Aquario(3,4);
		
		PosicaoAdjacente[] posAoRedor = aquario.olhaAoRedor(1, 2);
		
		String str = "";
		
		for (int i=0; i< posAoRedor.length; i++){
			str = str + posAoRedor[i].x + "," + posAoRedor[i].y + " | ";		
		}
		
		assertEquals("0,1 | 0,2 | 0,3 | 1,1 | 1,3 | 2,1 | 2,2 | 2,3 | ", str);
		
	}
	
	@Test
	public void ct30() {

		Aquario aquario = new Aquario(3,4);
		
		PosicaoAdjacente[] posAoRedor = aquario.olhaAoRedor(2, 2);
		
		String str = "";
		
		for (int i=0; i< posAoRedor.length; i++){
			str = str + posAoRedor[i].x + "," + posAoRedor[i].y + " | ";		
		}
		
		assertEquals("1,1 | 1,2 | 1,3 | 2,1 | 2,3 | ", str);
		
	}
	
	@Test
	public void ct31() {

		Aquario aquario = new Aquario(0,0);
		
		PosicaoAdjacente[] posAoRedor = aquario.olhaAoRedor(0, 0);
		
		String str = "";
		
		for (int i=0; i< posAoRedor.length; i++){
			str = str + posAoRedor[i].x + "," + posAoRedor[i].y + " | ";		
		}
		
		assertEquals("", str);
		
	}
	
	@Test
	public void ct32() {
		Aquario aquario = new Aquario(3,3);
		PosicaoAdjacente[] posAoRedor = aquario.olhaAoRedor(1, 1);
		Peixe peixe1 = new PeixeB(24,1,1);
		aquario.addPeixe(peixe1);
		peixe1.reproduzir(aquario, posAoRedor);
		assertEquals(0,aquario.getPosicao(0, 0).getId());
	}
	
	@Test
	public void ct33() {
		Aquario aquario = new Aquario(3,3);
		PosicaoAdjacente[] posAoRedor = aquario.olhaAoRedor(1, 1);
		Peixe peixe1 = new PeixeB(24,1,1);
		Peixe peixe2 = new PeixeA(25,0,0);
		aquario.addPeixe(peixe1);
		aquario.addPeixe(peixe2);
		peixe1.reproduzir(aquario, posAoRedor);
		assertEquals(0,aquario.getPosicao(0, 1).getId());
	}
	
	@Test
	public void ct34() {
		Aquario aquario = new Aquario(3,3);
		PosicaoAdjacente[] posAoRedor = aquario.olhaAoRedor(1, 1);
		Peixe peixe1 = new PeixeB(24,0,0);
		Peixe peixe2 = new PeixeB(25,0,1);
		aquario.addPeixe(peixe1);
		aquario.addPeixe(peixe2);
		peixe1.reproduzir(aquario, posAoRedor);
		int cont = 0;
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(aquario.getPosicao(i, j) != null)
					cont++;
			}
		}
		assertEquals(2,cont);
	}
	
}
