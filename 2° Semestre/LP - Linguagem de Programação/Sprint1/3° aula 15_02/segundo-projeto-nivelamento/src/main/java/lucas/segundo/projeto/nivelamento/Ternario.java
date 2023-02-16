/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.segundo.projeto.nivelamento;

/**
 *
 * @author aluno
 */
public class Ternario {
    public static void main(String[] args) {
        Boolean bloqueado = true;
        
        String frase;
        if (bloqueado) {
            frase = "Usuário bloqueado";
        } else {
            frase = "Usuário desbloqueado";
        }
        
        System.out.println(frase);
        
        // Operador ternario
        frase = bloqueado ? "Usuário bloqueado" : "Usuário desbloqueado";
        
        // Não serve somente para booleanos
        // Cenário: se o salario for maior que 1000,00 o bonus sera de 0,5
        // se for menor que 1000,00 o bonus sera de 0,2
        
        Double salario = 1075.0;
        Double bonus = 0.0;
        
        if (salario > 1000.0) {
            bonus = 0.5;
        } else {
            bonus = 0.2;
        }
        
        bonus = salario > 1000.0 ? 0.5 : 0.2;
    }
}
