package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJDBC {

	@Test
	public void initBanco() {

		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();

		userposjava.setNome("Camilo");
		userposjava.setEmail("camilo@gmail.com");

		userPosDAO.salvar(userposjava);
	}

	@Test
	public void initListar() {

		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();

			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println(
						"------------------------------------------------------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initBuscar() {

		UserPosDAO dao = new UserPosDAO();

		try {
			Userposjava userposjava = dao.buscar(4L);
			System.out.println(userposjava);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void initAtualizar() {
		UserPosDAO dao = new UserPosDAO();
		
		try {
			Userposjava objetoBanco = dao.buscar(4L);
			
			objetoBanco.setNome("Alexandre");
			
			dao.atualizar(objetoBanco);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initDeletar() {
		try {
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(9L);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initInsertTelefone() {
		
		Telefone telefone = new Telefone();
		telefone.setNumero("(14) 997548756");
		telefone.setTipo("Celular");
		telefone.setUsuario(14L);
		
		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);
		
	}
	
	@Test
	public void testeCarregaFonesUser() {
		
		UserPosDAO dao = new UserPosDAO();
		List<BeanUserFone> beanUserFones = dao.listaUserFone(10L);
		
		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("---------------------------------------------------------");
		}
		
	}
	
	@Test
	public void testeDeleteUserFone() {
		
		UserPosDAO dao = new UserPosDAO();
		dao.deleteFonesPorUser(11L);
		
	}

}
