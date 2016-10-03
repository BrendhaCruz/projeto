package les.projeto.quebra_galho.model;

/**
 * Created by GermanoPRodriguesGua on 28/08/2016.
 */
public class Usuario {
    public String nome;
    public String email;
    String senha;
    //public String avaliacao;

    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email =email;
        this.senha = senha;
      //  this.avaliacao = avaliacao;
    }

    public Usuario() {

    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
