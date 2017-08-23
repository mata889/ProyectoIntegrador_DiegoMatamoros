
package proyecto;

public abstract class Piezas {
    String tipo;

    public Piezas() {
    }

    public Piezas(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Piezas{" + "tipo=" + tipo + '}';
    }
    
    public abstract String[][] movimiento(String[][] matriz, int x, int y, int x2, int y2);
    public abstract String[][] comer();
}
