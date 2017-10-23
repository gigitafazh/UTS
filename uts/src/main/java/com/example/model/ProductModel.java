package com.example.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductModel {
	private int id;
	private String nama;
	private String deskripsi;
	private String kategori;
	private String pabrikan;
	private double berat;
	private int harga;
	private int tahun_produksi;
	private int jumlah_stok;
	private String kondisi;
}