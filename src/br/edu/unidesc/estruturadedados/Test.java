package br.edu.unidesc.estruturadedados;

public class Test {

    public static void main(String[] args) throws Exception {

        Arvore arv = new Arvore();

        arv.insertar(10);
        arv.insertar(20);
        arv.insertar(25);
        arv.insertar(16);
        arv.insertar(6);
        arv.insertar(1);

        arv.mostrar();
        System.out.println("------NÓ REMOVIDO------");

        arv.remover(20);
        arv.mostrar();

    }
}