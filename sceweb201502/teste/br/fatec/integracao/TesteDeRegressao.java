package br.fatec.integracao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UC01CadastrarEmpresa1.class, UC02ConsultarEmpresa.class, UC03ExcluirEmpresa.class })
public class TesteDeRegressao {

}
