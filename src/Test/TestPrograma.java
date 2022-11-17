package Test;

import Modelo.CajaDeAhorro;
import Modelo.Cuenta;
import Modelo.CuentaCorriente;
import Modelo.ListaCuentas;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestPrograma {

    @Test
    public void retirar_dinero_CA_exitoso() {
        CajaDeAhorro cuentaSeba = new CajaDeAhorro(22,"Sebastian Rodas",5000, true);
        cuentaSeba.retirarDinero(3000);
        assertEquals(2000, cuentaSeba.getSaldo());
    }
    @Test
    public void retirar_dinero_CA_denegado_fondo_insuficiente(){
        Cuenta cuentaSanti = new CajaDeAhorro(01,"Santiago Sosa", 1000, true);
        cuentaSanti.retirarDinero(3000);
        assertEquals(1000, cuentaSanti.getSaldo());
    }
    @Test
    public void retirar_dinero_CA_cuenta_no_habilitada(){
        Cuenta cuentaJose = new CajaDeAhorro(02,"Jose Fernandez", 5000, false);
        cuentaJose.retirarDinero(3000);
        assertEquals(5000, cuentaJose.getSaldo());
    }
    @Test
    public void retirar_dinero_CA_ingresa_numero_negativo(){
        Cuenta cuentaSofia = new CajaDeAhorro(03,"Sofia Snead", 10000, true);
        cuentaSofia.retirarDinero(-3000);
        assertEquals(10000, cuentaSofia.getSaldo());
    }
    @Test
    public void retirar_dinero_CC_exitoso(){
        Cuenta cuentaSanti = new CuentaCorriente(04,"Santiago Sosa", 1000, true,500);
        cuentaSanti.retirarDinero(1000);
        assertEquals(0, cuentaSanti.getSaldo());
    }
    @Test
    public void retirar_dinero_CC_saldo_con_descubierto_exitoso(){
        Cuenta cuentaRomina = new CuentaCorriente(05,"Romina Rojas", 1000, true,500);
        cuentaRomina.retirarDinero(1200);
        assertEquals(300, ((CuentaCorriente) cuentaRomina).getSaldoConDescubierto());
    }
    @Test
    public void retirar_dinero_CC_denegado_fondo_insuficiente(){
        Cuenta cuentaSanti = new CuentaCorriente(06,"Carlos Gomez", 20000, true,5000);
        cuentaSanti.retirarDinero(30000);
        assertEquals(25000, ((CuentaCorriente) cuentaSanti).getSaldoConDescubierto());
    }
    @Test
    public void retirar_dinero_CC_cuenta_no_habilitada(){
        Cuenta cuentaJose = new CuentaCorriente(07,"Jose Fernandez", 5000, false, 2000);
        cuentaJose.retirarDinero(3000);
        assertEquals(5000, cuentaJose.getSaldo());
    }
    @Test
    public void retirar_dinero_CC_ingresa_numero_negativo(){
        Cuenta cuentaSofia = new CajaDeAhorro(8,"Sofia Rodas", 12000, true);
        cuentaSofia.retirarDinero(-5000);
        assertEquals(12000, cuentaSofia.getSaldo());
    }
    @Test
    public void depositar_dinero_CA_exitoso(){
        Cuenta cuentaSandra = new CajaDeAhorro(9,"Sandra Ramirez", 6000,true);
        cuentaSandra.depositarDinero(5000);
        assertEquals(11000, cuentaSandra.getSaldo());
    }
    @Test
    public void depositar_dinero_CA_cuenta_no_habilitada(){
        Cuenta cuentaRamon = new CajaDeAhorro(10,"Ramon Romero",3500,false);
        cuentaRamon.depositarDinero(2000);
        assertEquals(3500, cuentaRamon.getSaldo());
    }
    @Test
    public void depositar_dinero_CC_exitoso(){
        Cuenta cuentaPablo = new CuentaCorriente(11,"Pablo Lopez",3600,true,1000);
        cuentaPablo.depositarDinero(2400);
        assertEquals(6000, cuentaPablo.getSaldo());
    }
    @Test
    public void depositar_dinero_CC_cuenta_no_habilitada(){
        Cuenta cuentaMicaela = new CuentaCorriente(12,"Micaela Perez",2500,false,1000);
        cuentaMicaela.depositarDinero(3000);
        assertEquals(2500, cuentaMicaela.getSaldo());
    }
    @Test
    public void tranferencia_CA_a_CC_exitosa(){
        Cuenta cuentaRodrigo=new CajaDeAhorro(13,"Rodrigo Gimenez",10000,true);
        Cuenta cuentaMicaela = new CuentaCorriente(12,"Micaela Perez",2500,true,1000);
        cuentaRodrigo.transferirDinero(cuentaMicaela,5000);
        assertEquals(4925,cuentaRodrigo.getSaldo());
        assertEquals(7500,cuentaMicaela.getSaldo());
    }
    @Test
    public void tranferencia_CA_a_CA_exitosa(){
        Cuenta cuentaJose=new CajaDeAhorro(14,"Jose Gomez",8000,true);
        Cuenta cuentaLucas = new CajaDeAhorro(15,"Lucas Rodas",5000,true);
        cuentaJose.transferirDinero(cuentaLucas,4000);
        assertEquals(4000,cuentaJose.getSaldo());
        assertEquals(9000,cuentaLucas.getSaldo());
    }
    @Test
    public void tranferencia_CA_a_CC_denegada_CA_no_habilitada(){
        Cuenta cuentaRodrigo=new CajaDeAhorro(13,"Rodrigo Gimenez",10000,false);
        Cuenta cuentaMicaela = new CuentaCorriente(12,"Micaela Perez",2500,true,1000);
        cuentaRodrigo.transferirDinero(cuentaMicaela,5000);
        assertEquals(10000,cuentaRodrigo.getSaldo());
        assertEquals(2500,cuentaMicaela.getSaldo());
    }
    @Test
    public void tranferencia_CA_a_CC_denegada_CC_no_habilitada(){
        Cuenta cuentaRodrigo=new CajaDeAhorro(13,"Rodrigo Gimenez",10000,true);
        Cuenta cuentaMicaela = new CuentaCorriente(12,"Micaela Perez",2500,false,1000);
        cuentaRodrigo.transferirDinero(cuentaMicaela,5000);
        assertEquals(10000,cuentaRodrigo.getSaldo());
        assertEquals(2500,cuentaMicaela.getSaldo());
    }
    @Test
    public void tranferencia_CA_a_CC_denegada_saldo_insuficiente(){
        Cuenta cuentaJimena=new CajaDeAhorro(17,"Jimena Salinas",5000,true);
        Cuenta cuentaRocio = new CuentaCorriente(18,"Rocio Gomez",3000,true,1000);
        cuentaJimena.transferirDinero(cuentaRocio,6000);
        assertEquals(5000,cuentaJimena.getSaldo());
        assertEquals(3000,cuentaRocio.getSaldo());
    }
    @Test
    public void tranferencia_CC_a_CA_exitosa(){
        Cuenta cuentaGaston=new CuentaCorriente(19,"Gaston Brizuela",10000,true,2000);
        Cuenta cuentaSeba = new CajaDeAhorro(12,"Sebastian Romero",2500,true);
        cuentaGaston.transferirDinero(cuentaSeba,5000);
        assertEquals(4850,cuentaGaston.getSaldo());
        assertEquals(7500,cuentaSeba.getSaldo());
    }
    @Test
    public void tranferencia_CC_a_CC_exitosa(){
        Cuenta cuentaGaston=new CuentaCorriente(19,"Gaston Brizuela",10000,true,2000);
        Cuenta cuentaPedro = new CuentaCorriente(20,"Pedro Torales",5500,true,1500);
        cuentaGaston.transferirDinero(cuentaPedro,2500);
        assertEquals(7500,cuentaGaston.getSaldo());
        assertEquals(8000,cuentaPedro.getSaldo());
    }
    @Test
    public void tranferencia_CC_a_CA_denegada_CC_no_habilitada(){
        Cuenta cuentaMicaela = new CuentaCorriente(12,"Micaela Perez",2500,false,1000);
        Cuenta cuentaRodrigo=new CajaDeAhorro(13,"Rodrigo Gimenez",10000,true);
        cuentaMicaela.transferirDinero(cuentaRodrigo,5000);
        assertEquals(2500,cuentaMicaela.getSaldo());
        assertEquals(10000,cuentaRodrigo.getSaldo());
    }
    @Test
    public void tranferencia_CC_a_CA_denegada_CA_no_habilitada(){
        Cuenta cuentaMicaela = new CuentaCorriente(12,"Micaela Perez",2500,true,1000);
        Cuenta cuentaRodrigo=new CajaDeAhorro(13,"Rodrigo Gimenez",10000,false);
        cuentaMicaela.transferirDinero(cuentaRodrigo,5000);
        assertEquals(2500,cuentaMicaela.getSaldo());
        assertEquals(10000,cuentaRodrigo.getSaldo());
    }
    @Test
    public void tranferencia_CC_a_CA_con_saldo_descubierto_exitosa(){
        Cuenta cuentaGaston=new CuentaCorriente(19,"Gaston Brizuela",10000,true,2000);
        Cuenta cuentaSeba = new CajaDeAhorro(12,"Sebastian Romero",2500,true);
        cuentaGaston.transferirDinero(cuentaSeba,11000);
        assertEquals(670, ((CuentaCorriente) cuentaGaston).getSaldoConDescubierto());
        assertEquals(13500,cuentaSeba.getSaldo());
    }
    @Test
    public void tranferencia_CC_a_CC_con_saldo_descubierto_exitosa(){
        Cuenta cuentaGaston=new CuentaCorriente(19,"Gaston Brizuela",3000,true,1000);
        Cuenta cuentaRobert = new CuentaCorriente(22,"Robert Rodriguez",6000,true,1000);
        cuentaGaston.transferirDinero(cuentaRobert,3100);
        assertEquals(900, ((CuentaCorriente) cuentaGaston).getSaldoConDescubierto());
        assertEquals(9100,cuentaRobert.getSaldo());
    }
    @Test
    public void tranferencia_CC_a_CA_denegada_saldo_insuficiente(){
        Cuenta cuentaRocio = new CuentaCorriente(18,"Rocio Gomez",3000,true,1000);
        Cuenta cuentaJimena=new CajaDeAhorro(17,"Jimena Salinas",5000,true);
        cuentaRocio.transferirDinero(cuentaJimena,6000);
        assertEquals(3000,cuentaRocio.getSaldo());
        assertEquals(5000,cuentaJimena.getSaldo());
    }
    @Test
    public void obtener_titulares_apto_para_prestamo_exitoso(){
        Cuenta cuentaJose=new CajaDeAhorro(14,"Jose Gomez",11000,true);
        Cuenta cuentaLucas = new CajaDeAhorro(15,"Lucas Rodas",5000,true);
        Cuenta cuentaJimena=new CajaDeAhorro(17,"Jimena Salinas",5000,true);
        Cuenta cuentaJose2=new CajaDeAhorro(14,"Jose Gomez",11000,true);
        Cuenta cuentaGaston=new CuentaCorriente(19,"Gaston Brizuela",10000,true,2000);
        Cuenta cuentaRocio = new CuentaCorriente(18,"Rocio Gomez",12000,false,1000);
        Cuenta cuentaPedro = new CuentaCorriente(20,"Pedro Torales",9000,true,1500);
        ArrayList<Cuenta> listaCuentas = new ArrayList<>();
        listaCuentas.add(cuentaJose);
        listaCuentas.add(cuentaLucas);
        listaCuentas.add(cuentaJimena);
        listaCuentas.add(cuentaJose2);
        listaCuentas.add(cuentaGaston);
        listaCuentas.add(cuentaRocio);
        listaCuentas.add(cuentaPedro);
        /*
        - Controla que no posea nombres repetidos (caso de cuentaJose y cuentaJose2)
        - Rocio Gomez no se encuentra en la lista por no estar habilitada la cuenta
        - Pedro Torales ingresa a la lista gracias al saldo con descubierto
        - La lista deberia quedar: JOSE GOMEZ, GASTON BRIZUELA, PEDRO TORALES
         */
        System.out.println(ListaCuentas.obtenerTitularesAptosParaPrestamo(listaCuentas));
        assertEquals(3, ListaCuentas.obtenerTitularesAptosParaPrestamo(listaCuentas).size());
    }
    @Test
    public void alguna_cuenta_puede_ser_hackeada(){
        Cuenta cuentaJose=new CajaDeAhorro(14,"Jose Gomez",11000,true);
        Cuenta cuentaLucas = new CajaDeAhorro(15,"Lucas Rodas",55000,true);
        Cuenta cuentaRocio = new CuentaCorriente(18,"Rocio Gomez",55000,false,1000);
        Cuenta cuentaPedro = new CuentaCorriente(19,"Pedro Roberto Torales ",60000,false,1500);
        ArrayList<Cuenta> listaCuentas = new ArrayList<>();
        listaCuentas.add(cuentaJose);
        listaCuentas.add(cuentaLucas);
        listaCuentas.add(cuentaRocio);
        listaCuentas.add(cuentaPedro);
        /*
        - La cuentaJose no cumple ningun requisito
        - La cuentaLucas es descartada porque el nombre del titular no supera los 15 caracteres y su nroCuenta es impar
        - La cuentaRocio es descartada porque el nombre del titular no supera los 15 caracteres
        - La cuentaPedro es descartada porque su numero de cuenta es impar
        - Se espera que retorne falso
         */
        System.out.println(ListaCuentas.algunaCuentaPuedeSerHackeada(listaCuentas));
        assertFalse(ListaCuentas.algunaCuentaPuedeSerHackeada(listaCuentas));
    }
    @Test
    public void alguna_cuenta_puede_ser_hackeada_verdadero(){
        Cuenta cuentaJose=new CajaDeAhorro(14,"Jose Esteban Gomez",60000,true);
        Cuenta cuentaLucas = new CajaDeAhorro(15,"Lucas Rodas",55000,true);
        Cuenta cuentaRocio = new CuentaCorriente(18,"Rocio Gomez",55000,false,1000);
        Cuenta cuentaPedro = new CuentaCorriente(19,"Pedro Roberto Torales ",60000,false,1500);
        ArrayList<Cuenta> listaCuentas = new ArrayList<>();
        listaCuentas.add(cuentaJose);
        listaCuentas.add(cuentaLucas);
        listaCuentas.add(cuentaRocio);
        listaCuentas.add(cuentaPedro);
        /*
        - La cuentaJose cumple con todos los requisitos
        - La cuentaLucas es descartada porque el nombre del titular no supera los 15 caracteres y su nroCuenta es impar
        - La cuentaRocio es descartada porque el nombre del titular no supera los 15 caracteres
        - La cuentaPedro es descartada porque su numero de cuenta es impar
        - Se espera que retorne true
         */
        System.out.println(ListaCuentas.algunaCuentaPuedeSerHackeada(listaCuentas));
        assertTrue(ListaCuentas.algunaCuentaPuedeSerHackeada(listaCuentas));
    }
}