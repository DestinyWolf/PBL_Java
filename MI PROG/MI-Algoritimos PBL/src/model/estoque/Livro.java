package model.estoque;

import LibraryExceptions.emprestimoexception.EmprestimoException;
import LibraryExceptions.estoqueExceptions.LivroException;
import dao.MasterDao;
import model.usuarios.Bibliotecario;

import java.io.Serializable;

/** <p>Classe model para livro</p>*/
public class Livro implements Serializable {
    private String isbn;
    private String autor;
    private String categoria;
    private String enderecoLivro;
    private String editora;
    private Integer anoDePublicacao;
    private String nome;
    private Integer quantidade;
    private Integer qntDeBuscas;

    /**
     * <p>Construtor da classe Livro</p>
     * @param isbn <b>String</b>
     * @param autor <b>String</b>
     * @param categoria <b>String</b>
     * @param enderecoLivro <b>String</b>
     * @param editora <b>String</b>
     * @param anoDePublicacao <b>Integer</b>
     * @param nome <b>String</b>
     */
    public Livro (String isbn, String autor, String categoria,String enderecoLivro, String editora, Integer anoDePublicacao, String nome) {
        this.isbn = isbn;
        this.autor = autor;
        this.categoria = categoria;
        this.enderecoLivro = enderecoLivro;
        this.editora = editora;
        this.anoDePublicacao = anoDePublicacao;
        this.nome = nome;
        this.quantidade = 1;
        this.qntDeBuscas = 0;
    }

    /**<p>Metodo responsavel por retornar o <b>ano de publicação</b> do livro</p>
     * @return <b>Integer</b> - <i>ano de publicação do livro</i> */
    public Integer getAnoDePublicacao() {
        return anoDePublicacao;
    }

    /**<p>Metodo responsavel por retornar o <b>codigo isbn</b> do livro</p>
     * @return <b>String</b> - <i>isbn do livro</i>*/
    public String getIsbn() {
        return isbn;
    }

    /**<p>Metodo responsavel por retornar o <b>autor</b> do livro</p>
     * @return  <b>String</b> - <i>autor do livro</i>*/
    public String getAutor() {
        return autor;
    }

    /**<p>Metodo responsavel por retornar a <b>categoria</b> do livro</p>
     * @return  <b>String</b> - <i>categoria do livro</i>*/
    public String getCategoria() {
        return categoria;
    }

    /**<p>Metodo responsavel por retornar a <b>editora</b> do livro</p>
     * @return <b>String</b> - <i>editora do livro</i>*/
    public String getEditora() {
        return editora;
    }

    /**<p>Metodo responsavel por retornar a <b>localização</b> do livro</p>
     * @return <b>String</b> - <i>localização do livro</i>*/
    public String getEnderecoLivro() {
        return enderecoLivro;
    }

    /**<p>Metodo responsavel por retornar o <b>nome</b> do livro</p>
     * @return <b>String</b> - <i>nome do livro</i>*/
    public String getNome() {
        return nome;
    }

    /**
     * <p>Metodo responsavel por retornar a <b>quantidade</b> de determinado livro</p>
     * @return <b>Integer</b> - <i>quantidade de livros</i>
     */
    public Integer getQuantidade() {
        return quantidade;
    }

    /**
     * <p>Metodo responsavel por retonar a <b>quantidade</b> de buscas de um livro</p>
     * @return <b>Integer</b> - <i>quantidade de buscas</i>
     */
    public Integer getQntDeBuscas() {
        return qntDeBuscas;
    }

    /**<p>Metodo responsavel por settar o <b>ano de publicação</b> do livro</p>
     *@param anoDePublicacao <b>Integer</b> */
    public void setAnoDePublicacao(Integer anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    /**<p>Metodo responsavel por settar o <b>autor</b> do livro</p>
     *@param autor <b>String</b> */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**<p>Metodo responsavel por settar a <b>categoria</b> do livro</p>
     *@param categoria  <b>String</b>*/
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**<p>Metodo responsavel por settar a <b>editora</b> do livro</p>
     *@param editora  <b>String</b>*/
    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**<p>Metodo responsavel por settar a <b>localização</b> do livro</p>
     *@param enderecoLivro  <b>String</b>*/
    public void setEnderecoLivro(String enderecoLivro) {
        this.enderecoLivro = enderecoLivro;
    }

    /**<p>Metodo responsavel por settar o <b>codigo isbn</b> do livro</p>
     *@param isbn  <b>String</b>*/
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**<p>Metodo responsavel por settar o <b>nome</b> do livro</p>
     *@param nome  <b>String</b>*/
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * <p>Metodo responsavel por settar a <b>quantidade</b> de livros</p>
     * @param quantidade <b>Integer</b>
     */
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * <p>Metodo responsavel por settar a <b>quantidade</b> de buscas</p>
     * @param qntDeBuscas <b>Integer</b>
     */
    public void setQntDeBuscas(Integer qntDeBuscas) {
        this.qntDeBuscas = qntDeBuscas;
    }

    /**
     * <p>Metodo responsavel por retornar a <b>quantidade</b> de emprestimos</p>
     * @return <b>Integer</b> - <i>quantidade de emprestimo</i>
     */
    public Integer getQntDeEmprestimos() {
        try {
            return MasterDao.getEmprestimoDao().findByLivro(this.isbn).size();
        } catch (EmprestimoException ee) {
            return  -1;
        }

    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Livro) {
            return ((this.getIsbn() == ((Livro) obj).getIsbn()) && this.getNome() == ((Livro) obj).getNome());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Livro{" +
                "isbn=" + isbn +
                ", autor='" + autor + '\'' +
                ", categoria='" + categoria + '\'' +
                ", enderecoLivro='" + enderecoLivro + '\'' +
                ", editora='" + editora + '\'' +
                ", anoDePublicacao=" + anoDePublicacao.toString() +
                ", nome='" + nome + '\'' +
                ", quantidade=" + quantidade.toString() +
                ", qntDeBuscas=" + qntDeBuscas.toString() +
                '}';
    }
}
