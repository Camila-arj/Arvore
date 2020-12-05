package br.edu.unidesc.estruturadedados;

public class Arvore {

    public No raiz_principal;

    public Arvore(){
        this.raiz_principal = null;
    }

    //Insertar com recursividade

    public void insertar(int valor) {

        raiz_principal = insertarRecursivo(raiz_principal, valor);
    }

    private No insertarRecursivo(No novo_raiz, int valor){

        if (novo_raiz == null) {
            return new No(valor);
        }else{
            if (valor < novo_raiz.valor) {
                novo_raiz.esq = insertarRecursivo(novo_raiz.esq, valor);
            } else {
                novo_raiz.dir = insertarRecursivo(novo_raiz.dir, valor);
            }
        }
        return novo_raiz;
    }

    //Metodo Mostrar Arvore

    public void mostrar() {
        mostrarRecursivo(raiz_principal, 0);
    }

    private void mostrarRecursivo(No novo_raiz, int cont){

        if (novo_raiz == null) {
            return;
        }else{
            mostrarRecursivo(novo_raiz.dir, cont + 1);

            for(int i = 0; i < cont; i++){
                System.out.print("   ");
            }

            System.out.println(novo_raiz.valor);
            mostrarRecursivo(novo_raiz.esq, cont + 1);
        }
    }

    //Metodo Remover

    public void remover(int valor) {
        raiz_principal = removerRecursivo(raiz_principal, valor);
    }

    private No removerRecursivo(No novo_raiz, int valor){

        if (novo_raiz == null){
            return null;
        }else{
            if (valor == novo_raiz.valor){
                if (novo_raiz.dir == null && novo_raiz.esq == null){
                    novo_raiz = null;
                }else if (novo_raiz.dir == null || novo_raiz.esq == null){
                    if (novo_raiz.dir != null){
                        novo_raiz = novo_raiz.dir;
                    }
                    if (novo_raiz.esq != null){
                        novo_raiz = novo_raiz.esq;
                    }
                }else{
                    int minValor = minValor(novo_raiz.dir);
                    novo_raiz.valor = minValor;
                    novo_raiz.dir = removerRecursivo(novo_raiz.dir, minValor);
                }
            }else if (valor < novo_raiz.valor){
                novo_raiz.esq = removerRecursivo(novo_raiz.esq, valor);
            }else {
                novo_raiz.dir = removerRecursivo(novo_raiz.dir, valor);
            }
        }
        return  novo_raiz;
    }

    private int minValor(No node) {

        if (node.esq != null){
            return minValor(node.esq);
        }
        return node.valor;
    }
}
