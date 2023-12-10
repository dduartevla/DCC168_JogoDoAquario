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
		
		jogo.setDimX();
		
		assertEquals(5,Configuracoes.getInstance().getDimX());
	}
	
	@Test
	public void ct2(){
		Jogo jogo = new Jogo();
		
		jogo.setDimY();
		
		assertEquals(3,Configuracoes.getInstance().getDimY());
	}
	
	@Test
	public void ct3(){
		Jogo jogo = new Jogo();
		
		jogo.setQtdPeixeA();
		
		assertEquals(3,Configuracoes.getInstance().getQtdPeixeA());
	}
	
	@Test
	public void ct4(){
		Jogo jogo = new Jogo();
		
		jogo.setRa();		
		assertEquals(5,Configuracoes.getInstance().getRa());
	}
	
	@Test
	public void ct5(){
		Jogo jogo = new Jogo();
		
		jogo.setMa();		
		assertEquals(10,Configuracoes.getInstance().getMa());
	}
	
	@Test
	public void ct6(){
		Jogo jogo = new Jogo();
		
		jogo.setRb();		
		assertEquals(5,Configuracoes.getInstance().getRb());
	}
	
	@Test
	public void ct7(){
		Jogo jogo = new Jogo();
		
		jogo.setMb();		
		assertEquals(10,Configuracoes.getInstance().getMb());
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
	@Test
	public void ct8(){
		Jogo jogo = new Jogo();
		int dimX, dimY, qtdA,  qtdB,  ra,  ma,  rb, mb;
		dimX = 5;
		dimY = 5;
		qtdA = 10;
		qtdB = 15;
		ra = 3;
		ma = 5;
		rb = 2;
		mb = 4;
		
		
		jogo.iniciarJogoT(dimX, dimY, qtdA,  qtdB,  ra,  ma,  rb, mb);
		
		int[] nums = {dimX, dimY, qtdA,  qtdB,  ra,  ma,  rb, mb};
		int[] comp = {Configuracoes.getInstance().getDimX(),
				Configuracoes.getInstance().getDimY(),
				Configuracoes.getInstance().getQtdPeixeA(),
				Configuracoes.getInstance().getQtdPeixeB(),
				Configuracoes.getInstance().getRa(),
				Configuracoes.getInstance().getMa(),
				Configuracoes.getInstance().getRb(),
				Configuracoes.getInstance().getMb()};
		
		assertArrayEquals(nums, comp);
	}
	*/

}
