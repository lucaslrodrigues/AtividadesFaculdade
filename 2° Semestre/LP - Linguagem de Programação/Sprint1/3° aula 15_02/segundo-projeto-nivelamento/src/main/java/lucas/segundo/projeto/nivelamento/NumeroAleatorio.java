package lucas.segundo.projeto.nivelamento;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author aluno
 */
public class NumeroAleatorio {
    public static void main(String[] args) {
        // Da pra fazer utilizando esta classe
        // Math.random
        // mas precisa criar um objeto, como o scanner
        
        Integer numeroSorteado = 
                ThreadLocalRandom.current().nextInt(1, 101);
        
        System.out.println("Número sorteado: " + numeroSorteado);
        
        System.out.println("Número Double sorteado: "+ 
                ThreadLocalRandom.current().nextDouble(1.3, 54.7));
    }
}
