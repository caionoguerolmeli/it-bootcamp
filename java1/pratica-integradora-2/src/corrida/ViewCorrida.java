package corrida;

import java.util.*;
import java.util.regex.Pattern;

public class ViewCorrida {

    private static ViewCorrida view;

    String option = "";
    int idNumber = 0;


    public static ViewCorrida getInstance() {
        if (view == null) {
            view = new ViewCorrida();
        }
        return view;
    }

    public ViewCorrida() {

    }

    public void start() {
        int optionInt = 0;
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("Escolha uma opcao abaixo");
            System.out.println("1 - Ver candidatos");
            System.out.println("2 - Inscrever novo participante");
            System.out.println("3 - Cancelar a inscricao de um participante");
            System.out.println("4 - Sair\n");

            option = s.next();
            if (this.isNumber(option)) {
                optionInt = Integer.valueOf(option);
                switch (optionInt) {
                    case 1:
                        this.showParticipants();
                        break;
                    case 2:
                        this.addInscription();
                        break;
                    case 3:
                        this.cancelInscription();
                        break;
                    default:
                        System.out.println("\nOpcao invalida\n");

                }
            } else {
                System.out.println("\nOpcao invalida\n");
            }


        } while (optionInt != 4);


    }

    private void cancelInscription() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("_____________________________");
            System.out.println("Insira o numero da inscricao que deseja cancelar");
            int idCancelado = s.nextInt();
            if (ControllerCorrida.getInstance().cancelInscription(idCancelado)) {
                System.out.println("\nParticipante removido\n");
            } else {
                System.out.println("\nParticipante não encontrado\n");
            }
        } catch (InputMismatchException e) {
            System.out.println("\nValor de inscricao invalido\n");
        }
    }

    private void addInscription() {
        Scanner s = new Scanner(System.in);
        System.out.println("_____________________________");
        try {
            System.out.println("Insira o rg - Apenas numeros");
            int rg = s.nextInt();
            System.out.println("Insira o nome");
            String name = s.next();
            System.out.println("Insira o sobrenome");
            String surname = s.next();
            System.out.println("Insira a idade - Apenas numeros");
            int age = s.nextInt();
            System.out.println("Insira o celular - Apenas numeros");
            long cellphone = s.nextLong();
            System.out.println("Insira o numero de emergencia - Apenas numeros");
            long emergencyphone = s.nextLong();
            System.out.println("Insira o grupo sanguineo");
            String bloodGroup = s.next();
            System.out.println("Escolha 1 para circuito pequeno, 2 para circuito medio, 3 para avancado");
            int circuitOption = s.nextInt();
            if (ControllerCorrida.getInstance().isCircuitOptionValid(circuitOption)) {
                int inscriptionValue = ControllerCorrida.getInstance().validateInscription(age, circuitOption);
                if (inscriptionValue != 0) {
                    idNumber = idNumber + 1;
                    Participant participant = new Participant(idNumber, rg, name, surname, age, cellphone, emergencyphone, bloodGroup, circuitOption, inscriptionValue);
                    if (ControllerCorrida.getInstance().validateData(participant)) {
                        ControllerCorrida.getInstance().addInscription(participant);
                        System.out.println("\nInscricao efetuada!\n");
                    } else {
                        throw new InputMismatchException();
                    }
                } else {
                    throw new Exception("\nNao é permitido menores de idade nessa modalidade!\n");
                }

            } else {
                throw new InputMismatchException();
            }

        } catch (InputMismatchException e) {
            System.out.println("\nDados incorretos, refaca a inscricao\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void showParticipants() {
        Scanner s = new Scanner(System.in);
        ArrayList<Participant> participantsToPrint = new ArrayList<>();

        try {
            System.out.println("Selecione uma das opcoes: \n1 - Circuito Pequeno\n2 - Circuito Medio\n3 - Circuito Avancado");
            int circuit = s.nextInt();
            if(circuit<4 && circuit>0){
                System.out.println("_____________________________");
                System.out.println("Lista de Participantes");
                HashMap<Integer, Participant> list = ControllerCorrida.getInstance().getList();
                if (list.isEmpty()) {
                    throw new Exception("\nLista de participantes vazia\n");
                }
                for (Map.Entry<Integer, Participant> entry : list.entrySet()) {
                    if (entry.getValue().getCircuit() == circuit) {
                        participantsToPrint.add(entry.getValue());
                    }

                }
                this.printParticipants(participantsToPrint);
            }else{
                throw new InputMismatchException();
            }


        }catch(InputMismatchException e){
            System.out.println("\nOpcao invalida\n");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void printParticipants(ArrayList<Participant> participantsToPrint) throws Exception {
        if (!participantsToPrint.isEmpty()) {
            for (Participant participant : participantsToPrint) {
                System.out.println("\nInscricao: " + participant.getIdNumber());
                System.out.println("RG: " + participant.getRg());
                System.out.println("Nome: " + participant.getName());
                System.out.println("Sobrenome: " + participant.getSurname());
                System.out.println("Idade: " + participant.getIdade());
                System.out.println("Celular: " + participant.getCellphone());
                System.out.println("Telefone de emergencia: " + participant.getEmergencyphone());
                System.out.println("Grupo Sanguineo: " + participant.getBloodGroup());
                System.out.println("Valor da inscricao (R$): " + participant.getInscriptionValue() + "\n");
            }
        } else {
            throw new Exception("\nLista de participantes vazia\n");
        }


    }

    private boolean isNumber(String value) {
        Pattern pattern;
        pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (value == null) {
            return false;
        }
        return pattern.matcher(value).matches();
    }

}