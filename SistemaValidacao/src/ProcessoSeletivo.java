import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public static void main(String[] args) {
        System.out.println("Processo seletivo");
        String [] candidatos = {"Gabriel", "Julia", "Marcos", "Nicholas", "Diego"};
        for(String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                tentativasRealizadas++;
            } else 
                System.out.println("Contato realizado");
            }
        while(continuarTentando && tentativasRealizadas < 3);

        if(atendeu){
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa");
        } else 
            System.out.println("Não conseguimos candidatos com " + candidato);
    }

    static boolean atender() {
        return new Random().nextInt(3)==1;
    }
    static void imprimirSelecionados(){
        String [] candidatos = {"Gabriel", "Julia", "Marcos", "Nicholas", "Diego"};
        for(int indice = 0 ; indice < candidatos.length ; indice++){
            System.out.println("O candidato de numero " + (indice + 1) + " é " + candidatos[indice]);
        }

        System.out.println("Forma abreviada");
        for(String candidato: candidatos){
            System.out.println("Candidato selecionado " + candidato);
        }
    }

    static void selecionarCandidatos() {
        String [] candidatos = {"Gabriel", "Julia", "Marcos", "Nicholas", "Diego", "Maria", "João", "Bianca"};
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salario " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                candidatosSelecionados++;

            }
            candidatosAtual++;
        }
        System.out.println(candidatosSelecionados);

    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2100);
    }
    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para candidato com contra propostra");
        } else {
            System.out.println("Aguardando outros candidatos");
        }
    }
}
