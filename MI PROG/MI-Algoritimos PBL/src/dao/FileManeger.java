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

    public static void generateCache() throws Exception{
        if(!(new File("cache")).exists()){
            File file = new File("cache");
            if (!file.exists()) {
                file.mkdirs();
            }
        }

        if (!(new File("cache\\leitor.dat")).exists()){
            FileManeger.saveLeitor(new HashMap<String,Leitor>());
        }
        if (!(new File("cache\\administrador.dat")).exists()){
            FileManeger.saveAdministrador(new HashMap<String, Administrador>());
        }
        if (!(new File("cache\\bibliotecario.dat")).exists()){
            FileManeger.saveBibliotecario(new HashMap<String, Bibliotecario>());
        }
        if (!(new File("cache\\livro.dat")).exists()){
            FileManeger.saveLivro(new HashMap<String, Livro>());
        }

        if (!(new File("cache\\emprestimo.dat")).exists()){
            FileManeger.saveEmprestimo(new HashMap<String, Emprestimo>());
        }
        if (!(new File("cache\\filaDeReserva.dat")).exists()){
            FileManeger.saveFilaDeReserva(new HashMap<String, FilaDeReserva>());
        }
    }

    public static void saveFilaDeReserva(HashMap<String, FilaDeReserva> filasDeReserva) throws ReservarException {
        try{
            File path = new File("cache\\filaDeReserva.dat");
            FileOutputStream teste = new FileOutputStream(path);
            ObjectOutputStream gravador = new ObjectOutputStream(teste);
            gravador.writeObject(filasDeReserva);
            gravador.close();
        } catch (IOException exception){
            throw new ReservarException("Impossivel realizar o salvamento", null);
        }
    }

    public static void saveEmprestimo(HashMap<String, Emprestimo> emprestimos) throws EmprestimoException {
        try{
            File path = new File("cache\\emprestimo.dat");
            FileOutputStream teste = new FileOutputStream(path);
            ObjectOutputStream gravador = new ObjectOutputStream(teste);
            gravador.writeObject(emprestimos);
            gravador.close();
        } catch (IOException exception){
            throw new EmprestimoException("Impossivel realizar o salvamento", null);
        }
    }

    public static void saveLivro(HashMap<String, Livro> livros) throws LivroException {
        try{
            File path = new File("cache\\livro.dat");
            FileOutputStream teste = new FileOutputStream(path);
            ObjectOutputStream gravador = new ObjectOutputStream(teste);
            gravador.writeObject(livros);
            gravador.close();
        } catch (IOException exception){
            throw new LivroException("Impossivel realizar o salvamento", null);
        }
    }

    public static void saveBibliotecario(HashMap<String, Bibliotecario> bibliotecarios) throws BibliotecarioException {
        try{
            File path = new File("cache\\bibliotecario.dat");
            FileOutputStream teste = new FileOutputStream(path);
            ObjectOutputStream gravador = new ObjectOutputStream(teste);
            gravador.writeObject(bibliotecarios);
            gravador.close();
        } catch (IOException exception){
            throw new BibliotecarioException("Impossivel realizar o salvamento", null);
        }
    }

    public static void saveAdministrador(HashMap<String, Administrador> administradores) throws AdministradorException {
        try{
            File path = new File("cache\\administrador.dat");
            FileOutputStream teste = new FileOutputStream(path);
            ObjectOutputStream gravador = new ObjectOutputStream(teste);
            gravador.writeObject(administradores);
            gravador.close();
        } catch (IOException exception){
            throw new AdministradorException("Impossivel realizar o salvamento", null);
        }
    }

    public static void saveLeitor(HashMap<String, Leitor> leitores) throws LeitorException {
        try{
            File path = new File("cache\\leitor.dat");
            FileOutputStream teste = new FileOutputStream(path);
            ObjectOutputStream gravador = new ObjectOutputStream(teste);
            gravador.writeObject(leitores);
            gravador.close();
        } catch (IOException exception){
            throw new LeitorException("Impossivel realizar o salvamento", null);
        }
    }

    public static HashMap<String, Leitor> openLeitor() throws LeitorException {
            try {
                FileInputStream path = new FileInputStream("cache\\leitor.dat");
                ObjectInputStream recebedor = new ObjectInputStream(path);
                HashMap<String, Leitor> leitores = (HashMap<String, Leitor>) recebedor.readObject();
                recebedor.close();
                if (leitores.isEmpty()) {
                    return new HashMap<String, Leitor>();
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

    public static HashMap<String, Administrador> openAdministrador() throws AdministradorException {
        try {
            FileInputStream path = new FileInputStream("cache\\administrador.dat");
            ObjectInputStream recebedor = new ObjectInputStream(path);
            HashMap<String, Administrador> administradores = (HashMap<String, Administrador>) recebedor.readObject();
            recebedor.close();
            if (administradores.isEmpty()) {
                return new HashMap<String, Administrador>();
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

    public static HashMap<String, Bibliotecario> openBibliotecario() throws BibliotecarioException {
        try {
            FileInputStream path = new FileInputStream("cache\\bibliotecario.dat");
            ObjectInputStream recebedor = new ObjectInputStream(path);
            HashMap<String, Bibliotecario> bibliotecarios = (HashMap<String, Bibliotecario>) recebedor.readObject();
            recebedor.close();
            if (bibliotecarios.isEmpty()) {
                return new HashMap<String, Bibliotecario>();
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

    public static HashMap<String, Livro> openLivro() throws LivroException {
        try {
            FileInputStream path = new FileInputStream("cache\\livro.dat");
            ObjectInputStream recebedor = new ObjectInputStream(path);
            HashMap<String, Livro> livros = (HashMap<String, Livro>) recebedor.readObject();
            recebedor.close();
            if (livros.isEmpty()) {
                return new HashMap<String, Livro>();
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

    public static HashMap<String, Emprestimo> openEmprestimo() throws EmprestimoException {
        try {
            FileInputStream path = new FileInputStream("cache\\emprestimo.dat");
            ObjectInputStream recebedor = new ObjectInputStream(path);
            HashMap<String, Emprestimo> emprestimos = (HashMap<String, Emprestimo>) recebedor.readObject();
            recebedor.close();
            if (emprestimos.isEmpty()) {
                return new HashMap<String, Emprestimo>();
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

    public static HashMap<String, FilaDeReserva> openFilaDeReserva() throws ReservarException {
        try {
            FileInputStream path = new FileInputStream("cache\\filaDeReserva.dat");
            ObjectInputStream recebedor = new ObjectInputStream(path);
            HashMap<String, FilaDeReserva> filasDeReserva = (HashMap<String, FilaDeReserva>) recebedor.readObject();
            recebedor.close();
            if (filasDeReserva.isEmpty()) {
                return new HashMap<String, FilaDeReserva>();
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
