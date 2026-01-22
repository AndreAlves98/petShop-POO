package RegraPetShop;

public class Agendamento {

    private String tutor;
    private String petEst;
    private String idade;
    private String data;
    private String hora;

    public Agendamento (String tutor, String petEst, String idade, String data, String hora) {
        this.tutor = tutor;
        this.petEst = petEst;
        this.idade = idade;
        this.data = data;
        this.hora = hora;
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


    public void setTutor(String tutor) { this.tutor = tutor; }

    public void setPetEst(String petEst) { this.petEst = petEst; }

    public void setIdade(String idade) { this.idade = idade; }

    public void setData(String data) { this.data = data; }

    public void setHora(String hora) { this.hora = hora; }



    // Comprovante

    public void exibirComprovante(int id) {
        System.out.println("\n-------------------------------------------");
        System.out.printf("ID: %d | TUTOR: %s\n", id, this.tutor, this.data, this.hora);
        System.out.println("NOME DO PET: " + this.petEst);
        System.out.println("IDADE: " + this.idade + " Anos");
        System.out.println("DATA: " + this.data);
        System.out.println("HORAS: " + this.hora);
        System.out.println("-------------------------------------------");
    }


    //Fim da Class Agendamento
}
