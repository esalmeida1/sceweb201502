package br.fatec.persistencia;

import java.util.List;

import org.hibernate.HibernateException;

import br.fatec.dominio.Empresa;



public interface IEmpresaDAO {
	
	public List<Empresa> findAll() ;
	public void merge(Empresa empresa);
	public void remove(Empresa empresa);
	public String cadastra(Empresa e) throws HibernateException;
	public int exclui(String cnpj);
	public Empresa consulta(Empresa e);
	public List<Empresa> consulta(String cnpj);
	
}
