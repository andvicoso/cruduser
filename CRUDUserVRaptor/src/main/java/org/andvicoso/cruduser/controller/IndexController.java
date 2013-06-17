package org.andvicoso.cruduser.controller;

import org.andvicoso.cruduser.model.Public;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class IndexController {
	@Path("/")
	@Public
	@Get
	public void index() {
	}
}
