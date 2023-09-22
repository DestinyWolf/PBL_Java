package model.estoque;

import LibraryExceptions.emprestimoexception.EmprestimoException;
import LibraryExceptions.estoqueExceptions.LivroException;
import dao.MasterDao;
import model.usuarios.Bibliotecario;

/**Classe model para livro*/
public class Livro {
    private Integer isbn;
    private String autor;
    private String categoria;
    private String enderecoLivro;
    private String editora;
    private Integer anoDePublicacao;
    private String nome;
    private Integer quantidade;
    private Integer qntDeBuscas;

    /**Construtor da classe Livro
     * @param isbn
     * @param autor
     * @param categoria
     * @param enderecoLivro
     * @param editora
     * @param anoDePublicacao
     * @param nome*/
    public Livro (Integer isbn, String autor, String categoria,String enderecoLivro, String editora, Integer anoDePublicacao, String nome) {
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

    /**Metodo responsavel por retornar o ano de publicação do livro
     * @return  ano de publicação do livro*/
    public Integer getAnoDePublicacao() {
        return anoDePublicacao;
    }

    /**Metodo responsavel por retornar o codigo isbn do livro
     * @return  isbn do livro*/
    public Integer getIsbn() {
        return isbn;
    }

    /**Metodo responsavel por retornar o autor do livro
     * @return  autor do livro*/
    public String getAutor() {
        return autor;
    }

    /**Metodo responsavel por retornar a categoria do livro
     * @return  categoria do livro*/
    public String getCategoria() {
        return categoria;
    }

    /**Metodo responsavel por retornar a editora do livro
     * @return  editora do livro*/
    public String getEditora() {
        return editora;
    }

    /**Metodo responsavel por retornar a localização do livro
     * @return  localização do livro*/
    public String getEnderecoLivro() {
        return enderecoLivro;
    }

    /**Metodo responsavel por retornar o nome do livro
     * @return  nome do livro*/
    public String getNome() {
        return nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Integer getQntDeBuscas() {
        return qntDeBuscas;
    }

    /**Metodo responsavel por settar o ano de publicação do livro
     *@param anoDePublicacao  */
    public void setAnoDePublicacao(Integer anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    /**Metodo responsavel por settar o autor do livro
     *@param autor  */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**Metodo responsavel por settar a categoria do livro
     *@param categoria  */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**Metodo responsavel por settar a editora do livro
     *@param editora  */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**Metodo responsavel por settar a localização do livro
     *@param enderecoLivro  */
    public void setEnderecoLivro(String enderecoLivro) {
        this.enderecoLivro = enderecoLivro;
    }

    /**Metodo responsavel por settar o codigo isbn do livro
     *@param isbn  */
    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    /**Metodo responsavel por settar o nome do livro
     *@param nome  */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setQntDeBuscas(Integer qntDeBuscas) {
        this.qntDeBuscas = qntDeBuscas;
    }

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
            return ((this.getIsbn() == ((Livro) obj).getIsbn()) || this.getNome() == ((Livro) obj).getNome());
        } else {
            return false;
        }
    }
}
