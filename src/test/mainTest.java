package test;

import org.junit.Test;

import Exceptions.ElementNotAllowedException;
import Exceptions.ListSizeOverflownException;
import Models.ListaOrdenada;

public class mainTest {
	
	private ListaOrdenada<Integer> l = new ListaOrdenada<Integer>((Integer a, Integer b) -> b-a);

	/**
	 * Comprueba que inserta bien el elemento.
	 */
	@Test
	public void AddSuccess(){
		assert(l.add(5));
		assert(l.contains(5));
	}

	/**
	 * Comprueba que no deja pasar null y que no sobrepasa el límite establecido.
	 */
	@Test
	public void AddFail(){
		for(int i = 0; i < 100; i++){
			l.add(i);
		}
		try{
			l.add(100);
		}catch(ListSizeOverflownException e){
			assert(l.size() == 100);
			assert(!l.contains(100));
		}
		
		try{
			l.add(null);
		}catch(ElementNotAllowedException ex){
			assert(!l.contains(null));
		}
		
	}
	
}
