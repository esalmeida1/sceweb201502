package br.fatec.persistencia;


import br.fatec.dominio.Responsavel;

public interface IResponsavelDAO {
	public String cadastra(Responsavel r);
	public Responsavel consulta(Responsavel r);
	public int exclui(String cnpj);
}
