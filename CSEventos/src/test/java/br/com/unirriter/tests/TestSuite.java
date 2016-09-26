package br.com.unirriter.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.unirriter.enums.TipoIngressoTest;
import br.com.unirriter.service.EventoServiceTest;
import br.com.unirriter.utils.DateUtilsTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 	TipoIngressoTest.class, 
						EventoServiceTest.class, 
						DateUtilsTest.class 
					})
public class TestSuite {

}
