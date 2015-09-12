package br.fatec.integracao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.fatec.dominio.Empresa;
import br.fatec.dominio.Responsavel;
import br.fatec.persistencia.HibernateEmpresaDAO;
import br.fatec.persistencia.HibernateResponsavelDAO;

public class UC03ExcluirEmpresa {

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
		empresaDAO.cadastra(empresa);
		responsavelDAO = new HibernateResponsavelDAO();
		responsavel = new Responsavel();
		responsavel.setCnpj("89424232000180");
		responsavel.setResponsavel("jose da silva");
		responsavel.setEmail("jose@email.com");
		responsavel.setTelefoneResponsavel("222222"); 
		responsavel.setSetor("contabilidade");
		responsavelDAO.cadastra(responsavel);
	}
	@Test
	public void CT01UC03ExcluirEmpresa_com_sucesso() {
		responsavelDAO.exclui("89424232000180");
		assertEquals (1,empresaDAO.exclui("89424232000180"));
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
//		responsavelDAO.exclui("89424232000180");
//		empresaDAO.exclui("89424232000180");
	}

	

}
