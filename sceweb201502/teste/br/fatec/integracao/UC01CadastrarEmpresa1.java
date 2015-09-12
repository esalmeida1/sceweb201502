package br.fatec.integracao;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.fatec.dominio.Empresa;
import br.fatec.dominio.Responsavel;
import br.fatec.persistencia.EmpresaDAO;
import br.fatec.persistencia.HibernateEmpresaDAO;
import br.fatec.persistencia.HibernateResponsavelDAO;

public class UC01CadastrarEmpresa1 {
	public static HibernateEmpresaDAO empresaDAO;
	public static Empresa empresa;
	public static Responsavel responsavel;
	public static HibernateResponsavelDAO responsavelDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		empresaDAO = new HibernateEmpresaDAO();
		empresa = new Empresa();
		//89.424.232/0001-80
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
		responsavelDAO = new HibernateResponsavelDAO();
		responsavel = new Responsavel();
		responsavel.setCnpj("89424232000180");
		responsavel.setResponsavel("jose da silva");
		responsavel.setEmail("jose@email.com");
		responsavel.setTelefoneResponsavel("222222"); 
		responsavel.setSetor("contabilidade");
	}

	@Test
	public void CT01UC01CadastrarEmpresa_com_sucesso() {
		try{
			assertEquals("Cadastro realizado com sucesso",empresaDAO.cadastra(empresa));
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		empresaDAO.exclui("89424232000180");
	}
	@Test
	public void CT02UC01CadastraResponsavel_com_sucesso() {
		try{
			empresaDAO.cadastra(empresa);
			assertEquals("Cadastro realizado com sucesso",responsavelDAO.cadastra(responsavel));
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		responsavelDAO.exclui("89424232000180");
		empresaDAO.exclui("89424232000180");
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {

//		responsavelDAO.exclui("89424232000180");
//		empresaDAO.exclui("89424232000180");
	}

}
