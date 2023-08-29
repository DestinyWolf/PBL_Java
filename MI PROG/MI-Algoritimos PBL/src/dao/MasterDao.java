package dao;

import dao.usuarios.ImMemoryLeitorDao;
import dao.usuarios.LeitorDao;

public class MasterDao {

    public static void getLeitorDAO(){
        LeitorDao leitor = new ImMemoryLeitorDao();
    }

    public static void main(String[] args){
        MasterDao.getLeitorDAO().creat
    }
}


