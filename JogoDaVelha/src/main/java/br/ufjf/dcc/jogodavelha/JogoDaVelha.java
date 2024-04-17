package br.ufjf.dcc.jogodavelha;

import java.util.Scanner;

/**
 *
 * @author Lucas Chaves
 */
public class JogoDaVelha {
    private Tabuleiro tabuleiro;
    private char jogadorAtual;

    public JogoDaVelha() {
        tabuleiro = new Tabuleiro();
        jogadorAtual = 'X';
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        int linha, coluna;

        do {
            tabuleiro.imprimirTabuleiro();
         
            System.out.println("Jogador " + jogadorAtual + ", é sua vez.");
            
            System.out.print("Digite a linha (1-3): ");
            linha = scanner.nextInt() - 1;
            
            System.out.print("Digite a coluna (1-3): ");
            coluna = scanner.nextInt() - 1;
        } while (!tabuleiro.jogadaValida(linha, coluna));

        tabuleiro.fazerJogada(linha, coluna, jogadorAtual);

        if (tabuleiro.verificarVitoria(jogadorAtual)) {
            System.out.println("Jogador " + jogadorAtual + " venceu!");
        } else if (tabuleiro.tabuleiroCompleto()) {
            System.out.println("O jogo terminou em empate!");
        } else {
            trocarJogador();
            jogar();
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
        JogoDaVelha jogo = new JogoDaVelha();
        System.out.println("Bem-vindo ao Jogo da Velha!");
        jogo.jogar();
    }
}
