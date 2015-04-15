package shop.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Good {
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String articul;
	private float price;
	private String description;
	private List<File> imageList = new ArrayList<File>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticul() {
		return articul;
	}

	public void setArticul(String articul) {
		this.articul = articul;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<File> getImageList() {
		return imageList;
	}

	public void setImageList(List<File> imageList) {
		this.imageList = imageList;
	}

	public void addImageFile(File image) {
		this.imageList.add(image);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
