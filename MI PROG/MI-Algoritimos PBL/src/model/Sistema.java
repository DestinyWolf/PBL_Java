package model;

import LibraryExceptions.emprestimoexception.EmprestimoException;
import dao.MasterDao;
import model.emprestimo.Emprestimo;
import model.usuarios.Leitor;
import util.Data;

public class Sistema {


    public static boolean AtualizaEmprestimos() {
        Data dataAtual = new Data();
        try {
            for (Emprestimo emprestimo : MasterDao.getEmprestimoDao().findEmprestimosAtivos()
                ){

                if (emprestimo.getPrazoFinal().compareData(dataAtual) == 2) {
                    emprestimo.getLeitor().setDiasRestantesMulta(emprestimo.getLeitor().getDiasRestantesMulta()+ 2);
                }
            }
            for (Leitor leitor: MasterDao.getLeitorDAO().findAll()
                 ) {
                if (MasterDao.getEmprestimoDao().findEmprestimosAtivosPorUsuario(leitor.getId()) == null) {
                    if (leitor.getDiasRestantesMulta() >= 1) {
                        leitor.setDiasRestantesMulta(leitor.getDiasRestantesMulta() - 1);
                    }
                }
            }
            return true;
        } catch (EmprestimoException e) {
            return false;

        }

    }
}
