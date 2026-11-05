package ar.edu.unlp.info.oo1;

public class ClienteEmpresarial extends Cliente {

    private int cuit;

    public ClienteEmpresarial (String nombre, String direccion, int cuit) {
        super(nombre, direccion);
        this.cuit = cuit;
    }
}
