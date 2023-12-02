package dao.usuarios;


import LibraryExceptions.userexcepitions.BibliotecarioException;
import LibraryExceptions.userexcepitions.LeitorException;
import dao.FileManeger;
import dao.MasterDao;
import model.usuarios.Bibliotecario;
import model.usuarios.Leitor;

import static util.Constantes.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**Classe que impelementa a interface BibliotecarioDao*/
public class ImMemoryBibliotecarioDao implements BibliotecarioDao{
    private HashMap<String, Bibliotecario> bibliotecarios;

    public ImMemoryBibliotecarioDao() {
        this.bibliotecarios = new HashMap<>();
    }
    @Override
    public Bibliotecario findById(String id) throws BibliotecarioException {
        if(this.bibliotecarios.isEmpty()){
            throw new BibliotecarioException(findWhenNotHaveObj, null);
        }
        else{
            for(Bibliotecario bibliotecario : this.bibliotecarios.values()){
                if(bibliotecario.getId() == id){
                    return bibliotecario;
                }
            }
            throw new BibliotecarioException(findUser, null);
        }
    }

    @Override
    public void save(Bibliotecario obj) throws BibliotecarioException {
        if (this.bibliotecarios.containsKey(obj.getId())) {
            throw new BibliotecarioException(createExistUser, MasterDao.getBibliotecarioDao().findById(obj.getId()));
        }
        else {
            Bibliotecario bibliotecario = new Bibliotecario(obj.getNome(), obj.getSenha(), obj.getId(), "Bibliotecario");
            this.bibliotecarios.put(bibliotecario.getId(), bibliotecario);
        }

    }

    @Override
    public void delete(Bibliotecario bibliotecario) throws BibliotecarioException{
        if (this.bibliotecarios.containsKey(bibliotecario.getId())) {
            this.bibliotecarios.remove(bibliotecario.getId());
        } else if (this.bibliotecarios.isEmpty()) {
            throw new BibliotecarioException(deleteWhenNotHaveObj,null);
        } else {
            throw new BibliotecarioException(deleteUser, MasterDao.getBibliotecarioDao().findById(bibliotecario.getId()));
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
    public List<Bibliotecario> findAll() {
        List<Bibliotecario> lista = new LinkedList<>();
        for(Bibliotecario bibliotecario : bibliotecarios.values()){
            lista.add(bibliotecario);
        }
        return  lista;
    }

    @Override
    public void clearAll() throws BibliotecarioException {
        if(!this.bibliotecarios.isEmpty())
            this.bibliotecarios.clear();

    }

    @Override
    public Bibliotecario findLogin(String id, String senha) throws BibliotecarioException {
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
