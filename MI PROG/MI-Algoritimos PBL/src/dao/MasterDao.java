package dao;

import dao.emprestimo.EmprestimoDao;
import dao.emprestimo.FiladeReservaDao;
import dao.emprestimo.ImMemoryEmprestimoDao;
import dao.emprestimo.ImMemoryFilaDeReservaDao;
import dao.estoque.ImMemoryLivroDao;
import dao.estoque.LivroDao;
import dao.usuarios.*;


public class MasterDao {

    private static LeitorDao leitorDao;
    private static LivroDao livroDao;
    private static BibliotecarioDao bibliotecarioDao;
    public static FiladeReservaDao filadeReservaDao;
    public static EmprestimoDao emprestimoDao;
    public static AdministradorDao administradorDao;

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

    public static FiladeReservaDao getFiladeReservaDao() {
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


