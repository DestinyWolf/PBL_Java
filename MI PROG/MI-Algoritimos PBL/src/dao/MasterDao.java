package dao;

import dao.estoque.LivroDao;
import dao.usuarios.ImMemoryLeitorDao;
import dao.usuarios.LeitorDao;
import model.usuarios.Leitor;

public class MasterDao {

    private static LeitorDao leitorDao;
    private static LivroDao livroDao;

    public static LeitorDao getLeitorDAO(){
        if(leitorDao == null){
            leitorDao = new ImMemoryLeitorDao();
        }
        return leitorDao;
    }

    public static LivroDao getLivroDao(){

        return livroDao;
    }

    public static void main(String[] args){

    }
}


