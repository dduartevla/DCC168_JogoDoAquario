package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import logica.Configuracoes;
import logica.Jogo;


public class ClasseEquivalenciaInvalidaTeste {
	
	@Test
	void ct1ErroDimensaoXNegativa(){
		Jogo jogo = new Jogo();
		
		jogo.setDimX();
		assertNotEquals(-1,Configuracoes.getInstance().getDimX());
	}
	

}
