package br.ufjf.dcc.jogodavelha;

import java.util.Scanner;

/**
 *
 * @author Lucas Chaves
 */
public class JogoDaVelha {
    private Tabuleiro tabuleiro;
    private char jogadorAtual;
    private boolean modoPvP;

    public JogoDaVelha(boolean modoPvP) {
        tabuleiro = new Tabuleiro();
        jogadorAtual = 'X';
        this.modoPvP = modoPvP;
    }

    public void jogada() {
        Scanner scanner = new Scanner(System.in);
        int linha, coluna;

        if(modoPvP) {
            do {
            tabuleiro.imprimirTabuleiro();
         
            System.out.println("Jogador " + jogadorAtual + ", é sua vez.");
            
            System.out.print("Digite a linha (1-3): ");
            linha = scanner.nextInt() - 1;
            
            System.out.print("Digite a coluna (1-3): ");
            coluna = scanner.nextInt() - 1;
            } while (!tabuleiro.jogadaValida(linha, coluna));

            tabuleiro.fazerJogada(linha, coluna, jogadorAtual);
        } else {
            System.out.println("WIP");
            return;
        }

        if (tabuleiro.verificarVitoria(jogadorAtual)) {
            System.out.println("Jogador " + jogadorAtual + " venceu!");
        } else if (tabuleiro.tabuleiroCompleto()) {
            System.out.println("O jogo terminou em empate!");
        } else {
            trocarJogador();
            jogada();
        }
    }

    private void trocarJogador() {
        if (jogadorAtual == 'X') {
            jogadorAtual = 'O';
        } else {
            jogadorAtual = 'X';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bem-vindo ao Jogo da Velha!");
        System.out.println("Escolha o Modo de Jogo:");
        System.out.println("0 - Jogador vs Jogador");
        System.out.println("1 - Jogador vs Computador");
        System.out.print("Modo: ");
        int modoInt = scanner.nextInt();
        boolean modoPvP = modoInt == 0;
        
        JogoDaVelha jogo = new JogoDaVelha(modoPvP);
        jogo.jogada();
    }
}
