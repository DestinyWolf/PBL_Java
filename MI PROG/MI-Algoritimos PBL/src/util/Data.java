package util;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * classe criada para facilitar a manipulação de datas*/
public class Data {
    private Integer dia;
    private Integer mes;
    private Integer ano;

    private final ArrayList<Integer> meses31dias = new ArrayList<>();

    public Data(Integer dia, Integer mes, Integer ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;

        this.meses31dias.add(1);
        this.meses31dias.add(3);
        this.meses31dias.add(5);
        this.meses31dias.add(7);
        this.meses31dias.add(8);
        this.meses31dias.add(10);
        this.meses31dias.add(12);


    }

    /**
     * @return ano*/
    public Integer getAno() {
        return ano;
    }

    public Integer getMes() {
        return mes;
    }

    public Integer getDia() {
        return dia;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public void setMes(Integer mes) {
            this.mes = mes;
    }

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

    public void addMes(Integer qntMes) {
        this.mes += qntMes;

        if(this.mes > 12){
            this.ano += 1;
            this.mes -= 12;
        }
    }

    public void addAno(Integer qntAno) {
        this.ano += ano;
    }
}
