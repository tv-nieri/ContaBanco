package com.tvn.dio.modelo;

public class Conta {
    private int numero;
    private String nomeCliente;
    private String agencia; //cada banco tem uma agência, para este exercício foi considerado que o usuário saberá sua agência para diversificar os exemplos.
    private double saldo;

    private static int NumeroContaDisponivel = 0;

    {
        // código default, será executado a cada criação de conta.
        // o número aqui informado deve bater com o número da conta criada.
        NumeroContaDisponivel++;
        System.out.println("Criando uma nova conta = " + NumeroContaDisponivel);
    }

    public Conta(String nome, String agencia) {
        this.numero = NumeroContaDisponivel;
        this.nomeCliente = nome;
        this.agencia = agencia;
    }

    public Conta (String nome, String agencia, double depositoInicial) {
        this.numero = NumeroContaDisponivel;
        this.nomeCliente = nome;
        this.agencia = agencia;
        this.saldo = depositoInicial;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNomeCliente(String nome) {
        this.nomeCliente = nome;
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public boolean deposita(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }
        return false;
    }

    public boolean saca(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transfere(Conta outraConta, double valor) {
        if (this.saldo >= valor && outraConta != null && valor > 0) {
            this.saldo -= valor;
            outraConta.deposita(valor);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Olá " + this.nomeCliente + ", obrigado por criar uma conta no nosso banco, "
                + "sua agência é " + this.getAgencia() + ", conta " + this.getNumero() + " e seu saldo de "
                + this.getSaldo() + " já está disponível para saque.";
    }

}
