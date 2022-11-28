package br.edu.infnet.usuario.model;

public class Usuario {

    private String nome;
    private String sobrenome;
    private Integer idade;
    private String nascimento;

    public Usuario(String nome, String sobrenome, Integer idade, String nascimento) { 
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.nascimento = nascimento;
	}

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }    

	public String getSobrenome() {
		return sobrenome;
	}

	public String getNascimento() {
		return nascimento;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", sobrenome=" + sobrenome + ", idade=" + idade + ", nascimento=" + nascimento	+ "]";
	}
}
