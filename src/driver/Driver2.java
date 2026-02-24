import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Data tetap (tidak perlu input siswa)
        int[] nilai = {75, 80, 65, 70};
        char[] gender = {'W', 'W', 'P', 'P'};

        // Nama kelompok
        String[] namaKelompok = {
            "Kelompok Wanita",
            "Kelompok Pria",
            "Kelompok Ganjil",
            "Kelompok Genap"
        };

        // Total nilai tiap kelompok
        int[] total = new int[4];

        // Hitung total kelompok
        for (int i = 0; i < nilai.length; i++) {

            // Wanita / Pria
            if (gender[i] == 'W') {
                total[0] += nilai[i]; // wanita
            } else {
                total[1] += nilai[i]; // pria
            }

            // Ganjil / Genap
            if (nilai[i] % 2 == 0) {
                total[3] += nilai[i]; // genap
            } else {
                total[2] += nilai[i]; // ganjil
            }
        }

        // Deklarasi pilihan kelompok (INPUTAN)
        System.out.println("Pilih Kelompok:");
        for (int i = 0; i < namaKelompok.length; i++) {
            System.out.println((i + 1) + ". " + namaKelompok[i]);
        }
        System.out.print("Masukkan kode kelompok: ");

        int kode = sc.nextInt();

        // Output hasil
        if (kode >= 1 && kode <= 4) {
            System.out.println(namaKelompok[kode - 1]);
            System.out.println("Total Nilai = " + total[kode - 1]);
        } else {
            System.out.println("Kode kelompok tidak valid");
        }
    }
}