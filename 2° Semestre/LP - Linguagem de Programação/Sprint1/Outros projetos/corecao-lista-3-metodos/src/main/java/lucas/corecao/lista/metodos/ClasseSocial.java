/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.corecao.lista.metodos;

/**
 *
 * @author lukas
 */
public class ClasseSocial {
    Double calcularQtdSalMin (Double renda){
        Double qtdSalario = renda / 1045;
        return qtdSalario;
    }
    
    Double calcularQtdSalMin (Double renda, Double salarioMin){
        return renda / salarioMin;
    }
    String definirClasse (Double qtdSalario){
        String classe = "";
        
        if (qtdSalario > 20){
            classe = "A";
        }else if (qtdSalario >= 10 && qtdSalario <= 20){
            classe = "B";
        }else if (qtdSalario >= 4 && qtdSalario < 10){
            classe = "C";
        }else if (qtdSalario >= 2 && qtdSalario < 4){
            classe = "E";
        }else {
            classe = "E";
        }
        return classe;
    }
    
    void exibirRelatorioClasseSocial(Double qtdSalario, String classeSocial){
        System.out.println(String.format("Você recebe aproximadamente %.1f"
         + " salários minimos.", qtdSalario));
        
        System.out.println(String.format ("Você pertence a classe socia"
                + " %s.", classeSocial));
    }
    
    void exibirRelatorioClasseSocial(Double renda){
        Double qtdSalario = calcularQtdSalMin(renda);
        String classeSocial = definirClasse(qtdSalario);
        
        
    System.out.println(String.format("Você recebe aproximadamente %.1f"
     + " salários minimos.", qtdSalario));

    System.out.println(String.format ("Você pertence a classe socia"
            + " %s.", classeSocial));
    }
}
