package dao.usuarios;

import dao.MasterDao;
import model.usuarios.Administrador;

import java.util.HashMap;
import java.util.LinkedList;

/**Classe que implementar a interface AdministradorDao*/
public class ImMemoryAdministradorDao implements AdministradorDao{
    private HashMap<Integer, Administrador> administradores;

    @Override
    public Administrador findById(Integer id) {
        return administradores.get(id);
    }

    @Override
    public void save(Administrador obj) {
        if(MasterDao.getAdministradorDao().findById(obj.getId()) != null) {
            //lançar exceção
        }
        else {
            Administrador administrador = new Administrador(obj.getSenha(), obj.getNome(), "Administrador", obj.getId());
            administradores.put(administrador.getId(), administrador);
        }

    }

    @Override
    public void deleteById(Integer id) {
        administradores.remove(id);
    }

    @Override
    public void Update(Administrador administrador, Administrador old) {
        administradores.remove(old.getId());
        administradores.put(administrador.getId(), administrador);
    }

    @Override
    public LinkedList<Administrador> findAll() {
        return (LinkedList<Administrador>) administradores.values();
    }
}
