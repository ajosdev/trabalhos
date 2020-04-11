class Matrix {
    private Celula indice;
    private int linha, coluna;

    public Matrix() throws Exception {
        this.linha = 3;
        this.coluna = 3;
    }

    public void Matriz_c(int linha, int coluna) throws Exception {
        if (linha <= 0 || coluna <= 0)
            throw new Exeception("erro");

        this.linha = linha;
        this.coluna = coluna;

        this.indice = new Celula();
        Celula tmp = this.indice;

        for (int i = 0; i < coluna - 1; i++) {
            tmp.dir = new Celula();
            tmp = tmp.dir;
        }

        tmp = indice;

        for (int j = 0; j < linha - 1; j++) {

            Celula aux = tmp;
            Celula aux2 = new Celula();
            aux.inf = aux2;
            aux2.sup = aux;

            for (int z = 0; z < coluna - 1; z++) {

                aux2.dir = new Celula();
                aux2.dir.esq = aux2;
                aux.dir.esq = aux;
                aux = aux.dir;
                aux2 = aux2.dir;
                aux.inf = aux2;
                aux2.sup = aux;

            }
            tmp = tmp.inf;

        }

    }

    public void mostrar() {
        Celula l = this.indice;
        for (int i = 0; i < linha; i++) {
            Celula c = l;
            for (int j = 0; j < coluna; j++) {
                System.out.print(c.elemento + " ");
                c = c.dir;
            }
            System.out.println("");
            l = l.inf;
        }
    }

}

// public class newMatriz {
// public static void main(String[] args) throws Exception {
// Matrix m = new Matrix();
// m.Matriz_c(3, 3);
// m.mostrar();
// }
// }
