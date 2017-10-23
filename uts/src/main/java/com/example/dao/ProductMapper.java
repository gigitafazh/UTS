package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.ProductModel;

@Mapper
public interface ProductMapper {
	// viewall products
	@Select("select * from product")
	List<ProductModel> selectAllProducts();

	// view
	@Select("select * from product where id = #{id}")
	ProductModel selectProduct(@Param("id") int id);

	// update product
	@Update("update product set nama = #{nama}, deskripsi = #{deskripsi}, kategori = #{kategori},"
			+ "pabrikan = #{pabrikan}, berat = #{berat}, harga = #{harga},"
			+ "tahun_produksi = #{tahun_produksi}, jumlah_stok = #{jumlah_stok}, kondisi = #{kondisi} where id = #{id}")
	void updateProduct(ProductModel product);

	// add product
	@Insert("insert into product (nama, deskripsi, kategori, pabrikan, berat, harga, tahun_produksi, jumlah_stok, kondisi)"
			+ "values (#{nama}, #{deskripsi}, #{kategori}, #{pabrikan}, #{berat}, #{harga}, #{tahun_produksi}, "
			+ "#{jumlah_stok}, #{kondisi})")
	void addProduct(ProductModel product);
}