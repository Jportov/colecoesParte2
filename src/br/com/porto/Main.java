package br.com.porto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Listas para armazenar os nomes por sexo
        List<String> masculinos = new ArrayList<>();
        List<String> femininos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        // Variável para continuar pedindo entradas
        String continuar = "";

        do {
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o sexo (M/F): ");
            String sexo = scanner.nextLine().toUpperCase();  // Converter para maiúsculo para evitar problemas de case

            // Adiciona o nome na lista correta
            if (sexo.equals("M")) {
                masculinos.add(nome);
            } else if (sexo.equals("F")) {
                femininos.add(nome);
            } else {
                System.out.println("Sexo inválido. Tente novamente.");
                continue;
            }

            // Pergunta se o usuário deseja continuar
            System.out.print("Deseja adicionar outro nome? (S/N): ");
            continuar = scanner.nextLine().toUpperCase();

        } while (continuar.equals("S"));

        scanner.close();

        // Exibir os resultados
        System.out.println("\nNomes masculinos: " + String.join(", ", masculinos));
        System.out.println("Nomes femininos: " + String.join(", ", femininos));
    }
}
