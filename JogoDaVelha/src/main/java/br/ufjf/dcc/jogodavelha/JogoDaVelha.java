package br.ufjf.dcc.jogodavelha;

/**
 *
 * @author Lucas Chaves
 */
import java.util.Scanner;
import java.util.Random;

public class JogoDaVelha {
    private Tabuleiro tabuleiro;
    private char jogadorAtual;
    private boolean modoPvP;
    private Random rand;

    public JogoDaVelha(boolean modoPvP) {
        tabuleiro = new Tabuleiro();
        jogadorAtual = 'X';
        this.modoPvP = modoPvP;
        rand = new Random();
    }

    public void jogada() {
        Scanner scanner = new Scanner(System.in);
        int linha, coluna;

        if (modoPvP) {
            do {
                System.out.println("Jogador " + jogadorAtual + ", é sua vez.");
                tabuleiro.imprimirTabuleiro();
                System.out.print("Digite a linha (1-3): ");
                linha = scanner.nextInt() - 1;
                System.out.print("Digite a coluna (1-3): ");
                coluna = scanner.nextInt() - 1;
            } while (!tabuleiro.jogadaValida(linha, coluna, false));
            tabuleiro.fazerJogada(linha, coluna, jogadorAtual);
        } else {
            if (jogadorAtual == 'X') {
                do {
                    System.out.println("Jogador " + jogadorAtual + ", é sua vez.");
                    tabuleiro.imprimirTabuleiro();
                    System.out.print("Digite a linha (1-3): ");
                    linha = scanner.nextInt() - 1;
                    System.out.print("Digite a coluna (1-3): ");
                    coluna = scanner.nextInt() - 1;
                } while (!tabuleiro.jogadaValida(linha, coluna, false));
                tabuleiro.fazerJogada(linha, coluna, jogadorAtual);
            } else {
                do {
                    linha = rand.nextInt(3);
                    coluna = rand.nextInt(3);
                } while (!tabuleiro.jogadaValida(linha, coluna, true));
                tabuleiro.fazerJogada(linha, coluna, jogadorAtual);
                System.out.println("O computador jogou na posição: " + (linha + 1) + ", " + (coluna + 1));
            }
            //System.out.println("Work In Progress"); // Modo jogador vs computador
            //return;
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
        System.out.println("Escolha o modo de jogo:");
        System.out.println("0 - Jogador vs Jogador");
        System.out.println("1 - Jogador vs Computador");
        System.out.print("Modo: ");
        int modo = scanner.nextInt();
        boolean modoJogadorVsJogador = modo == 0;

        JogoDaVelha jogo = new JogoDaVelha(modoJogadorVsJogador);
        jogo.jogada();
    }
}

