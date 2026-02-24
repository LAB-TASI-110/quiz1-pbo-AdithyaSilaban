import java.util.Scanner;

public class Driver3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String lanjut;

        System.out.println("=== SISTEM PENGECEKAN BARANG LAUNDRY KAMPUS DEL ===");

        do {
            System.out.print("\nNama Mahasiswa : ");
            String nama = input.nextLine();

            System.out.print("Asrama         : ");
            String asrama = input.nextLine();

            System.out.print("\nJumlah jenis barang yang ingin diinput: ");
            int jumlahBarang = input.nextInt();
            input.nextLine(); // bersihkan buffer

            String[] namaBarang = new String[jumlahBarang];
            String[] warnaBarang = new String[jumlahBarang];
            int[] ambil = new int[jumlahBarang];
            int[] kembali = new int[jumlahBarang];

            System.out.println("\n--- INPUT BARANG SAAT DIAMBIL ---");
            for (int i = 0; i < jumlahBarang; i++) {
                System.out.println("Barang ke-" + (i + 1));

                System.out.print("Nama barang  : ");
                namaBarang[i] = input.nextLine();

                System.out.print("Warna barang : ");
                warnaBarang[i] = input.nextLine();

                ambil[i] = inputJumlahValid(input, "Jumlah saat diambil : ");
                System.out.println();
            }

            System.out.println("\n--- INPUT BARANG SAAT DIKEMBALIKAN ---");
            for (int i = 0; i < jumlahBarang; i++) {
                kembali[i] = inputJumlahValid(
                        input,
                        "Jumlah " + namaBarang[i] + " (" + warnaBarang[i] + ") : "
                );
            }

            System.out.println("\n=== HASIL PENGECEKAN LAUNDRY ===");
            System.out.println("Nama Mahasiswa : " + nama);
            System.out.println("Asrama         : " + asrama);
            System.out.println("--------------------------------");

            int totalSelisih = 0;

            for (int i = 0; i < jumlahBarang; i++) {
                int selisih = kembali[i] - ambil[i];
                totalSelisih += Math.abs(selisih);

                if (selisih == 0) {
                    System.out.println(namaBarang[i] + " (" + warnaBarang[i] + ") : Lengkap ✅");
                } else if (selisih < 0) {
                    System.out.println(namaBarang[i] + " (" + warnaBarang[i] + ") : Kurang "
                            + (-selisih) + " ❌");
                } else {
                    System.out.println(namaBarang[i] + " (" + warnaBarang[i] + ") : Lebih "
                            + selisih + " ⚠️ (Kemungkinan tertukar)");
                }
            }

            System.out.println("--------------------------------");
            System.out.println("Total selisih barang : " + totalSelisih);

            System.out.print("\nInput laundry mahasiswa lain? (y/n): ");
            lanjut = input.nextLine();

        } while (lanjut.equalsIgnoreCase("y"));

        System.out.println("\nTerima kasih telah menggunakan sistem laundry Kampus DEL.");
        input.close();
    }

    // Validasi input jumlah
    public static int inputJumlahValid(Scanner input, String pesan) {
        int jumlah;
        do {
            System.out.print(pesan);
            jumlah = input.nextInt();
            input.nextLine(); // bersihkan buffer

            if (jumlah < 0) {
                System.out.println("Jumlah tidak boleh negatif. Masukkan ulang!");
            }
        } while (jumlah < 0);

        return jumlah;
    }
}