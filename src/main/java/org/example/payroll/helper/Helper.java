package org.example.payroll.helper;

public class Helper {
    public static void clearTerminal() {
        final String os = System.getProperty("os.name");

        try {
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // System.out.print("\033\143");
                // System.out.flush();
                Runtime.getRuntime().exec("clear");
                // new ProcessBuilder("clear").inheritIO().start().waitFor();
            }

        } catch (Exception e) {
            System.out.println("clearTerminal err: " + e.getMessage());
        }
    }

    public static void menuList() {
        System.out.println("Menu");
        System.out.println("1. Tambah employee");
        System.out.println("2. Daftar employee");
        System.out.println("3. Daftar salary");
        System.out.println("4. Hitung payroll");
        System.out.println("5. Daftar payroll");
        System.out.println("6. Detail payroll");
        System.out.println("7. Exit\n");
        System.out.println("Pilih Menu");
    }
}
