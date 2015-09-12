package br.fatec.persistencia;

import org.hibernate.Session;

import br.fatec.dominio.Empresa;

public class EmpresaDAO {
	private final Session session;

	public EmpresaDAO(Session session) {
		this.session = session;
	}

	public Empresa porId(int id) {
		return (Empresa) session.load(Empresa.class, id);
	}
	public Empresa porNomeEEmail (String nome, String email){
		return (Empresa) session.createQuery("from Empresa e where e.nome =:nome and e.email =:email")
		        .setParameter("nome", nome)
		        .setParameter("email", email)
		        .uniqueResult();
	}
	public void salvar(Empresa empresa){
		session.save(empresa);
	}
	public void atualizar(Empresa empresa){
		session.merge(empresa);
	}
}
