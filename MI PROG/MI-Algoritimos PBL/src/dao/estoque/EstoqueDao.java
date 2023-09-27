package dao.estoque;
import dao.Dao;
import model.estoque.Estoque;

public interface EstoqueDao extends Dao<Estoque, Exception> {
    void deleteById(Estoque obj) throws Exception;
}
