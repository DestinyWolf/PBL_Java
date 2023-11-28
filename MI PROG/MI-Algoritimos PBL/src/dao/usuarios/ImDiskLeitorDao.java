package dao.usuarios;

import LibraryExceptions.emprestimoexception.EmprestimoException;
import LibraryExceptions.userexcepitions.LeitorException;
import dao.FileManeger;
import dao.MasterDao;
import model.usuarios.Leitor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static util.Constantes.*;

public class ImDiskLeitorDao implements LeitorDao{
    private HashMap<String, Leitor> leitores;
    public ImDiskLeitorDao(){
        try {
            this.leitores = FileManeger.openLeitor();
        } catch (Exception ignore) {

        }
    }

    @Override
    public void save(Leitor obj) throws LeitorException {

        if (this.leitores.containsKey(obj.getId())) {
            throw new LeitorException(createExistUser, MasterDao.getLeitorDAO().findById(obj.getId()));
        }else {

            Leitor leitor = new Leitor(obj.getNome(), obj.getSenha(), obj.getId(), obj.getEndereco(), obj.getTelefone());
            leitores.put(leitor.getId(), leitor);
            FileManeger.saveLeitor(leitores);
        }
    }



    @Override
    public void delete(Leitor leitor) throws LeitorException{
        try {
            if (this.leitores.containsKey(leitor.getId())   /*&& MasterDao.getEmprestimoDao().findByUser(leitor.getId()) == null*/) {
                leitores.remove(leitor.getId());
                FileManeger.saveLeitor(leitores);
            } else if (MasterDao.getEmprestimoDao().findByUser(leitor.getId()) != null) {
                throw new LeitorException(deleteUsuarioWithEmprestimo, MasterDao.getLeitorDAO().findById(leitor.getId()));
            } else {
                throw new LeitorException(deleteUser, null);
            }
        } catch (EmprestimoException ee){
            throw new LeitorException(deleteUser, null);
        }
    }

    @Override
    public void Update(Leitor leitor, Leitor old) throws LeitorException{
        if (this.leitores.get(old.getId()) != null) {
            this.leitores.remove(leitor.getId());
            this.leitores.put(leitor.getId(), leitor);
            FileManeger.saveLeitor(leitores);
        }
        else if(this.leitores.isEmpty()) {
            throw new LeitorException(updateWhenNotHaveObj, null);
        }
        else {
            throw new LeitorException(updateUser, null);
        }
    }



    @Override
    public Leitor findById(String id) throws LeitorException{
        if(this.leitores.isEmpty()){
            throw new LeitorException(findWhenNotHaveObj, null);
        }
        else{
            if(this.leitores.containsKey(id)){
                return leitores.get(id);
            }
            throw new LeitorException(findUser, null);
        }

    }


    @Override
    public List<Leitor> findAll() {
        List<Leitor> lista = new LinkedList<>();
        for(Leitor leitor : leitores.values()){
            lista.add(leitor);
        }
        return  lista;
    }


    @Override
    public Leitor findLogin(String id, String senha) throws LeitorException {
        for (Leitor leitor : leitores.values()) {
            if (leitor.getId() == id && leitor.getSenha().equals(senha)) {
                return leitor;
            }
        }
        throw new LeitorException(loguinUser, null);
    }

}
