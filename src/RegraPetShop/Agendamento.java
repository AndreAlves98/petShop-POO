package RegraPetShop;

public class Agendamento {

    private String tutor;
    private String petEst;
    private String idade;

    public Agendamento (String tutor, String petEst, String idade) {
        this.tutor = tutor;
        this.petEst = petEst;
        this.idade = idade;
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

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public void setPetEst(String petEst) {
        this.petEst = petEst;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }


    // Comprovante

    public void exibirComprovante(int id) {
        System.out.println("\n-------------------------------------------");
        System.out.printf("ID: %d | TUTOR: %s\n", id, this.tutor);
        System.out.println("NOME DO PET: " + this.petEst);
        System.out.println("IDADE: " + this.idade + " Anos");
        System.out.println("-------------------------------------------");
    }


    //Fim da Class Agendamento
}
