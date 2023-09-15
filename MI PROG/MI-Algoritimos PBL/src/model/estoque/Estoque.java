package model.estoque;


import LibraryExceptions.estoqueExceptions.LivroCreateException;

import LibraryExceptions.estoqueExceptions.LivroDeleteException;
import dao.MasterDao;

/**Classe model para o estoque*/
public class Estoque { 

    /**Construtor do Estoque*/
    public Estoque() {

    }

    /**metodo de adição de um livro novo ao estoque
     * @param livro */
    public Livro novoLivro(Livro livro) throws LivroCreateException{
        try {
            MasterDao.getLivroDao().save(livro);
            return livro;
        } catch (Exception lce) {
            throw new LivroCreateException();
        }
    }

    /**Metodo responsavel por remover um livro do estoque
     * @param livro */
    public void RemoveLivro(Livro livro) throws LivroDeleteException {
        try {
            MasterDao.getLivroDao().deleteById(livro.getIsbn());
        } catch (Exception lde) {
            throw new LivroDeleteException();
        }

    }

    /**Metodo responsavel por retornar a quantidade total de livros no estoque
     * @return numero de livros no estoque*/
    public Integer getTotalLivros() {
        return MasterDao.getLivroDao().findAll().size();
    }


}
