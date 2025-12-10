import java.util.Scanner;

public class magang {

    // Array paralel
    static String[] nama = new String[50];
    static String[] nim = new String[50];
    static String[] prodi = new String[50];
    static String[] perusahaan = new String[50];
    static int[] semester = new int[50];
    static String[] status = new String[50];

    static int jumlah = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int pilih;
        do {
            System.out.println("\nSistem Pendaftaran Magang Mahasiswa");
            System.out.println("1. Tambah Data Magang");
            System.out.println("2. Tampilkan Semua Pendaftar");
            System.out.println("3. Cari Pendaftar berdasarkan Prodi");
            System.out.println("4. Hitung Status Magang");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    tambahData();
                    break;

                case 2:
                    tampilkanData();
                    break;

                case 3:
                    cariProdi();
                    break;

                case 4:
                    hitungStatus();
                    break;

                case 5:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Menu ini dikerjakan anggota lain.");
            }

        } while (pilih != 5);
    }

    public static void tambahData() {

        if (jumlah >= 100) {
            System.out.println("Kapasitas data penuh!");
            return;
        }

        System.out.print("Nama Mahasiswa: ");
        nama[jumlah] = sc.nextLine();

        System.out.print("NIM: ");
        nim[jumlah] = sc.nextLine();

        System.out.print("Program Studi: ");
        prodi[jumlah] = sc.nextLine();

        System.out.print("Perusahaan Tujuan Magang: ");
        perusahaan[jumlah] = sc.nextLine();

        while (true) {
            System.out.print("Semester pengambilan magang (6 atau 7): ");
            semester[jumlah] = sc.nextInt();
            sc.nextLine();
            if (semester[jumlah] == 6 || semester[jumlah] == 7)
                break;
            System.out.println("Semester harus 6 atau 7!");
        }

        while (true) {
            System.out.print("Status magang (Diterima/Menunggu/Ditolak): ");
            status[jumlah] = sc.nextLine();
            if (status[jumlah].equals("Diterima") ||
                    status[jumlah].equals("Menunggu") ||
                    status[jumlah].equals("Ditolak"))
                break;

            System.out.println("Status tidak valid!");
        }

        jumlah++;

        System.out.println("Data pendaftaran magang berhasil ditambahkan. Total pendaftar: " + jumlah);
    }

    public static void tampilkanData() {
        if (jumlah == 0) {
            System.out.println("Belum ada data pendaftar.");
            return;
        }

        System.out.println("\n=== Daftar Seluruh Pendaftar Magang ===");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-3s | %-20s | %-12s | %-12s | %-15s | %-9s | %-10s |\n",
                "No", "Nama", "NIM", "Prodi", "Perusahaan", "Semester", "Status");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < jumlah; i++) {
            System.out.printf("| %-3d | %-20s | %-12s | %-12s | %-15s | %-9d | %-10s |\n",
                    (i + 1), nama[i], nim[i], prodi[i], perusahaan[i], semester[i], status[i]);
        }

        System.out.println(
                "----------------------------------------------------------------------------------------------------------------");
    }

    public static void cariProdi() {
        if (jumlah == 0) {
            System.out.println("Belum ada data pendaftar.");
            return;
        }

        System.out.print("\nMasukkan Program Studi yang ingin dicari: ");
        String cari = sc.nextLine().toLowerCase();
        boolean ditemukan = false;
        System.out.println("\n=== Hasil Pencarian Untuk Prodi: " + cari + " ===");

        for (int i = 0; i < jumlah; i++) {  
            String p = prodi[i].toLowerCase();

            boolean sama = true;

            if (p.length() == cari.length()) {
                for (int j = 0; j < p.length(); j++) {
                    if (p.charAt(j) != cari.charAt(j)) {
                        sama = false;
                        break;
                    }
                }
            } else {
                sama = false;
            }

            if (sama) {
                ditemukan = true;
                System.out.println("--------------------------------------------");
                System.out.println("Nama       : " + nama[i]);
                System.out.println("NIM        : " + nim[i]);
                System.out.println("Prodi      : " + prodi[i]);
                System.out.println("Perusahaan : " + perusahaan[i]);
                System.out.println("Semester   : " + semester[i]);
                System.out.println("Status     : " + status[i]);
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada pendaftar dari prodi tersebut.");
        }
    }

    public static void hitungStatus() {
        if (jumlah == 0) {
            System.out.println("Belum ada data pendaftar.");
            return;
        }

        int diterima = 0;
        int menunggu = 0;
        int ditolak = 0;

        // Hitung berdasarkan status
        for (int i = 0; i < jumlah; i++) {
            if (status[i].equals("Diterima"))
                diterima++;
            else if (status[i].equals("Menunggu"))
                menunggu++;
            else if (status[i].equals("Ditolak"))
                ditolak++;
        }

        System.out.println("\n=== Jumlah Pendaftar Berdasarkan Status Magang ===");
        System.out.println("Diterima : " + diterima + " orang");
        System.out.println("Menunggu : " + menunggu + " orang");
        System.out.println("Ditolak  : " + ditolak + " orang");
    }
}
