package com.jobsheet7;
import java.util.*;
public class MahasiswaMain {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner sl = new Scanner(System.in);
        System.out.print("Masukkan jumlah mahasiswa : ");
        int jumMhs = s.nextInt();
        PencarianMhs data = new PencarianMhs(jumMhs);
        System.out.println("-----------------------------------------------------");
        System.out.println("Masukkan data mahasiswa secara urut dari nim terkecil");
        for (int i = 0; i < jumMhs; i++) {
            System.out.println("-----------------------------------------------------");
            System.out.print("NIM\t : ");
            int nim = s.nextInt();
            System.out.print("Nama\t : ");
            String nama = sl.nextLine();
            System.out.print("Umur\t : ");
            int umur = s.nextInt();
            System.out.print("IPK\t : ");
            double ipk = s.nextDouble();
            Mahasiswa m = new Mahasiswa(nim, nama, umur, ipk);
            data.tambah(m);
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("Data keseluruhan mahasiswa : ");
        data.tampil();
        System.out.println("Pencarian data : ");
        System.out.println("Masukkan NIM mahasiswa yang dicari : ");
        System.out.print("NIM\t : ");
        int cari = s.nextInt();
        System.out.println("Menggunakan sequential search");
        int posisi = data.findSeqSearch(cari);
        data.tampilPosisi(cari, posisi);
        data.tampilData(cari, posisi);
        System.out.println("Menggunakan binary search");
        posisi = data.findBinarySearch(cari, 0, jumMhs - 1);
        data.tampilPosisi(cari, posisi);
        data.tampilData(cari, posisi);
        System.out.println("Masukkan nama mahasiswa yang ingin dicari : ");
        System.out.print("Nama\t : ");
        String cariNama = sl.nextLine();
        data.findBinarySearchByName(cariNama);
        System.out.println("-----------------------------------------------------");
    }
}