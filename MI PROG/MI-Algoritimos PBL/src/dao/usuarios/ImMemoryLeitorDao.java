package dao.usuarios;

import model.usuarios.Leitor;

import java.util.HashMap;
import java.util.LinkedList;

public class ImMemoryLeitorDao implements LeitorDao{
    private HashMap<Integer, Leitor> leitores;
    public ImMemoryLeitorDao() {
        this.leitores = new HashMap<>();
    }

    @Override
    public void save(Leitor obj) {
        this.leitores.put(obj.getId(), obj);
    }

    @Override
    public void deleteById(Integer id) {
        Leitor leitor = this.findById(id);

        if(leitor != null) {
            leitores.remove(id);
        }
    }

    @Override
    public void Update(Leitor leitor, Leitor old) {
        this.leitores.remove(leitor.getId());
        this.leitores.put(leitor.getId(), leitor);
    }

    @Override
    public Leitor findById(Integer id) {
        return this.leitores.get(id);
    }

    @Override
    public LinkedList<Leitor> findAll() {
        return (LinkedList<Leitor>) this.leitores.values();
    }
}
