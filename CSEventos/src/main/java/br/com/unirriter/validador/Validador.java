package br.com.unirriter.validador;

import br.com.unirriter.exception.CSEventosException;
import br.com.unirriter.utils.ResourceBundleUtils;

public abstract class Validador<T> {

	private ResourceBundleUtils resourceBundleUtils;
	
	public Validador() {
		resourceBundleUtils = ResourceBundleUtils.getInstance();
	}
	
	public String getPropriedade(String key) {
		return resourceBundleUtils.getProperty(key);
	}
	
	/**
	 * M�todo de valida��o de cada sub classe validador
	 */
	public abstract void validar(T modelo) throws CSEventosException;
}
