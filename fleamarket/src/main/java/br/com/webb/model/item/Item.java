package br.com.webb.model.item;

import br.com.webb.model.Product;

public interface Item {

	public abstract Product getProduct();

	public abstract int getQuantity();

}