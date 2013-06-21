package org.andvicoso.cruduser.model.dao;

import java.util.List;

public interface GenericDao<O> {
	void create(O obj);

	void update(O obj);

	List<O> list();

	O find(long id);

	void remove(long id);
}
