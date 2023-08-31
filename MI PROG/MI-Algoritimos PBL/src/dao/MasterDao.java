package dao;

import dao.estoque.ImMemoryLivroDao;
import dao.estoque.LivroDao;
import dao.usuarios.BibliotecarioDao;
import dao.usuarios.ImMemoryBibliotecarioDao;
import dao.usuarios.ImMemoryLeitorDao;
import dao.usuarios.LeitorDao;
import model.usuarios.Leitor;

public class MasterDao {

    private static LeitorDao leitorDao;
    private static LivroDao livroDao;
    private static BibliotecarioDao bibliotecarioDao;

    public static LeitorDao getLeitorDAO(){
        if(leitorDao == null){
            leitorDao = new ImMemoryLeitorDao();
        }
        return leitorDao;
    }

    public static LivroDao getLivroDao(){
        if(livroDao == null) {
            livroDao = new ImMemoryLivroDao();
        }
        return livroDao;
    }

    public static BibliotecarioDao getBibliotecarioDao() {
        if(bibliotecarioDao == null) {
            bibliotecarioDao = new ImMemoryBibliotecarioDao();
        }
        return bibliotecarioDao;
    }

}


