package com.coopeuch.api.repositories;

import java.util.List;

import com.coopeuch.api.entities.TareaEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends CrudRepository<TareaEntity, Long> {

    public TareaEntity findById(long id);

    public List<TareaEntity> findAllByOrderById();
}