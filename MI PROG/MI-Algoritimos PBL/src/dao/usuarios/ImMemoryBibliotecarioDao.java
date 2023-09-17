package dao.usuarios;


import LibraryExceptions.userexcepitions.BibliotecarioException;
import dao.MasterDao;
import model.usuarios.Bibliotecario;
import static util.Constantes.*;
import java.util.HashMap;
import java.util.LinkedList;

/**Classe que impelementa a interface BibliotecarioDao*/
public class ImMemoryBibliotecarioDao implements BibliotecarioDao{
    private HashMap<Integer, Bibliotecario> bibliotecarios;

    public ImMemoryBibliotecarioDao() {
        this.bibliotecarios = new HashMap<>();
    }
    @Override
    public Bibliotecario findById(Integer id) throws BibliotecarioException {
        if (MasterDao.getBibliotecarioDao().findById(id) != null) {
            return this.bibliotecarios.get(id);
        }
        else {
            throw new BibliotecarioException(findUser,null);
        }
    }

    @Override
    public void save(Bibliotecario obj) throws BibliotecarioException {
        if (MasterDao.getBibliotecarioDao().findById(obj.getId()) != null) {
            throw new BibliotecarioException(createExistUser, MasterDao.getBibliotecarioDao().findById(obj.getId()));
        }
        else {
            Bibliotecario bibliotecario = new Bibliotecario(obj.getNome(), obj.getSenha(), obj.getId(), "Bibliotecario");
            this.bibliotecarios.put(bibliotecario.getId(), bibliotecario);
        }

    }

    @Override
    public void deleteById(Integer id) throws BibliotecarioException{
        if (!this.bibliotecarios.isEmpty() && MasterDao.getBibliotecarioDao().findById(id) != null) {
            this.bibliotecarios.remove(id);
        } else if (this.bibliotecarios.isEmpty()) {
            throw new BibliotecarioException(deleteWhenNotHaveObj,null);
        } else {
            throw new BibliotecarioException(deleteUser, MasterDao.getBibliotecarioDao().findById(id));
        }
    }

    @Override
    public void Update(Bibliotecario bibliotecario, Bibliotecario old) throws BibliotecarioException{
        if (!this.bibliotecarios.isEmpty() && this.bibliotecarios.get(old.getId()) != null) {
            this.bibliotecarios.remove(old.getId(), old);
            this.bibliotecarios.put(bibliotecario.getId(), bibliotecario);
        } else if (this.bibliotecarios.isEmpty()) {
            throw new BibliotecarioException(updateWhenNotHaveObj, null);
        } else {
            throw new BibliotecarioException(updateUser, old);
        }
    }

    @Override
    public LinkedList<Bibliotecario> findAll() {
        LinkedList<Bibliotecario> values = (LinkedList<Bibliotecario>) this.bibliotecarios.values();
        return values;
    }

    @Override
    public Bibliotecario findLogin(Integer id, String senha) throws BibliotecarioException {
        for (Bibliotecario bibliotecario: bibliotecarios.values()
        ) {
            if (bibliotecario.getId() == id){
                if (bibliotecario.getSenha() == senha){
                    return bibliotecario;
                }
            }
        }
        throw new BibliotecarioException(loguinUser, null);
    }
}
