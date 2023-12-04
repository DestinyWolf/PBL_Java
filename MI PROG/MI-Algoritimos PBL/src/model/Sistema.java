package model;

import LibraryExceptions.emprestimoexception.EmprestimoException;
import dao.MasterDao;
import model.emprestimo.Emprestimo;
import model.usuarios.Administrador;
import model.usuarios.Bibliotecario;
import model.usuarios.Leitor;
import util.Data;

import java.util.LinkedList;

public class Sistema {

    public static Leitor sessaoAtualLeitor;
    public static Bibliotecario sessaoAtualBibliotecario;
    public static Administrador sessaoAtualAdministrador;


    /**
     * <p>Metodo responsavel por, toda vez que o sistema iniciar, calcular as multas</p>
     * @return <b>boolean</b> - <i><b>true</b>, se tudo ocoreu certo, <b>false</b>, caso ocorra algum erro</i>*/
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
                if (MasterDao.getEmprestimoDao().findEmprestimosAtivosPorUsuario(leitor.getId()) == null) {
                    if (leitor.getDiasRestantesMulta() >= 1) {
                        Emprestimo ultimoEmprestimo = null;
                        for (Emprestimo emprestimo: MasterDao.getEmprestimoDao().findByUser(leitor.getId())
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

    /**
     * <p>metodo responsavel por retornar o leitor que esta logado no atual momento</p>
     * @return <b>Leitor</b> - <i>o leitor atual logado</i>
     */
    public static Leitor getSessaoAtualLeitor() {
        return sessaoAtualLeitor;
    }

    /**
     * <p>metodo responsavel por retornar o administrador que esta logado no atual momento</p>
     * @return <b>Administrador</b> - <i>o administrador atual logado</i>
     */
    public static Administrador getSessaoAtualAdministrador() {
        return sessaoAtualAdministrador;
    }

    /**
     * <p>metodo responsavel por retornar o bibliotecario que esta logado no atual momento</p>
     * @return <b>Bibliotecario</b> - <i>o bibliotecario atual logado</i>
     */
    public static Bibliotecario getSessaoAtualBibliotecario() {
        return sessaoAtualBibliotecario;
    }

    /**
     * <p>Metodo responsavel por settar o administrador passado por parametro como administrador atual logado</p>
     * @param sessaoAtualAdministrador <b>Administrador</b>
     */
    public static void setSessaoAtualAdministrador(Administrador sessaoAtualAdministrador) {
        Sistema.sessaoAtualAdministrador = sessaoAtualAdministrador;
    }

    /**
     * <p>Metodo responsavel por settar o bibliotecario passado por parametro como bibliotecario atual logado</p>
     * @param sessaoAtualBibliotecario <b>Bibliotecario</b>
     */
    public static void setSessaoAtualBibliotecario(Bibliotecario sessaoAtualBibliotecario) {
        Sistema.sessaoAtualBibliotecario = sessaoAtualBibliotecario;
    }

    /**
     * <p>Metodo responsavel por settar o leitor passado por parametro como leitor atual logado</p>
     * @param sessaoAtualLeitor
     */
    public static void setSessaoAtualLeitor(Leitor sessaoAtualLeitor) {
        Sistema.sessaoAtualLeitor = sessaoAtualLeitor;
    }

}
