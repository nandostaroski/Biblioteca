package modelo;

import java.io.Serializable;

public class Aluno implements Serializable {

    private long codAluno;
    private String cpf;
    private String nome;

    public Aluno(String cpf, String nome) {
        super();
        codAluno = System.currentTimeMillis();
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(long codAluno) {
        this.codAluno = codAluno;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) obj;
        return codAluno == other.codAluno;
    }

    @Override
    public String toString() {
        return "Aluno{" + "cpf=" + cpf + ", nome=" + nome + '}';
    }
}
