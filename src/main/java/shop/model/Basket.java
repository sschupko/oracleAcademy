package shop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Basket {
	@Id
	private long id;
	@OneToOne
	private String owner;
	private List<Good> goodList = new ArrayList<Good>();

	public List<Good> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<Good> goodList) {
		this.goodList = goodList;
	}

	public void addGood(Good good) {
		this.goodList.add(good);
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
