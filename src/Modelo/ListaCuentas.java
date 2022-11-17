package Modelo;

import java.util.ArrayList;

public class ListaCuentas {
    public static ArrayList<String> obtenerTitularesAptosParaPrestamo(ArrayList<Cuenta> listaCuentas) {
        ArrayList<String> titularesAptos = new ArrayList<>();
        listaCuentas.stream()
                    .filter(x -> x.isEstaHabilitada() && (x.getSaldoTotal() >= 10000)
                            && !titularesAptos.contains(x.getTitular().toUpperCase()))
                    .forEach(x -> {titularesAptos.add(x.getTitular().toUpperCase());
        });
        return titularesAptos;
    }

    public static boolean algunaCuentaPuedeSerHackeada(ArrayList<Cuenta> listaCuentas) {
        return listaCuentas.stream()
                           .anyMatch(x -> ((x.getNroCuenta() % 2 == 0)
                                   && (x.getSaldo() > 50000)
                                   && (x.getTitular().replace(" ", "").length() > 15)));
    };
}
