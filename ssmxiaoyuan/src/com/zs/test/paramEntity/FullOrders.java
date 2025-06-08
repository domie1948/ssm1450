package com.zs.test.paramEntity;

import java.util.List;


import com.zs.test.entity.Address;
import com.zs.test.entity.Orderext;
import com.zs.test.entity.Orders;

public class FullOrders {
private Orders orders;
private List<HalfOrderext> HalfOrderextList;
private Address address;
public Orders getOrders() {
	return orders;
}
public void setOrders(Orders orders) {
	this.orders = orders;
}

public List<HalfOrderext> getHalfOrderextList() {
	return HalfOrderextList;
}
public void setHalfOrderextList(List<HalfOrderext> halfOrderextList) {
	HalfOrderextList = halfOrderextList;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}

}
