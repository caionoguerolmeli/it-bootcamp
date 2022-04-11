package corrida;

public class Participant {
    private int inscriptionValue;
    private int circuit;
    private int idNumber;
    private int rg;
    private String name = "";
    private String surname = "";
    private int idade;
    private long cellphone;
    private long emergencyphone;
    private String bloodGroup = "";

    public Participant(int idNumber, int rg, String name, String surname, int idade, long cellphone, long emergencyphone, String bloodGroup, int circuit, int inscriptionValue) {
        this.setIdNumber(idNumber);
        this.setRg(rg);
        this.setCellphone(cellphone);
        this.setEmergencyphone(emergencyphone);
        this.setName(name);
        this.setSurname(surname);
        this.setBloodGroup(bloodGroup);
        this.setIdade(idade);
        this.setInscriptionValue(inscriptionValue);
        this.setCircuit(circuit);
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getCircuit() {
        return circuit;
    }

    public void setCircuit(int circuit) {
        this.circuit = circuit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getCellphone() {
        return cellphone;
    }

    public void setCellphone(long cellphone) {
        this.cellphone = cellphone;
    }

    public long getEmergencyphone() {
        return emergencyphone;
    }

    public void setEmergencyphone(long emergencyphone) {
        this.emergencyphone = emergencyphone;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getInscriptionValue() {
        return inscriptionValue;
    }

    public void setInscriptionValue(int inscriptionValue) {
        this.inscriptionValue = inscriptionValue;
    }
}
