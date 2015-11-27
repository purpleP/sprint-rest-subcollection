package main.foo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mihaildoronin on 27/11/15.
 */

@RestController
public class FooController {

    @Autowired
    private FooRepository repository;

    @RequestMapping(value = "foos", method = RequestMethod.POST)
    public int postFoo(@RequestBody Foo foo) {
        repository.save(foo);
        return foo.getId();
    }

    @RequestMapping(value = "foos/{fooId}/bars", method = RequestMethod.POST)
    public int postBar(@RequestBody Bar bar, @PathVariable("fooId") int fooId) {
        Foo one = repository.findOne(fooId);
        one.addBar(bar);
        repository.save(one);
        return bar.getId();
    }

    @RequestMapping(value = "foos/{fooId}/bars", method = RequestMethod.GET)
    public List<Bar> getBars(@PathVariable("fooId") int fooId) {
        return repository.findOne(fooId).getBars();
    }

    @RequestMapping(value = "foos/{fooId}/bars/insert", method = RequestMethod.POST)
    public int insertBar(@PathVariable("fooId") int fooId, @RequestBody List<Bar> bars, @RequestParam("fromIndex") int fromIndex) {
        Foo one = repository.findOne(fooId);
        one.getBars().addAll(fromIndex, bars);
        repository.save(one);
        return 1;
    }
}
