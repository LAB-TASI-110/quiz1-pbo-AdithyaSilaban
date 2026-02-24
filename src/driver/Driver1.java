import java.util.Scanner;

public class Driver1 {

    // Method diskon
    static double getDiskon(int total) {
        if (total >= 500000) return 0.25;
        else if (total >= 400000) return 0.20;
        else if (total >= 300000) return 0.15;
        else if (total >= 200000) return 0.10;
        else if (total >= 100000) return 0.05;
        else return 0.0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Data menu
        String[] kode = {"NGS", "AP", "SA", "BU", "MAP", "GG", "SAM", "RD", "IB", "NUK"};
        String[] nama = {
            "Nasi Goreng Spesial", "Ayam Penyet", "Sate Ayam",
            "Bakso Urat", "Mie Ayam Pangsit", "Gado-Gado",
            "Soto Ayam", "Rendang Daging", "Ikan Bakar", "Nasi Uduk Komplit"
        };
        int[] harga = {15000, 20000, 25000, 18000, 15000, 15000, 17000, 35000, 35000, 20000};

        int totalBelanja = 0;

        System.out.println("===== SISTEM TRANSAKSI RESTORAN =====");

        while (true) {
            System.out.print("\nMasukkan kode menu: ");
            String kodeInput = input.next().toUpperCase();

            int index = -1;
            for (int i = 0; i < kode.length; i++) {
                if (kode[i].equals(kodeInput)) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                System.out.println("Kode menu tidak ditemukan!");
                continue;
            }

            System.out.print("Masukkan porsi Butet: ");
            int porsiButet = input.nextInt();

            int porsiUcok = porsiButet * 2;
            int totalPorsi = porsiButet + porsiUcok;
            int subtotal = totalPorsi * harga[index];

            totalBelanja += subtotal;

            System.out.println("\n--- Detail Pesanan ---");
            System.out.println("Menu        : " + nama[index]);
            System.out.println("Porsi Butet : " + porsiButet);
            System.out.println("Porsi Ucok  : " + porsiUcok);
            System.out.println("Total Porsi : " + totalPorsi);
            System.out.println("Subtotal    : " + subtotal);

            System.out.print("\nTambah menu lagi? (y/n): ");
            char pilih = input.next().charAt(0);
            if (pilih == 'n' || pilih == 'N') {
                break;
            }
        }

        double diskon = getDiskon(totalBelanja);
        int potongan = (int) (totalBelanja * diskon);
        int totalBayar = totalBelanja - potongan;

        System.out.println("\n==============================================");
        System.out.println("TOTAL BELANJA : " + totalBelanja);
        System.out.println("DISKON        : " + (int)(diskon * 100) + "%");
        System.out.println("POTONGAN     : " + potongan);
        System.out.println("----------------------------------------------");
        System.out.println("TOTAL BAYAR  : " + totalBayar);
        System.out.println("==============================================");
    }
}