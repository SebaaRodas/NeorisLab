package Modelo;

public abstract class Cuenta implements Transferencia, Extraccion, Deposito{
    private int nroCuenta;
    private String titular;
    private double saldo;
    private boolean estaHabilitada;
    Cuenta cuentaDestinatario;
    double monto;
    private double saldoTotal;

    public Cuenta(int nroCuenta, String titular, double saldo, boolean estaHabilitada) {
        this.nroCuenta = nroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.estaHabilitada = estaHabilitada;
    }

    public Cuenta(Cuenta cuentaDestinatario, double monto) {
        this.cuentaDestinatario = cuentaDestinatario;
        this.monto = monto;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }
    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public boolean isEstaHabilitada() {
        return estaHabilitada;
    }
    public void setEstaHabilitada(boolean estaHabilitada) {
        if (estaHabilitada){
            this.estaHabilitada = true;
        } else {
            this.estaHabilitada = false;
        }
    }
    public Cuenta getCuenta() {
        return cuentaDestinatario;
    }
    public void setCuenta(Cuenta cuentaDestinatario) {
        this.cuentaDestinatario = cuentaDestinatario;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void recibirTransferencia(double monto){
        double montoRecibido = getSaldo() + monto;
        setSaldo(montoRecibido);
        System.out.println("Transferencia recibida correctamente! \n"+this.toString()+"\n");
    }
    public void depositarDinero(double monto){
        if(this.isEstaHabilitada()){
            if(validarMonto(monto)) {
                double depositar = getSaldo() + monto;
                this.setSaldo(depositar);
                System.out.println("Dinero depositado correctamente! Tu nuevo saldo disponible es de: " + getSaldo());
            }
        } else {
            System.out.println("Error, la cuenta no esta habilitada");
        }
    }
    public boolean validarMonto(double monto){
        if (monto > 0){
            return true;
        } else {
            System.out.println("No se puede utilizar numeros negativos \n");
            return false;
        }
    }
    @Override
    public String toString() {
        return "- Numero de cuenta: " + nroCuenta + "\n" +
                "- Titular: " + titular + "\n" +
                "- Saldo: " + saldo + "\n" +
                "- Cuenta habilitada: " + estaHabilitada;
    }
}
