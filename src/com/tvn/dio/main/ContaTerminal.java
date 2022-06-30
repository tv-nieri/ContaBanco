package com.tvn.dio.main;

import java.util.Scanner;

import com.tvn.dio.modelo.Conta;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double depositoInicial = 0.0;

        System.out.println("====== BEM VINDO AO BANCO DIO ======");
        System.out.println("Vamos criar a sua conta...");

        System.out.print("Digite o seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite a agência desejada: ");
        String agencia = sc.nextLine();

        System.out.println("Deseja fazer um depósito inicial? S/N");
        String resp = sc.next();
        if (resp.toUpperCase().equals("S")) {
            System.out.print("Digite o valor do depósito: ");
            depositoInicial = sc.nextDouble(); 
            if (depositoInicial <= 0) {
                System.out.println("O valor informado é inválido. 0.0 Será considerado.");
                depositoInicial = 0.0;
            }
        }

        Conta c1 = new Conta(nome, agencia, depositoInicial);
        System.out.println(c1);
        System.out.println();
    }
}
