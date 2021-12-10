package com.example.petstore;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

import com.example.petstore.domain.Cat;
import com.example.petstore.domain.Pet;

@Component
public class RepositorySearchesProcessor implements RepresentationModelProcessor<EntityModel<Pet>> {

	@Override
	public EntityModel<Pet> process(EntityModel<Pet> model) {
		// .../cats/feed 또는 .../dogs/feed link 추가
		model.add(Link.of(model.getRequiredLink("self").getHref() + "/feed").withRel("feed"));
		
		if (model.getContent() instanceof Cat) { // model.getContent()가 고양이 instance인 경우
			// .../cats/groom link 추가
			model.add(Link.of(model.getRequiredLink("self").getHref() + "/groom").withRel("groom"));	
		}
		
		return model;
	}

}
