package ar.edu.unlp.info.oo1;

public class CajaDeAhorro extends Cuenta{

    @Override
    public void depositar(double monto) {
        super.depositar(monto - (monto * 0.02));
    }

    public boolean extraer (double monto){
        return super.extraer(monto);
    }

    @Override
    public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
        return super.transferirACuenta(monto , cuentaDestino);
    }

    @Override
    protected void extraerSinControlar(double monto) {
        super.extraerSinControlar(monto * 1.02);
    }

    @Override
    public boolean puedeExtraer(double monto) {
        return this.getSaldo() >= (monto * 1.02);
    }
}
