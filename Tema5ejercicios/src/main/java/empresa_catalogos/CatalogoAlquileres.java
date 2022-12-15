/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresa_catalogos;

/**
 *
 * @author jatierra
 */
public class CatalogoAlquileres {

    private int numeroAlquileres;

    private Alquiler[] listaAlquilers;

    public CatalogoAlquileres(int tamanio) {
        tamanio = Math.abs(tamanio);
        this.numeroAlquileres = 0;

        this.listaAlquilers = new Alquiler[tamanio];

    }

    @Override
    public String toString() {

        String tmp = "";

        for (Alquiler a : listaAlquilers) {
            if (a != null) {
                tmp += a.toString() + "\n";
            }

        }

        return tmp;
    }

    // para saber el numero clientes
    public int getNumeroClientes() {

        return numeroAlquileres;
    }

    // buscar un cliente
    private int buscarAlquiler(Alquiler c) {
        if (c != null) {

            for (int i = 0; i < listaAlquilers.length; i++) {
                if (this.listaAlquilers != null && c.equals(this.listaAlquilers[i])) {
                    /*Con esta condición controlo los null*/
                    return i;
                }
            }
        }

        return -1;

    }

    public void añadirAlquiler(Alquiler c) {

        if (this.numeroAlquileres < this.listaAlquilers.length) {
            for (int i = 0; i < this.listaAlquilers.length; i++) {
                if (this.listaAlquilers[i] == null) {
                    this.listaAlquilers[i] = c;
                    this.numeroAlquileres++;
                    break;

                }
            }

        } else {
            this.numeroAlquileres++;
            this.listaAlquilers = copiar();
            this.listaAlquilers[this.numeroAlquileres - 1] = c;
        }

    }

    // Metodo para copiar privado.
    private Alquiler[] copiar() {

        Alquiler[] aux = new Alquiler[this.listaAlquilers.length + 1];

        for (int i = 0; i < this.listaAlquilers.length; i++) {
            aux[i] = this.listaAlquilers[i];
        }

        return aux;
    }

    //borrar clientes
    public boolean borrarAlquiler(Alquiler c) {
        int posicion = buscarAlquiler(c);
        if (posicion >= 0) {

            this.listaAlquilers[posicion] = null;
            this.numeroAlquileres--;
            return true;
        }
        return false;
    }

    public Alquiler buscarAlquiler(int id) {
        //Sirve para crear un alquiler con datos aleatorios.
        Alquiler aux = new Alquiler();
        aux.setAlquilerID(id); //Para ponerle el id que yo busque.
        int posicion = buscarAlquiler(aux);

        return (posicion >= 0) ? this.listaAlquilers[posicion] : null;

    }

}
