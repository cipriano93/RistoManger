package testingUtente;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.UtenteBean;
import model.UtenteBeanDAO;

public class TestUBDdoDelete {
	private UtenteBeanDAO ubd = new UtenteBeanDAO();
	private UtenteBean ub = new UtenteBean();
	
	
	@Before
	public void setUp() {
		ub.setUsername("gestore85");
		ub.setPassword("gestore85");
		ub.setNome("Paolo");
		ub.setCognome("Flora");
		ub.setTipo("gestore");
		ubd.doSave(ub);
	}
	
	
	@Test
	public void doDeleteTest() {
		assertEquals(true, ubd.doDelete("gestore85"));
	}
}
