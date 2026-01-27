package RegraPetShop;

public class Agendamento {

    private String tutor;
    private String petEst;
    private String idade;
    private String data;
    private String hora;
    private String servico;
    private double valor;
    private String formaPagamento;

    public Agendamento (String tutor, String petEst, String idade, String data, String hora, String servico, double valor, String formaPagamento) {
        this.tutor = tutor;
        this.petEst = petEst;
        this.idade = idade;
        this.data = data;
        this.hora = hora;
        this.servico = servico;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }


    //Getters e Setters

    public String getTutor() {
        return tutor;
    }
    public String getPetEst() {
        return petEst;
    }
    public String getIdade() {
        return idade;
    }
    public String getdata() {
        return data;
    }
    public String gethora() {
        return hora;
    }
    public String getServico() { return servico; }
    public double getValor() { return valor; }
    public String getFormaPagamento() { return formaPagamento; }




    public void setTutor(String tutor) { this.tutor = tutor; }
    public void setPetEst(String petEst) { this.petEst = petEst; }
    public void setIdade(String idade) { this.idade = idade; }
    public void setData(String data) { this.data = data; }
    public void setHora(String hora) { this.hora = hora; }
    public void setServico (String servico) { this.servico = servico; }



    // Comprovante

    public void exibirComprovante(int id) {
        System.out.println("\n-------------------------------------------");
        System.out.printf("ID: %d\n", id, this.tutor, this.data, this.hora);
        System.out.println("TUTOR: " + this.tutor.toUpperCase());
        System.out.println("NOME DO PET: " + this.petEst.toUpperCase());
        System.out.println("IDADE: " + this.idade.toUpperCase() + " ANOS");
        System.out.println("DATA: " + this.data);
        System.out.println("HORAS: " + this.hora);
        System.out.println("SERVIÇO: " + this.servico.toUpperCase());
        System.out.println("PAGAMENTO: " + this.formaPagamento.toUpperCase());
        System.out.printf("VALOR TOTAL: R$ %.2f\n", this.valor);
        System.out.println("-------------------------------------------");
    }


    //Fim da Class Agendamento
}
