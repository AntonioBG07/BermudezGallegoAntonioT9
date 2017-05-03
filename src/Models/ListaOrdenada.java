package Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import Exceptions.ElementNotAllowedException;
import Exceptions.ListSizeOverflownException;

public class ListaOrdenada<T> extends ArrayList<T>{

	private final byte MAX_SIZE = 100;
	
	public ListaOrdenada(Comparator<T> comp){
		super();
	}
	
	
	/**
	 * Comprueba que el valor a introducir no es null y que la lista no está llena, en caso de que cumpla los dos requisitos lo inserta.
	 */
	@Override
	public boolean add(T obj){
		
		if(obj != null){
			if(this.size() <= MAX_SIZE){
				return super.add(obj);
			}
			else{
				throw new ListSizeOverflownException();
			}
		}
		else{
			throw new ElementNotAllowedException();
		}
		
	}

	/**
	 * Comprueba que el rango de valores a introducir no contiene null y que cabe ne la lista, en caso de que cumpla los dos requisitos lo inserta.
	 */
	@Override
	public boolean addAll(Collection<? extends T> coll) {
		
		if(!coll.contains(null)){
			if(coll.size()+this.size() <= MAX_SIZE) {
				return super.addAll(coll);
			}
			else{
				throw new ListSizeOverflownException(); 
			}
			}
			else{
				throw new ElementNotAllowedException();
			}
		}
}

	