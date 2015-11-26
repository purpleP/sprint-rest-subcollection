package main.foo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by mihaildoronin on 27/11/15.
 */
@RepositoryRestResource
public interface FooRepository extends PagingAndSortingRepository<Foo, Integer> {
}
