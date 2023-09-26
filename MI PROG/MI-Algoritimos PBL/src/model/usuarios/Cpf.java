package model.usuarios;

import static util.Constantes.cpfInvalido;
public class Cpf {
    private String cpf;

    public Cpf(){
        this.cpf = "";
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws Exception{
        int digt1 = 0;
        int digt2 = 0;
        String[] vetor = cpf.split("");
        for(int i =1; i< vetor.length-2; i++) {
            digt1 += (Integer.parseInt(vetor[i-1]) * i);
        }
        digt1 = digt1%11;
        if (digt1 == 10){
            digt1 = 0;
        }

        for(int i =0; i< vetor.length-1; i++) {
            digt2 += (Integer.parseInt(vetor[i]) * i);
        }
        digt2 = digt2%11;
        if (digt2 == 10){
            digt2 = 0;
        }

        if(digt1 == Integer.parseInt(vetor[9]) && digt1 == Integer.parseInt(vetor[10]))
            this.cpf = cpf;
        else {
            throw new Exception(cpfInvalido);
        }
    }
}
