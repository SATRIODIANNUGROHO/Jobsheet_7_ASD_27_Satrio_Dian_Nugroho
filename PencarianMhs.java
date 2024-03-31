package com.jobsheet7;

import java.util.Arrays;

public class PencarianMhs {
    Mahasiswa[] listMhs;
    int idx;
    public PencarianMhs(int jumMhs) {
        listMhs = new Mahasiswa[jumMhs];
        idx = 0;
    }
    void tambah(Mahasiswa m) {
        if (idx < listMhs.length) {
            listMhs[idx] = m;
            idx++;
        }else {
            System.out.println("Data sudah penuh");
        }
    }
    void tampil() {
        for (Mahasiswa m : listMhs) {
            m.tampil();
            System.out.println("-----------------------------------------------------");
        }
    }
    public int findSeqSearch(int cari) {
        int posisi = -1;
        for (int j = 0; j < listMhs.length; j++) {
            if (listMhs[j].nim == cari) {
                posisi = j;
                break;
            }
        }
        return posisi;
    }
    public void tampilPosisi(int x, int pos) {
        if (pos != -1) {
            System.out.println("Data\t : " + (x) + " ditemukan pada indeks " + (pos));
        }else {
            System.out.println("Data\t : " + (x) + " tidak ditemukan");
        }
    }
    public void tampilData(int x, int pos) {
        if (pos != -1) {
            System.out.println("NIM\t : " + (x));
            System.out.println("Nama\t : " + (listMhs[pos].nama));
            System.out.println("Umur\t : " + (listMhs[pos].umur));
            System.out.println("IPK\t : " + (listMhs[pos].ipk));
        }else {
            System.out.println("Data " + (x) + " tidak ditemukan");
        }
    }
    public int findBinarySearch(int cari, int left, int right) {
        for (int i = 0; i < listMhs.length; i++) {
            for (int j = 1; j < listMhs.length - i; j++) {
                if (listMhs[j].nim < listMhs[i].nim) {
                    Mahasiswa buffer = listMhs[j];
                    listMhs[j] = listMhs[i];
                    listMhs[i] = buffer;
                }
            }
        }
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
            if (cari == listMhs[mid].nim) {
                return mid;
            }else if (listMhs[mid].nim > cari) {
                return findBinarySearch(cari, left, mid - 1);
            }else {
                return findBinarySearch(cari, mid + 1, right);
            }
        }
        return -1;
    }
    public void findBinarySearchByName(String nama) {
        Arrays.sort(listMhs, (m1, m2) -> m1.nama.compareTo(m2.nama));
        int left = 0;
        int right = idx - 1;
        int mid;
        int hasil = -1;
        int counter = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (listMhs[mid].nama.compareTo(nama) == 0) {
                hasil = mid;
                counter++;
                break;
            } else if (listMhs[mid].nama.compareTo(nama) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (hasil != -1) {
            if (counter > 1) {
                System.out.println("Peringatan: Ditemukan lebih dari 1 hasil dengan nama " + nama);
            }
            System.out.println("Data ditemukan pada indeks " + hasil);
            tampilData(listMhs[hasil].nim, hasil);
        } else {
            System.out.println("Data dengan nama " + nama + " tidak ditemukan");
        }
    }
}