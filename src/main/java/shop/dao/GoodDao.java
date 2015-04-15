package shop.dao;

import shop.dao.impl.GoodDaoImpl;
import shop.model.Good;

import java.util.List;

public interface GoodDao {
	GoodDao INSTANCE_GOOD = new GoodDaoImpl();

	List<Good> getGoods();

	void addGood(Good good);

	void deleteGood(Long id);

	void saveGood(Good good);
}
