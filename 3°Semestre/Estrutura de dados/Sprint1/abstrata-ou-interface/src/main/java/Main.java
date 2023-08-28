public class Main {
    public static void main(String[] args) {
        Professor professor = new Professor("Lucas", "0101010101", 20, 10.0);
        Coordenador coordenador = new Coordenador("Josias", "0101010101", 20, 10.0, 2);
        Secretaria secretaria = new Secretaria("joaquina", "01010101", 1800.00, 200.00);

        System.out.println(professor.calcularSalario());
        System.out.println(professor.receberBonus());
        System.out.println(coordenador.calcularSalario());
        System.out.println(coordenador.receberBonus());
        System.out.println(secretaria.calcularSalario());
    }
}