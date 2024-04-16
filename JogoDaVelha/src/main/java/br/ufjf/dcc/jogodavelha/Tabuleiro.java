/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.jogodavelha;

/**
 *
 * @author Lucas Chaves
 */
public class Tabuleiro {
    
    private char[][] tabuleiro;
    
    public Tabuleiro() {
        tabuleiro = new char[3][3];
        inicializarTabuleiro();
    }
    
    public void inicializarTabuleiro() {
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }
    
    public boolean jogadaValida(int linha, int coluna) {
        if (linha < 0 || linha >= 3 || coluna < 0 || coluna >= 3) {
            System.out.println("Posição inválida. Tente novamente.");
            return false;
        }
        if (tabuleiro[linha][coluna] != '-') {
            System.out.println("Essa posição já está ocupada. Tente novamente.");
            return false;
        }
        return true;
    }
    
    public void fazerJogada(int linha, int coluna, char jogador) {
        tabuleiro[linha][coluna] = jogador;
    }
    
    public boolean verificarVitoria(char jogadorAtual) {
        // Verifica linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) {
                return true;
            }
        }
        // Verifica colunas
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == jogadorAtual && tabuleiro[1][j] == jogadorAtual && tabuleiro[2][j] == jogadorAtual) {
                return true;
            }
        }
        // Verifica diagonais
        if ((tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) ||
                (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual)) {
            return true;
        }
        return false;
    }
    
    public boolean tabuleiroCompleto() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void imprimirTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }
}
