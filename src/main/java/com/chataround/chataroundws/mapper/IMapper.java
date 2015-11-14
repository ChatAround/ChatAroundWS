package com.chataround.chataroundws.mapper;

import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
public interface IMapper<T, D> {
    T fromDTO(D dto);

    List<T> fromDTO(List<D> DTOs);

    D toDTO(T model);

    List<D> toDTO(List<T> models);
}
