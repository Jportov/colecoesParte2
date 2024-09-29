package br.com.porto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    // Classe interna para representar uma Pessoa
    static class Pessoa {
        private String nome;
        private String sexo;

        public Pessoa(String nome, String sexo) {
            this.nome = nome;
            this.sexo = sexo;
        }

        public String getNome() {
            return nome;
        }

        public String getSexo() {
            return sexo;
        }

        @Override
        public String toString() {
            return nome + " (" + sexo + ")";
        }
    }

    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String continuar = "";

        do {
            System.out.print("Digite o nome e sexo separados por espaço e vírgula (Ex: Maria, F): ");
            String entrada = scanner.nextLine();

            // Divide a entrada pelo espaço e vírgula
            String[] dados = entrada.split(",\\s*");
            if (dados.length != 2) {
                System.out.println("Entrada inválida. Tente novamente.");
                continue;
            }

            String nome = dados[0];
            String sexo = dados[1].toUpperCase(); // Converter para maiúsculo para evitar problemas de case

            if (!sexo.equals("M") && !sexo.equals("F")) {
                System.out.println("Sexo inválido. Tente novamente.");
                continue;
            }

            // Adiciona a nova pessoa à lista
            pessoas.add(new Pessoa(nome, sexo));

            // Pergunta se o usuário deseja continuar
            System.out.print("Deseja adicionar outro nome? (S/N): ");
            continuar = scanner.nextLine().toUpperCase();

        } while (continuar.equals("S"));

        scanner.close();

        // Filtrar apenas as mulheres (sexo == "F") usando lambda e streams
        List<Pessoa> mulheres = pessoas.stream()
                .filter(pessoa -> pessoa.getSexo().equals("F"))
                .collect(Collectors.toList());

        // Exibir os resultados
        System.out.println("\nLista de todas as pessoas: ");
        pessoas.forEach(System.out::println);

        System.out.println("\nLista apenas com mulheres: ");
        mulheres.forEach(System.out::println);
    }
}
