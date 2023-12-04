package dao;
import LibraryExceptions.emprestimoexception.EmprestimoException;
import LibraryExceptions.emprestimoexception.ReservarException;
import LibraryExceptions.estoqueExceptions.LivroException;
import LibraryExceptions.userexcepitions.AdministradorException;
import LibraryExceptions.userexcepitions.BibliotecarioException;
import LibraryExceptions.userexcepitions.LeitorException;
import model.emprestimo.Emprestimo;
import model.emprestimo.FilaDeReserva;
import model.estoque.Livro;
import model.usuarios.Administrador;
import model.usuarios.Bibliotecario;
import model.usuarios.Leitor;

import java.io.*;
import java.util.HashMap;
import java.util.List;

/** classe responsavels por aganizar o salvamento, abertura e fechamento dos arquivor
 *
 */
public class FileManeger {

    /**
     * <p>Metodo <b>statico</b> responsavel por gerar as pastas e os arquivos de persitencia de dados</p>
     * @throws Exception <i>caso ocorra algum problema no momento da crição por exemplo, não haja permissão para
     * criar arquivos naquela pasta</i>
     */
    public static void generateCache() throws Exception{
        if(!(new File("cache")).exists()){
            File file = new File("cache");
            if (!file.exists()) {
                file.mkdirs();
            }
        }

        if (!(new File("cache\\leitor.bin")).exists()){
            FileManeger.saveLeitor(new HashMap<String,Leitor>());
        }
        if (!(new File("cache\\administrador.bin")).exists()){
            FileManeger.saveAdministrador(new HashMap<String, Administrador>());
        }
        if (!(new File("cache\\bibliotecario.bin")).exists()){
            FileManeger.saveBibliotecario(new HashMap<String, Bibliotecario>());
        }
        if (!(new File("cache\\livro.bin")).exists()){
            FileManeger.saveLivro(new HashMap<String, Livro>());
        }

        if (!(new File("cache\\emprestimo.bin")).exists()){
            FileManeger.saveEmprestimo(new HashMap<String, Emprestimo>());
        }
        if (!(new File("cache\\filaDeReserva.bin")).exists()){
            FileManeger.saveFilaDeReserva(new HashMap<String, FilaDeReserva>());
        }
    }

    /**
     * <p>Metodo <b>statico</b> responsavel por salvar <b>em arquivo</b> os dados armazenados no DAO da fila de reserva</p>
     * @param filasDeReserva <b>HashMap&lt;String, FilaDeReserva&gt;</b>
     * @throws ReservarException <i>Caso haja algum problema no momento do salvamento no arquivo</i>
     */
    public static void saveFilaDeReserva(HashMap<String, FilaDeReserva> filasDeReserva) throws ReservarException {
        try{
            File path = new File("cache\\filaDeReserva.bin");
            FileOutputStream teste = new FileOutputStream(path);
            ObjectOutputStream gravador = new ObjectOutputStream(teste);
            gravador.writeObject(filasDeReserva);
            gravador.close();
        } catch (IOException exception){
            throw new ReservarException("Impossivel realizar o salvamento", null);
        }
    }

    /**
     *  <p>Metodo <b>statico</b> responsavel por salvar <b>em arquivo</b> os dados armazenados no DAO dos emprestimos</p>
     * @param emprestimos <b>HashMap&lt;String, Emprestimo&gt;</b>
     * @throws EmprestimoException <i>Caso haja algum problema no momento do salvamento no arquivo</i>
     */
    public static void saveEmprestimo(HashMap<String,Emprestimo> emprestimos) throws EmprestimoException {
        try{
            File path = new File("cache\\emprestimo.bin");
            ObjectOutputStream gravador = new ObjectOutputStream(new FileOutputStream(path));
            gravador.writeObject(emprestimos);
            gravador.close();
        } catch (IOException exception){
            throw new EmprestimoException("Impossivel realizar o salvamento", null);
        }
    }

