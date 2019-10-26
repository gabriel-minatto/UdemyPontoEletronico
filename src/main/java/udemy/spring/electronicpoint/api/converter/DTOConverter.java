package udemy.spring.electronicpoint.api.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface DTOConverter<T, V> {

    /**
     * Receives a dto an returns a domain entity
     *
     * @param dto The dto containing the domain entity data
     * @return A filled entity
     */
    T toDomain(V dto);

    /**
     * Receives a domain entity and returns a specific dto
     *
     * @param entity The entity to be converted to a dto
     * @return A filled dto
     */
    V toDTO(T entity);

    /**
     * Calls the toDomain impl to a list of DTO's and returns a list of Entities
     * @param dtos A list of dtos
     * @return A list of entities
     */
    default List<T> toDomain(List<V> dtos) {
        return dtos.stream().map(this::toDomain).collect(Collectors.toList());
    }

    /**
     * Calls the toDTO impl to a list of entities and returns a list of DTOS
     *
     * @param entities A List of entities
     * @return A list of  dtos
     */
    default List<V> toDTO(List<T> entities) {
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }

}
