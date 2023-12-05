package model.estoque;


import LibraryExceptions.estoqueExceptions.LivroException;
import dao.MasterDao;

import java.io.Serializable;

import static util.Constantes.createLivro;
import static util.Constantes.deleteLivro;

/**<p>Classe model para o estoque</p>*/
public class Estoque implements Serializable {

    /**<p>Construtor do Estoque</p>*/
    public Estoque() {

    }

    /**
     * <p>Metodo responsavel por <b>adicionar</b> um novo livro</p>
     * @param livro <b>Livro</b>
     * @return <b>Livro</b> - <i>Livro adicionado</i>
     * @throws LivroException <i>Caso ocorra algum problema durante a criação de um novo livro</i>
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
     * <p>Metodo responsavel por <b>remover</b> um livro</p>
     * @param livro <b>Livro</b>
     * @throws LivroException <i>Caso ocorra algum probelma durante o deletar de um livro</i>
     */
    public void RemoveLivro(Livro livro) throws LivroException {
        try {
            MasterDao.getLivroDao().delete(livro);
        } catch (Exception lde) {
            throw new LivroException(deleteLivro, null);
        }

    }

    /**<p>Metodo responsavel por retornar a <b>quantidade total de livros</b> no estoque</p>
     * @return <b>Integer</b> numero de livros no estoque*/
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
