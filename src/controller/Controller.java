package controller;

import infra.CRUD;
import infra.TXT;
import sort.MergeSort;
import sort.Sort;

public class Controller {

    public static String gerFile(String path) {
        CRUD crud = TXT.getInstance();
        return crud.ler(path);
    }

    public static String sort(String data) {

        Sort sort = new MergeSort();

        String[] aux = data.split("\r\n");
        String[] novo;          // novo array com o conteúdo ordenado

                                //  vetor com numeros inteiros contendo os
        int[] list = null;      //  valores do arquivo ou o inteiro
                                //  representante da tabela ascii de cada caractere

        /*****************************************
        * Verifica se o conteúdo é letra ou número
        *******************************************/

        if (isStr(data)) {
            list = strToChar(aux);
        } else if (Character.isDigit(data.charAt(0))) {
            list = strToInt(aux);
        } else {
            return "conteúdo inválido";
        }

        novo = recover(aux, sort.sort(list));   //insere conteudo ordenado
        //  show(novo);                         //exibe no console

        return concatenate(novo);               //  retorna uma unica string
    }

    private static boolean isStr(String data) {

        char charac = data.charAt(0);    //captura primeiro caractere da String

        //converte para letra minúcula (se for o caso)
        charac = Character.toLowerCase(charac);

        return charac >= 97 && charac <= 122;
    }

    private static int[] strToChar(String[] list) {

        int[] vetor = new int[list.length];
        char charac;

        /*********************************************
         * Passa o primeiro caractere de cada palavra
         *    para um inteiro e add na lista
         ********************************************/
        for (int i = 0; i < list.length; i++) {

          //captura primeiro caractere da String
            charac = list[i].toCharArray()[0];
            vetor[i] = Character.toLowerCase(charac);
        }

        return vetor;
    }

    private static int[] strToInt(String[] list) {

        int[] vetor = new int[list.length];

        /*********************************************
         * Converte o valor da string para inteiro
        **********************************************/
        try {

            for (int i = 0; i < list.length; i++) {
                vetor[i] = Integer.parseInt(list[i]);
            }

        } catch (NumberFormatException err) {
            System.err.println("Erro ao converter String para int");
        }

        return vetor;
    }

    /******************************************
    * Exibe o vetor no console
    *******************************************/
    private static void show(String[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    /***********************************************************
     * A funcao deve receber o vetor original e o
     * vetor que contem as tags de cada posicao (ordenado)
     * será retornado um novo vetor, ordenado por nome ou numero
     ************************************************************/

    private static String[] recover(String[] original, int[] tag) {

        String[] novo = new String[original.length];

        int pos;

        for (int i = 0; i < original.length; i++) {
            pos = tag[i];               // valor ordenado da proxima posição
            novo[i] = original[pos];    //valor ordenado
        }

        return novo;

    }

    private static String concatenate(String[] data) {
        String str = "";
        for (int i = 0; i < data.length; i++) {
            str += data[i] + "\r\n";
        }
        return str;
    }
}
