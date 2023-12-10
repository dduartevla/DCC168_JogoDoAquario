package testes;
import static org.junit.Assert.*;

import org.junit.Test;

import logica.Aquario;
import logica.Configuracoes;
import logica.Jogo;
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
			
		assertEquals("Tamanhao inválido de aquário", str);
	}
	
	@Test
	public void ct10(){
		Jogo jogo = new Jogo();
		int[] valores = {4,4,20,16,2,-1,3,6};		
		
		String str = jogo.auxIniciarJogo(valores);
			
		assertEquals("Quantidade de peixes inválida", str);
	}
	
	@Test
	public void ct11(){
		Jogo jogo = new Jogo();
		int[] valores = {4,4,20,16,2,-1,3,6};		
		
		String str = jogo.auxIniciarJogo(valores);
			
		assertEquals("Quantidade de peixes inválida", str);
	}
	
	@Test
	public void ct12(){
		Jogo jogo = new Jogo();
		int[] valores = {6,6,15,10,4,2,5,-2};		
		
		String str = jogo.auxIniciarJogo(valores);
			
		assertEquals("Condições do ambiente inválidas.", str);
	}
	
	@Test
	public void ct13(){
		Jogo jogo = new Jogo();
		int[] valores = {3,3,0,0,0,0,0,0};		
		
		String str = jogo.auxIniciarJogo(valores);
			
		assertEquals("Quantidade de peixes inválida", str);
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
			
		assertEquals("Tamanhao inválido de aquário", str);
	}
	
	/*
	@Test
	public void deveRetornarPosicoesAoRedor() {

		Aquario aquario = new Aquario(3,3);
		
		PosicaoAdjacente[] posAoRedor = aquario.olhaAoRedor(1, 1);
		
		String str = "";
		
		for (int i=0; i< posAoRedor.length; i++){
			str = str + posAoRedor[i].x + "," + posAoRedor[i].y + " | ";		
		}
		
		assertEquals("0,0 | 0,1 | 0,2 | 1,0 | 1,2 | 2,0 | 2,1 | 2,2 | ", str);
		
	}
	*/
	
	/*
	
	*/

}
