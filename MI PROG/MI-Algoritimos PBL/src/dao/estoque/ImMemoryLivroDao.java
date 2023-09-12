package dao.estoque;

import LibraryExceptions.estoqueExceptions.*;
import model.estoque.Livro;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

/**Classe que implementa a interface LivroDao*/
public class ImMemoryLivroDao implements LivroDao{
    private HashMap<Integer, LinkedList<Livro>> livros;

    public ImMemoryLivroDao() {
        this.livros = new HashMap<>();
    }


    @Override
    public Livro findById(Integer id) throws Exception{
        if(this.livros.get(id) != null) {
            return livros.get(id).getFirst();
        }
        else {
            throw new FindLivroException();
        }
    }

    @Override
    public void save(Livro obj) throws LivroCreateException {
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
    public void deleteById(Integer id) throws LivroDeleteException {
        if (livros.get(id) != null) {
            this.livros.remove(id);
        }
        else {
            throw new LivroDeleteException();
        }
    }

    @Override
    public void Update(Livro livro, Livro old) throws LivroUpdateException{
        if (livros.get(old.getIsbn()) != null) {
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
        }
        else {
            throw new LivroUpdateException();
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
    public LinkedList<Livro> findByAutor(String autor) throws AutorException {
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
            throw new AutorException();
        }
        else {
            return livrosList;
        }
    }

    @Override
    public LinkedList<Livro> findByCategoria(String categoria) throws CategoriaException{
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
            throw new CategoriaException();
        }
        else {
            return livrosList;
        }
    }

    @Override
    public LinkedList<Livro> findByNome(String nome)  throws FindLivroException {
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
            throw new FindLivroException();
        }
        else {
            return livrosList;
        }
    }

    @Override
    public LinkedList<Livro> findByIsbn(Integer isbn) throws FindIsbnException{
        if(this.livros.get(isbn).isEmpty()) {
            throw new FindIsbnException();
        }
        else {
            return this.livros.get(isbn);
        }
    }

    @Override
    public void deleteOnlyOne(Livro obj) throws LivroDeleteException{
        if (livros.get(obj.getIsbn()) != null){
            LinkedList<Livro> livrosList = this.livros.get(obj.getIsbn());
            livrosList.remove(obj);
            this.livros.put(obj.getIsbn(), livrosList);
        }
        else {
            throw new LivroDeleteException();
        }
    }
}
