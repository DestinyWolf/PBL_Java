package dao.estoque;

import model.estoque.Livro;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class ImMemoryLivroDao implements LivroDao{
    private HashMap<Integer, LinkedList<Livro>> livros;

    public ImMemoryLivroDao() {
        this.livros = new HashMap<>();
    }


    @Override
    public Livro findById(Integer id) {
        return livros.get(id).getFirst(); //retornar o primeiro livro da lista de livros daquele isbn
    }

    @Override
    public void save(Livro obj) {
        if(this.livros.get(obj.getIsbn()) != null) {
             LinkedList<Livro> livrosList = this.livros.get(obj.getIsbn());
             livrosList.add(obj);
             this.livros.put(obj.getIsbn(), livrosList);
        }

    }

    @Override
    public void deleteById(Integer id) {
        this.livros.remove(id);
    }

    @Override
    public void Update(Livro livro, Livro old) {
        if(Objects.equals(livro.getIsbn(), old.getIsbn())) {
            LinkedList<Livro> livrosList = this.livros.get(livro.getIsbn());
            livrosList.remove(old);
            livrosList.add(livro);
            this.livros.put(livro.getIsbn(), livrosList);
        }
        else {
            LinkedList<Livro> livrosList = this.livros.get(old.getIsbn());
            livrosList.remove(old);
            this.livros.put(old.getIsbn(), livrosList);
            livrosList = this.livros.get(livro.getIsbn());
            livrosList.add(livro);
            this.livros.put(livro.getIsbn(), livrosList);
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
    public LinkedList<Livro> findByAutor(String autor) {
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
        return livrosList;

    }

    @Override
    public LinkedList<Livro> findByCategoria(String categoria) {
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
        return livrosList;
    }

    @Override
    public LinkedList<Livro> findByNome(String nome) {
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
        return livrosList;
    }

    @Override
    public void deleteOnlyOne(Livro obj) {
        LinkedList<Livro> livrosList =  this.livros.get(obj.getIsbn());
        livrosList.remove(obj);
        this.livros.put(obj.getIsbn(), livrosList);
    }
}
