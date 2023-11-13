public class Main {
    public static void main(String[] args) {
        ListaObj<Paciente> lista = new ListaObj<>(6);

        lista.adiciona(new Paciente(101, "Fabio Reis","Dor de garganta", false,65.7, 25));
        lista.adiciona(new Paciente(102, "Paula Souza","Gestante", true,57.7, 27));
        lista.adiciona(new Paciente(103, "Ana Teixeira","Dor de cabeca", false,56.0, 30));
        lista.adiciona(new Paciente(104, "Mario Silva","Febre alta", true, 70.5, 63));
        lista.adiciona(new Paciente(105, "Catia Miranda","Dor na lombar", false,61.4, 45));
        lista.adiciona(new Paciente(106, "Claudia Luz","Sinusite", false,55.5, 35));

        GerenciadorDeArquivos.gravaArquivoCsv(lista, "paciente.csv");
        GerenciadorDeArquivos.leArquivoCsv("paciente.csv");
    }
}
