package dao;

import dao.emprestimo.EmprestimoDao;
import dao.emprestimo.FilaDeReservaDao;
import dao.emprestimo.ImMemoryEmprestimoDao;
import dao.emprestimo.ImMemoryFilaDeReservaDao;
import dao.estoque.ImMemoryLivroDao;
import dao.estoque.LivroDao;
import dao.usuarios.*;
import dao.estoque.EstoqueDao;
import dao.estoque.ImMemoryEstoqueDao;



/**Classe MasterDao, reune todos os outros DAOs menores e implementa o Padão singleton*/
public class MasterDao {


    private static LeitorDao leitorDao;
    private static LivroDao livroDao;
    private static BibliotecarioDao bibliotecarioDao;
    public static FilaDeReservaDao filadeReservaDao;
    private static EmprestimoDao emprestimoDao;

    private static EstoqueDao estoqueDao;
    private static AdministradorDao administradorDao;

    public static EstoqueDao getEstoqueDao(){
        if(estoqueDao == null){
            estoqueDao = new ImMemoryEstoqueDao();
        }
        return estoqueDao;
    }

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

    public static FilaDeReservaDao getFiladeReservaDao() {
        if (filadeReservaDao == null) {
            filadeReservaDao = new ImMemoryFilaDeReservaDao();
        }
        return filadeReservaDao;
    }

    public static EmprestimoDao getEmprestimoDao() {
        if (emprestimoDao == null) {
            emprestimoDao = new ImMemoryEmprestimoDao();
        }
        return emprestimoDao;
    }

    public static AdministradorDao getAdministradorDao() {
        if (administradorDao == null) {
            administradorDao = new ImMemoryAdministradorDao();
        }

        return administradorDao;
    }
}


