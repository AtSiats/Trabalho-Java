import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    public static void main(String[] args) {
        final double VALOR_BASE = 2000.00;
        String[] candidatos = { "Jim Carry","Steve Carell","Johnny Depp","Anthony Star","Chiristian Bale","Mark Ruffalo","Ryan Gyosling" };
        String[] aprovados = new String[5];
        int aprovadosCount = 0;
        for (int i = 0; i < candidatos.length; i++) {
            double valorPretendido = valorPretendido();
            if (VALOR_BASE >= valorPretendido && aprovadosCount < 5) {
                aprovados[aprovadosCount++] = candidatos[i];
                System.out.println("chamando candidatos" + candidatos[i]);
            } else if (VALOR_BASE == valorPretendido) {
                System.out.println("chamando candidatos " + candidatos[i] + " refazendo propostas");
            } else {
                System.out.println(candidatos[i] + " Aguardando os resusltados");
            }
        }
        System.out.println("\nCandidatos escolhidos:");
        for (int i = 0; i < aprovadosCount; i++) {
            System.out.println(aprovados[i]);
            int tentativas = 0;
            boolean contato = false;
            while (tentativas < 3 && !contato) {
                tentativas++;
                contato = ThreadLocalRandom.current().nextBoolean();
                if (contato) {
                    System.out.println("Foi aprovado o candidato " + aprovados[i] + " Após " + tentativas + " Tentativa(S)");
                }
            }
            if (!contato) {
                System.out.println("Não conseguimos contato com o candidato " + aprovados[i]);
            }
        }
    }
}