    /**
     *  <p>Metodo <b>statico</b> responsavel por salvar <b>em arquivo</b> os dados armazenados no DAO dos livros</p>
     * @param livros <b>HashMap&lt;String, Livro&gt;</b>
     * @throws LivroException <i>Caso haja algum problema no momento do salvamento no arquivo</i>
     */
    public static void saveLivro(HashMap<String, Livro> livros) throws LivroException {
        try{
            File path = new File("cache\\livro.bin");
            ObjectOutputStream gravador = new ObjectOutputStream(new FileOutputStream(path));
            gravador.writeObject(livros);
            gravador.close();

        } catch (IOException exception){
            throw new LivroException("Impossivel realizar o salvamento", null);
        }
    }

    /**
     * <p>Metodo <b>statico</b> responsavel por salvar <b>em arquivo</b> os dados armazenados no DAO dos bibliotecarios</p>
     * @param bibliotecarios <b>HashMap&lt;String, Bibliotecario&gt;</b>
     * @throws BibliotecarioException <i>Caso haja algum problema no momento do salvamento no arquivo</i>
     */
    public static void saveBibliotecario(HashMap<String, Bibliotecario> bibliotecarios) throws BibliotecarioException {
        try{
            File path = new File("cache\\bibliotecario.bin");
            FileOutputStream teste = new FileOutputStream(path);
            ObjectOutputStream gravador = new ObjectOutputStream(teste);
            gravador.writeObject(bibliotecarios);
            gravador.close();
        } catch (IOException exception){
            throw new BibliotecarioException("Impossivel realizar o salvamento", null);
        }
    }

    /**
     * <p>Metodo <b>statico</b> responsavel por salvar <b>em arquivo</b> os dados armazenados no DAO dos administradores</p>
     * @param administradores <b>HashMap&lt;String, Administrador&gt;</b>
     * @throws AdministradorException <i>Caso haja algum problema no momento do salvamento no arquivo</i>
     */
    public static void saveAdministrador(HashMap<String, Administrador> administradores) throws AdministradorException {
        try{
            File path = new File("cache\\administrador.bin");
            FileOutputStream teste = new FileOutputStream(path);
            ObjectOutputStream gravador = new ObjectOutputStream(teste);
            gravador.writeObject(administradores);
            gravador.close();
        } catch (IOException exception){
            throw new AdministradorException("Impossivel realizar o salvamento", null);
        }
    }

    /**
     * <p>Metodo <b>statico</b> responsavel por salvar <b>em arquivo</b> os dados armazenados no DAO dos leitores</p>
     * @param leitores <b>HashMap&lt;String, Leitor&gt;</b>
     * @throws LeitorException <i>Caso haja algum problema no momento do salvamento no arquivo</i>
     */
    public static void saveLeitor(HashMap<String, Leitor> leitores) throws LeitorException {
        try{
            File path = new File("cache\\leitor.bin");
            FileOutputStream teste = new FileOutputStream(path);
            ObjectOutputStream gravador = new ObjectOutputStream(teste);
            gravador.writeObject(leitores);
            gravador.close();
        } catch (IOException exception){
            throw new LeitorException("Impossivel realizar o salvamento", null);
        }
    }

    /**
     *<p>Metodo responsavel por retornar um <b>HashMap</b> contendo os leitores salvos no arquivo, em caso do
     * arquivo estar vazio, cria e retorna um <b>novo HashMap</b></p>
     * @return <b>HashMap&lt;String, Leitor&gt;</b> - <i>HashMap contendo como chave o cpf e
     * como valor um objeto do tipo Leitor</i>
     * @throws LeitorException <i>caso ocorra erro ao buscar o arquivo, a mensagem respectivva ao erro será exibida</i>
     */
    public static HashMap<String, Leitor> openLeitor() throws LeitorException {
            try {
                FileInputStream path = new FileInputStream("cache\\leitor.bin");
                ObjectInputStream recebedor = new ObjectInputStream(path);
                HashMap<String, Leitor> leitores = (HashMap<String, Leitor>) recebedor.readObject();
                recebedor.close();
                if (leitores.isEmpty()) {
                    leitores = new HashMap<>();
                }
                return leitores;
            } catch (FileNotFoundException excep) {
                throw new LeitorException("O arquivo não foi encontrado no sistema.", null);
            } catch (ClassNotFoundException excep) {
                throw new LeitorException("Classe não encontrada.", null);
            } catch (IOException excep) {
                throw new LeitorException("Problemas na leitura do arquivo.", null);
            }

    }

