package model.estoque;


import LibraryExceptions.estoqueExceptions.LivroException;
import dao.MasterDao;

import static util.Constantes.createLivro;
import static util.Constantes.deleteLivro;

/**Classe model para o estoque*/
public class Estoque { 

    /**Construtor do Estoque*/
    public Estoque() {

    }

    /**
     * metodo de adição de um livro novo ao estoque
     * @param livro
     * @return
     * @throws LivroException
     */
    public Livro novoLivro(Livro livro) throws LivroException {
        try {
            MasterDao.getLivroDao().save(livro);
            return livro;
        } catch (Exception e) {
            throw new LivroException(createLivro, null);
        }
    }

    /**
     * Metodo responsavel por remover um livro do estoque
     * @param livro
     * @throws LivroException
     */
    public void RemoveLivro(Livro livro) throws LivroException {
        try {
            MasterDao.getLivroDao().delete(livro);
        } catch (Exception lde) {
            throw new LivroException(deleteLivro, null);
        }

    }

    /**Metodo responsavel por retornar a quantidade total de livros no estoque
     * @return numero de livros no estoque*/
    public Integer getTotalLivros() {
        return MasterDao.getLivroDao().findAll().size();
    }

    @Override
    public boolean equals(Object obj){
        if (obj != null && obj instanceof Estoque) {
            return true;
        } else {
            return false;
        }
    }


}
