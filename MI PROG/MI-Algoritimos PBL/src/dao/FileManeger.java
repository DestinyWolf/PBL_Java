package dao;
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

    public static void generateCache() {

    }
    public FileManeger() throws Exception{
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

    public static void saveFilaDeReserva(HashMap<String, FilaDeReserva> filasDeReserva) throws Exception{
        try{
            File path = new File("cache\\filaDeReserva.dat");
            FileOutputStream teste = new FileOutputStream(path);
            ObjectOutputStream gravador = new ObjectOutputStream(teste);
            gravador.writeObject(filasDeReserva);
            gravador.close();
        } catch (IOException exception){
            throw new Exception("Impossivel realizar o salvamento");
        }
    }

    public static void saveEmprestimo(HashMap<String, Emprestimo> emprestimos) throws Exception {
        try{
            File path = new File("cache\\emprestimo.dat");
            FileOutputStream teste = new FileOutputStream(path);
            ObjectOutputStream gravador = new ObjectOutputStream(teste);
            gravador.writeObject(emprestimos);
            gravador.close();
        } catch (IOException exception){
            throw new Exception("Impossivel realizar o salvamento");
        }
    }

    public static void saveLivro(HashMap<String, Livro> livros) throws Exception{
        try{
            File path = new File("cache\\livro.dat");
            FileOutputStream teste = new FileOutputStream(path);
            ObjectOutputStream gravador = new ObjectOutputStream(teste);
            gravador.writeObject(livros);
            gravador.close();
        } catch (IOException exception){
            throw new Exception("Impossivel realizar o salvamento");
        }
    }

    public static void saveBibliotecario(HashMap<String, Bibliotecario> bibliotecarios) throws Exception{
        try{
            File path = new File("cache\\bibliotecario.dat");
            FileOutputStream teste = new FileOutputStream(path);
            ObjectOutputStream gravador = new ObjectOutputStream(teste);
            gravador.writeObject(bibliotecarios);
            gravador.close();
        } catch (IOException exception){
            throw new Exception("Impossivel realizar o salvamento");
        }
    }

    public static void saveAdministrador(HashMap<String, Administrador> administradores) throws Exception{
        try{
            File path = new File("cache\\administrador.dat");
            FileOutputStream teste = new FileOutputStream(path);
            ObjectOutputStream gravador = new ObjectOutputStream(teste);
            gravador.writeObject(administradores);
            gravador.close();
        } catch (IOException exception){
            throw new Exception("Impossivel realizar o salvamento");
        }
    }

    public static void saveLeitor(HashMap<String, Leitor> leitores) throws Exception {
        try{
            File path = new File("cache\\leitor.dat");
            FileOutputStream teste = new FileOutputStream(path);
            ObjectOutputStream gravador = new ObjectOutputStream(teste);
            gravador.writeObject(leitores);
            gravador.close();
        } catch (IOException exception){
            throw new Exception("Impossivel realizar o salvamento");
        }
    }

    public static HashMap<String, Leitor> openLeitor() throws Exception {
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
                throw new Exception("O arquivo não foi encontrado no sistema.", excep);
            } catch (ClassNotFoundException excep) {
                throw new Exception("Classe não encontrada.", excep);
            } catch (IOException excep) {
                throw new Exception("Problemas na leitura do arquivo.", excep);
            }

    }

    public static HashMap<String, Administrador> openAdministrador() throws Exception {
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
            throw new Exception("O arquivo não foi encontrado no sistema.", excep);
        } catch (ClassNotFoundException excep) {
            throw new Exception("Classe não encontrada.", excep);
        } catch (IOException excep) {
            throw new Exception("Problemas na leitura do arquivo.", excep);
        }

    }

    public static HashMap<String, Bibliotecario> openBibliotecario() throws Exception {
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
            throw new Exception("O arquivo não foi encontrado no sistema.", excep);
        } catch (ClassNotFoundException excep) {
            throw new Exception("Classe não encontrada.", excep);
        } catch (IOException excep) {
            throw new Exception("Problemas na leitura do arquivo.", excep);
        }

    }

    public static HashMap<String, Livro> openLivro() throws Exception {
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
            throw new Exception("O arquivo não foi encontrado no sistema.", excep);
        } catch (ClassNotFoundException excep) {
            throw new Exception("Classe não encontrada.", excep);
        } catch (IOException excep) {
            throw new Exception("Problemas na leitura do arquivo.", excep);
        }

    }

    public static HashMap<String, Emprestimo> openEmprestimo() throws Exception {
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
            throw new Exception("O arquivo não foi encontrado no sistema.", excep);
        } catch (ClassNotFoundException excep) {
            throw new Exception("Classe não encontrada.", excep);
        } catch (IOException excep) {
            throw new Exception("Problemas na leitura do arquivo.", excep);
        }

    }

    public static HashMap<String, FilaDeReserva> openFilaDeReserva() throws Exception {
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
            throw new Exception("O arquivo não foi encontrado no sistema.", excep);
        } catch (ClassNotFoundException excep) {
            throw new Exception("Classe não encontrada.", excep);
        } catch (IOException excep) {
            throw new Exception("Problemas na leitura do arquivo.", excep);
        }

    }

}
