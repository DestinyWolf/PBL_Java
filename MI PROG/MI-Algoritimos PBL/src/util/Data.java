package util;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * <p>classe criada para facilitar a manipulação de <b>datas</b></p>*/
public class Data implements Serializable {
    private Integer dia;
    private Integer mes;
    private Integer ano;

    private final ArrayList<Integer> meses31dias = new ArrayList<>();

    /**<p>Construtor da classe Data, atribui a <b>data atual</b> aos atributos: <b>dia, mes , ano</b></p>*/
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
     * <p>Construtor da classe Data, permite a criação de uma data <b>especifica</b></p>
     * @param dia <b>Integer</b>
     * @param mes <b>Integer</b>
     * @param ano  <b>Integer</b>*/
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

    /**<p>Metodo resposavel por retornar o ano</p>
     * @return <b>Integer</b> - <i>ano</i>*/
    public Integer getAno() {
        return ano;
    }

    /**<p>Metodo resposavel por retornar o mes</p>
     * @return <b>Integer</b> - <i>mes</i>*/
    public Integer getMes() {
        return mes;
    }

    /**<p>Metodo resposavel por retornar o dia</p>
     * @return <b>Integer</b> - <i>dia</i> */
    public Integer getDia() {
        return dia;
    }

    /**<p>Metodo responsavel por settar o ano</p>
     * @param ano <b>Integer</b>*/
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    /**<p>Metodo responsavel por settar o dia</p>
     * @param dia <b>Integer</b>*/
    public void setDia(Integer dia) {
        this.dia = dia;
    }

    /**<p>Metodo responsavel por settar o mes</p>
     * @param mes <b>Integer</b>*/
    public void setMes(Integer mes) {
            this.mes = mes;
    }

    /**<p>Metodo responsavel por <b>adicionar dias</b> a data e calcular a nova data</p>
     * @param qntDias <b>Integer</b>*/
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

    /**<p>Metodo responsavel por <b>adicionar meses</b> a data e calcular a nova data</p>
     * @param qntMes  <b>Integer</b>*/
    public void addMes(Integer qntMes) {
        this.mes += qntMes;

        if(this.mes > 12){
            this.ano += 1;
            this.mes -= 12;
        }
    }

    /**<p>Metodo responsavel por <b>adicionar anos</b>a data e calcular a nova data</p>
     * @param qntAno <b>Integer</b>*/
    public void addAno(Integer qntAno) {
        this.ano += ano;
    }

    /**<p>Metodo responsavel por fazer a comparação entre duas datas</p>
     * @param data <b>Data</b>
     * @return <b>Integer</b> - <i><b>1</b> se a data do parametro é <b>menor</b> que esta data, <b>2</b> se for <b>maior</b>, <b>0  </b>se são <b>iguais</b></i>
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

    @Override
    public String toString() {
        return "Data: "+dia +'/'+mes+'/'+ano;
    }
}
