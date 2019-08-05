package sort;


public class MergeSort implements Sort{

    public int[] sort(int vetor[]) {

        //System.err.println("\t** MergeSort **");
        
        int inicio = 0;
        int fim = vetor.length - 1;
        
        int[] tag = new int [vetor.length];
        
        for (int i = 0; i < tag.length; i++){
            tag[i] = i;
        }

        mergeSort(inicio, fim, vetor, tag);

        return tag;
    }

    public void mergeSort(int inicio, int fim, int[] vetor, int[] tag) {

        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio, vetor, tag);
            mergeSort(meio + 1, fim, vetor, tag);
            merge(inicio, meio, fim, vetor, tag);
        }

    }

    public void merge(int inicio, int meio, int fim, int[] vetor, int[] tag) {

        //vetores para auxiliar as trocas
        int[] L = new int[meio - inicio + 1];
        int[] LAux = new int[meio - inicio + 1];
        
        int[] R = new int[fim - meio];
        int[] RAux = new int[fim - meio];

        int i, j;
        
        //inserindo os elementos nos vetores auxiliares: lado direito e esquerdo
        for (i = 0; i < L.length; i++) {
            L[i] = vetor[i + inicio];
            LAux[i] = tag[i + inicio];
        }
        for (i = 0; i < R.length; i++) {
            R[i] = vetor[i + meio + 1];
            RAux[i] = tag[i + meio + 1];
        }

        i = j = 0;

        for (int k = inicio; k <= fim; k++) {

            
            if (i >= L.length) {        // Caso todos os elementos de L tenham 
                vetor[k] = R[j];        // sido inseridos no vetor. Insira todos
                tag[k] = RAux[j];
                j++;                    // os elementos de R
                
            } else if (j >= R.length) {
                vetor[k] = L[i];
                tag[k] = LAux[i];
                i++;
                
            } else {
                if (L[i] <= R[j]) {             //*****************************
                    vetor[k] = L[i];            // Verifica qual o menor valor
                    tag[k] = LAux[i];
                    i++;                        // entre os elementos de L e R
                } else {                        // e o insere no vetor
                    vetor[k] = R[j];            //*****************************
                    tag[k] = RAux[j];
                    j++;
                }
            }

        }

    }
}