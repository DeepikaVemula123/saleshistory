package com.sprint.saleshistory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.saleshistory.dao.ProductsRepository;
import com.sprint.saleshistory.dao.entities.ProductEntity;
import com.sprint.saleshistory.models.ProductPojo;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductsRepository productRepository;
	@Override
	public List<ProductPojo> getAllProducts() {
		List<ProductEntity> allProductsEntity = productRepository.findAll();
		List<ProductPojo> allProductPojo = new ArrayList<ProductPojo>();
		for(ProductEntity productEntity: allProductsEntity) {
			ProductPojo productPojo = new ProductPojo();
			BeanUtils.copyProperties(productEntity, productPojo);
			allProductPojo.add(productPojo);
		}
		return allProductPojo;
	}

	@Override
	public ProductPojo getProduct(int id) {
		Optional<ProductEntity> opt  = productRepository.findById(id);
		if(opt.isPresent()) return null;
		ProductEntity productEntity = new ProductEntity();
		ProductPojo productPojo =new ProductPojo();
		BeanUtils.copyProperties(productEntity, productPojo);
		return productPojo;
	}

	@Override
	public String deleteProduct(int id) {
		Optional<ProductEntity> opt  = productRepository.findById(id);
		if(!opt.isPresent()) return "product does not exists";
		productRepository.deleteById(id);
		return "susccessfully deleted" ;
	}

	@Override
	public ProductPojo updateProduct(ProductPojo updateProduct) {
		Optional<ProductEntity> opt  = productRepository.findById(updateProduct.getProdId());
		if(!opt.isPresent()) return null;
		ProductEntity productEntity = new ProductEntity();
		ProductPojo productPojo =new ProductPojo();
		BeanUtils.copyProperties(productPojo,productEntity );
		productRepository.save(productEntity);
		return productPojo ;
	}

	@Override
	public ProductPojo addProduct(ProductPojo newProduct) {
		Optional<ProductEntity> opt  = productRepository.findById(newProduct.getProdId());
		if(opt.isPresent()) return null;
		ProductEntity productEntity = new ProductEntity();
		ProductPojo productPojo =new ProductPojo();
		BeanUtils.copyProperties(productPojo,productEntity );
		productRepository.save(productEntity);
		return productPojo ;
	}

	@Override
	public List<ProductPojo> getProductByCategory(String category) {
		List<ProductEntity> allProductsEntityByCategory = productRepository.findByProdCategory(category);
		List<ProductPojo> allProductPojoBycategory = new ArrayList<ProductPojo>();
		for(ProductEntity productEntity: allProductsEntityByCategory) {
			ProductPojo productPojo = new ProductPojo();
			BeanUtils.copyProperties(productEntity, productPojo);
			allProductPojoBycategory.add(productPojo);
		}
		return allProductPojoBycategory;
	}

	@Override
	public List<ProductPojo> getProductByStatus(String status) {
		List<ProductEntity> allProductsEntityByStatus = productRepository.findByProdStatus(status);
				List<ProductPojo> allProductPojoByStatus = new ArrayList<ProductPojo>();
				for(ProductEntity productEntity: allProductsEntityByStatus) {
					ProductPojo productPojo = new ProductPojo();
					BeanUtils.copyProperties(productEntity, productPojo);
					allProductPojoByStatus.add(productPojo);
				}
				return allProductPojoByStatus;
	}

	@Override
	public List<ProductPojo> getProductBySubcategory(String subcategory) {
		List<ProductEntity> allProductsEntityBySubcategory = productRepository.findByProdSubcategory(subcategory);
		List<ProductPojo> allProductPojoBySubcategory = new ArrayList<ProductPojo>();
		for(ProductEntity productEntity: allProductsEntityBySubcategory) {
			ProductPojo productPojo = new ProductPojo();
			BeanUtils.copyProperties(productEntity, productPojo);
			allProductPojoBySubcategory.add(productPojo);
		}
		return allProductPojoBySubcategory;
	}

	@Override
	public List<ProductPojo> getProductBySupplierId(int id) {
		List<ProductEntity> allProductsEntityBySupplierId = productRepository.findBySupplierId(id);
		List<ProductPojo> allProductPojoBySupplierID = new ArrayList<ProductPojo>();
		for(ProductEntity productEntity: allProductsEntityBySupplierId) {
			ProductPojo productPojo = new ProductPojo();
			BeanUtils.copyProperties(productEntity, productPojo);
			allProductPojoBySupplierID.add(productPojo);
		}
		return allProductPojoBySupplierID;
	}

	@Override
	public List<ProductPojo> getDuplicateProducts(String prodName) {
		List<ProductEntity> allProductsEntityByProdName = productRepository.findByProdName(prodName);
		List<ProductPojo> allProductPojoByProdName = new ArrayList<ProductPojo>();
		for(ProductEntity productEntity: allProductsEntityByProdName) {
			ProductPojo productPojo = new ProductPojo();
			BeanUtils.copyProperties(productEntity, productPojo);
			allProductPojoByProdName.add(productPojo);
		}
		return allProductPojoByProdName;
	}

}