    /**
     * <p>Metodo responsavel por retornar um <b>HashMap</b> contendo os Administradores salvos no arquivo, em caso do
     * arquivo estar vazio, cria e retorna um <b>novo HashMap</b></p>
     * @return <b>HashMap&lt;String, Administrador&gt;</b> - <i>HashMap contendo como chave o
     * cpf e como valor um objeto do tipo Administrador</i>
     * @throws AdministradorException <i>caso ocorra erro ao buscar o arquivo, a mensagem respectivva ao erro será exibida</i>
     */
    public static HashMap<String, Administrador> openAdministrador() throws AdministradorException {
        try {
            FileInputStream path = new FileInputStream("cache\\administrador.bin");
            ObjectInputStream recebedor = new ObjectInputStream(path);
            HashMap<String, Administrador> administradores = (HashMap<String, Administrador>) recebedor.readObject();
            recebedor.close();
            if (administradores.isEmpty()) {
                administradores = new HashMap<>();
            }
            return administradores;
        } catch (FileNotFoundException excep) {
            throw new AdministradorException("O arquivo não foi encontrado no sistema.", null);
        } catch (ClassNotFoundException excep) {
            throw new AdministradorException("Classe não encontrada.", null);
        } catch (IOException excep) {
            throw new AdministradorException("Problemas na leitura do arquivo.", null);
        }

    }

    /**
     * <p>Metodo responsavel por retornar um <b>HashMap</b> contendo os Bibliotecarios salvos no arquivo, em caso do
     * arquivo estar vazio, cria e retorna um <b>novo HashMap</b></p>
     * @return <b>HashMap&lt;String, Bibliotecario&gt;</b> - <i>HashMap contendo como chave o cpf e como valor
     * um objeto do tipo Bibliotecario</i>
     * @throws BibliotecarioException <i>caso ocorra erro ao buscar o arquivo, a mensagem respectivva ao erro será exibida</i>
     */
    public static HashMap<String, Bibliotecario> openBibliotecario() throws BibliotecarioException {
        try {
            FileInputStream path = new FileInputStream("cache\\bibliotecario.bin");
            ObjectInputStream recebedor = new ObjectInputStream(path);
            HashMap<String, Bibliotecario> bibliotecarios = (HashMap<String, Bibliotecario>) recebedor.readObject();
            recebedor.close();
            if (bibliotecarios.isEmpty()) {
                bibliotecarios =  new HashMap<>();
            }
            return bibliotecarios;
        } catch (FileNotFoundException excep) {
            throw new BibliotecarioException("O arquivo não foi encontrado no sistema.", null);
        } catch (ClassNotFoundException excep) {
            throw new BibliotecarioException("Classe não encontrada.", null);
        } catch (IOException excep) {
            throw new BibliotecarioException("Problemas na leitura do arquivo.", null);
        }

    }

