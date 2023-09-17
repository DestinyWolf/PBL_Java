package dao.estoque;

import LibraryExceptions.emprestimoexception.EmprestimoException;
import LibraryExceptions.estoqueExceptions.*;
import dao.MasterDao;
import model.estoque.Livro;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import static util.Constantes.*;

/**Classe que implementa a interface LivroDao*/
public class ImMemoryLivroDao implements LivroDao{
    private HashMap<Integer, LinkedList<Livro>> livros;

    public ImMemoryLivroDao() {
        this.livros = new HashMap<>();
    }


    @Override
    public Livro findById(Integer id) throws LivroException {
        if(this.livros.get(id) != null) {
            return livros.get(id).getFirst();
        } else if (livros.isEmpty()) {
            throw new LivroException(findWhenNotHaveObj, null);
        } else {
            throw new LivroException(findLivro, null);
        }
    }

    @Override
    public void save(Livro obj) throws LivroException {
            Livro livro = new Livro(obj.getIsbn(), obj.getAutor(), obj.getCategoria(), obj.getEnderecoLivro(), obj.getEditora(), obj.getAnoDePublicacao(), obj.getNome());
            if(this.livros.get(livro.getIsbn()) != null) {
                 LinkedList<Livro> livrosList = this.livros.get(livro.getIsbn());
                 livrosList.add(livro);
                 this.livros.put(livro.getIsbn(), livrosList);
            }
            else {
                LinkedList<Livro> livrosList = new LinkedList<>();
                livrosList.add(livro);
                this.livros.put(livro.getIsbn(), livrosList);
            }

    }

    @Override
    public void deleteById(Integer id) throws LivroException {
        try {
            if (livros.get(id) != null && MasterDao.getEmprestimoDao().findByLivro(id).isEmpty()) {
                this.livros.remove(id);
            } else if (!MasterDao.getEmprestimoDao().findByLivro(id).isEmpty()) {
                throw new LivroException(deleteLivroWithEmprestimo, livros.get(id).getFirst());
            } else {
                throw new LivroException(deleteLivro, null);
            }
        } catch (EmprestimoException ee){
            throw new LivroException(deleteLivro, null);
        }
    }

    @Override
    public void Update(Livro livro, Livro old) throws LivroException{
        if (livros.get(old.getIsbn()) != null && !livros.get(old.getIsbn()).isEmpty()) {
            if (Objects.equals(livro.getIsbn(), old.getIsbn())) {
                LinkedList<Livro> livrosList = this.livros.get(livro.getIsbn());
                livrosList.remove(old);
                livrosList.add(livro);
                this.livros.put(livro.getIsbn(), livrosList);
            } else {
                LinkedList<Livro> livrosList = this.livros.get(old.getIsbn());
                livrosList.remove(old);
                this.livros.put(old.getIsbn(), livrosList);
                livrosList = this.livros.get(livro.getIsbn());
                livrosList.add(livro);
                this.livros.put(livro.getIsbn(), livrosList);
            }
        } else if (livros.get(old.getIsbn()).isEmpty()) {
            throw new LivroException(updateWhenNotHaveObj, null);
        } else {
            throw new LivroException(updateLivro, null);
        }

    }

    @Override
    public LinkedList<Livro> findAll() {
        LinkedList<Livro> livros = new LinkedList<>();

        for (LinkedList<Livro> livro:
             this.livros.values()) {
            livros.addAll(livro);
        }
        return livros;
    }

    @Override
    public LinkedList<Livro> findByAutor(String autor) throws LivroException {
        LinkedList<Livro> livrosList = new LinkedList<>();
        for (LinkedList<Livro> livros:
                this.livros.values()) {
            for (Livro livro:
                 livros) {
                if (Objects.equals(livro.getAutor(), autor)) {
                    livrosList.add(livro);
                }
            }
        }
        if(livrosList.isEmpty()){
            throw new LivroException(autorNotExist, null);
        }
        else {
            return livrosList;
        }
    }

    @Override
    public LinkedList<Livro> findByCategoria(String categoria) throws LivroException{
        LinkedList<Livro> livrosList = new LinkedList<>();
        for (LinkedList<Livro> livros:
                this.livros.values()) {
            for (Livro livro:
                    livros) {
                if (Objects.equals(categoria, livro.getCategoria())) {
                    livrosList.add(livro);
                }
            }
        }
        if(livrosList.isEmpty()){
            throw new LivroException(categoriaNotExist, null);
        }
        else {
            return livrosList;
        }
    }

    @Override
    public LinkedList<Livro> findByNome(String nome)  throws LivroException {
        LinkedList<Livro> livrosList = new LinkedList<>();
        for (LinkedList<Livro> livros:
                this.livros.values()) {
            for (Livro livro:
                    livros) {
                if (Objects.equals(nome, livro.getNome())) {
                    livrosList.add(livro);
                }
            }
        }
        if(livrosList.isEmpty()){
            throw new LivroException(nomeNotExist, null);
        }
        else {
            return livrosList;
        }
    }

    @Override
    public LinkedList<Livro> findByIsbn(Integer isbn) throws LivroException{
        if(this.livros.get(isbn).isEmpty()) {
            throw new LivroException(findLivro, null);
        }
        else {
            return this.livros.get(isbn);
        }
    }

    @Override
    public void deleteOnlyOne(Livro obj) throws LivroException{
        if (livros.get(obj.getIsbn()) != null){
            LinkedList<Livro> livrosList = this.livros.get(obj.getIsbn());
            livrosList.remove(obj);
            this.livros.put(obj.getIsbn(), livrosList);
        } else if (livros.isEmpty()) {
            throw new LivroException(deleteWhenNotHaveObj, null);
        } else {
            throw new LivroException(deleteLivro, null);
        }
    }
}
