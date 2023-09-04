package model.usuarios;
//package ProjetoPBL.Usuarios;

import ProjetoPBL.estoque.Livro;

public class Bibliotecario extends Pessoa{
    private String cargo;

    //set
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    //get
    public String getCargo() {
        return cargo;
    }


    public void emprestaLivro(Livro livro, Leitor leitor){
        //verifica se o id nao ta bloqueado, se nao tem mais de 3 livros 
        //verifica se o livro está emprestado
        if(livro.getEmprestado() == true && leitor.isBloqueio() == true){
           livro.setEmprestado(true);
        }
    }

    public void devolveLivro(Integer isbn, Integer id){
        //manda o atributo logico do emprestimo como falso
    }

}


}
