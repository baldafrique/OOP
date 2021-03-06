package com.example.petstore;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

import com.example.petstore.domain.CartItem;

@Component
public class RepositorySearchesProcessor implements RepresentationModelProcessor<EntityModel<CartItem>> {

	@Override
	public EntityModel<CartItem> process(EntityModel<CartItem> model) {
		// hateoas 구현을 위해 link 추가
		model.add(Link.of(model.getContent().getPet()).withRel("pet"));
		return model;
	}

}
