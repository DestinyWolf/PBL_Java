package util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * classe criada para facilitar a manipulação de datas*/
public class Data {
    private Integer dia;
    private Integer mes;
    private Integer ano;

    private final ArrayList<Integer> meses31dias = new ArrayList<>();

    /**Construtor da classe Data, atribui a data atual ao dia, mes e ano*/
    public Data() {
        this.dia = LocalDate.now().getDayOfMonth();
        this.mes = LocalDate.now().getMonthValue();
        this.ano = LocalDate.now().getYear();

        this.meses31dias.add(1);
        this.meses31dias.add(3);
        this.meses31dias.add(5);
        this.meses31dias.add(7);
        this.meses31dias.add(8);
        this.meses31dias.add(10);
        this.meses31dias.add(12);


    }

    /**
     * Construtor da classe Data
     * @param dia
     * @param mes
     * @param ano */
    public Data(Integer dia, Integer mes, Integer ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;

        if (this.dia > 31 && this.meses31dias.contains(this.mes)){
            this.mes +=1;
            this.dia -= 31;
        }

        else if (this.dia >28 && this.mes == 2 && this.ano%4 !=0) {
            this.mes +=1;
            this.dia -= 28;
        }
        else if (this.dia >29 && this.mes == 2 && this.ano%4 ==0) {
            this.mes +=1;
            this.dia -= 29;
        }
        else if (this.dia > 30) {
            this.mes +=1;
            this.dia -= 30;
        }

        this.meses31dias.add(1);
        this.meses31dias.add(3);
        this.meses31dias.add(5);
        this.meses31dias.add(7);
        this.meses31dias.add(8);
        this.meses31dias.add(10);
        this.meses31dias.add(12);


    }

    /**Metodo resposavel por retornar o ano
     * @return ano*/
    public Integer getAno() {
        return ano;
    }

    /**Metodo resposavel por retornar o mes
     * @return mes*/
    public Integer getMes() {
        return mes;
    }

    /**Metodo resposavel por retornar o dia
     * @return dia*/
    public Integer getDia() {
        return dia;
    }

    /**Metodo responsavel por settar o ano
     * @param ano */
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    /**Metodo responsavel por settar o dia
     * @param dia */
    public void setDia(Integer dia) {
        this.dia = dia;
    }

    /**Metodo responsavel por settar o mes
     * @param mes */
    public void setMes(Integer mes) {
            this.mes = mes;
    }

    /**Metodo responsavel por adicionar dias a data e calcular a nova data
     * @param qntDias */
    public  void addDia(Integer qntDias) {
        this.dia += qntDias;
        if (this.dia > 31 && this.meses31dias.contains(this.mes)){
            this.mes +=1;
            this.dia -= 31;
        }

        else if (this.dia >28 && this.mes == 2 && this.ano%4 !=0) {
            this.mes +=1;
            this.dia -= 28;
        }
        else if (this.dia >29 && this.mes == 2 && this.ano%4 ==0) {
            this.mes +=1;
            this.dia -= 29;
        }
        else if (this.dia > 30) {
            this.mes +=1;
            this.dia -= 30;
        }
    }

    /**Metodo responsavel por adicionar meses a data e calcular a nova data
     * @param qntMes */
    public void addMes(Integer qntMes) {
        this.mes += qntMes;

        if(this.mes > 12){
            this.ano += 1;
            this.mes -= 12;
        }
    }

    /**Metodo responsavel por adicionar anos a data e calcular a nova data
     * @param qntAno */
    public void addAno(Integer qntAno) {
        this.ano += ano;
    }

    /**Metodo responsavel por fazer a comparação entre duas datas
     * @param data
     * @return 1 se a data do parametro é menor que esta data, 2 se esta for menor e 0 se são iguais
     *  */
    public Integer compareData(Data data) {
        if(data.getDia() < this.getDia() || data.getMes() < this.getMes() || data.getAno() < this.getAno()){
            return 1;
        } else if (this.getDia() < data.getDia() || this.getMes() <data.getMes() || this.getAno() < data.getAno()) {
            return 2;
        } else {
            return 0;
        }
    }
}
