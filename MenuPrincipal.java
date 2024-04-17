import javax.swing.JOptionPane;

public class MenuPrincipal {
    public static void main(String[] args) {
        while (true) {
            String escolha = JOptionPane.showInputDialog("Escolha uma opção:\n"
                    + "1 - Exercício 1\n"
                    + "2 - Exercício 2\n"
                    + "3 - Exercício 3\n"
                    + "4 - Exercício 4\n"
                    + "5 - Exercício Desafio\n"
                    + "6 - Sair");

            switch (escolha) {
                case "1":
                    executarExercicio1();
                    break;
                case "2":
                    executarExercicio2();
                    break;
                case "3":
                    executarExercicio3();
                    break;
                case "4":
                    executarExercicio4();
                    break;
                case "5":
                    executarExercicioDesafio();
                    break;
                case "6":
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    public static void executarExercicio1() {
        Automovel carro = new Automovel();
        carro.ligarMotor();
        String mensagem = "Estado do motor: " + (carro.isEstadoMotor() ? "Ligado" : "Desligado");
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static void executarExercicio2() {
        String marca = "Fiat";
        String modelo = "Palio";
        String cor = "Vermelho";
        int ano = 2020;
        Automovel carro = new Automovel(marca, modelo, cor, ano);
        String mensagem = "Estado do motor: " + (carro.isEstadoMotor() ? "Ligado" : "Desligado");
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static void executarExercicio3() {
        String marca = JOptionPane.showInputDialog("Digite a marca do automóvel:");
        String modelo = JOptionPane.showInputDialog("Digite o modelo do automóvel:");
        String cor = JOptionPane.showInputDialog("Digite a cor do automóvel:");
        int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do automóvel:"));
        Automovel carro = new Automovel(marca, modelo, cor, ano);
        String mensagem = "Automóvel cadastrado:\n"
                + "Marca: " + carro.getFabricante() + "\n"
                + "Modelo: " + carro.getModelo() + "\n"
                + "Cor: " + carro.getCor() + "\n"
                + "Ano: " + carro.getAno() + "\n"
                + "Estado do motor: " + (carro.isEstadoMotor() ? "Ligado" : "Desligado");
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static void executarExercicio4() {
        int numeroCarros = Integer.parseInt(JOptionPane.showInputDialog("Quantos carros deseja cadastrar?"));
        for (int i = 0; i < numeroCarros; i++) {
            String marca = JOptionPane.showInputDialog("Digite a marca do automóvel " + (i + 1) + ":");
            String modelo = JOptionPane.showInputDialog("Digite o modelo do automóvel " + (i + 1) + ":");
            String cor = JOptionPane.showInputDialog("Digite a cor do automóvel " + (i + 1) + ":");
            int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do automóvel " + (i + 1) + ":"));
            Automovel carro = new Automovel(marca, modelo, cor, ano);
            String mensagem = "Automóvel " + (i + 1) + " cadastrado:\n"
                    + "Marca: " + carro.getFabricante() + "\n"
                    + "Modelo: " + carro.getModelo() + "\n"
                    + "Cor: " + carro.getCor() + "\n"
                    + "Ano: " + carro.getAno() + "\n"
                    + "Estado do motor: " + (carro.isEstadoMotor() ? "Ligado" : "Desligado");
            JOptionPane.showMessageDialog(null, mensagem);
        }
    }

    public static void executarExercicioDesafio() {
        Figura quadrado = new Quadrado(5);
        Figura retangulo = new Retangulo(4, 6);
        Figura triangulo = new Triangulo(3, 4);

        String mensagem = "Áreas das figuras:\n"
                + "Quadrado: " + quadrado.calcularArea() + "\n"
                + "Retângulo: " + retangulo.calcularArea() + "\n"
                + "Triângulo: " + triangulo.calcularArea();
        JOptionPane.showMessageDialog(null, mensagem);
    }
}

abstract class Figura {
    abstract double calcularArea();
}

class Quadrado extends Figura {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    @Override
    double calcularArea() {
        return lado * lado;
    }
}

class Retangulo extends Figura {
    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    double calcularArea() {
        return base * altura;
    }
}

class Triangulo extends Figura {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    double calcularArea() {
        return (base * altura) / 2;
    }
}

class Automovel {
    private String fabricante;
    private String modelo;
    private String cor;
    private int ano;
    private boolean estadoMotor;

    public Automovel() {
        // Construtor padrão
    }

    public Automovel(String fabricante, String modelo, String cor, int ano) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public int getAno() {
        return ano;
    }

    public boolean isEstadoMotor() {
        return estadoMotor;
    }

    public void ligarMotor() {
        estadoMotor = true;
    }
}
