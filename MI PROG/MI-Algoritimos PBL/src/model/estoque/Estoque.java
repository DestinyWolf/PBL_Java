package model.estoque;

import dao.MasterDao;

/**Classe model para o estoque*/
public class Estoque {

    /**Construtor do Estoque*/
    public Estoque() {

    }

    /**metodo de adição de um livro novo ao estoque
     * @param livro */
    public Livro novoLivro(Livro livro){
        MasterDao.getLivroDao().save(livro);
        return livro;
    }

    /**Metodo responsavel por remover um livro do estoque
     * @param livro */
    public void RemoveLivro(Livro livro){
        MasterDao.getLivroDao().deleteById(livro.getIsbn());
    }

    /**Metodo responsavel por retornar a quantidade total de livros no estoque
     * @return numero de livros no estoque*/
    public Integer getTotalLivros() {
        return MasterDao.getLivroDao().findAll().size();
    }


}
