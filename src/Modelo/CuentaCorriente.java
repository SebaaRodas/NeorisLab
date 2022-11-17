package Modelo;

public class CuentaCorriente extends Cuenta{
    private double saldoConDescubierto;

    public CuentaCorriente(int nroCuenta, String titular, double saldo, boolean estaHabilitada, double saldoConDescubierto) {
        super(nroCuenta, titular, saldo, estaHabilitada);
        this.saldoConDescubierto = saldoConDescubierto;
    }
    public CuentaCorriente(Cuenta cuenta, double monto){
        super(cuenta, monto);
    }
    public double getSaldoConDescubierto() {
        return super.getSaldo() + saldoConDescubierto;
    }
    public double getSaldoTotal(){
        return this.getSaldo()+this.saldoConDescubierto;
    }
    public void setSaldoConDescubierto(double saldoConDescubierto) {
        this.saldoConDescubierto = saldoConDescubierto;
    }


    public void transferirDinero(Cuenta cuentaDestinatario, double monto){
        if (this.isEstaHabilitada()&& cuentaDestinatario.isEstaHabilitada()) {
            if(validarMonto(monto)) {
                if ((this.getClass() != cuentaDestinatario.getClass()) && (!(getTitular().equals(cuentaDestinatario.getTitular())))) {
                    double montoConRecargo = monto + (monto * 0.03);
                    if (this.getSaldo() >= montoConRecargo) {
                        cuentaDestinatario.recibirTransferencia(monto);
                        double descontar = getSaldo() - montoConRecargo;
                        setSaldo(descontar);
                        System.out.println("Transferencia enviada correctamente a la cuenta: "+ cuentaDestinatario.getNroCuenta() +
                                "\nSe envió: " + monto +
                                "\nCon un recargo de: " + (monto * 0.03) +
                                "\nTu saldo actual es: " + getSaldo() +
                                "\nTipo de transferencia: Cuenta Corriente a Caja de Ahorro");
                    } else if (this.getSaldoConDescubierto() >= montoConRecargo) {
                        cuentaDestinatario.recibirTransferencia(monto);
                        double descontar = getSaldoConDescubierto() - montoConRecargo;
                        setSaldo(0);
                        setSaldoConDescubierto(descontar);
                        System.out.println("Transferencia enviada correctamente! " +
                                "\nSe envió: " + monto +
                                "\nCon un recargo de: " + (monto * 0.03) +
                                "\nTu saldo actual es: " + getSaldo() +
                                "\nTu saldo con descubierto es: " + getSaldoConDescubierto() +
                                "\nTipo de transferencia: Cuenta Corriente a Caja de Ahorro");
                    } else {
                        System.out.println("Error, no posee saldo suficiente para realizar la transferencia \n");
                    }
                } else {
                    if (this.getSaldo() >= monto) {
                        cuentaDestinatario.recibirTransferencia(monto);
                        double descontar = getSaldo() - monto;
                        setSaldo(descontar);
                        System.out.println("Transferencia enviada correctamente! " +
                                "\nSe envió: " + monto +
                                "\nTu saldo actual es: " + getSaldo() +
                                "\nTipo de transferencia: Cuenta Corriente a Cuenta Corriente");
                    } else if (this.getSaldoConDescubierto() >= monto) {
                        cuentaDestinatario.recibirTransferencia(monto);
                        double descontar = getSaldoConDescubierto() - monto;
                        setSaldo(0);
                        setSaldoConDescubierto(descontar);
                        System.out.println("Transferencia enviada correctamente! " +
                                "\nSe envió: " + monto +
                                "\nCon un recargo de: " + (monto * 0.03) +
                                "\nTu saldo actual es: " + getSaldo() +
                                "\nTu saldo con descubierto es: " + getSaldoConDescubierto() +
                                "\nTipo de transferencia: Cuenta Corriente a Caja de Ahorro");
                    } else {
                        System.out.println("No posee saldo suficiente para realizar la transferencia \n");
                    }
                }
            }
        } else if (!super.isEstaHabilitada()){
            System.out.println("Error tu cuenta no esta habilitada \n");
        } else {
            System.out.println("Error la cuenta destino no esta habilitada \n");
        }
    }
    @Override
    public void retirarDinero(double monto) {
        if(super.isEstaHabilitada()) {
            if (super.validarMonto(monto)) {
                if (super.getSaldo() >= monto) {
                    double debitar = getSaldo() - monto;
                    super.setSaldo(debitar);
                    System.out.println("Dinero retirado correctamente! \nTu saldo actual es de: " + getSaldo() + "\n");
                } else if (this.getSaldoConDescubierto() >= monto) {
                    double debitar = this.getSaldoConDescubierto() - monto;
                    super.setSaldo(0);
                    this.setSaldoConDescubierto(debitar);
                    System.out.println("Dinero retirado correctamente! " +
                            "\nTu saldo actual es de: " + this.getSaldo() +
                            "\nTu saldo con descubierto es de: "+this.getSaldoConDescubierto());
                } else {
                    System.out.println("No posee fondos suficientes ");
                }
            } else {
                System.out.println("Error, la cuenta no está habilitada");
            }
        } else {
            System.out.println("Error, la cuenta no está habilitada");
        }
    }
    @Override
    public String toString() {
        return "\nCuenta Corriente \n" + super.toString() + "\n- Saldo con descubierto: " + getSaldoConDescubierto();
    }


}
