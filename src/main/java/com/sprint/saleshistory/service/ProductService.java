package com.sprint.saleshistory.service;

import java.util.List;

import com.sprint.saleshistory.models.ProductPojo;



public interface ProductService {
	List<ProductPojo> getAllProducts();
	ProductPojo getProduct(int id);
	String deleteProduct(int id);
	ProductPojo updateProduct(ProductPojo updateProduct);
	ProductPojo addProduct(ProductPojo newProduct);
	List<ProductPojo> getProductByCategory(String category);
	List<ProductPojo> getProductByStatus(String status);
	List<ProductPojo> getProductBySubcategory(String subcategory);
	List<ProductPojo> getProductBySupplierId(int id);
	List<ProductPojo> getDuplicateProducts(String prodName);
	
}


//List<AuthorPojo> getAllAuthors();
//AuthorPojo getAAuthor();
//AuthorPojo addAuthor(AuthorPojo newAuthor);
//void deleteAuthor(int authorId);
//AuthorPojo updateAuthor(AuthorPojo updateAuthor);