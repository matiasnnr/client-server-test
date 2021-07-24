package com.coopeuch.api;

import com.coopeuch.api.entities.TareaEntity;
import com.coopeuch.api.entities.TareaEntityTest;
import com.coopeuch.api.repositories.TareaRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ApiApplicationTests {

	@Autowired
	TareaRepository tareaRepository;

	@Autowired
	TareaEntityTest tareaEntityTest;

	@Test
	@Order(1)
	public void testCreate() {
		TareaEntity tarea = new TareaEntity();
		tarea.setDescripcion("Testeando la creación de una tarea...");
		tarea.setVigente(true);
		tarea = tareaRepository.save(tarea);
		tareaEntityTest.setId(tarea.getId());
		assertNotNull(tareaRepository.findById(tarea.getId()));
	}

	@Test
	@Order(2)
	public void testReadAll() {
		List<TareaEntity> list = tareaRepository.findAllByOrderById();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testRead() {
		System.out.println("TareaEntityTest Id: " + tareaEntityTest.getId());
		TareaEntity tarea = tareaRepository.findById(tareaEntityTest.getId());
		assertEquals("Testeando la creación de una tarea...", tarea.getDescripcion());
	}

	@Test
	@Order(4)
	public void testUpdate() {
		TareaEntity tarea = tareaRepository.findById(tareaEntityTest.getId());
		tarea.setDescripcion("Testeando la actualización de una tarea...");
		tareaRepository.save(tarea);
		assertNotEquals("Testeando la creación de una tarea...",
				tareaRepository.findById(tareaEntityTest.getId()).getDescripcion());
	}

	@Test
	@Order(5)
	public void testDelete() {
		tareaRepository.deleteById(tareaEntityTest.getId());
		assertThat(tareaRepository.existsById(tareaEntityTest.getId())).isFalse();
	}

}
