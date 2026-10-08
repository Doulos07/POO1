package ar.edu.unlp.info.oo1;

public class CuentaCorriente extends Cuenta{

    private double descubierto;

    public CuentaCorriente(){
        this.descubierto = 0;
    }

    public void setDescubierto (double limite){
        this.descubierto = limite;
    }

    public double getDescubierto() {
        return this.descubierto;
    }

    @Override
    public void depositar(double monto) {
        super.depositar(monto);
    }

    public boolean extraer (double monto){
        return super.extraer(monto);
    }

    @Override
    public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
        return super.transferirACuenta(monto, cuentaDestino);
    }


    @Override
    public boolean puedeExtraer(double monto) {
        return this.getSaldo() + this.getDescubierto() >= monto;
    }
}
