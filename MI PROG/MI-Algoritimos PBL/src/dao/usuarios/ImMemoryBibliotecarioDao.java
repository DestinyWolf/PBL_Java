package dao.usuarios;


import model.usuarios.Bibliotecario;

import java.util.HashMap;
import java.util.LinkedList;

/**Classe que impelementa a interface BibliotecarioDao*/
public class ImMemoryBibliotecarioDao implements BibliotecarioDao{
    private HashMap<Integer, Bibliotecario> bibliotecarios;

    public ImMemoryBibliotecarioDao() {
        this.bibliotecarios = new HashMap<>();
    }
    @Override
    public Bibliotecario findById(Integer id) {
        return this.bibliotecarios.get(id);
    }

    @Override
    public void save(Bibliotecario obj) {
        this.bibliotecarios.put(obj.getId(), obj);
    }

    @Override
    public void deleteById(Integer id) {
        this.bibliotecarios.remove(id);
    }

    @Override
    public void Update(Bibliotecario bibliotecario, Bibliotecario old) {
        this.bibliotecarios.remove(old.getId(),old);
        this.bibliotecarios.put(bibliotecario.getId(), bibliotecario);
    }

    @Override
    public LinkedList<Bibliotecario> findAll() {
        LinkedList<Bibliotecario> values = (LinkedList<Bibliotecario>) this.bibliotecarios.values();
        return values;
    }
}
