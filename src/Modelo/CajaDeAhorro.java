package Modelo;

public class CajaDeAhorro extends Cuenta{
    public CajaDeAhorro(int nroCuenta, String titular, double saldo, boolean estaHabilitada) {
        super(nroCuenta, titular, saldo, estaHabilitada);
    }

    public double getSaldoTotal(){
        return this.getSaldo();
    }
    public void retirarDinero(double monto){
        if(super.isEstaHabilitada()){
            if(super.validarMonto(monto)) {
                if (super.getSaldo() >= monto) {
                    double debitar = getSaldo() - monto;
                    super.setSaldo(debitar);
                    System.out.println("Dinero retirado correctamente! \n" + this.toString());
                } else {
                    System.out.println("No posee saldo suficiente \n"+ this.toString());
                }
            }
        } else {
            System.out.println("Error, la cuenta cuenta no está habilitada \n");
        }
    }

    @Override
    public void transferirDinero(Cuenta cuentaDestinatario, double monto) {
        if (super.isEstaHabilitada() && cuentaDestinatario.isEstaHabilitada()){
            if (super.validarMonto(monto)) {
                if ((this.getClass() != cuentaDestinatario.getClass()) && (!(getTitular().equals(cuentaDestinatario.getTitular())))) {
                    double montoConCargo = monto + (monto * 0.015);
                    if (this.getSaldo() >= montoConCargo) {
                        cuentaDestinatario.recibirTransferencia(monto);
                        double descontar = getSaldo() - montoConCargo;
                        setSaldo(descontar);
                        System.out.println("Transferencia enviada correctamente a la cuenta: "+ cuentaDestinatario.getNroCuenta() +
                                "\nSe envió: " + monto +
                                "\nCon un recargo de: " + (monto * 0.015) +
                                "\nTu saldo actual es: " + getSaldo() +
                                "\nTipo de transferencia: Caja de Ahorro a Cuenta Corriente");
                    } else {
                        System.out.println("No posee saldo suficiente para realizar la transferencia \n");
                    }
                } else {
                    if (this.getSaldo() >= monto) {
                        cuentaDestinatario.recibirTransferencia(monto);
                        double descontar = getSaldo() - monto;
                        setSaldo(descontar);
                        System.out.println("Transferencia enviada correctamente! " +
                                "\nSe envió: " + monto +
                                "\n"+this.toString()+ "\n");
                    } else {
                        System.out.println("No posee saldo suficiente para realizar la transferencia \n");
                    }
                }
            }
        } else if (!super.isEstaHabilitada()){
            System.out.println("Error la cuenta origen no esta habilitada \n");
        } else {
            System.out.println("Error la cuenta destino no esta habilitada \n");
        }
    }

    @Override
    public String toString() {
        return "Caja de Ahorro \n" + super.toString();
    }
}
