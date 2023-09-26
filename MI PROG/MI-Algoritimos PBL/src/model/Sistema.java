package model;

import LibraryExceptions.emprestimoexception.EmprestimoException;
import dao.MasterDao;
import model.emprestimo.Emprestimo;
import model.usuarios.Leitor;
import util.Data;

public class Sistema {


    public static boolean atualizaMultas() {
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
                if (MasterDao.getEmprestimoDao().findEmprestimosAtivosPorUsuario(Integer.parseInt(leitor.getId())) == null) {
                    if (leitor.getDiasRestantesMulta() >= 1) {
                        Emprestimo ultimoEmprestimo = null;
                        for (Emprestimo emprestimo: MasterDao.getEmprestimoDao().findByUser(Integer.parseInt(leitor.getId()))
                             ) {

                            if (ultimoEmprestimo == null) {
                                ultimoEmprestimo = emprestimo;
                            }
                            else if (emprestimo.getDataDevolucao().compareData(ultimoEmprestimo.getDataDevolucao()) == 1) {
                                ultimoEmprestimo = emprestimo;
                            }
                        }
                        Integer qntDiasQuePassaram = 30*(ultimoEmprestimo.getDataDevolucao().getMes() - dataAtual.getMes());
                        qntDiasQuePassaram += (ultimoEmprestimo.getDataDevolucao().getDia() - dataAtual.getDia());
                        qntDiasQuePassaram += 365*(ultimoEmprestimo.getDataDevolucao().getAno() - dataAtual.getAno());


                        leitor.setDiasRestantesMulta(leitor.getDiasRestantesMulta() - qntDiasQuePassaram);
                    }
                }
            }
            return true;
        } catch (EmprestimoException e) {
            return false;

        }

    }

}