    /**
     * <p>Metodo responsavel por retornar um <b>HashMap</b> contendo os Livros salvos no arquivo, em caso do
     * arquivo estar vazio, cria e retorna um <b>novo HashMap</b></p>
     * @return <b>HashMap&lt;String, Livro&gt;</b> - <i>HashMap contendo como chave o codigo ISBN e como valor
     * um objeto do tipo Livro</i>
     * @throws LivroException <i>caso ocorra erro ao buscar o arquivo, a mensagem respectivva ao erro será exibida</i>
     */
    public static HashMap<String, Livro> openLivro() throws LivroException {
        try {
            HashMap<String, Livro> livros = new HashMap<>();
            FileInputStream path = new FileInputStream("cache\\livro.bin");
            ObjectInputStream recebedor = new ObjectInputStream(path);
            livros = (HashMap<String, Livro>) recebedor.readObject();
            recebedor.close();
            if (livros.isEmpty()) {
                return new HashMap<>();
            }
            return livros;
        } catch (FileNotFoundException excep) {
            throw new LivroException("O arquivo não foi encontrado no sistema.", null);
        } catch (ClassNotFoundException excep) {
            throw new LivroException("Classe não encontrada.", null);
        } catch (IOException excep) {
            throw new LivroException("Problemas na leitura do arquivo.", null);
        }

    }

    /**
     <p>Metodo responsavel por retornar um <b>HashMap</b> contendo os Emprestimos salvos no arquivo, em caso do
     * arquivo estar vazio, cria e retorna um <b>novo HashMap</b></p>
     * @return <b>HashMap&lt;String, Emprestimo&gt;</b> - <i>HashMap contendo como chave o Id do Emprestimo e como valor
     * um objeto do tipo Emprestimo</i>
     * @throws EmprestimoException <i>caso ocorra erro ao buscar o arquivo, a mensagem respectivva ao erro será exibida</i>
     */
    public static HashMap<String, Emprestimo> openEmprestimo() throws EmprestimoException {
        try {
            HashMap<String, Emprestimo> emprestimos;
            FileInputStream path = new FileInputStream("cache\\emprestimo.bin");
            ObjectInputStream recebedor = new ObjectInputStream(path);
            emprestimos = (HashMap<String, Emprestimo>) recebedor.readObject();
            recebedor.close();
            if (emprestimos.isEmpty()) {
                emprestimos = new HashMap<>();
            }
            return emprestimos;
        } catch (FileNotFoundException excep) {
            throw new EmprestimoException("O arquivo não foi encontrado no sistema.", null);
        } catch (ClassNotFoundException excep) {
            throw new EmprestimoException("Classe não encontrada.", null);
        } catch (IOException excep) {
            throw new EmprestimoException("Problemas na leitura do arquivo.", null);
        }

    }

    /**
     <p>Metodo responsavel por retornar um <b>HashMap</b> contendo as Filas de Reserva salvos no arquivo, em caso do
     * arquivo estar vazio, cria e retorna um <b>novo HashMap</b></p>
     * @return <b>HashMap&lt;String, FilaDeReserva&gt;</b> - <i>HashMap contendo como chave o ISBN do livro e como valor
     * um objeto do tipo FilaDeReserva</i>
     * @throws ReservarException <i>caso ocorra erro ao buscar o arquivo, a mensagem respectivva ao erro será exibida</i>
     */
    public static HashMap<String, FilaDeReserva> openFilaDeReserva() throws ReservarException {
        try {
            HashMap<String, FilaDeReserva> filasDeReserva;
            FileInputStream path = new FileInputStream("cache\\filaDeReserva.bin");
            ObjectInputStream recebedor = new ObjectInputStream(path);
            filasDeReserva = (HashMap<String, FilaDeReserva>) recebedor.readObject();
            recebedor.close();
            if (filasDeReserva.isEmpty()) {
                filasDeReserva = new HashMap<>();
            }
            return filasDeReserva;
        } catch (FileNotFoundException excep) {
            throw new ReservarException("O arquivo não foi encontrado no sistema.", null);
        } catch (ClassNotFoundException excep) {
            throw new ReservarException("Classe não encontrada.", null);
        } catch (IOException excep) {
            throw new ReservarException("Problemas na leitura do arquivo.", null);
        }

    }

}
