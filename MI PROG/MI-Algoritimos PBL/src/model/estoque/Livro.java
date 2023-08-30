package model.estoque;

public class Livro {
    private Integer isbn;
    private String autor;
    private String categoria;
    private String enderecoLivro;
    private String editora;
    private Integer anoDePublicacao;
    private String nome;


    public Livro (Integer isbn, String autor, String categoria,String enderecoLivro, String editora, Integer anoDePublicacao, String nome) {
        this.isbn = isbn;
        this.autor = autor;
        this.categoria = categoria;
        this.enderecoLivro = enderecoLivro;
        this.editora = editora;
        this.anoDePublicacao = anoDePublicacao;
        this.nome = nome;
    }

    public Integer getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEditora() {
        return editora;
    }

    public String getEnderecoLivro() {
        return enderecoLivro;
    }

    public String getNome() {
        return nome;
    }

    public void setAnoDePublicacao(Integer anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setEnderecoLivro(String enderecoLivro) {
        this.enderecoLivro = enderecoLivro;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
